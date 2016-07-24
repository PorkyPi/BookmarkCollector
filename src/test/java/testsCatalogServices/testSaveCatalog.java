package testsCatalogServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.services.CatalogServices;

public class testSaveCatalog {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		
		Catalog catalog = new Catalog();
		catalog.setCatalogName("AJAX");
		catalog.setCatalogAncestor(101);
		
		catalogServices.saveCatalog(catalog);
		System.out.println(catalog.getCatalogId());
	}
}
