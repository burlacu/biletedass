package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Specificari;

public interface SpecificDao {
	
	public List<Specificari> getAllSpecific();
	public Specificari getSpecificById(int idSpecific);
	public Specificari getSpecificByName(String nameSpecific);

}
