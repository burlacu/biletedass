package com.dburlacu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specificari")
public class Specificari {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Specific")
	private int id_Specific;
	
	@Column(name="Denumire")
	private String specificName;
	
	public Specificari() {}

	public int getId_Specific() {
		return id_Specific;
	}

	public void setId_Specific(int id_Specific) {
		this.id_Specific = id_Specific;
	}

	public String getSpecificName() {
		return specificName;
	}

	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}

}
