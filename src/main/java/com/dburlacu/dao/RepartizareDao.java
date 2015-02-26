package com.dburlacu.dao;

import java.util.List;

import com.dburlacu.model.Raion;
import com.dburlacu.model.Repartizare;
import com.dburlacu.model.Tichete;

public interface RepartizareDao {
	
	public void add(Repartizare reaprtizare);
	public void edit(Repartizare reaprtizare);
	public void delete(int reaprtizareId);
	
	public List<Repartizare> getAllReaprtizari();
	public Repartizare getRepartizareById(int idReaprtizare);
	public List<Tichete> getRepartizareByRaion(Raion raion);
	public List<Tichete> getRepartizareByTichet(Tichete tichet);

}
