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
	public void save(Bookmark bookmark) {
		bookmarkDao.save(bookmark);
	}
}
