package com.dburlacu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.InsotitorDao;
import com.dburlacu.model.Insotitori;

@Repository
public class InsotitorDaoImpl implements InsotitorDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Insotitori sol) {
		session.getCurrentSession().save(sol);
	}

	@Override
	public void edit(Insotitori sol) {
		session.getCurrentSession().update(sol);
	}
	
	@Override
	public void delete(int idSol) {
		session.getCurrentSession().delete(getInsotitoriById(idSol));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Insotitori> getAllInsotitori() {
		return session.getCurrentSession().createQuery("from Insotitori").list();
	}

	@Override
	public Insotitori getInsotitoriById(int idSol) {
		return (Insotitori)session.getCurrentSession().get(Insotitori.class, idSol);
	}

	@Override
	public Insotitori getInsotitoriByIdnp(String idnpInsotitor) {
		Query q = (Query) session.getCurrentSession().createQuery("from Insotitori where idnp=:condName");
		 q.setParameter("condName", idnpInsotitor);
		 return (Insotitori) q.list().get(0);
	}

	@Override
	public Integer findInsotitorByIdnp(String idnp) {
		Query q = (Query) session.getCurrentSession().createQuery("from Insotitori where idnp=:condName");
		 q.setParameter("condName", idnp);
		 return q.list().size();
	}

}
