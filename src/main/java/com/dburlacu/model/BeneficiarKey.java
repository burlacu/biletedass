package com.dburlacu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
public class BeneficiarKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trimestrul")
	private Date trimestrul;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Raion_Id")
	private Raion raionId;

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
	
}
