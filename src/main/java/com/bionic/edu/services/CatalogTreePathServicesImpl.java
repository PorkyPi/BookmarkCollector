package com.bionic.edu.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.CatalogTreePathDao;
import com.bionic.edu.entity.CatalogTreePath;
@Named
public class CatalogTreePathServicesImpl implements CatalogTreePathServices {
	@Inject
	private CatalogTreePathDao catalogTreePathDao;
	
	@Transactional
	public void save(CatalogTreePath catalogTreePath) {
		catalogTreePathDao.save(catalogTreePath);
	}

}
