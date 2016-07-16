package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class CatalogTreePath {
	@Id
	private int descendant;

	private int ancesor;

	public int getDescendant() {
		return descendant;
	}

	public void setDescendant(int descendant) {
		this.descendant = descendant;
	}

	public int getAncesor() {
		return ancesor;
	}

	public void setAncesor(int ancesor) {
		this.ancesor = ancesor;
	}
}
