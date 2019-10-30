package com.kh.chap1.condition;

import java.util.Scanner;

public class A_If {
	
	// �ܵ� if�� 
	/*
	 * if (���ǽ�) {
	 * 	������ �ڵ� �ۼ�
	 * }
	 * 
	 * --> ���ǽ��� true�̸� ��({}) �� �ڵ� ����
	 * --> ���ǽ��� false�̸� ��({})�� �ǳʶ�
	 * 
	 * */
	
	public void method1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		
		int num = sc.nextInt();
		
		if (num<0) {
			System.out.println("������");
		}
		
		if (num==0) {
			System.out.println("0�̴�");
		}
		
		if (num>0) {
			System.out.println("�����");
		}
		//if (num<=0) {
		//	System.out.println("����� �ƴϴ�");
		//}
		
	}
	
	public void method2() {
		//�Է¹��� ������ ¦������ Ȧ������ ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		if (input%2==0) {
			System.out.println("¦���Դϴ�.");
		} else {
			System.out.println("Ȧ���Դϴ�.");
		}
	}
	
	public void method3() {
		// �Է¹��� ��(��)�� �´� ���� ����ϱ�
		// ��, 1~12 ������ ���� �ƴϸ� "�ش��ϴ� ������ �����ϴ�" ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("��(��)�� �Է����ּ���: ");
		int input = sc.nextInt();
		String season; // ��� System.out.~~ �̰� ���ֱ� �Ⱦ
		
		// �� : 3, 4, 5��
		if (input>=3&&input<=5) {
			season = "��";
		// ���� : 6, 7, 8��
		} else if (6<=input&&input<=8) {
			season = "����";
		// ���� : 9, 10, 11��
		} else if (9<=input&&input<=11) {
			season = "����";
		// �ܿ� : 12, 1, 2��
		} else if (input==12||input==1||input==2) {
			season = "�ܿ�";
		} else {
			season = "�ش��ϴ� ������ �����ϴ�";
		}
		
		System.out.println(season);		
	}
	
	public void method4() {
		/*
		 * ������ �ϳ� �Է¹޾� ����� ���� ������ ����� ����ض�
		 * 90�� �̻��� A���
		 * 90�� �̸� 80�� �̻��� B���
		 * 80�� �̸� 70�� �̻��� C���
		 * 70�� �̸� 60�� �̻��� D���
		 * 60�� �̸��� F���
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int score = sc.nextInt();
		char grade;
		
		if (90<=score) {
			grade = 'A';
		} else if (80<=score) {
			grade = 'B';
		} else if (70<=score) {
			grade = 'C';
		} else if (60<=score) {
			grade = 'D';
		} else { // ���࿡ �̰� else if�� �ϰ� ������ �ְ� ������ ��쿡�� �����߻� -> grade�� �ʱⰪ ������ �ȵ� ���̱� ������...!
			grade = 'F';
		}
		
		System.out.println("����� ������ "+score+"���̰�, "+"����� "+grade+"�Դϴ�.");
		
	}
	
	public void method5() {
		// �� ��޿��� ������ ��쿡 '+' ������ �߰��� ��µ� �� �ֵ��� ����
		
		// 95�� �̻� A+
		// 85�� �̻� B+
		// 75�� �̻� C+
		// 65�� �̻� D+
		
		/*
		 * ������ �ϳ� �Է¹޾� ����� ���� ������ ����� ����ض�
		 * 90�� �̻��� A���
		 * 90�� �̸� 80�� �̻��� B���
		 * 80�� �̸� 70�� �̻��� C���
		 * 70�� �̸� 60�� �̻��� D���
		 * 60�� �̸��� F���
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int score = sc.nextInt();
		String grade;
		
		if (90<=score) {
			grade = "A";
			if(95<=score) {
				grade += "+"; // grade = "A+"�� ���� ���ص� A�� Ȱ����
			}
		} else if (80<=score) {
			grade = "B";
			if(85<=score) {
				grade += "+";
			}
		} else if (70<=score) {
			grade = "C";
			if(75<=score) {
				grade += "+";
			}
		} else if (60<=score) {
			grade = "D";
			if(65<=score) {
				grade += "+";
			}
		} else {
			grade = "F";
		}
		
		System.out.println("����� ������ "+score+"���̰�, "+"����� "+grade+"�Դϴ�.");
		
	}
	

}
