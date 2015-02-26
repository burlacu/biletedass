package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.RepartizareDao;
import com.dburlacu.model.Raion;
import com.dburlacu.model.Repartizare;
import com.dburlacu.model.Tichete;

@Repository
public class RepartizareDaoImpl implements RepartizareDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Repartizare reaprtizare) {
		session.getCurrentSession().save(reaprtizare);
	}

	@Override
	public void edit(Repartizare reaprtizare) {
		session.getCurrentSession().update(reaprtizare);
	}
	
	@Override
	public void delete(int repartizareId) {
		session.getCurrentSession().delete(getRepartizareById(repartizareId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Repartizare> getAllReaprtizari() {
		return session.getCurrentSession().createQuery("from Repartizare").list();
	}

	@Override
	public Repartizare getRepartizareById(int idReaprtizare) {
		return (Repartizare)session.getCurrentSession().get(Repartizare.class, idReaprtizare);
	}

	@SuppressWarnings("unchecked")
	public List<Tichete> getRepartizareByTichet(Tichete t) {
		Query q = (Query) session.getCurrentSession().createQuery("from Repartizare where tichet=:conditieParam");
		q.setParameter("conditieParam", t);
		return q.list();
	}

	@SuppressWarnings("unchecked" )
	@Override
	public List<Tichete> getRepartizareByRaion(Raion raion) {
		Query q = (Query) session.getCurrentSession().createQuery("from Repartizare where raionId=:conditieParam");
		q.setParameter("conditieParam", raion);
		return q.list();
	}

}
