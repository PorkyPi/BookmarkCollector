package com.bionic.edu.services;

import java.util.List;

import com.bionic.edu.entity.Bookmark;

public interface BookmarkServices {
	public void addNewBookmark(Bookmark bookmark);
	public Bookmark findBookmarkById(int bookmarkId);
	public void updateBookmark(Bookmark bookmark);
	public void removeBookmark(Bookmark bookmark);
	public List<Bookmark> getAllBookmarks();
	public List<Bookmark> getAllBookmarksByCatalogId(int catlogId);
}
