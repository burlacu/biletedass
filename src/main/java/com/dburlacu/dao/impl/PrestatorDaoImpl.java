package com.dburlacu.dao.impl;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.PrestatorDao;
import com.dburlacu.model.Prestator;

@Repository
public class PrestatorDaoImpl implements PrestatorDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Prestator> getAllPrestator() {
		return session.getCurrentSession().createQuery("from Prestator").list();
	}

	@Override
	public Prestator getPrestatorById(int idPrestator) {
		return (Prestator)session.getCurrentSession().get(Prestator.class, idPrestator);
	}

	@Override
	public Prestator getPrestatorByName(String namePrestator) {
		 Query q = (Query) session.getCurrentSession().createQuery("from Prestator where prestatorName=:condPrestator");
		 q.setParameter("condPrestator", namePrestator);
		 System.out.println(namePrestator);
		 return (Prestator) q.list().get(0);
	}

}
