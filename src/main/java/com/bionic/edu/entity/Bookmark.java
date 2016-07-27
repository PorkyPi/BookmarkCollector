package com.bionic.edu.entity;

import java.text.SimpleDateFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookmarkId;
	@NotEmpty(message="Name can not be empty")
	private String bookmarkName;
	@NotEmpty(message="Reference can not be empty")
	private String bookmarkRef;
	@NotEmpty(message="Description can not be empty")
	private String bookmarkDescription;
	@Digits(integer=1 ,fraction=0 , message="Mark must be 1 digit, 1 or 0")
	@Min(0)
	@Max(1)
	private int markAsRead;
	@Digits(integer=1, fraction=0, message="Mark musst be 1 digit, from 0 to 5")
	@Min(0)
	@Max(5)
	private int markAsImportancy;
	private java.sql.Date bookmarkAddedDate;
	@NotEmpty(message="The form languge can not be empty")
	private String bookmarkLanguge;
	private int catalogAncestor;

	public int getCatalogAncestor() {
		return catalogAncestor;
	}

	public void setCatalogAncestor(int catalogAncestor) {
		this.catalogAncestor = catalogAncestor;
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

	public String toString() {
		String txt = "bookmarkId = " + bookmarkId + "; bookmarkName = ";
		txt += bookmarkName + "; bookmarkRef = " + bookmarkRef;
		txt += "; bookmarkDescription = " + bookmarkDescription;
		txt += "; markAsRead = " + markAsRead;
		txt += "; markAsImportancy = " + markAsImportancy;
		SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
		txt += "; bookmarkAddedDate = " + dtFrm;
		txt += "; bookmarkLanguge = " + bookmarkLanguge;
		txt += "; catalogAncestor = " +this.catalogAncestor;
		return txt;
	}
}
