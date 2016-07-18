package com.bionic.edu;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.*;
import com.bionic.edu.services.*;


public class testAddNewBookmark {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookmarkServices bookmarkServices = context.getBean(BookmarkServices.class);
		
		Bookmark bookmark = new Bookmark();
		bookmark.setBookmarkName("Модель иерархии данных с SQL и PHP");
		bookmark.setBookmarkRef("slideshare.net/billkarwin/models-for-hierarchical-data");
		bookmark.setBookmarkDescription("Презентация о моделях представления данных в БД");
		bookmark.setMarkAsRead(0);
		bookmark.setMarkAsImportancy(3);
		bookmark.setBookmarkAddedDate(Date.valueOf(LocalDate.of(2016, 7, 18)));
		bookmark.setBookmarkLanguge("Eng");
		
		BookmarkTreePath bookmarkPath = new BookmarkTreePath();
		bookmarkPath.setCatalogId(1);
		
		ArrayList<BookmarkTreePath> list = new ArrayList<BookmarkTreePath>();
		list.add(bookmarkPath);
		bookmark.setBookmarkTreePath(list);
		bookmarkPath.setBookmark(bookmark);
		bookmarkServices.addNewBookmark(bookmark);
	}
}
