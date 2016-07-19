package testsBookmarkServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Bookmark;
import com.bionic.edu.services.BookmarkServices;

public class testRemoveBookmark {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookmarkServices bookmarkServices = context.getBean(BookmarkServices.class);
		
		Bookmark bookmark = new Bookmark();
		bookmark.setBookmarkId(101);
		bookmarkServices.removeBookmark(bookmark);
	}

}
