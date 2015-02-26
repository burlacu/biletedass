package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.RequestDao;
import com.dburlacu.model.Requests;

@Repository
public class RequestDaoImpl implements RequestDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void addRequest(Requests req) {
		session.getCurrentSession().save(req);
	}

	@Override
	public void editRequest(Requests req) {
		session.getCurrentSession().update(req);
	}

	@Override
	public void deleteRequest(int idReq) {
		session.getCurrentSession().delete(getRequestById(idReq));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Requests> getAllRequests() {
		return session.getCurrentSession().createQuery("from Requests").list();
	}

	@Override
	public Requests getRequestById(int idReq) {
		return (Requests)session.getCurrentSession().get(Requests.class, idReq);
	}

}
