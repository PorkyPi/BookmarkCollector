package com.bionic.edu.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.BookmarkDao;
import com.bionic.edu.entity.Bookmark;

@Named
public class BookmarkServicesImpl implements BookmarkServices {
	@Inject
	private BookmarkDao bookmarkDao;
	
	@Transactional
	public void addNewBookmark(Bookmark bookmark) {
		bookmarkDao.addNewBookmark(bookmark);
	}

	@Transactional
	public Bookmark findBookmarksById(int bookmarkId) {
		return bookmarkDao.findBookmarksById(bookmarkId);
	}

	@Transactional
	public void updateBookmark(Bookmark bookmark) {
		bookmarkDao.updateBookmark(bookmark);
	}

	@Transactional
	public void removeBookmark(Bookmark bookmark) {
		bookmarkDao.removeBookmark(bookmark);
	}
}
