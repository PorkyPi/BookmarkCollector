package com.bionic.edu;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.*;
import com.bionic.edu.services.*;

public class test {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//CatalogServices catalogServices = context.getBean(CatalogServices.class);
		//Catalog catalog = new Catalog();
		//catalog.setCatalogName("HTML");
		//catalogServices.save(catalog);
		//System.out.println("Id = " + catalog.getCatalogId());
		BookmarkServices bookmarkServices = context.getBean(BookmarkServices.class);
		Bookmark bookmark = new Bookmark();
		bookmark.setBookmarkName("First and Test Bookmarks");
		bookmark.setBookmarkRef("www.dddd.com");
		bookmark.setBookmarkDescription("Just first re��");
		bookmark.setMarkAsImportancy(0);
		LocalDate date = LocalDate.of(2016, 7, 8);
		bookmark.setBookmarkAddedDate(java.sql.Date.valueOf(date));
		bookmark.setBookmarkLanguge("Eng");
		bookmarkServices.save(bookmark);
		System.out.println("The bookmark is saved with id =" + bookmark.getBookmarkId());
	}
}
