package com.bionic.edu.entity;

import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookmarkId;
	private String bookmarkName;
	private String bookmarkRef;
	private String bookmarkDescription;
	private int markAsRead;
	private int markAsImportancy;
	private java.sql.Date bookmarkAddedDate;
	private String bookmarkLanguge;
	@OneToMany(mappedBy="bookmark", cascade=CascadeType.PERSIST)
	Collection<BookmarkTreePath> bookmarkTreePath;
	
	public Collection<BookmarkTreePath> getBookmarkTreePath() {
		return bookmarkTreePath;
	}

	public void setBookmarkTreePath(Collection<BookmarkTreePath> bookmarkTreePath) {
		this.bookmarkTreePath = bookmarkTreePath;
	}

	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getBookmarkName() {
		return bookmarkName;
	}

	public void setBookmarkName(String bookmarkName) {
		this.bookmarkName = bookmarkName;
	}

	public String getBookmarkRef() {
		return bookmarkRef;
	}

	public void setBookmarkRef(String bookmarkRef) {
		this.bookmarkRef = bookmarkRef;
	}

	public String getBookmarkDescription() {
		return bookmarkDescription;
	}

	public void setBookmarkDescription(String bookmarkDescription) {
		this.bookmarkDescription = bookmarkDescription;
	}

	public int getMarkAsRead() {
		return markAsRead;
	}

	public void setMarkAsRead(int markAsRead) {
		this.markAsRead = markAsRead;
	}

	public int getMarkAsImportancy() {
		return markAsImportancy;
	}

	public void setMarkAsImportancy(int markAsImportancy) {
		this.markAsImportancy = markAsImportancy;
	}

	public java.sql.Date getBookmarkAddedDate() {
		return bookmarkAddedDate;
	}

	public void setBookmarkAddedDate(java.sql.Date bookmarkAddedDate) {
		this.bookmarkAddedDate = bookmarkAddedDate;
	}

	public String getBookmarkLanguge() {
		return bookmarkLanguge;
	}

	public void setBookmarkLanguge(String bookmarkLanguge) {
		this.bookmarkLanguge = bookmarkLanguge;
	}

	public String toString(){
		String txt = "bookmarkId = " + bookmarkId + "; bookmarkName = ";
		txt += bookmarkName + "; bookmarkRef = " + bookmarkRef;
		txt += "; bookmarkDescription = " + bookmarkDescription;
		txt += "; markAsRead = " + markAsRead;
		txt += "; markAsImportancy = " + markAsImportancy;
		SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
		txt += "; bookmarkAddedDate = " + dtFrm;
		txt += "; bookmarkLanguge = " + bookmarkLanguge;
		return txt;
	}
}
