package com.bionic.edu.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.*;
import com.bionic.edu.entity.*;

@Named
public class CatalogServicesImpl implements CatalogServices {
	@Inject
	private CatalogDao catalogDao;
	
	@Transactional
	public void addNewCatalog(Catalog catalog){
		catalogDao.addNewCatalog(catalog);
	}

	@Transactional
	public Catalog findCatalogById(int catalogId) {
		return catalogDao.findCatalogById(catalogId);
	}

	@Transactional
	public void updateCatalog(Catalog catalog) {
		catalogDao.updateCatalog(catalog);
	}

	@Transactional
	public void removeCatalog(Catalog catalog) {
		catalogDao.removeCatalog(catalog);
	}
}
