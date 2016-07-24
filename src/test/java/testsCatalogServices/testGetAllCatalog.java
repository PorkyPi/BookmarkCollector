package testsCatalogServices;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Catalog;
import com.bionic.edu.services.CatalogServices;

public class testGetAllCatalog {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CatalogServices catalogServices = context.getBean(CatalogServices.class);
		
		List<Catalog> catalogsList = catalogServices.getAllCatalogs();
		for(Catalog cat: catalogsList){
			System.out.println(cat.toString());
		}
		Recursion rec = new Recursion();
		String txt = rec.bealdTree(catalogsList, 1);
		System.out.println(txt);
	}
}
