package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.SpecificDao;
import com.dburlacu.model.Specificari;
import com.dburlacu.service.SpecificService;

@Service
public class SpecificServiceImpl implements SpecificService {

	@Autowired
	SpecificDao reqDao;
	
	@Transactional
	public List<Specificari> getAllSpecific() {
		return reqDao.getAllSpecific();
	}

	@Transactional
	public Specificari getSpecificById(int idSpecific) {
		return reqDao.getSpecificById(idSpecific);
	}

	@Transactional
	public Specificari getSpecificByName(String nameSpecific) {
		return reqDao.getSpecificByName(nameSpecific);
	}
	
}
