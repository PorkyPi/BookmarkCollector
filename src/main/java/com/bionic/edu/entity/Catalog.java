package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogId;
	private String catalogName;
	
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

}
