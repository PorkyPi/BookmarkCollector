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
	public void save(Bookmark bookmark) {
		em.persist(bookmark);
	}

}
