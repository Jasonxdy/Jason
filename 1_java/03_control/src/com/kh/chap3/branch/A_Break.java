package com.kh.chap3.branch;

import java.util.Scanner;

public class A_Break {
	
	// �б⹮
	// 1. break 
	//   ---> ���� ����� �ݺ����� ���� ������ ����
	
	
	public void method1() {
		// 1���� �Է¹��� �� ������ ��� ���� �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();;
		int sum = 0;
		for (int i=1; /*���ǽ� ����*/ ;i++) {
			sum+=i;
			if (input==i) {
				// �Է°��� i�� ���� ��� �ݺ��� ����
				break;
			}
		}
		System.out.println(sum);
	}

	public void method2() {
		
		//���ڿ��� �Է¹޾� �ش� ���ڿ��� ���� ����(����)�� ����ϴ� �ݺ� ���α׷� ����
		// ��, "exit" �Է� �� ����
		Scanner sc = new Scanner(System.in);
		String str = null;
		
		while(true) { // break ���ö����� ���� ������ ��������
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
			
			if(str.equals("exit")) break;
			System.out.println(str + "�� ���� ���� : " + str.length());
		}
		System.out.println("���α׷��� �����մϴ�");
		
	}
	
}
