package com.kh.objectArray.controller;

import java.util.Scanner;

import com.kh.objectArray.model.vo.Book;

public class BookController {
	
	public void method1() {
		
		// Book ��ü�� 3�� ���� ������ ���� �˸°� �ʱ�ȭ�� �� �� 
		// å ������ �Է¹޾� �ش� å�� ������ å ���� ���, ������ "�ش��ϴ� å�� �����ϴ�" ���
		
		// ũ�Ⱑ 3�� Book�迭�� ���� �� �Ҵ� 
		Book books[] = new Book[3];
		Scanner sc = new Scanner(System.in);
		
		// Book �迭�� �� ��Ҹ� �ʱ�ȭ
		books[0] = new Book("�ڹ�������", "���ü�", "��������", 30000);
		books[1] = new Book("C���������", "������", "KH����", 60000);
		books[2] = new Book("����������", "ȫ����", "��������", 60000);
		
		//Book �迭�� ����� ��� å�� ���� ���
		/*
		System.out.println(books[0].inform());
		System.out.println(books[1].inform());
		System.out.println(books[2].inform());
		*/
		
		for (int i = 0; i<books.length;i++) {
			// books�� i��° �ε��� ��Ұ� ������ �ִ� inform()�̶�� �޼ҵ带 �̿��Ͽ� �ش� ��ü�� ������ ���
			System.out.println(books[i].inform());
		}
		
		System.out.print("�˻��� å ���� : ");
		String title = sc.nextLine();
		
		
		//�Է¹��� �� �˻�
		boolean flag = true;
		for(int i =0; i<books.length; i++) {
			// books�� i��° ����� title 
			if (books[i].getTitle().equals(title)) {
				System.out.println(books[i].inform());
				flag = false;
				break; //�޸� �Ƴ�
			}
			
			// �˻��� �⺻ �˰����� ���𰡸� ã������ ��ǥ�� �ְ� ��ã���� �� ��ǥ�� ���ؼ� ��������� �˷���
			}
		if(flag) {
			System.out.println("�ش��ϴ� å�� �����ϴ�.");
		}
		
		
	}

}
