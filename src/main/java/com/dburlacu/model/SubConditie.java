package com.dburlacu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="subconditie")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class SubConditie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_SubConditie")
	private int id_SubContition;
	
	@Column(name="Nume")
	private String subConditionName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "conditie_Id")
	@JsonManagedReference
	private Conditie conditie;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "subConditieSolicitant")
	private Set<Solicitanti> solicitant = new HashSet<Solicitanti>(0);
	
	public SubConditie() {	}

	public SubConditie(int id_SubContition, String conditionName) {
		this.id_SubContition = id_SubContition;
		this.subConditionName = conditionName;
	}

	public int getId_SubContition() {
		return id_SubContition;
	}

	public void setId_SubContition(int id_SubContition) {
		this.id_SubContition = id_SubContition;
	}

	public String getSubConditionName() {
		return subConditionName;
	}

	public void setSubConditionName(String subConditionName) {
		this.subConditionName = subConditionName;
	}

	public Conditie getConditie() {
		return conditie;
	}

	public void setConditie(Conditie conditie) {
		this.conditie = conditie;
	}

	@Override
	public String toString() {
		return "SubConditie [id_SubContition=" + id_SubContition
				+ ", subConditionName=" + subConditionName + ", conditie="
				+ conditie + ", solicitant=" + solicitant + "]";
	}
	
	
	
}
