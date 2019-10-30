package com.kh.operator;

public class B_InDecrease {
	
	// ���� ������
	// �ǿ������� ���� 1�� ���ϰų� ���� ������
	// ����, ���� �����ڷ� ����
	
	public void method1() {
		
		// ���� ������ : �ٸ� ���� �켱 ���� �� ����
		int a = 10; // a==10
		int b = a++; // b==10, a==11
		System.out.println(a + ", " + b);
		
		// ���� ������ : ���� ���� �� �ٸ� ���� ����
		int a2 = 10; // a2 ==10
		int b2 = ++a2; // a2 == 11, b2 = 11
		System.out.println(a2 + ", " + b2);
		
	}
	
	public void method2() {
		
		// ���� ���� ������ �׽�Ʈ
		int iNum = 10;
		System.out.println("���� ���� �� : " + iNum);
		System.out.println("++iNum 1ȸ ���� : " + ++iNum); // 11
		System.out.println("++iNum 2ȸ ���� : " + ++iNum); // 12
		System.out.println("++iNum 3ȸ ���� : " + ++iNum); // 13
		System.out.println("++iNum 4ȸ ���� : " + ++iNum); // 14
		System.out.println("++iNum 5ȸ ���� : " + ++iNum); // 15		
		System.out.println("���� iNum �� : " + iNum); 
		System.out.println();
		System.out.println();
		
		
		// ���� ���� ������ �׽�Ʈ
		int iNum2 = 10;
		System.out.println("���� ���� �� : " + iNum2);
		System.out.println("iNum2-- 1ȸ ���� : " + iNum2--);
		System.out.println("iNum2-- 2ȸ ���� : " + iNum2--);
		System.out.println("iNum2-- 3ȸ ���� : " + iNum2--);
		System.out.println("iNum2-- 4ȸ ���� : " + iNum2--);
		System.out.println("iNum2-- 5ȸ ���� : " + iNum2--);
		System.out.println("���� iNum2 �� : " + iNum2);
		
	}
	
	public void method3() {
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(a++); // 10
		// a = 11, b = 20, c = 30
		System.out.println(++a + b++); // 32
		// a = 12, b = 21, c = 30
		System.out.println(a++ + --b + --c); // 12 + 20 + 29 = 61
		// a = 13, b = 20, c =29
		
		System.out.println("a == " + a); // 13
		System.out.println("b == " + b); // 20
		System.out.println("c == " + c); // 29
		
	}
	
}
