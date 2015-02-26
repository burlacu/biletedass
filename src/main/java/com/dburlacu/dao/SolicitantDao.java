package com.dburlacu.dao;

import java.util.List;
import com.dburlacu.model.Solicitanti;

public interface SolicitantDao {
	
	public void add(Solicitanti sol);
	public void edit(Solicitanti sol);
	public void delete(int solId);
	
	public List<Solicitanti> getAllSolicitanti();
	public Solicitanti getSolicitantById(int idSol);
	public Solicitanti getSolicitantByIdnp(String idnp);
	
	public Integer findSolicitantByIdnp(String idnp);

}
