package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.SubConditieDao;
import com.dburlacu.model.Conditie;
import com.dburlacu.model.SubConditie;
import com.dburlacu.service.SubConditieService;

@Service
public class SubConditieServiceImpl implements SubConditieService {

	@Autowired
	SubConditieDao reqDao;
	
	@Transactional
	public List<SubConditie> getAllSubConditie() {
		return reqDao.getAllSubConditie();
	}

	@Transactional
	public SubConditie getSubConditieById(int idReq) {
		return reqDao.getSubConditieById(idReq);
	}

	@Transactional
	public List<SubConditie> getSubConditieByConditieId(Conditie cond) {
		return reqDao.getSubConditieByConditieId(cond);
	}

	@Transactional
	public List<SubConditie> getAllSubConditieForInsotitoriByCondition(
			Conditie cond) {
		return reqDao.getAllSubConditieForInsotitoriByCondition(cond);
	}

}
