package com.bionic.edu.entity;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogId;
	@NotEmpty(message="Name can not be empty")
	private String catalogName;
	private int catalogAncestor;

	public int getCatalogAncestor() {
		return catalogAncestor;
	}

	public void setCatalogAncestor(int catalogAncestor) {
		this.catalogAncestor = catalogAncestor;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public String toString(){
		String txt = "catalogId = " + this.catalogId;
		txt += "; catalogName = " + this.catalogName;
		txt += "; catalogAncestor = " + this.catalogAncestor;
		return txt;
	}

}
