package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Conditie;

public interface ConditieDao {
	
	public List<Conditie> getAllConditie();
	public Conditie getConditieById(int idReq);
	public Conditie getConditieByName(String nameCond);
	public List<Conditie> getAllConditieForInsotitor();

}
