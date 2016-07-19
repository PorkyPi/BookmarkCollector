package com.bionic.edu.services;

import com.bionic.edu.entity.*;

public interface CatalogServices {
	public void addNewCatalog(Catalog catalog);
	public Catalog findCatalogById(int catalogId);
	public void updateCatalog(Catalog catalog);
	public void removeCatalog(Catalog catalog);
}
