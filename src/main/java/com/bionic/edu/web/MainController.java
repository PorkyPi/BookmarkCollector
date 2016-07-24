package com.bionic.edu.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bionic.edu.entity.*;
import com.bionic.edu.services.*;


@Controller
@RequestMapping("/collector")
public class MainController {
	private List<Catalog> clist;
	private List<Bookmark> blist;
	private String catalogView;
	
	@Inject
	CatalogServices catServices;
	@Inject
	BookmarkServices bookServices;

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String mainByCatalog(@RequestParam("catalogId") int catalogId, ModelMap model) {
		this.bealdCatalog(1);
		this.getAllBookmarksByCatalogId(catalogId);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		return "main";
	}
	
	@RequestMapping(value = "/editCatalog", method = RequestMethod.GET)
	public String newCatalog(@RequestParam("catalogId") int catalogId, ModelMap model){
		this.bealdCatalog(1);
		this.getAllBookmarksByCatalogId(catalogId);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		model.addAttribute("catalogEditor", this.createCatalogForm());
		return "main";
	}
	
	/*@RequestMapping(value = "/addCatalog", method = RequestMethod.POST)
	public String addCatalog(@ModelAttribute("catalog")Catalog catalog, ModelMap model){
		catServices.saveCatalog(catalog);
		List<Catalog> clist = catServices.getAllCatalogs();
		CatalogBealder cb = new CatalogBealder();
		String txt = cb.bealdTree(clist, 1);
		txt += "<div>" + "<a class=\"catalogs\" href=\"catalog?catalogId=1\">All</a>" + "</div>";
		List<Bookmark> blist;
		blist = bookServices.getAllBookmarks();
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", txt);
		return "main";
	}*/
	
	private void getAllBookmarksByCatalogId(int catalogId){
		if(catalogId == 1){
			this.blist = bookServices.getAllBookmarks();
		} else {
			this.blist = bookServices.getAllBookmarksByCatalogId(catalogId);
		}
	}
	
	private void bealdCatalog(int catalogId){
		this.catalogView = "";
		this.clist = catServices.getAllCatalogs();
		this.catalogView += "<div>" + "<a class=\"catalogs\" href=\"catalog?catalogId=1\">All</a>" + "</div>";
		this.catalogView += this.bealdTree(clist, catalogId);
		this.catalogView += "<a href=\"editCatalog?catalogId=" + catalogId + "\">ред.</a>" ;
	}
	
	private String bealdTree(List<Catalog> list, int catalogId){
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
	
	private String createCatalogForm(){
		String txt = "<cf:form method=\"POST\" action=\"newCatalog\" modelAttribute=\"catalog\">";
		txt += "<cf:label class=\"catalogLabel\" path=\"catalogId\">Id</cf:label>";
		txt += "<cf:input class=\"catalogEditor\" path=\"catalogId\" />";
		txt += "<cf:label class=\"catalogLabel\" path=\"catalogName\">Id</cf:label>";
		txt += "<cf:input class=\"catalogEditor\" path=\"catalogName\" />";
		txt += "<cf:label class=\"catalogLabel\" path=\"catalogAncestor\">Id</cf:label>";
		txt += "<cf:input class=\"catalogEditor\" path=\"catalogAncestor\" />";
		txt += "<input type=\"submit\" value=\"Save\"/>";
		txt += "</cf:form>";
		return txt;
	}
}
