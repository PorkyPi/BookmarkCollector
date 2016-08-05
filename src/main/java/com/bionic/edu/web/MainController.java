package com.bionic.edu.web;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	private CatalogServices catServices;
	@Inject
	private BookmarkServices bookServices;

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String mainByCatalog(@RequestParam("catalogId") int catalogId, ModelMap model) {
		                                 
		this.getAllBookmarksByCatalogId(catalogId);       //+извлекаем все закладки по номеру каталога
		model.addAttribute("bookmarksList", blist);
		
		this.bealdCatalog(1, catalogId);                  //+-Создаем уже прорисованное дерево каталогов
		model.addAttribute("catalogList", catalogView);
		
		Catalog catalog = new Catalog();                  //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		
		Bookmark bookmark = new Bookmark();               //Добавляем сущность закладки в модель
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "/delateBookmark", method = RequestMethod.GET)
	public String delateBookmark(@RequestParam("bookmarkId") int bookmarkId, ModelMap model){
		Bookmark bookmark = bookServices.findBookmarkById(bookmarkId);
		int catalogId = bookmark.getCatalogAncestor();
		bookServices.removeBookmark(bookmark);
		
		this.getAllBookmarksByCatalogId(catalogId);       //+извлекаем все закладки по номеру каталога
		model.addAttribute("bookmarksList", blist);
		
		this.bealdCatalog(1, catalogId);                  //+-Создаем уже прорисованное дерево каталогов
		model.addAttribute("catalogList", catalogView);
		
		Catalog catalog = new Catalog();                  //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		
		bookmark = new Bookmark();               //Добавляем сущность закладки в модель
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "/deleteCatalog", method = RequestMethod.GET)
	public String deleteCatalogAndBookmarks(@RequestParam("catalogId") int catalogId, ModelMap model){
		Catalog catalog = catServices.findCatalogById(catalogId);
		catServices.removeCatalog(catalog);
		
		this.getAllBookmarksByCatalogId(catalogId);
		for(Bookmark bookmark: blist){
			bookServices.removeBookmark(bookmark);
		}
		
		catalogId = 1;
		
		this.getAllBookmarksByCatalogId(catalogId);       //+извлекаем все закладки по номеру каталога
		model.addAttribute("bookmarksList", blist);
		
		this.bealdCatalog(1, catalogId);                  //+-Создаем уже прорисованное дерево каталогов
		model.addAttribute("catalogList", catalogView);
		
		catalog = new Catalog();                  //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		
		Bookmark bookmark = new Bookmark();               //Добавляем сущность закладки в модель
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "editBookmark", method = RequestMethod.GET)
	public String editBookmark(@RequestParam("bookamrkId") int bookamrkId, ModelMap model) {
		
		Bookmark bookmark = new Bookmark();                     //находим закладку по номеру
		bookmark = bookServices.findBookmarkById(bookamrkId);   
		model.addAttribute("bookmark", bookmark);
		int catalogId = bookmark.getCatalogAncestor();          //для дальнейего функционирования нужен номер каталога
		 
		this.getAllBookmarksByCatalogId(catalogId);             //+извлекаем все закладки по номеру каталога
		model.addAttribute("bookmarksList", blist);
		
		model.addAttribute("catalogList", catalogView);         //+-добавляем в модель наши папки уже берем из построенного дерева
		
		Catalog catalog = new Catalog();                        //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		return "main";
	}
	
	@RequestMapping(value = "/newBookmark", method = RequestMethod.POST)
	public String newBookmark(@Valid @ModelAttribute("bookmark") Bookmark bookmark, BindingResult bindingResult, ModelMap model){
		
		
		if(bindingResult.hasErrors()){
			
			if(bookmark.getBookmarkId() != 0){
				bookmark.setBookmarkAddedDate(Date.valueOf(LocalDate.now()));
				bookServices.addNewBookmark(bookmark);
				int catalogId = bookmark.getCatalogAncestor();
				
				Bookmark newBookmark = new Bookmark();                           
				newBookmark.setCatalogAncestor(catalogId);
				model.addAttribute("bookmark", newBookmark);                      //Добавляем сущность закладки в модель
			}
			
			int catalogId = bookmark.getCatalogAncestor();                    //извлечение номера каталога
			Catalog catalog = new Catalog();                                  //+Добавляем сущность каталога в модель
			catalog.setCatalogAncestor(catalogId);
			model.addAttribute("catalog", catalog);
			
			this.getAllBookmarksByCatalogId(catalogId);
			model.addAttribute("bookmarksList", blist); 
			
			model.addAttribute("catalogList", catalogView);
			
			return "main";
		}
		
		bookmark.setBookmarkAddedDate(Date.valueOf(LocalDate.now()));     //дата сохранения
		bookServices.addNewBookmark(bookmark);                            //сохранение закладки
		
		int catalogId = bookmark.getCatalogAncestor();                    //извлечение номера каталога
		
		Bookmark newBookmark = new Bookmark();                           
		newBookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", newBookmark);                      //Добавляем сущность закладки в модель
		
		this.getAllBookmarksByCatalogId(catalogId);
		model.addAttribute("bookmarksList", blist);                       //Добавляем список наших закладок не обновляя
		
		Catalog catalog = new Catalog();                                  //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		
		model.addAttribute("catalogList", catalogView);                   //+-добавляем в модель наши папки уже берем из построенного дерева
		return "main";
	}
	
	@RequestMapping(value = "/newCatalog", method = RequestMethod.POST)
	public String newCatalog(@Valid @ModelAttribute("catalog") Catalog catalog,  BindingResult bindingResult,  ModelMap model){
		int catalogId = catalog.getCatalogId();                           //для дальнейего функционирования нужен номер каталога
		System.out.println(catalogId);
		if(bindingResult.hasErrors()){
			this.getAllBookmarksByCatalogId(catalogId);                       //+извлекаем все закладки по номеру каталога
			model.addAttribute("bookmarksList", blist);
			
			this.bealdCatalog(1, catalogId);                                  //+-Создаем уже прорисованное дерево каталогов
			model.addAttribute("catalogList", catalogView);
			
			Bookmark bookmark = new Bookmark();                               //Добавляем сущность закладки в модель
			bookmark.setCatalogAncestor(catalogId);
			model.addAttribute("bookmark", bookmark);
			
			return "main";
		}                      
		catServices.saveCatalog(catalog);                                //сохраняем каталог
		
		this.getAllBookmarksByCatalogId(catalogId);                       //+извлекаем все закладки по номеру каталога
		model.addAttribute("bookmarksList", blist);
		
		this.bealdCatalog(1, catalogId);                                  //+-Создаем уже прорисованное дерево каталогов
		model.addAttribute("catalogList", catalogView);
		
		catalog = new Catalog();                                          //+Добавляем сущность каталога в модель
		catalog.setCatalogAncestor(catalogId);
		model.addAttribute("catalog", catalog);
		
		Bookmark bookmark = new Bookmark();                               //Добавляем сущность закладки в модель
		bookmark.setCatalogAncestor(catalogId);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	@RequestMapping(value = "/{catalogId}", method = RequestMethod.GET)
	public String editCatalog(@PathVariable String catalogId, ModelMap model){
		int id = Integer.valueOf(catalogId);                       
		
		Catalog catalog = catServices.findCatalogById(id);                 //Сушность существующего каталога для изменения
		model.addAttribute("catalog", catalog);
		
		model.addAttribute("bookmarksList", blist);                        //все закладки
		
		model.addAttribute("catalogList", catalogView);                    //отображение каталогов
		
		Bookmark bookmark = new Bookmark();                                //Добавляем сущность закладки в модель
		bookmark.setCatalogAncestor(id);
		model.addAttribute("bookmark", bookmark);
		return "main";
	}
	
	
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
		this.catalogView += "<a class=\"buttonreductor\" href=\"" + catalogId + "\">ред.</a>" ;
		this.catalogView += "<a class=\"buttonreductor\" href=\"deleteCatalog?catalogId=" + catalogId + "\">del</a>";
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

	public CatalogServices getCatServices() {
		return catServices;
	}

	public void setCatServices(CatalogServices catServices) {
		this.catServices = catServices;
	}

	public BookmarkServices getBookServices() {
		return bookServices;
	}

	public void setBookServices(BookmarkServices bookServices) {
		this.bookServices = bookServices;
	}
	
	
}
