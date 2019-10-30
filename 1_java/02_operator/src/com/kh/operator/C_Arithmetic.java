package com.kh.operator;

import java.util.Scanner;

public class C_Arithmetic {
	
	//��� ������
	// �⺻���� ��Ģ���� (+ - * /) + % (������) : 5���� ����
	// [* / %]�� �켱������ ����
	
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�ι�° ���� �Է� : ");
		int num2 = sc.nextInt();
		
		System.out.println("num1 + num2 : " + (num1 + num2));
		System.out.println("num1 - num2 : " + (num1 - num2));
		System.out.println("num1 * num2 : " + (num1 * num2));
		System.out.println("num1 / num2 : " + (num1 / num2));
		System.out.println("num1 % num2 : " + (num1 % num2));
		
	}
	
	public void method2() {
		
		// '%'�� �ַ� ����ϴ� ���! --> � ���� ��������� Ȯ���ϴ� ��쿡 �ַ� ����.
		
		// ex) 2�� ������� �ƴ��� Ȯ���ϴ� ���  -> ¦�� vs Ȧ�� ����
		// 10 % 2 == 5
		
		System.out.println("10 % 2 = " + 10%2);
		System.out.println("8795 % 2 = " + 8795%2);

		// 5�� ������� Ȯ��
		System.out.println("54865 % 5 = " + 54865%5);
	}
	
	public void method3() {

		//��������� + ���������� ����~~
		
		int a = 5;
		int b = 10;
		
		int c = (++a) + b; // c = 16
		// a = 6, b = 10
		
		int d = c / a; // d = 2
		// a = 6, b = 10, c = 16
		
		int e = c % a; // e = 4
		// a = 6, b = 10, c = 16, d = 2
		
		int f = e++; // f = 4
		// a = 6, b = 10, c = 16, d = 2, e = 5
		
		int g = (--b) + (d--); // g = 9 + 2 = 11
		// a = 6, b = 9, c = 16, d = 1, e = 5, f = 4
		
		int h = 2;
		
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		//  i =  6  + 9/   (15/4)   * (11-1)    %   (6+2) = 6+30%8 = 12
		// a = 7, b = 9, c = 15, d = 1, e = 6, f = 4, g = 10, h = 2
		
		System.out.println("a  : " +a); // 7
		System.out.println("b  : " +b); // 9
		System.out.println("c  : " +c); // 15
		System.out.println("d  : " +d); // 1
		System.out.println("e  : " +e); // 6
		System.out.println("f  : " +f); // 4
		System.out.println("g  : " +g); // 10
		System.out.println("h  : " +h); // 2
		System.out.println("i  : " +i); // 12
		
	}

}
