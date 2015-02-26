package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.DocumenteDao;
import com.dburlacu.model.Documente;

@Repository
public class DocumenteDaoImpl implements DocumenteDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Documente doc) {
		session.getCurrentSession().save(doc);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documente> getAllDocumente() {
		return session.getCurrentSession().createQuery("from Documente").list();
	}

	@Override
	public Documente getDocumentById(int idReq) {
		return (Documente)session.getCurrentSession().get(Documente.class, idReq);
	}

}
