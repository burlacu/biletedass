package com.dburlacu.dao.impl;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.RaionDao;
import com.dburlacu.model.Raion;

@Repository
public class RaionDaoImpl implements RaionDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<Raion> getAllRaion() {
		return session.getCurrentSession().createQuery("from Raion").list();
	}

	@Override
	public Raion getRaionById(int idRaion) {
		return (Raion)session.getCurrentSession().get(Raion.class, idRaion);
	}

	@Override
	public Raion getRaionByName(String nameCond) {
		 Query q = (Query) session.getCurrentSession().createQuery("from Raion where raionName=:condName");
		 q.setParameter("condName", nameCond);
		 System.out.println(nameCond);
		 return (Raion) q.list().get(0);
	}

}
