package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {
	
	//�� ������ (==���� ������)
	/* - �� �ǿ����ڸ� ���ϴ� ������;
	 * - �� �����ڴ� ������ �����ϸ� true / �ƴϸ� false�� ��ȯ��.
	 * 
	 * a < b : a�� b���� ������? (a���� b�� �̸��ΰ�)
	 * a > b : a�� b���� ū��? (a���� b�� �ʰ��ΰ�)
	 * a == b: a�� b�� ������?
	 * a != b: a�� b�� �ٸ���?
	 * a <= b: a�� b���� �۰ų� ������? (a���� b�� �����ΰ�)
	 * a >= b: a�� b���� ũ�ų� ������? (a���� b�� �̻��ΰ�)
	 * (6����, �ε�ȣ�� ������ ��ȣ���� ���� ����)
	 * 
	 * 
	 * 
	 * */
	public void method1() {
		int a = 10;
		int b = 25;
		
		boolean result1, result2, result3;
		// ���ʻ� ���� ���� ǥ�� (�ǹ����� ���� ����)
		
		result1=a==b; // false
		result2=a<=b; // true
		result3=a>b; // false
		
		System.out.println("result1 : " +result1);
		System.out.println("result2 : " +result2);
		System.out.println("result3 : " + result3);
		
		System.out.println("a�� ¦���ΰ�? : " + ((a%2)==0)); //true
		System.out.println("b�� Ȧ���ΰ�? : " + ((b%2)!=0)); //true
		
	}
	
	public void method2() {
		//Ű����� �Է¹��� ���� 3�� ������� Ȯ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("3�� ������� Ȯ���ϰ� ���� ���� �Է� : ");
		int num = sc.nextInt();
		
		System.out.println("�ش� ���ڰ� 3�� ������ ���� " + (num%3==0) + "�Դϴ�.");
		
	}

}
