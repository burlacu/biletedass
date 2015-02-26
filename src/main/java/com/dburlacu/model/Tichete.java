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
@Table(name="tichete")
public class Tichete {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Tichet")
	private int id_Tichet;
	
	@Column(name="NrDeLa")
	private Integer fromTichet;
	
	@Column(name="NrPinaLa")
	private Integer toTichet;
	
	@Column(name="Seria")
	private String seriaTichet;
	
	@Column(name="Durat")
	private int durataTichet;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Perioada_de_la")
	private Date fromDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Perioada_pina_la")
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Prestator_Id")
	private Prestator prestator;
	
	@Column(name="Cost")
	private double costTichet;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Specific_Id")
	private Specificari specificari;

	public Tichete() {}

	public int getId_Tichet() {
		return id_Tichet;
	}

	public void setId_Tichet(int id_Tichet) {
		this.id_Tichet = id_Tichet;
	}

	public Integer getFromTichet() {
		return fromTichet;
	}

	public void setFromTichet(Integer fromTichet) {
		this.fromTichet = fromTichet;
	}

	public Integer getToTichet() {
		return toTichet;
	}

	public void setToTichet(Integer toTichet) {
		this.toTichet = toTichet;
	}

	public String getSeriaTichet() {
		return seriaTichet;
	}

	public void setSeriaTichet(String seriaTichet) {
		this.seriaTichet = seriaTichet;
	}

	public int getDurataTichet() {
		return durataTichet;
	}

	public void setDurataTichet(int durataTichet) {
		this.durataTichet = durataTichet;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Prestator getPrestator() {
		return prestator;
	}

	public void setPrestator(Prestator prestator) {
		this.prestator = prestator;
	}

	public double getCostTichet() {
		return costTichet;
	}

	public void setCostTichet(double costTichet) {
		this.costTichet = costTichet;
	}

	public Specificari getSpecific() {
		return specificari;
	}

	public void setSpecific(Specificari specificari) {
		this.specificari = specificari;
	}

}
