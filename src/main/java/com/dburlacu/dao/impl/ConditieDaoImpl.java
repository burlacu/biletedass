package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.ConditieDao;
import com.dburlacu.model.Conditie;

@Repository
public class ConditieDaoImpl implements ConditieDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Conditie> getAllConditie() {
		
		return session.getCurrentSession().createQuery("from Conditie").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conditie> getAllConditieForInsotitor() {
		
		return session.getCurrentSession().createQuery("from Conditie where Id_Conditie in (1, 2)").list();
	}

	@Override
	public Conditie getConditieById(int idReq) {
		return (Conditie)session.getCurrentSession().get(Conditie.class, idReq);
	}

	@Override
	public Conditie getConditieByName(String nameCond) {
		 Query q = (Query) session.getCurrentSession().createQuery("from Conditie where conditionName=:condName");
		 q.setParameter("condName", nameCond);
		 return (Conditie) q.list().get(0);
	}

}
