package com.bionic.edu.dao;

import com.bionic.edu.entity.*;

public interface BookmarkDao {
	public void addNewBookmark(Bookmark bookmark);
	public Bookmark findBookmarksById(int bookmarkId);
	public void updateBookmark(Bookmark bookmark);
	public void removeBookmark(Bookmark bookmark);
}
