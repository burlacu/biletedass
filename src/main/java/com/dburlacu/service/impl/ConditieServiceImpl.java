package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.ConditieDao;
import com.dburlacu.model.Conditie;
import com.dburlacu.service.ConditieService;

@Service
public class ConditieServiceImpl implements ConditieService {

	@Autowired
	ConditieDao reqDao;
	
	@Transactional
	public List<Conditie> getAllConditie() {
		return reqDao.getAllConditie();
	}

	@Transactional
	public Conditie getConditieById(int idReq) {
		return reqDao.getConditieById(idReq);
	}
	
	@Transactional
	public Conditie getConditieByName(String nameCond) {
		return reqDao.getConditieByName(nameCond);
	}

	@Transactional
	public List<Conditie> getAllConditieForInsotitor() {
		// TODO Auto-generated method stub
		return reqDao.getAllConditieForInsotitor();
	}

}
