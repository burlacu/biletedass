package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.InsotitorDao;
import com.dburlacu.model.Insotitori;
import com.dburlacu.service.InsotitorService;

@Service
public class InsotitoriServiceImpl implements InsotitorService {

	@Autowired
	InsotitorDao solDao;

	@Transactional
	public void add(Insotitori sol) {
		solDao.add(sol);
	}

	@Transactional
	public void edit(Insotitori sol) {
		solDao.edit(sol);
	}

	@Transactional
	public void delete(int solId) {
		solDao.delete(solId);
	}

	@Transactional
	public List<Insotitori> getAllInsotitori() {
		return solDao.getAllInsotitori();
	}

	@Transactional
	public Insotitori getInsotitoriById(int idSol) {
		return solDao.getInsotitoriById(idSol);
	}

	@Transactional
	public Insotitori getInsotitoriByIdnp(String idnpInsotitor) {
		return solDao.getInsotitoriByIdnp(idnpInsotitor);
	}

	@Transactional
	public Integer findInsotitorByIdnp(String idnp) {
		return solDao.findInsotitorByIdnp(idnp);
	}
	
}
