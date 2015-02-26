package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.SolicitantDao;
import com.dburlacu.model.Solicitanti;
import com.dburlacu.service.SolicitantService;

@Service
public class SolicitantiServiceImpl implements SolicitantService {

	@Autowired
	SolicitantDao solDao;
	
	@Transactional
	public void add(Solicitanti sol) {
		solDao.add(sol);
	}

	@Transactional
	public void edit(Solicitanti sol) {
		solDao.edit(sol);
	}

	@Transactional
	public void delete(int idReq) {
		solDao.delete(idReq);
	}

	@Transactional
	public List<Solicitanti> getAllSolicitanti() {
		return solDao.getAllSolicitanti();
	}

	@Transactional
	public Solicitanti getSolicitantById(int idSol) {
		return solDao.getSolicitantById(idSol);
	}

	@Transactional
	public Solicitanti getSolicitantByIdnp(String idnp) {
		// TODO Auto-generated method stub
		return solDao.getSolicitantByIdnp(idnp);
	}

	@Transactional
	public Integer findSolicitantByIdnp(String idnp) {
		return solDao.findSolicitantByIdnp(idnp);
	}

}
