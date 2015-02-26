package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Requests;

public interface RequestDao {
	

	public void addRequest(Requests req);
	public void editRequest(Requests req);
	public void deleteRequest(int idReq);
	
	public List<Requests> getAllRequests();
	public Requests getRequestById(int idReq);

}
