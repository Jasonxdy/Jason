package com.kh.chap1_poly.practice.view;

import java.util.Scanner;

import com.kh.chap1_poly.model.vo.Member;
import com.kh.chap1_poly.practice.controller.LibraryController;

public class LibraryMenu {
	
//	- lc : LibraryController // �ʱ�ȭ ����
//	- sc : Scanner // �ʱ�ȭ ����
//	+ mainMenu() : void
//	+ selectAll() : void
//	+ searchBook() : void
//	+ rentBook() : void
	
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
//		// �̸�, ����, ������ Ű����� �Է� ���� �� Member ��ü ����
//		// LibraryController�� insertMember() �޼ҵ忡 ����
//		==== �޴� ==== // ���� �ݺ� ����
//		1. ���������� // LibraryController�� myInfo() ȣ���Ͽ� ���
//		2. ���� ��ü ��ȸ // LibraryMenu�� selectAll() ȣ��
//		3. ���� �˻� // LibraryMenu�� searchBook() ȣ��
//		4. ���� �뿩�ϱ� // LibraryMenu�� rentBook() ȣ��
//		9. ���α׷� �����ϱ�
//		�޴� ��ȣ :
		
//		�̸� : �鵿��
//		���� : 20
//		���� : M
		
//		// �̸�, ����, ������ Ű����� �Է� ���� �� Member ��ü ����
//		// LibraryController�� insertMember() �޼ҵ忡 ����
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("����(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		lc.insertMember(new Member(name, age, gender, 0));
		
//		==== �޴� ==== // ���� �ݺ� ����
//		1. ���������� // LibraryController�� myInfo() ȣ���Ͽ� ���
//		2. ���� ��ü ��ȸ // LibraryMenu�� selectAll() ȣ��
//		3. ���� �˻� // LibraryMenu�� searchBook() ȣ��
//		4. ���� �뿩�ϱ� // LibraryMenu�� rentBook() ȣ��
//		9. ���α׷� �����ϱ�
		int sel = 0;
		while(sel != 9) {
			System.out.println(
					"==== �޴� ====\r\n" + 
					"1. ����������\r\n" + 
					"2. ���� ��ü ��ȸ\r\n" + 
					"3. ���� �˻�\r\n" + 
					"4. ���� �뿩�ϱ�\r\n" + 
					"9. ���α׷� �����ϱ�");
			System.out.print("�޴� ��ȣ : ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1 : System.out.println(lc.myInfo()); break;
			case 2 : selectAll(); break;
			case 3 : searchBook(); break;
			case 4 : rentBook(); break;
			case 9 : System.out.println("���α׷��� �����մϴ�"); return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public void selectAll() {
		// LibraryController�� selectAll()�޼ҵ� ȣ���Ͽ� ��� �� Book[] �ڷ��� bList�� ���
		// for�� �̿��Ͽ� bList�� ��� ���� ��� ���
		// ��, i�� �̿��Ͽ� �ε����� ���� ��� �뿩�� �� ������ȣ�� �˱� ����
//		ex ) 0������ : �������� ���� / ������ / tvN / true
		
		
		for (int i = 0; i < lc.selectAll().length; i++) {
			System.out.println(i + "�� ���� : " + lc.selectAll()[i]);
		}
	}
	
	public void searchBook() {
		while(true) {
			System.out.print("�˻��� ���� Ű���� : ");
			String keyword = sc.nextLine();
			if(lc.searchBook(keyword) == null) {
				System.out.println("�˻��� Ű���带 �����ϴ� ������ �����ϴ�.");
				return;
			} else {
				for (int i = 0; i < lc.searchBook(keyword).length; i++) {
					if(lc.searchBook(keyword)[i] != null) {
						System.out.println(lc.searchBook(keyword)[i]);
					}
				}
				return;
			}
		}
	}
	
	public void rentBook() {
			selectAll();
			System.out.print("�뿩�� ���� ��ȣ ���� : ");
			int index = sc.nextInt();
			sc.nextLine();
			switch(lc.rentBook(index)) {
			case 0 : System.out.println("���������� �뿩�Ǿ����ϴ�"); break;
			case 1 : System.out.println("������������ �뿩 �Ұ����Դϴ�"); break;
			case 2 : System.out.println("���������� �뿩�Ǿ����ϴ�. �丮�п� ������ �߱޵Ǿ����� �������������� Ȯ���ϼ���"); break;
			default : System.out.println("�ش� ������ �����ϴ�"); 
			}
		}
}
