package testsCatalogServices;

import java.util.List;

import com.bionic.edu.entity.Catalog;

public class Recursion {
	public String bealdTree(List<Catalog> list, int catalogId){
		String txt = "";
		if(list != null){
			for(Catalog catalog: list){
				if(catalog.getCatalogAncestor() == catalogId){
					txt += "<div>" + catalog.getCatalogName();
					txt += this.bealdTree(list, catalog.getCatalogId());
					txt += "</div>";
				}
			}
		}
		return txt;
	}
}
