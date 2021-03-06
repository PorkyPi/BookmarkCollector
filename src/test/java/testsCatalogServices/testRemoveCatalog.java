package testsCatalogServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.services.CatalogServices;

public class testRemoveCatalog {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		
		Catalog catalog = new Catalog();
		catalog.setCatalogAncestor(1);
		catalog.setCatalogId(1);
		catalog.setCatalogName("root");
		catalogServices.removeCatalog(catalog);
	}
}
