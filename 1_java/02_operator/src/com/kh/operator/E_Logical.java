package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	
	// �� ������
	/*
	 * �� �� �ΰ��� ���ϴ� ������
	 * AND (&&) : �׸���, ~�̸鼭
	 * OR (||) : �Ǵ�, ~�̰ų�
	 * 
	 * */
	
	public void method1() {
		// �Է¹��� ������ 1~100 ������ ������ Ȯ���ϱ�
		//Scanner�ʿ�, �����ϱ� nextInt(), Ȯ���ϱ�� t/f �����ڱ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		boolean isTrue = (input>=1)&&(input<=100);
		
		System.out.println(input + "��/�� 1���� 100������ �� : " + isTrue);
		
		//System.out.println("�Է¹��� ���� 1~100 ������ ������? : " + ((1<=input)&&(input<=100)));
	}

	public void method2() {
		
		// �Է¹��� ���ڰ� ���� �빮������ Ȯ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		char ch = sc.nextLine().charAt(0);
		
		/*
		int input = ch; // ---> �̰� �߿�, �ڵ� ����ȯ��
		boolean isTrue =  (65<=input)&&(input<=90);
		*/
		
		boolean isTrue = (ch >= 'A')&&(ch <= 'Z'); // ---> char�� ���������� ����ǹǷ� char������ �� ������ ������!! �߿�!
		
		System.out.println("�Է¹��� ���� "+ch+"��/�� ���� �빮�ڰ� : " + isTrue);
		
	}
	
	public void method3() {
		
		// �Է¹��� ���ڰ� �������� (��, �ҹ��� ���� X) Ȯ���ϱ�
		Scanner sc = new Scanner (System.in);
		System.out.print("���� �Է� : ");
		char ch = sc.nextLine().charAt(0);
		boolean isTrue = (('a'<=ch)&&(ch<='z'))||(('A'>=ch)&&(ch<='Z'));
		System.out.println("�Է����ֽ� ���� "+ch+"��/�� ���ĺ��ΰ� : "+isTrue);
		
	}

}
