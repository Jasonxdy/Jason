package com.kh.chap3_Wrapper.controller;

public class WrapperController {
	
	// Wrapper Class
	/*
	 * - Wrapper : ������
	 * - ������ �����ϴ� Ŭ����? -> �⺻ �ڷ����� ��ü�� �����ϴ� Ŭ����
	 * - �� �����ϴ°�?
	 * 1) �⺻ �ڷ������δ� ������ �� ���� ����� �߰��Ͽ� ����ϱ� ���ؼ� ex) �ڷ����� �ִ�, �ּҰ� ��� / String ���ڿ� ("123123") -> �� Ÿ�� (int�� 123123)�� �°� ��ȯ ���..
	 * 2) �⺻ �ڷ����� ��ü�� �ٷ�߸� �Ǵ� ��찡 �־ ex) �Ű����� �Ǵ� ��ȯ���� ��ü�� �䱸�ϴ� ��� / �⺻ �ڷ����� �ƴ� ��ü�� ���� �����ϴ� ��� / ��ü���� �񱳰� �ʿ��� ���
	 */

	public void method1() {
		// int�� Wrapper Class -> Integer (������ 1��, �׸��� ������� ����:ex -> int�� �ִ�, �ּҰ� / int ũ�� ���)
		System.out.println("int�� byte ũ�� : " + Integer.BYTES); // static���� ��� ����Ǿ����� public static final
		System.out.println("int�� bit ũ�� : " + Integer.SIZE);
		System.out.println("int�� �ִ밪 : " + Integer.MAX_VALUE);
		System.out.println("int�� �ּҰ� : " + Integer.MIN_VALUE);
		System.out.println("Integer�� �⺻ �ڷ��� : " + Integer.TYPE);
		
		// int�� �ּҰ�~�ִ밪 100�� �����ϴ� �ڵ� ���
		/*
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i+=100) {
			System.out.println(i);
		}
		*/
		
		// String���� �⺻ �ڷ������� ��ȯ
		String num1 = "10";
		int num2 = 20;
		System.out.println(Integer.parseInt(num1) + num2); //parse : String �ڷ����� �⺻ �ڷ������� �ٲٴ� ��..?
						  // String�� ���ڸ� int�� ���ڷ� ��ȯ�����ִ� �޼ҵ�
		
		byte bNum = Byte.parseByte("100"); // parse �޼ҵ�� static�� ����Ǿ� ����... �׻� �� �� �ֵ���
		short sNum = Short.parseShort("1000");
		int iNum = Integer.parseInt("123456789");
		long lNum = Long.parseLong("123456789123456789");
		float fNum = Float.parseFloat("3.14");
		double dNum = Double.parseDouble("3.141592123456");
		boolean bool = Boolean.parseBoolean("true");
		// Character Ŭ������ parse��� ����.. ���ڿ��� �ƹ��� �޾Ƶ� 1���� ���� �� �־
		char ch = "Hello".charAt(0);
		
		// �⺻ �ڷ��� -> String���� ��ȯ
		String s1 = Integer.valueOf(123).toString(); // valueOf : �ʵ�� �����ϴ� �޼ҵ�
		String s2 = 123 + "";
		
		
		// Boxing : �⺻ �ڷ����� Wrapper Class ��ü�� �����ϴ� ���� -> �⺻ �ڷ����� �ڽ��� ����
		Integer it1 = new Integer(123);
		
		// UnBoxing : Wrapper Class�� �⺻ �ڷ������� ��ȯ
		int i = it1.intValue(); // it1�� ����Ǿ� �ִ� int���� get�ض�
		int i2 = (int)it1; // ���� ����ȯ�� ���� ����...!! -> Integer ��ü ���ο� int�� ��ȯ
		
		
		// AutoBoxing & UnBoxing : �����ϰ� ������ �ڵ�����!
		Integer it2 = 100; // Auto Boxing
		int i3 = it2; // Auto UnBoxing
		
		
		
		
		
	}
	

}
