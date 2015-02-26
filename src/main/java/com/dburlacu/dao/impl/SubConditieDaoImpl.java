package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.SubConditieDao;
import com.dburlacu.model.Conditie;
import com.dburlacu.model.SubConditie;

@Repository
public class SubConditieDaoImpl implements SubConditieDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<SubConditie> getAllSubConditie() {
		return session.getCurrentSession().createQuery("from SubConditie").list();
	}

	@Override
	public SubConditie getSubConditieById(int idReq) {
		return (SubConditie)session.getCurrentSession().get(SubConditie.class, idReq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubConditie> getSubConditieByConditieId(Conditie cond) {
		Query q = (Query) session.getCurrentSession().createQuery("from SubConditie where conditie=:conditieParam");
		q.setParameter("conditieParam", cond);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubConditie> getAllSubConditieForInsotitoriByCondition(Conditie cond) {
		Query q = (Query) session.getCurrentSession().createQuery("from SubConditie where id_SubContition in (3, 5, 6) and conditie=:conditieParam");
		q.setParameter("conditieParam", cond);
		return q.list();
	}

}
