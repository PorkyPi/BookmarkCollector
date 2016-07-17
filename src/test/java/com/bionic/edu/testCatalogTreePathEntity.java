package com.bionic.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.CatalogTreePath;
import com.bionic.edu.services.CatalogTreePathServices;

public class testCatalogTreePathEntity {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogTreePathServices pathServices = context.getBean(CatalogTreePathServices.class);
		CatalogTreePath path = new CatalogTreePath();
		path.setAncestor(1);
		
		pathServices.save(path);
		System.out.println(path.getCatalogTreePathId());
	}
}