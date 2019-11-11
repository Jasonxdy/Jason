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
		do {
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
			case 9 : System.out.println("���α׷��� �����մϴ�"); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} while (sel != 9);
	}
	
	public void selectAll() {
		for (int i = 0; i < 5; i++) {
			System.out.println(lc.selectAll()[i]);
		}
	}
	
	public void searchBook() {
		
	}
	
	public void rentBook() {
		
	}
			

}
