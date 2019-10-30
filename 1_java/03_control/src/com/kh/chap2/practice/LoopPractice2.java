package com.kh.chap2.practice;

import java.util.Scanner;

public class LoopPractice2 {
	
	public void practice11() {
		/*
		1���� ����ڿ��� �Է� ���� ������ �߿���
		1) 2�� 3�� ����� ��� ����ϰ�
		2) 2�� 3�� ������� ������ ����ϼ���.
		* ����������� �� �̻��� ���� ������ ������ ������ � ���� �ش� ����� ������ ��
		��� �������� 0�� ������ ��
		ex.
		�ڿ��� �ϳ��� �Է��ϼ��� : 15
		2 3 4 6 8 9 10 12 14 15
		count : 2
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ��� �ϳ��� �Է��ϼ��� : ");
		int input = sc.nextInt();
		int count = 0;
		
		for (int i = 1; i<=input; i++) {
			if(i%2==0&&i%3==0) {
				++count;
				System.out.printf("%d ", i);
			} else if (i%2==0||i%3==0) {
				System.out.printf("%d ", i);
			}
		}
		System.out.println();
		System.out.println("count : " +count);
	}

	public void practice12() {
		
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
		
		for(int i = input; 1<=i; i--) {
			for (int j = 1; j<=input; j++) {
				if (i<=j) {
					System.out.print('*');
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	// �ٽ� Ǯ��� (�ǽ����� 10��)
	
	public void practice13() {
		
		/*
		������ ���� ���� ������ �����ϼ���.
		ex.
		���� �Է� : 3
		*
		**
		***
		**
		*
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		for (int i = 1;i<=input*2-1;i++) {
			if (i<=input) {
				for (int j=1; j<=i;j++) {
					System.out.print('*');
				}
				System.out.println();
			} else {
				for (int j =2*input-i; j>=1; j--) {
					System.out.print('*');
				}
				System.out.println();
			}
			
		}
		
		
	}
}
