package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.PrestatorDao;
import com.dburlacu.model.Prestator;
import com.dburlacu.service.PrestatorService;

@Service
public class PrestatorServiceImpl implements PrestatorService {

	@Autowired
	PrestatorDao reqDao;
	
	@Transactional
	public List<Prestator> getAllPrestator() {
		return reqDao.getAllPrestator();
	}

	@Transactional
	public Prestator getPrestatorById(int idPrestator) {
		return reqDao.getPrestatorById(idPrestator);
	}
	
	@Transactional
	public Prestator getPrestatorByName(String namePrestator) {
		return reqDao.getPrestatorByName(namePrestator);
	}

}
