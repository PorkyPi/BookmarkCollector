package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class BookmarkTreePath {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int linkCollectionTreePathId;
	private int catalogId;
	@ManyToOne
	@JoinColumn(name="bookmarkId")
	private Bookmark bookmark;
	
	public int getLinkCollectionTreePathId() {
		return linkCollectionTreePathId;
	}
	public void setLinkCollectionTreePathId(int linkCollectionTreePathId) {
		this.linkCollectionTreePathId = linkCollectionTreePathId;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public Bookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	
	public String toString(){
		String txt = "linkCollectionTreePathId = " + linkCollectionTreePathId;
		txt += "; catalogId = " + catalogId;
		return txt;
	}
}
