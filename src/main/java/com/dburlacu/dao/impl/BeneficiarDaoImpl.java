package com.dburlacu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dburlacu.dao.BeneficiarDao;
import com.dburlacu.model.BeneficiarData;
import com.dburlacu.model.Raion;

@Repository
public class BeneficiarDaoImpl implements BeneficiarDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<BeneficiarData> getAllBeneficiariByDate(Date date) {
		Query q = (Query) session.getCurrentSession().createQuery("from BeneficiarData where trimestrul=:condName");
		q.setParameter("condName", date);
		return q.list();
	}

	@Override
	public BeneficiarData getBeneficiarByRaionAndDate(Raion raion, Date date) {
		Query q = (Query) session.getCurrentSession().createQuery("from BeneficiarData where trimestrul=:condName1 and raionId=:condName2");
		q.setParameter("condName1", date);
		q.setParameter("condName2", raion);
		return (BeneficiarData) q.list().get(0);
	}

	@Override
	public Integer getTotalBeneficiariByDate(Date date) {
		// TODO Auto-generated method stub
		Query q = (Query) session.getCurrentSession().createQuery("select sum(nrBeneficiari) from BeneficiarData where trimestrul=:condName");
		q.setParameter("condName", date);
		return ((Long)q.uniqueResult()).intValue();
	}

}
