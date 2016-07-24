package testsBookmarkServices;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Bookmark;
import com.bionic.edu.services.BookmarkServices;

public class testGetAllBookmarks {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookmarkServices bookmarkServices = context.getBean(BookmarkServices.class);
		
		List<Bookmark> bookmarksList = bookmarkServices.getAllBookmarks();
		for(Bookmark bookmark: bookmarksList){
			System.out.println(bookmark.toString());
		}
	}

}
