package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.RepartizareDao;
import com.dburlacu.model.Raion;
import com.dburlacu.model.Repartizare;
import com.dburlacu.model.Tichete;
import com.dburlacu.service.RepartizareService;

@Service
public class RepartizareServiceImpl implements RepartizareService {

	@Autowired
	RepartizareDao reqDao;

	@Transactional
	public void add(Repartizare reaprtizare) {
		reqDao.add(reaprtizare);
	}

	@Transactional
	public void edit(Repartizare reaprtizare) {
		reqDao.edit(reaprtizare);
	}

	@Transactional
	public void delete(int reaprtizareId) {
		reqDao.delete((reaprtizareId));
	}

	@Transactional
	public List<Repartizare> getAllReaprtizari() {
		return reqDao.getAllReaprtizari();
	}

	@Transactional
	public Repartizare getRepartizareById(int idReaprtizare) {
		return reqDao.getRepartizareById(idReaprtizare);
	}

	@Transactional
	public List<Tichete> getRepartizareByRaion(Raion raion) {
		return reqDao.getRepartizareByRaion(raion);
	}

	@Transactional
	public List<Tichete> getRepartizareByTichet(Tichete tichet) {
		return reqDao.getRepartizareByTichet(tichet);
	}

}
