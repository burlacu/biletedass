package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Documente;

public interface DocumenteService {
	
	public void add(Documente doc);
	
	public List<Documente> getAllDocumente();
	public Documente getDocumentById(int idReq);

}
