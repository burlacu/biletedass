package com.dburlacu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dburlacu.dao.TichetDao;
import com.dburlacu.model.Tichete;
import com.dburlacu.service.TichetService;

@Service
public class TichetServiceImpl implements TichetService {

	@Autowired
	TichetDao reqDao;

	@Transactional
	public void add(Tichete tichet) {
		reqDao.add(tichet);
	}

	@Transactional
	public void edit(Tichete tichet) {
		reqDao.edit(tichet);
	}

	@Transactional
	public void delete(int tichetId) {
		reqDao.delete(tichetId);
	}

	@Transactional
	public void addAll(List<Tichete> tichetList) {
		reqDao.addAll(tichetList);
	}

	@Transactional
	public List<Tichete> getAllTichete() {
		return reqDao.getAllTichete();
	}

	@Transactional
	public Tichete getTichetById(int idTichet) {
		return reqDao.getTichetById(idTichet);
	}
	
}
