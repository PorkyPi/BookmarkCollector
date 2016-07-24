package com.bionic.edu.services;

import java.util.List;

import com.bionic.edu.entity.*;

public interface CatalogServices {
	public void saveCatalog(Catalog catalog);
	public Catalog findCatalogById(int catalogId);
	public void removeCatalog(Catalog catalog);
	public List<Catalog> getAllCatalogs();
}
