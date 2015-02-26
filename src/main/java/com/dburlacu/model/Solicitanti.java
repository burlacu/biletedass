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
@Table(name="solicitanti")
public class Solicitanti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Person")
	private int idSolicitant;
	@Column(name="IDNP")
	private String idnp;
	@Column(name="Nume")
	private String numeSolicitant;
	@Column(name="Prenume")
	private String prenumeSolicitant;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Localitate_Id", nullable = false)
	private Localitate localitate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubConditie_Id", nullable = false)
	private SubConditie subConditieSolicitant;
	
	@Column(name="Is_Angajat")
	private int isAngajat;
	
	public Solicitanti() { }

	public int getIdSolicitant() {
		return idSolicitant;
	}

	public void setIdSolicitant(int idSolicitant) {
		this.idSolicitant = idSolicitant;
	}

	public String getIdnp() {
		return idnp;
	}

	public void setIdnp(String idnp) {
		this.idnp = idnp;
	}

	public String getNumeSolicitant() {
		return numeSolicitant;
	}

	public void setNumeSolicitant(String numeSolicitant) {
		this.numeSolicitant = numeSolicitant;
	}

	public String getPrenumeSolicitant() {
		return prenumeSolicitant;
	}

	public void setPrenumeSolicitant(String prenumeSolicitant) {
		this.prenumeSolicitant = prenumeSolicitant;
	}


	public Localitate getLocalitate() {
		return localitate;
	}

	public void setLocalitate(Localitate localitate) {
		this.localitate = localitate;
	}

	public SubConditie getSubConditieSolicitant() {
		return subConditieSolicitant;
	}

	public void setSubConditieSolicitant(SubConditie subConditieSolicitant) {
		this.subConditieSolicitant = subConditieSolicitant;
	}

	public SubConditie getSubConditie() {
		return subConditieSolicitant;
	}

	public void setSubConditie(SubConditie subConditie) {
		this.subConditieSolicitant = subConditie;
	}

	public int getIsAngajat() {
		return isAngajat;
	}

	public void setIsAngajat(int isAngajat) {
		this.isAngajat = isAngajat;
	}

	@Override
	public String toString() {
		return "Solicitanti [idSolicitant=" + idSolicitant + ", idnp=" + idnp
				+ ", numeSolicitant=" + numeSolicitant + ", prenumeSolicitant="
				+ prenumeSolicitant + ", localitate=" + localitate
				+ ", subConditieSolicitant=" + subConditieSolicitant
				+ ", isAngajat=" + isAngajat + "]";
	}

}
