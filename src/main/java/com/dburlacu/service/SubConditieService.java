package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Conditie;
import com.dburlacu.model.SubConditie;

public interface SubConditieService {
	
	public List<SubConditie> getAllSubConditie();
	public SubConditie getSubConditieById(int idReq);
	public List<SubConditie> getSubConditieByConditieId(Conditie cond);
	public List<SubConditie> getAllSubConditieForInsotitoriByCondition(Conditie cond);

}
