package com.hzyc.Ebcus.bean;

public class Book {
	
	//ISBN ��
	private String ISBN;
	//��Ʒ���
	private int id;
	//��Ʒ��
	private String name;
	//�۸�
	private String price;
	//����
	private String type;
	//��ѯ�ؼ���
	private String keywords;
	//������
	private String pulichouse;
	
	//Ʒ��
	private String brands;
	//��װ
	private String packages;
	//����
	private String format;
	//����ʱ��
	private String publictime;
	//ֽ��
	private String paper;
	//ҳ��
	private String pagenum;
	//����
	private String lang;
	//ͼƬ·��
	private String imagepath;
	//���ݼ��
	private String shortcontent;
	//���߼��
	private String shortauth;
	//����
	private String num;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", type=" + type
				+ ", keywords=" + keywords + ", pulichouse=" + pulichouse
				+ ", ISBN=" + ISBN + ", brands=" + brands + ", packages="
				+ packages + ", format=" + format + ", publictime="
				+ publictime + ", paper=" + paper + ", pagenum=" + pagenum
				+ ", lang=" + lang + "]";
	}
	
	
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getShortcontent() {
		return shortcontent;
	}
	public void setShortcontent(String shortcontent) {
		this.shortcontent = shortcontent;
	}


	public String getShortauth() {
		return shortauth;
	}


	public void setShortauth(String shortauth) {
		this.shortauth = shortauth;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getPulichouse() {
		return pulichouse;
	}
	public void setPulichouse(String pulichouse) {
		this.pulichouse = pulichouse;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPublictime() {
		return publictime;
	}
	public void setPublictime(String publictime) {
		this.publictime = publictime;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	

}
