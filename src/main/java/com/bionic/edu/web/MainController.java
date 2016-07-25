package com.bionic.edu.web;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		this.bealdCatalog(1, catalogId);
		this.getAllBookmarksByCatalogId(catalogId);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		Catalog catalog = new Catalog();
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		Bookmark bookmark = new Bookmark();
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "editBookmark", method = RequestMethod.GET)
	public String editBookmark(@RequestParam("bookamrkId") int bookamrkId, ModelMap model) {
		Bookmark bookmark = new Bookmark();
		bookmark = bookServices.findBookmarkById(bookamrkId);
		model.addAttribute("bookmark", bookmark);
		int catalogId = bookmark.getCatalogAncestor();
		this.getAllBookmarksByCatalogId(catalogId);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		Catalog catalog = new Catalog();
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		return "main";
	}
	
	@RequestMapping(value = "/newBookmark", method = RequestMethod.POST)
	public String newBookmark(@ModelAttribute("bookmark") Bookmark bookmark, ModelMap model){
		bookmark.setBookmarkAddedDate(Date.valueOf(LocalDate.now()));
		System.out.println(bookmark.toString());
		bookServices.addNewBookmark(bookmark);
		int catalogId = bookmark.getCatalogAncestor();
		Bookmark newBookmark = new Bookmark();
		newBookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", newBookmark);
		model.addAttribute("bookmarksList", blist);
		Catalog catalog = new Catalog();
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		model.addAttribute("catalogList", catalogView);
		return "main";
	}
	
	@RequestMapping(value = "/newCatalog", method = RequestMethod.POST)
	public String newCatalog(@ModelAttribute("catalog") Catalog catalog,  ModelMap model){
		catServices.saveCatalog(catalog);
		int catalogId = catalog.getCatalogId();
		this.getAllBookmarksByCatalogId(catalogId);
		this.bealdCatalog(1, catalogId);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		catalog = new Catalog();
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		Bookmark bookmark = new Bookmark();
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "/{catalogId}", method = RequestMethod.GET)
	public String editCatalog(@PathVariable String catalogId, ModelMap model){
		int id = Integer.valueOf(catalogId);
		Catalog catalog = catServices.findCatalogById(id);
		model.addAttribute("bookmarksList", blist);
		model.addAttribute("catalogList", catalogView);
		model.addAttribute("catalog", catalog);
		Bookmark bookmark = new Bookmark();
		bookmark.setCatalogAncestor(id);
		model.addAttribute("bookmark", bookmark);
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
	
	private void bealdCatalog(int catalogAncestor, int catalogId){
		this.catalogView = "";
		this.clist = catServices.getAllCatalogs();
		this.catalogView += "<div>" + "<a class=\"catalogs\" href=\"catalog?catalogId=1\">All</a>" + "</div>";
		this.catalogView += this.bealdTree(clist, catalogAncestor);
		this.catalogView += "<a href=\"" + catalogId + "\">ред.</a>" ;
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
