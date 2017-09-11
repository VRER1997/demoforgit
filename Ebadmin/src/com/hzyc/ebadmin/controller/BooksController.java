package com.hzyc.ebadmin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hzyc.ebadmin.bean.Book;
import com.hzyc.ebadmin.bean.Page;
import com.hzyc.ebadmin.service.Impl.BooksServImpl;

@Controller
public class BooksController {
	
	@Autowired
	private BooksServImpl booksServImpl;
	
	@Autowired
	private Page page;
	
	@RequestMapping("showBook.do")
	public ModelAndView showBook() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		List<Book> list = booksServImpl.showBooks();
		mav.addObject("list", list);
		mav.setViewName("show_book.jsp");
		return mav;
	}
	
	@RequestMapping("delBook.do")
	public String delBook(String ISBN) throws Exception{
		
		System.out.println(ISBN);
		booksServImpl.delBooks(ISBN);
		
		return "queryBooksPage.do";
	}
	
	@RequestMapping("delBooks.do")
	public String delBooks(String [] ISBN) throws Exception{
		
		System.out.println(ISBN);
		for (String item : ISBN) {
			booksServImpl.delBooks(item);
		}
		
		return "queryBooksPage.do";
	}
	/*@RequestMapping("addBook.do")
	public String addBooks(Book book) throws Exception{
		
		booksServImpl.addBooks(book);
		return "showBook.do";		
	}*/
	
	//��ʾ�鼮����ϸ��Ϣ
	@RequestMapping("showBookByISBN.do")
	protected ModelAndView showBookByISBN(String ISBN) throws Exception {
		Book book = new Book();
		book = booksServImpl.showBooksByISBN(ISBN);
		System.out.println(book);
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", book);
		mav.setViewName("show_book_modal.jsp");
		return mav;
	}
	
	//�����鼮��Ϣ
	@RequestMapping("updateBookByISBN.do")
	protected ModelAndView updateBookByISBN(String ISBN) throws Exception {
		Book book = new Book();
		book = booksServImpl.showBooksByISBN(ISBN);
		System.out.println(book);
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", book);
		mav.setViewName("update_book.jsp");
		return mav;
	}
	
	@RequestMapping("showBookByISBN1.do")
	protected void showBookByISBN11(String ISBN, HttpServletResponse response) throws Exception {
		//PrintWriter�Ǹ���  �ַ���
		System.out.println(ISBN);
		Book book = new Book();
		book = booksServImpl.showBooksByISBN(ISBN);
		System.out.println(book);
		PrintWriter out = response.getWriter();		
		Gson gson = new Gson();
		String bookinfo = gson.toJson(book);
		out.write(bookinfo);
		out.flush();//ˢ�£�����
		out.close();
	}
	
	//��ͼƬͬʱ���ݵ��ͷ��˵ķ�����
	public  void copy(String name) throws IOException{
	    
		String base = "D:/Desk/DeskAA/hzyc/java_web_tem/.metadata/.me_tcat7/webapps/";
	    //1.��ȡ���������ֽ���
	    //�ҵ�ͼƬ·��
	    File file  = new File(base+"Ebadmin/image/"+name);
	    
	    FileInputStream inputStream = new FileInputStream(file);
	    //2.д����������ֽ���
	    File file1  = new File(base+"EbCus/image/"+name);
	    FileOutputStream outputStream = new FileOutputStream(file1);
	    
	    byte [] b = new byte[1024];
	    
	    while (inputStream.read(b)!=-1) {
	        
	        outputStream.write(b);
	        
	    }
	    //�ر���  �ر���ԭ���ȿ���أ����ȹء�
	    
	    outputStream.close();
	    inputStream.close();
	      
	    
	    
	}
	/**
	 * ����鼮
	 * @param image
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addBook.do")
	public String upload(MultipartFile image,HttpServletRequest request) throws Exception{
		//ModelAndView mav = new ModelAndView();
		System.out.println("upload.....");
		String imageName = image.getOriginalFilename();//��ȡͼƬ������
		System.out.println(imageName);
		
		//ͼƬ���֣�ʱ�����
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		imageName = date+imageName;
		
		/*
		 * ��ͼƬд������
		 */
		String tomcatPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(tomcatPath);
		System.out.println(tomcatPath+"image/"+imageName);
		System.out.println(tomcatPath+"image\\"+imageName);
		File file = new File(tomcatPath+"image/"+imageName);
		//File file1 = new File("D:\Desk\DeskAA\hzyc\java_web_tem\.metadata\.me_tcat7\webapps\EbCus\image"+imageName);
		image.transferTo(file);//�൱�ڶԽ�
		//image.transferTo(file1);
		
		//��ͼƬ����ת�洦��
		copy(imageName);
		//UUID
		Book book = new Book();
		book.setISBN(request.getParameter("ISBN"));
		book.setName(request.getParameter("name"));
		book.setPrice(request.getParameter("price"));
		book.setType(request.getParameter("type"));
		book.setKeywords(request.getParameter("keywords"));
		book.setPulichouse(request.getParameter("pulichouse"));
		book.setBrands(request.getParameter("brands"));
		book.setPackages(request.getParameter("packages"));
		book.setFormat(request.getParameter("format"));
		book.setPublictime(request.getParameter("publictime"));
		book.setPaper(request.getParameter("paper"));
		book.setPagenum(request.getParameter("pagenum"));
		book.setLang(request.getParameter("lang"));
		book.setImagepath(imageName);
		book.setShortcontent(request.getParameter("shortcontent"));
		book.setShortauth(request.getParameter("shortauth"));
		book.setTitle(request.getParameter("title"));
		System.out.println(book);
		int ans = booksServImpl.addBooks(book);
		/*if(i>0){
			List<Image> list = uploadServImpl.selImage();
			//mav.addObject("list", list);
			//mav.setViewName("show_image.jsp");
		}*/
		System.out.println(ans);
		return "queryBooksPage.do";
	}
	//�����鼮
	@RequestMapping("updateBook.do")
	public void updateBookByISBN(HttpServletRequest request) throws Exception{
		
		Book book = booksServImpl.showBooksByISBN(request.getParameter("ISBN"));
		System.out.println("update....");
		System.out.println(book);
		book.setName(request.getParameter("name"));
		book.setPrice(request.getParameter("price"));
		book.setType(request.getParameter("type"));
		book.setKeywords(request.getParameter("keywords"));
		book.setPulichouse(request.getParameter("pulichouse"));
		book.setPackages(request.getParameter("packages"));
		book.setFormat(request.getParameter("format"));
		book.setPublictime(request.getParameter("publictime"));
		/*book.setPaper(request.getParameter("paper"));*/
		book.setPagenum(request.getParameter("pagenum"));
		book.setLang(request.getParameter("lang"));
		book.setShortcontent(request.getParameter("shortcontent"));
		book.setShortauth(request.getParameter("shortauth"));
		book.setTitle(request.getParameter("title"));
		book.setNum(request.getParameter("num"));
		
		booksServImpl.updateBookByISBN(book);
	}
	/**
	 * ��ҳ
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryBooksPage.do")
	public ModelAndView queryGoodsPage() throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("��ǰҳ1"+page.getNowPage());
		System.out.println(page);
		page.initStartPosition();
		List<Book> list = booksServImpl.queryBooksPage(page);
		int temp = page.getNowPage();
		page = booksServImpl.queryBooksCount();
		page.setNowPage(temp);
		page.pageNum();
		System.out.println("��ǰҳ2"+page.getNowPage());
		mav.addObject("list", list);
		mav.addObject("page", page);
		mav.setViewName("show_book.jsp");
		return mav;
	}
	//���Ϸ�ҳ
	@RequestMapping("pageUp.do")
	public String pageUp(String nowPage) throws Exception {
		System.out.println(nowPage);
		int nPage = Integer.parseInt(nowPage);
		nPage = (nPage==1)?1:(nPage-1);
		
		page.setNowPage(nPage);
		System.out.println("��һҳ֮��"+nPage);
		return "queryBooksPage.do";
	}
	//���·�ҳ
	@RequestMapping("pageDown.do")
	public String pageDown(String nowPage) throws Exception {
		int nPage = Integer.parseInt(nowPage);
		System.out.println("��ҳ..");
		if(page.getNowPage() < page.getPageNum()) 
			nPage++;
		page.setNowPage(nPage);
		
		return "queryBooksPage.do";
	}
	
}
