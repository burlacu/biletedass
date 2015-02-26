package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.LocalitateDao;
import com.dburlacu.model.Localitate;
import com.dburlacu.model.Raion;

@Repository
public class LocalitateDaoImpl implements LocalitateDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Localitate> getAllLocalitate() {
		return session.getCurrentSession().createQuery("from Localitate").list();
	}

	@Override
	public Localitate getLocalitateById(int idReq) {
		return (Localitate)session.getCurrentSession().get(Localitate.class, idReq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Localitate> getLocalitateByRaionId(Raion cond) {
		Query q = (Query) session.getCurrentSession().createQuery("from Localitate where raion=:conditieParam");
		q.setParameter("conditieParam", cond);
		return q.list();
	}

}
