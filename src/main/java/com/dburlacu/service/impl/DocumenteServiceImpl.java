package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.DocumenteDao;
import com.dburlacu.model.Documente;
import com.dburlacu.service.DocumenteService;

@Service
public class DocumenteServiceImpl implements DocumenteService {

	@Autowired
	DocumenteDao reqDao;
	
	@Transactional
	public void add(Documente doc) {
		reqDao.add(doc);
	}

	@Transactional
	public List<Documente> getAllDocumente() {
		return reqDao.getAllDocumente();
	}

	@Transactional
	public Documente getDocumentById(int idReq) {
		return reqDao.getDocumentById(idReq);
	}

}
