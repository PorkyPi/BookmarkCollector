package com.bionic.edu.services;

import java.util.List;

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
	public Bookmark findBookmarkById(int bookmarkId) {
		return bookmarkDao.findBookmarkById(bookmarkId);
	}

	@Transactional
	public void updateBookmark(Bookmark bookmark) {
		bookmarkDao.updateBookmark(bookmark);
	}

	@Transactional
	public void removeBookmark(Bookmark bookmark) {
		bookmarkDao.removeBookmark(bookmark);
	}

	@Transactional
	public List<Bookmark> getAllBookmarks() {
		return bookmarkDao.getAllBookmark();
	}

	@Transactional
	public List<Bookmark> getAllBookmarksByCatalogId(int catalogId) {
		return bookmarkDao.findAllBookmarksByCatalogId(catalogId);
	}
	
}
