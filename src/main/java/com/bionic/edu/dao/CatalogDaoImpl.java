package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Catalog;

@Repository
public class CatalogDaoImpl implements CatalogDao {
	@PersistenceContext
	private EntityManager em = null;
	
	@Override
	public void addNewCatalog(Catalog catalog){
		em.persist(catalog);
	}

	@Override
	public Catalog findCatalogById(int catalogId) {
		return em.find(Catalog.class, catalogId);	
	}

	@Override
	public void updateCatalog(Catalog catalog) {
		if(em.find(Catalog.class, catalog.getCatalogId()) != null){	
			em.merge(catalog);
		}
	}

	@Override
	public void removeCatalog(Catalog catalog) {
		catalog = em.find(Catalog.class, catalog.getCatalogId());
		if(catalog != null){
			em.remove(catalog);
		}
	}
}
