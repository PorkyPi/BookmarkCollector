
package com.bionic.edu;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.entity.CatalogTreePath;
import com.bionic.edu.services.CatalogServices;

public class testAddNewCatalog {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		
		Catalog catalog = new Catalog();
		catalog.setCatalogName("Bookmarks");
		
		CatalogTreePath catalogTreePath= new CatalogTreePath();
		catalogTreePath.setAncestor(1);
		
		ArrayList<CatalogTreePath> list = new ArrayList<CatalogTreePath>();
		list.add(catalogTreePath);
		catalog.setCatalogTreePath(list);
		catalogTreePath.setCatalog(catalog);
		catalogServices.addNewCatalog(catalog);
		System.out.println(catalog.getCatalogId());
	}
}
