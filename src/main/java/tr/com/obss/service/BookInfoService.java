package tr.com.obss.service;

import java.util.List;

import tr.com.obss.model.BookInfo;

public interface BookInfoService {
	public BookInfo get(int bookID);

	public BookInfo post(BookInfo book);

	public BookInfo put(int bookID, BookInfo book);

	public void delete(int bookID);
	
	public List<BookInfo> getAll();
}
