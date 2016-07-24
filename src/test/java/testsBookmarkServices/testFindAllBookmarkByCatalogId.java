package testsBookmarkServices;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entity.Bookmark;
import com.bionic.edu.services.BookmarkServices;

public class testFindAllBookmarkByCatalogId {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BookmarkServices services = context.getBean(BookmarkServices.class);
		
		List<Bookmark> list = services.getAllBookmarksByCatalogId(701);
		for(Bookmark bookmark: list){
			System.out.println(bookmark.toString());
		}
	}

}
