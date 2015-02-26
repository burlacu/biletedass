package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.SolicitantDao;
import com.dburlacu.model.Solicitanti;

@Repository
public class SolicitantDaoImpl implements SolicitantDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Solicitanti sol) {
		session.getCurrentSession().save(sol);
	}

	@Override
	public void edit(Solicitanti sol) {
		session.getCurrentSession().update(sol);
	}

	@Override
	public void delete(int idSol) {
		session.getCurrentSession().delete(getSolicitantById(idSol));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitanti> getAllSolicitanti() {
		return session.getCurrentSession().createQuery("from Solicitanti").list();
	}

	@Override
	public Solicitanti getSolicitantById(int idSol) {
		return (Solicitanti)session.getCurrentSession().get(Solicitanti.class, idSol);
	}

	@Override
	public Solicitanti getSolicitantByIdnp(String idnp) {
		 Query q = (Query) session.getCurrentSession().createQuery("from Solicitanti where idnp=:condName");
		 q.setParameter("condName", idnp);
		 return (Solicitanti) q.list().get(0);
	}

	@Override
	public Integer findSolicitantByIdnp(String idnp) {
		Query q = (Query) session.getCurrentSession().createQuery("from Solicitanti where idnp=:condName");
		 q.setParameter("condName", idnp);
		 return q.list().size();
	}

}
