package com.dburlacu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="beneficiar_data")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class BeneficiarData {
	

	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trimestrul")
	private Date trimestrul;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Raion_Id")
	private Raion raionId;
	
	@Column(name= "Nr_Beneficiari")
	private Integer nrBeneficiari;

	public Date getTrimestrul() {
		return trimestrul;
	}

	public void setTrimestrul(Date trimestrul) {
		this.trimestrul = trimestrul;
	}

	public Raion getRaionId() {
		return raionId;
	}

	public void setRaionId(Raion raionId) {
		this.raionId = raionId;
	}

	public Integer getNrBeneficiari() {
		return nrBeneficiari;
	}

	public void setNrBeneficiari(Integer nrBeneficiari) {
		this.nrBeneficiari = nrBeneficiari;
	}
	
	
}
