package com.kh.chap1_list.part1.view;

import java.util.Scanner;

import com.kh.chap1_list.part1.controller.ObjectArrayController;
import com.kh.chap1_list.part1.controller.StudentController;
import com.kh.chap1_list.part1.model.vo.Student;

public class Menu {
	
	private Scanner sc = new Scanner(System.in); // ��ĳ�ʸ� �ʵ�� ���� -> �̶� ĸ��ȭ�� ��Ģ�� �����ؾ� �ؼ� private���� ���������� ����
	//private ObjectArrayController con = new ObjectArrayController();
	private StudentController con = new StudentController(); 

	public void display() {
		int sel = 0; // �Է¹��� �޴� ��ȣ�� ������ ���� ����
		
		do {
			System.out.println("==== �л� ���� ���α׷� ====");
			System.out.println("1. �л��߰�");
			System.out.println("2. ��ü ��ȸ");
			System.out.println("3. �л� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("�޴� ���� --> ");
			sel = sc.nextInt();
			sc.nextLine(); // �Է� ���ۿ� �����ִ� �ٹٲ� ���� ����
			
			switch(sel) {
			case 1 : insertStudent(); break;
			case 2 : printStudent(); break;
			case 3 : removeStudent(); break;
			case 0 : System.out.println("���α׷� ����"); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			
		} while(sel != 0);
	}
	
	
	// Sub �޴����� ������ private���� ���������� ����� ��
	
	private void insertStudent() { // DB�ʿ��� �����͸� �߰��ϴ°� insert ���
		System.out.println("[�л� �߰�]");
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("���� : ");
		int score = sc.nextInt();
		sc.nextLine();
		
		// �л� ��ü�� �������ڸ��� �ش� ��ü�� �ּҸ� ObjectArrayController�� insertStudent()�� ����
		con.insertStudent(new Student(name,score)); // ��ü ���� ���� ���ϰ� �׳� �ٷ� �ѱ�
	}
	
	private void printStudent() {
		System.out.println("[��ü �л� ���� ���]");
		con.printStudent();
	}

	
	// �л� ���� �޼ҵ�
	// �Է¹��� �ε����� �ش��ϴ� �л� ��ü ����
	private void removeStudent() {
		System.out.println("[�л� ����]");
		System.out.print("�ε��� �Է� : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		con.removeStudent(index);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
