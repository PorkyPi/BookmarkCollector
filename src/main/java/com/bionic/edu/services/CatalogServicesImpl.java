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
	public void save(Catalog catalog) {
		catalogDao.save(catalog);
	}
	
	
	public void addNewCatalog(CatalogTreePath ctp, Catalog catalog){
		catalogDao.addNewCatalog(ctp, catalog);
	}
}
