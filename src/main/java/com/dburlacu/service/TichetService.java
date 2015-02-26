package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Tichete;

public interface TichetService {
	
	public void add(Tichete tichet);
	public void edit(Tichete tichet);
	public void delete(int tichetId);
	
	public void addAll(List<Tichete> tichetList);
	
	public List<Tichete> getAllTichete();
	public Tichete getTichetById(int idTichet);

}
