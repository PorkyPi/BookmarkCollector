package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class LinkCollectionTreePath {

	private int ancestor;
	@Id
	private int descendant;

	public int getAncestor() {
		return ancestor;
	}

	public void setAncestor(int ancestor) {
		this.ancestor = ancestor;
	}

	public int getDescendant() {
		return descendant;
	}

	public void setDescendant(int descendant) {
		this.descendant = descendant;
	}

}
