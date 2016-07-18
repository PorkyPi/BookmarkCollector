package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Catalog;

@Repository
public class CatalogDaoImpl implements CatalogDao {
	@PersistenceContext
	private EntityManager em = null;
	
	public void addNewCatalog(Catalog catalog){
		em.persist(catalog);
	}
}
