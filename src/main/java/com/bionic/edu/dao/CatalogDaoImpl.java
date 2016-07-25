package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entity.Catalog;

@Repository
public class CatalogDaoImpl implements CatalogDao {
	@PersistenceContext
	private EntityManager em = null;
	
	@Override
	public void saveCatalog(Catalog catalog){
		if(catalog.getCatalogId() == 0) 
			em.persist(catalog);
		else 
			em.merge(catalog);
	}

	@Override
	public Catalog findCatalogById(int catalogId) {
		return em.find(Catalog.class, catalogId);	
	}

	@Override
	public void removeCatalog(Catalog catalog) {
		catalog = em.find(Catalog.class, catalog.getCatalogId());
		if(catalog != null){
			em.remove(catalog);
		}
	}

	@Override
	public List<Catalog> getAllCatalogs() {
		TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c", Catalog.class);
		List<Catalog> listCatalogs = query.getResultList();
		return listCatalogs;
	}
}
