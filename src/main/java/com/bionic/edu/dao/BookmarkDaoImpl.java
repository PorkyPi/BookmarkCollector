package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Bookmark;

@Repository
public class BookmarkDaoImpl implements BookmarkDao {
	@PersistenceContext
	private EntityManager em = null;
	@Override
	public void addNewBookmark(Bookmark bookmark) {
		em.persist(bookmark);
	}
	@Override
	public Bookmark findBookmarksById(int bookmarkId) {
		return em.find(Bookmark.class, bookmarkId);
	}
	@Override
	public void updateBookmark(Bookmark bookmark) {
		if(em.find(Bookmark.class, bookmark.getBookmarkId()) != null){
			em.merge(bookmark);
		}
	}
	@Override
	public void removeBookmark(Bookmark bookmark) {
		bookmark = em.find(Bookmark.class, bookmark.getBookmarkId());
		if(bookmark != null){
			em.remove(bookmark);
		}
	}
}
