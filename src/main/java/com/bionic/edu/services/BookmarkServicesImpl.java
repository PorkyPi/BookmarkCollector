package com.bionic.edu.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.BookmarkDao;
import com.bionic.edu.entity.Bookmark;

@Named
public class BookmarkServicesImpl implements BookmarkServices {
	@Inject
	private BookmarkDao bookmarkDao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addNewBookmark(Bookmark bookmark) {
		bookmarkDao.addNewBookmark(bookmark);
	}
}
