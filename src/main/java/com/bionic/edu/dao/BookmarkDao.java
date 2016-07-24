package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entity.*;

public interface BookmarkDao {
	public void addNewBookmark(Bookmark bookmark);
	public Bookmark findBookmarkById(int bookmarkId);
	public void updateBookmark(Bookmark bookmark);
	public void removeBookmark(Bookmark bookmark);
	public List<Bookmark> getAllBookmark();
	public List<Bookmark> findAllBookmarksByCatalogId(int catalogId);
}
