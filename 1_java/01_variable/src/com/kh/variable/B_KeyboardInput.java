package com.kh.variable;

import java.util.Scanner;

public class B_KeyboardInput {
	
	public void inputScanner1() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� �̸��� �����Դϱ�? : ");

		String name = sc.nextLine();
		
		System.out.println("����� �̸��� " + name + "�Դϴ�.");
		
	}
	
	public void inputScanner2() {
		
		Scanner sc = new Scanner(System.in); // System.in = Ű���� �Է��� ����
		// �̸�, ����, Ű �Է¹ް� ���
		
		System.out.print("�̸� : ");
		String name = sc.nextLine(); //nextLine = ���ڿ�
		
		System.out.print("���� : ");
		int age = sc.nextInt(); // nextInt = ������
		
		System.out.print("Ű : ");
		double height = sc.nextDouble(); //nextDouble = �Ǽ���
		
		System.out.println(name + "���� " + age + "�� �̸�, Ű�� " + height + "cm�Դϴ�.");
		
	}

}
