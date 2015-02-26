package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.RequestDao;
import com.dburlacu.model.Requests;
import com.dburlacu.service.RequestsService;

@Service
public class RequestsServiceImpl implements RequestsService {

	@Autowired
	RequestDao reqDao;
	
	@Transactional
	public void addRequest(Requests req) {
		reqDao.addRequest(req);
	}

	@Transactional
	public void editRequest(Requests req) {
		reqDao.editRequest(req);
	}

	@Transactional
	public void deleteRequest(int idReq) {
		reqDao.deleteRequest(idReq);
	}

	@Transactional
	public List<Requests> getAllRequests() {
		return reqDao.getAllRequests();
	}

	@Transactional
	public Requests getRequestById(int idReq) {
		return reqDao.getRequestById(idReq);
	}

}
