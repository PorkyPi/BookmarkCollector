package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Bookmark;

@Repository
public class BookmarkDaoImpl implements BookmarkDao {
	@PersistenceContext
	private EntityManager em = null;
	@Override
	public void addNewBookmark(Bookmark bookmark) {
		if(bookmark.getBookmarkId() == 0) 
			em.persist(bookmark);
		else 
			em.merge(bookmark);
	}
	@Override
	public Bookmark findBookmarkById(int bookmarkId) {
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
	@Override
	public List<Bookmark> getAllBookmark() {
		TypedQuery<Bookmark> query = em.createQuery("SELECT b FROM Bookmark b", Bookmark.class);
		return query.getResultList();
		
	}
	@Override
	public List<Bookmark> findAllBookmarksByCatalogId(int catalogId) {
		TypedQuery<Bookmark> query = 
				em.createQuery("SELECT b FROM Bookmark b WHERE b.catalogAncestor = " + catalogId, Bookmark.class);
		return query.getResultList();
	}
}
