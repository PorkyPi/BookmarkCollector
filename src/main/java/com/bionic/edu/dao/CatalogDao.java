package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.*;

public interface CatalogDao {
	public void saveCatalog(Catalog catalog);
	public Catalog findCatalogById(int idcatalogId);
	public void removeCatalog(Catalog catalog);
	public List<Catalog> getAllCatalogs();
}
