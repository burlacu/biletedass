package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Specificari;

public interface SpecificService {
	
	public List<Specificari> getAllSpecific();
	public Specificari getSpecificById(int idSpecific);
	public Specificari getSpecificByName(String nameSpecific);

}
