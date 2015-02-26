package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Requests;

public interface RequestsService {

	public void addRequest(Requests req);
	public void editRequest(Requests req);
	public void deleteRequest(int idReq);
	
	public List<Requests> getAllRequests();
	public Requests getRequestById(int idReq);
	
}
