package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.entity.CatalogTreePath;

@Repository
public class CatalogDaoImpl implements CatalogDao {
	@PersistenceContext
	private EntityManager em = null;
	
	@Override
	public void save(Catalog catalog) {
		em.persist(catalog);
	}
	
	public void addNewCatalog(CatalogTreePath ctp, Catalog catalog){
		em.persist(catalog);
		ctp.setDescendant(catalog.getCatalogId());
		em.persist(ctp);
	}
}
