package com.bionic.edu.services;

import java.util.List;

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
	public void saveCatalog(Catalog catalog){
		catalogDao.saveCatalog(catalog);
	}

	@Transactional
	public Catalog findCatalogById(int catalogId) {
		return catalogDao.findCatalogById(catalogId);
	}

	@Transactional
	public void removeCatalog(Catalog catalog) {
		catalogDao.removeCatalog(catalog);
	}

	@Transactional
	public List<Catalog> getAllCatalogs() {
		return catalogDao.getAllCatalogs();
	}
	
}
