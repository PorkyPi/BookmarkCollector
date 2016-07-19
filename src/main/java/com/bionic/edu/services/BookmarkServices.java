package com.bionic.edu.services;

import com.bionic.edu.entity.Bookmark;

public interface BookmarkServices {
	public void addNewBookmark(Bookmark bookmark);
	public Bookmark findBookmarksById(int bookmarkId);
	public void updateBookmark(Bookmark bookmark);
	public void removeBookmark(Bookmark bookmark);
}
