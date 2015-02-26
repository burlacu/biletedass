package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Conditie;

public interface ConditieService {
	
	public List<Conditie> getAllConditie();
	public List<Conditie> getAllConditieForInsotitor();
	public Conditie getConditieById(int idReq);
	public Conditie getConditieByName(String nameCond);
	
}
