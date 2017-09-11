package com.hzyc.ebadmin.mapper;

import java.util.List;

import com.hzyc.ebadmin.bean.Book;
import com.hzyc.ebadmin.bean.Page;

public interface BooksMapper {
	//��ѯ����
	public List<Book> showBooks() throws Exception; 
	//����
	public int addBooks(Book book) throws Exception;
	//ɾ��
	public void delBooks(String IBSN) throws Exception;
	//��ISBN��ѯ
	public Book showBooksByISBN(String IBSN) throws Exception;
	
	public void updateBookByISBN(Book book) throws Exception;
	
	public List<Book> queryBooksPage(Page page) throws Exception;
	
	public Page queryBooksCount() throws Exception;
}
