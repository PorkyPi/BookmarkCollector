package testsCatalogServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.services.CatalogServices;

public class testUpdateCatalog {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		
		/*Catalog catalog = new Catalog();
		catalog.setCatalogName("HTMLL");
		catalog.setCatalogAncestor(1);
		catalogServices.addNewCatalog(catalog);
		int catalogId = catalog.getCatalogId();
		System.out.println(catalog.toString());*/
		
		Catalog changedCatalog = new Catalog();
		changedCatalog.setCatalogId(101);
		changedCatalog.setCatalogAncestor(1);
		changedCatalog.setCatalogName("Java");
		catalogServices.updateCatalog(changedCatalog);
		System.out.println(changedCatalog.toString());
		
	}
}
