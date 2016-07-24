package com.bionic.edu.services;

import java.util.List;

import com.bionic.edu.entity.Catalog;

public class CatalogBealder {
	
	
	public String bealdTree(List<Catalog> list, int catalogId){
		String txt = "";
		for(Catalog catalog: list){
			if(catalog.getCatalogAncestor() == catalogId){
				txt += "<div>" + "<a class=\"catalogs\" href=\"catalog?catalogId=" + catalog.getCatalogId() + "\">" + catalog.getCatalogName()+"</a>";
				txt += this.bealdTree(list, catalog.getCatalogId());
				txt += "</div>";
			}
		}
		return txt;
	}
}
