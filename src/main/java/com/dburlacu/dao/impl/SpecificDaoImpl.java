package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.SpecificDao;
import com.dburlacu.model.Specificari;

@Repository
public class SpecificDaoImpl implements SpecificDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Specificari> getAllSpecific() {
		System.out.println(session.getCurrentSession().toString());
		return session.getCurrentSession().createQuery("from Specificari").list();
	}

	@Override
	public Specificari getSpecificById(int idSpecific) {
		return (Specificari)session.getCurrentSession().get(Specificari.class, idSpecific);
	}

	@Override
	public Specificari getSpecificByName(String nameSpecific) {
		 Query q = (Query) session.getCurrentSession().createQuery("from Specificari where specificName=:condName");
		 q.setParameter("condName", nameSpecific);
		 return (Specificari) q.list().get(0);
	}

}
