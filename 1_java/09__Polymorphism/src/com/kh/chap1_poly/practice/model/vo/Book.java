package com.kh.chap1_poly.practice.model.vo;

public class Book {
	
//	- title : String // ������
//	- author : String // ���ڸ�
//	- publisher : String // ���ǻ��
//	+ Book()
//	+ Book(title:String, author:String,
//	publisher:String)
//	+ toString() : String
	
	private String title;
	private String author;
	private String publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
	

}
