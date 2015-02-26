package com.dburlacu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="raion")
public class Raion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Raion")
	private int id_Raion;
	
	@Column(name="DenumireRaion")
	private String raionName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "raion")
	private Set<Localitate> localitate = new HashSet<Localitate>(0);

	public Raion() {
	}

	public int getId_Raion() {
		return id_Raion;
	}

	public void setId_Raion(int id_Raion) {
		this.id_Raion = id_Raion;
	}

	public String getRaionName() {
		return raionName;
	}

	public void setRaionName(String raionName) {
		this.raionName = raionName;
	}
	
}
