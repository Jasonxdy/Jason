package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.Book;

public class BookRun {
	public static void main(String[] args) {
		Book book1 = new Book();
		System.out.println(book1.inform());
		Book book2 = new Book("�ڹ�������", 20000, 0.2, "����");
		System.out.println(book2.inform());
		System.out.println("====================");
		
		System.out.println("������ ��� Ȯ��");
		book1.setTitle("C���");
		book1.setPrice(30000);
		book1.setDiscountRate(0.1);
		book1.setAuthor("ȫ�浿");
		System.out.println(book1.inform());
		System.out.println("====================");
		
		System.out.println("������ = " + book1.getTitle());
		System.out.println("���ε� ���� = " + (int)(book1.getPrice()*(1-book1.getDiscountRate())));
		System.out.println("������ = " + book2.getTitle());
		System.out.println("���ε� ���� = " + (int)(book2.getPrice()*(1-book2.getDiscountRate())));
		
	}

}
