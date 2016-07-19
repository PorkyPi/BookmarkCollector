package testsBookmarkServices;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Bookmark;
import com.bionic.edu.services.BookmarkServices;

public class testUpdateBookmark {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookmarkServices bookmarkServices = context.getBean(BookmarkServices.class);
		
		/*Bookmark bookmark1 = new Bookmark();
		bookmark1.setBookmarkName("Name");
		bookmark1.setBookmarkRef("someRef");
		bookmark1.setBookmarkDescription("SomeDescription");
		bookmark1.setBookmarkAddedDate(Date.valueOf(LocalDate.now()));
		bookmark1.setBookmarkLanguge("Isp");
		bookmark1.setCatalogAncestor(1);
		bookmark1.setMarkAsImportancy(5);
		bookmark1.setMarkAsRead(0);
		bookmarkServices.addNewBookmark(bookmark1);
		int bookmarkId = bookmark1.getBookmarkId();
		System.out.println(bookmark1.toString());*/
		
		Bookmark bookmark2 = new Bookmark();
		bookmark2.setBookmarkName("MMMMM");
		bookmark2.setBookmarkRef("mmmm");
		bookmark2.setBookmarkDescription("mmm");
		bookmark2.setBookmarkAddedDate(Date.valueOf(LocalDate.now()));
		bookmark2.setBookmarkLanguge("Rus");
		bookmark2.setCatalogAncestor(1);
		bookmark2.setMarkAsImportancy(4);
		bookmark2.setMarkAsRead(1);
		bookmark2.setBookmarkId(101);
		bookmarkServices.updateBookmark(bookmark2);
		System.out.println(bookmark2.toString());
		
	}
}
