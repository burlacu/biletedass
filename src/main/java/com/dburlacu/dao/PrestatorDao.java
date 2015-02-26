package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Prestator;

public interface PrestatorDao {
	
	public List<Prestator> getAllPrestator();
	public Prestator getPrestatorById(int idPrestator);
	public Prestator getPrestatorByName(String namePrestator);

}
