package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Insotitori;

public interface InsotitorService {
	
	public void add(Insotitori sol);
	public void edit(Insotitori sol);
	public void delete(int solId);
	
	public List<Insotitori > getAllInsotitori();
	public Insotitori getInsotitoriById(int idSol);
	public Insotitori getInsotitoriByIdnp(String idnpInsotitor);
	
	public Integer findInsotitorByIdnp(String idnp);

}
