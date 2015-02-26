package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Documente;

public interface DocumenteDao {
	
	public void add(Documente doc);
	
	public List<Documente> getAllDocumente();
	public Documente getDocumentById(int idReq);

}
