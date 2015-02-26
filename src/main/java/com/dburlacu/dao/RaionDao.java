package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Raion;

public interface RaionDao {
	
	public List<Raion> getAllRaion();
	public Raion getRaionById(int idRaion);
	public Raion getRaionByName(String nameRaion);

}
