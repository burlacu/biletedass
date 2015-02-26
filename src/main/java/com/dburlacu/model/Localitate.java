package com.dburlacu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="localitate")
public class Localitate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Localitate")
	private int id_Localitate;
	
	@Column(name="Denumire_Localitate")
	private String localitateName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Raion_Id", nullable = false)
	private Raion raion;

	public Localitate() {
	}

	public int getId_Localitate() {
		return id_Localitate;
	}

	public void setId_Localitate(int id_Localitate) {
		this.id_Localitate = id_Localitate;
	}

	public String getLocalitateName() {
		return localitateName;
	}

	public void setLocalitateName(String localitateName) {
		this.localitateName = localitateName;
	}

	public Raion getRaion() {
		return raion;
	}

	public void setRaion(Raion raion) {
		this.raion = raion;
	}

}
