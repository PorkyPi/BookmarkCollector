package com.bionic.edu.dao;

import com.bionic.edu.entity.*;

public interface CatalogDao {
	public void addNewCatalog(Catalog catalog);
	public Catalog findCatalogById(int idcatalogId);
	public void updateCatalog(Catalog catalog);
	public void removeCatalog(Catalog catalog);
}
