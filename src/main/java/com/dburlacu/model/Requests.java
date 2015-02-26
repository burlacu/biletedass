package com.dburlacu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="request_table")
public class Requests {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Request")
	private int requestId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Solicitant_Id")
	private Solicitanti solicitanti;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Insotitor_Id")
	private Insotitori insotitori;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Specific_Id")
	private Specificari specificari;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Data_Request")
	private Date requestDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Data_Emitere")
	private Date outDate;
	
	@Column(name = "Is_Urgent")
	private Integer isUrgent;
	
	public Requests() {	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Solicitanti getSolicitanti() {
		return solicitanti;
	}

	public void setSolicitanti(Solicitanti solicitanti) {
		this.solicitanti = solicitanti;
	}

	public Insotitori getInsotitori() {
		return insotitori;
	}

	public void setInsotitori(Insotitori insotitori) {
		this.insotitori = insotitori;
	}

	public Specificari getSpecificari() {
		return specificari;
	}

	public void setSpecificari(Specificari specificari) {
		this.specificari = specificari;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Integer getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

}