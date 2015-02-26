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
@Table(name="repartizare")
public class Repartizare {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Repartizare")
	private int id_Repartizare;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Raion_Id")
	private Raion raionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Tichet_Id")
	private Tichete tichet;
	
	@Column(name="Total_Tichete")
	private int totalTichet;
	
	public Repartizare() {}

	public int getId_Repartizare() {
		return id_Repartizare;
	}

	public void setId_Repartizare(int id_Repartizare) {
		this.id_Repartizare = id_Repartizare;
	}

	public Raion getRaionId() {
		return raionId;
	}

	public void setRaionId(Raion raionId) {
		this.raionId = raionId;
	}

	public Tichete getTichet() {
		return tichet;
	}

	public void setTichet(Tichete tichet) {
		this.tichet = tichet;
	}

	public int getTotalTichet() {
		return totalTichet;
	}

	public void setTotalTichet(int totalTichet) {
		this.totalTichet = totalTichet;
	}

}