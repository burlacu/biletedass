package com.dburlacu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Blob;


@Entity
@Table(name="documents")
public class Documente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_Document")
	private int id_Document;
	
	@Column(name="Document_Name")
	private String docName;
	
	@Column(name="Document_Blob")
    @Lob
    private Blob documentBlob;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Request_Id")
	private Requests request;
	
	public Documente() {	}

	public int getId_Document() {
		return id_Document;
	}

	public void setId_Document(int id_Document) {
		this.id_Document = id_Document;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Blob getDocumentBlob() {
		return documentBlob;
	}

	public void setDocumentBlob(Blob documentBlob) {
		this.documentBlob = documentBlob;
	}

	public Requests getRequest() {
		return request;
	}

	public void setRequest(Requests request) {
		this.request = request;
	}


}
