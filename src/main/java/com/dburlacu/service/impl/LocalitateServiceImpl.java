package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.LocalitateDao;
import com.dburlacu.model.Localitate;
import com.dburlacu.model.Raion;
import com.dburlacu.service.LocalitateService;

@Service
public class LocalitateServiceImpl implements LocalitateService {

	@Autowired
	LocalitateDao reqDao;
	
	@Transactional
	public List<Localitate> getAllLocalitate() {
		return reqDao.getAllLocalitate();
	}

	@Transactional
	public Localitate getLocalitateById(int idReq) {
		return reqDao.getLocalitateById(idReq);
	}

	@Transactional
	public List<Localitate> getLocalitateByRaionId(Raion cond) {
		return reqDao.getLocalitateByRaionId(cond);
	}

}
