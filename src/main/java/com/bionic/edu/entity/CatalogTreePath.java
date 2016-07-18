package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class CatalogTreePath {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogTreePathId;
	private int ancestor;
	@ManyToOne
	@JoinColumn(name="descendant")
	private Catalog catalog;

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public int getAncestor() {
		return ancestor;
	}

	public void setAncestor(int ancesor) {
		this.ancestor = ancesor;
	}

	public int getCatalogTreePathId() {
		return catalogTreePathId;
	}

	public void setCatalogTreePathId(int catalogTreePathId) {
		this.catalogTreePathId = catalogTreePathId;
	}
	
	public String toString(){
		String txt = "catalogTreePathId = " + catalogTreePathId;
		txt += "; ancestor = " + ancestor;
		return txt;
	}
}
