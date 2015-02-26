package com.dburlacu.dao;

import java.util.Date;
import java.util.List;

import com.dburlacu.model.BeneficiarData;
import com.dburlacu.model.Raion;

public interface BeneficiarDao {
	
	public List<BeneficiarData> getAllBeneficiariByDate(Date date);
	public Integer getTotalBeneficiariByDate(Date date);
	public BeneficiarData getBeneficiarByRaionAndDate(Raion raion, Date date);

}
