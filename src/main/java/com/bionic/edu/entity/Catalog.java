package com.bionic.edu.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogId;
	private String catalogName;
	@OneToMany(mappedBy="catalog", cascade=CascadeType.PERSIST)
	private Collection<CatalogTreePath> catalogTreePath;
	
	public Collection<CatalogTreePath> getCatalogTreePath() {
		return catalogTreePath;
	}

	public void setCatalogTreePath(Collection<CatalogTreePath> catalogTreePath) {
		this.catalogTreePath = catalogTreePath;
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

}
