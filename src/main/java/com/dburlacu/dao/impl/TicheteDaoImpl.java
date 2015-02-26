package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.TichetDao;
import com.dburlacu.model.Tichete;

@Repository
public class TicheteDaoImpl implements TichetDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Tichete tichet) {
		session.getCurrentSession().save(tichet);
	}

	@Override
	public void edit(Tichete tichet) {
		session.getCurrentSession().update(tichet);
	}

	@Override
	public void delete(int tichetId) {
		session.getCurrentSession().delete(getTichetById(tichetId));
	}

	@Override
	public void addAll(List<Tichete> tichetList) {
		for(Tichete t:tichetList)
		{
			session.getCurrentSession().save(t);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tichete> getAllTichete() {
		return session.getCurrentSession().createQuery("from Tichete").list();
	}

	@Override
	public Tichete getTichetById(int idTichet) {
		return (Tichete)session.getCurrentSession().get(Tichete.class, idTichet);
	}

}
