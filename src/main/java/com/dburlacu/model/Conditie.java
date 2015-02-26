package com.dburlacu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="conditie")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Conditie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Conditie")
	private int id_Contition;
	
	@Column(name="Name")
	private String conditionName;
	
//	@OneToMany(fetch = FetchType.EAGER)//(fetch = FetchType.EAGER, mappedBy = "conditie")
//	@JoinTable(name = "subconditie", joinColumns = @JoinColumn(name = "Id_Conditie"), inverseJoinColumns = @JoinColumn(name = "Conditie_Id"))
//	@JsonIgnore
//	@JsonBackReference
//	private Set<SubConditie> subConditie;// = new HashSet<SubConditie>(0);

	public Conditie() {
	}

	public int getId_Contition() {
		return id_Contition;
	}

	public void setId_Contition(int id_Contition) {
		this.id_Contition = id_Contition;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

//	public Set<SubConditie> getSubConditie() {
//		return subConditie;
//	}
//
//	public void setSubConditie(Set<SubConditie> subConditie) {
//		this.subConditie = subConditie;
//	}
	
}
