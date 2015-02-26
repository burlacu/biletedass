package com.dburlacu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prestator")
public class Prestator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Prestator")
	private int idPrestator;

	@Column(name="Prestator_Name")
	private String prestatorName;
	
	public Prestator() {
	}

	public Prestator(int idPrestator, String prestatorName) {
		super();
		this.idPrestator = idPrestator;
		this.prestatorName = prestatorName;
	}

	public int getIdPrestator() {
		return idPrestator;
	}

	public void setIdPrestator(int idPrestator) {
		this.idPrestator = idPrestator;
	}

	public String getPrestatorName() {
		return prestatorName;
	}

	public void setPrestatorName(String prestatorName) {
		this.prestatorName = prestatorName;
	}
	
}
