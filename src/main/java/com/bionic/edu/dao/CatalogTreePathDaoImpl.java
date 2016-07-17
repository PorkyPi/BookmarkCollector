package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.bionic.edu.entity.CatalogTreePath;

@Repository
public class CatalogTreePathDaoImpl implements CatalogTreePathDao {
	@PersistenceContext
	private EntityManager em = null;

	@Override
	public void save(CatalogTreePath catalogTreePath) {
		em.persist(catalogTreePath);
	}

}
