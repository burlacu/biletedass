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
@Table(name="insotitori")
public class Insotitori {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Insotitor")
	private int idInsotitor;
	@Column(name="IDNP")
	private String idnp;
	@Column(name="Nume")
	private String numeInsotitor;
	@Column(name="Prenume")
	private String prenumeInsotitor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Localitate_Id", nullable = false)
	private Localitate localitate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubConditie_Id", nullable = false)
	private SubConditie subConditieInsotitor;
	
	@Column(name="Is_Angajat")
	private int isAngajat;
	
	public Insotitori() { }

	public int getIdInsotitor() {
		return idInsotitor;
	}

	public void setIdInsotitor(int idInsotitor) {
		this.idInsotitor = idInsotitor;
	}

	public String getIdnp() {
		return idnp;
	}

	public void setIdnp(String idnp) {
		this.idnp = idnp;
	}

	public String getNumeInsotitor() {
		return numeInsotitor;
	}

	public void setNumeInsotitor(String numeInsotitor) {
		this.numeInsotitor = numeInsotitor;
	}

	public String getPrenumeInsotitor() {
		return prenumeInsotitor;
	}

	public void setPrenumeInsotitor(String prenumeInsotitor) {
		this.prenumeInsotitor = prenumeInsotitor;
	}

	public Localitate getLocalitate() {
		return localitate;
	}

	public void setLocalitate(Localitate localitate) {
		this.localitate = localitate;
	}

	public SubConditie getSubConditieInsotitor() {
		return subConditieInsotitor;
	}

	public void setSubConditieInsotitor(SubConditie subConditieInsotitor) {
		this.subConditieInsotitor = subConditieInsotitor;
	}

	public int getIsAngajat() {
		return isAngajat;
	}

	public void setIsAngajat(int isAngajat) {
		this.isAngajat = isAngajat;
	}

}
