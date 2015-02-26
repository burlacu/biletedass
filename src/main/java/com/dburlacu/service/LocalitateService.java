package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Localitate;
import com.dburlacu.model.Raion;

public interface LocalitateService {
	
	public List<Localitate> getAllLocalitate();
	public Localitate getLocalitateById(int idReq);
	public List<Localitate> getLocalitateByRaionId(Raion cond);

}
