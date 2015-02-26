package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.RaionDao;
import com.dburlacu.model.Raion;
import com.dburlacu.service.RaionService;

@Service
public class RaionServiceImpl implements RaionService {

	@Autowired
	RaionDao reqDao;
	
	@Transactional
	public List<Raion> getAllRaion() {
		return reqDao.getAllRaion();
	}

	@Transactional
	public Raion getRaionById(int idReq) {
		return reqDao.getRaionById(idReq);
	}
	
	@Transactional
	public Raion getRaionByName(String nameCond) {
		return reqDao.getRaionByName(nameCond);
	}

}
