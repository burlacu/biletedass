package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Prestator;

public interface PrestatorService {
	
	public List<Prestator> getAllPrestator();
	public Prestator getPrestatorById(int idPrestator);
	public Prestator getPrestatorByName(String namePrestator);
	
}
