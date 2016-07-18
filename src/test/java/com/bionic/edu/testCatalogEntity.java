package com.bionic.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.*;
import com.bionic.edu.services.*;

public class testCatalogEntity {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		Catalog catalog = new Catalog();
		catalog.setCatalogName("main");
		//catalogServices.save(catalog);
		System.out.println(catalog.getCatalogId());
	}
}
