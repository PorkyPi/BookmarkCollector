package com.bionic.edu.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.*;
import com.bionic.edu.entity.*;

@Named
public class CatalogServicesImpl implements CatalogServices {
	@Inject
	private CatalogDao catalogDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void addNewCatalog(Catalog catalog){
		catalogDao.addNewCatalog(catalog);
	}
}
