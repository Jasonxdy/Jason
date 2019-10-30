package com.kh.chap2.practice;

import java.util.Scanner;

public class LoopPractice1 {
	
	public void practice1() {
		/*
		����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���.
		��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���.
		ex.
		1�̻��� ���ڸ� �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� : 0
		1 2 3 4 1 �̻��� ���ڸ� �Է����ּ���.
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		
		if (input>=1) {
			for (int i = 1; i<=input;i++) {
				System.out.printf("%d ",i);
			}
		} else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
		}
		
		
		
	}
	
	public void practice2() {
		/*
		����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���.
		��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		ex.
		1�̻��� ���ڸ� �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� : 0
		4 3 2 1 1 �̻��� ���ڸ� �Է����ּ���.
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		
		if (input>=1) {
			for (int i=input; i>=1; i--) {
				System.out.printf("%d ",i);
			}
		} else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
	}

	public void practice3() {
		/*
		1���� ����ڿ��� �Է� ���� �������� �������� ���� for���� �̿��Ͽ� ����ϼ���.
		ex.
		������ �ϳ� �Է��ϼ��� : 8
		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int input = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i<input; i++) {
			System.out.printf("%d + ", i);
			sum += i;
		}
		sum += input;
		System.out.print(+input+" = "+sum);		
	}

	public void practice4() {
		/*
		����ڷκ��� �� ���� ���� �Է� �޾� �� ������ ���ڸ� ��� ����ϼ���.
		���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���.
		ex.
		ù ��° ���� : 8 ù ��° ���� : 4 ù ��° ���� : 9
		�� ��° ���� : 4 �� ��° ���� : 8 �� ��° ���� : 0
		4 5 6 7 8 4 5 6 7 8 1 �̻��� ���ڸ� �Է����ּ���.
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		
		if (num1>num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if (num1>=1&&num2>=1) {
			for (int i=num1; i<=num2; i++) {
				System.out.printf("%d ", i);
			}
		} else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���~");
		}
		
	}

	public void practice5() {
		/*
		����ڷκ��� �Է� ���� ������ ���� ����ϼ���.
		ex.
		���� : 4
		===== 4�� =====
		4 * 1 = 4
		4 * 2 = 8
		4 * 3 = 12
		4 * 4 = 16
		4 * 5 = 20
		4 * 6 = 24
		4 * 7 = 28
		4 * 8 = 32
		4 * 9 = 36
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int input = sc.nextInt();
		
		for (int i = 1; i<=9 ; i++) {
			System.out.printf("%d X %d = %2d\n",input,i,input*i);
		}
	}
	
	public void practice6() {
		
		/*
		����ڷκ��� �Է� ���� ������ �ܺ��� 9�ܱ��� ����ϼ���.
		��, 9�� �ʰ��ϴ� ���ڰ� ������ ��9 ������ ���ڸ� �Է����ּ��䡱�� ����ϼ���.
		���� : 4 ���� : 10
		===== 4�� ===== 9 ������ ���ڸ� �Է����ּ���.
		===== 5�� =====
		===== 6�� =====
		===== 7�� =====
		===== 8�� =====
		===== 9�� =====
		(�ش� ���� ������� ���� �� ����)
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int input = sc.nextInt();
	
		if (input<=9) {
			for (int i =input; i<=9; i++) {
				System.out.printf("========== %d�� =========\n", i);
				for (int j=1; j<=9;j++) {
					System.out.printf("%d X %d = %d\n",i,j,i*j);
				}
			}
		} else {
			System.out.println("9 ������ ���ڸ� �Է����ּ���");
		}
		
		
		
	}
	
	public void practice7() {
	
		/*
		������ ���� ���� ������ �����ϼ���.
		ex.
		���� �Է� : 4
		*
		**
		***
		****
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		for (int i=1; i<=input;i++) {
			for(int j =1; j<=i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}
	
	public void practice8() {
		
		/*
		������ ���� ���� ������ �����ϼ���.
		ex.
		���� �Է� : 4
		****
		***
		**
		*
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		for (int i = input; i>=1; i--) {
			for (int j = i; j>=1; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}	
}
