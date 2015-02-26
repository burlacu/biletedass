package com.dburlacu.service;

import java.util.List;

import com.dburlacu.model.Raion;

public interface RaionService {
	
		
		public List<Raion> getAllRaion();
		public Raion getRaionById(int idRaion);
		public Raion getRaionByName(String nameRaion);

	}

