package com.dburlacu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.BeneficiarDao;
import com.dburlacu.model.BeneficiarData;
import com.dburlacu.model.Raion;
import com.dburlacu.service.BeneficiarService;

@Service
public class BeneficiarServiceImpl implements BeneficiarService {

	@Autowired
	BeneficiarDao reqDao;
	
	@Transactional
	public List<BeneficiarData> getAllBeneficiariByDate(Date date) {
		return reqDao.getAllBeneficiariByDate(date);
	}

	@Transactional
	public Integer getTotalBeneficiariByDate(Date date) {
		return reqDao.getTotalBeneficiariByDate(date);
	}

	@Transactional
	public BeneficiarData getBeneficiarByRaionAndDate(Raion raion, Date date) {
		return reqDao.getBeneficiarByRaionAndDate(raion, date);
	}

}
