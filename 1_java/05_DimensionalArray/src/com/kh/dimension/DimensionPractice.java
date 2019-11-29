package com.kh.dimension;

import java.util.Arrays;
import java.util.Scanner;

public class DimensionPractice {
	
	public void practice1() {
		/*
		3�� 3��¥�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
		�ε��� 0�� 0������ 2�� 2������ ���ʴ�� �����Ͽ� ��(0, 0)���� ���� �������� ���� �� ����ϼ���.
		ex.
		(0, 0)(0, 1)(0, 2)
		(1, 0)(1, 1)(1, 2)
		(2, 0)(2, 1)(2, 2)
		*/
		
		String[][] arr = new String[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = "("+i+", "+j+")";
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		/*
		4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
		1) 1 ~ 16���� ���� ���ʴ�� �����ϼ���.
		2) ����� ������ ���ʴ�� ����ϼ���.
		ex.
		1 2 3 4
		5 6 7 8
		9 10 11 12
		13 14 15 16
		*/
		
		int num =1;
		
		int[][] arr = new int[4][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice3() {
		/*
		4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
		1) 16 ~ 1�� ���� ���� �Ųٷ� �����ϼ���.
		2) ����� ������ ���ʴ�� ����ϼ���.
		ex.
		16 15 14 13
		12 11 10 9
		8 7 6 5
		4 3 2 1
		*/
		
		int num = 16;

		int[][] arr = new int[4][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num--;
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();

		}
	}
	
	public void practice4() {
		/*
		4�� 4�� 2���� �迭�� �����Ͽ� 0�� 0������ 2�� 2�������� 1~10������ ������ ���� �� ���� ��
		�Ʒ��� ����ó�� ó���ϼ���.
		ex.
		2 4 3 9
		10 2 2 14
		7 3 8 18
		19 9 13 62
		*/
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][4];
		
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				arr[i][3] = 0;
				for (int j = 0; j < arr[i].length - 1; j++) {
					System.out.print(i + "�� " + j + "�� �� �Է� (1~10���� ����) : ");
					arr[i][j] = sc.nextInt();
					arr[i][3] += arr[i][j];
				}
			} else {
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr.length - 1; k++) {
						arr[i][j] += arr[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
			System.out.println();
		}
	}
	
	public void practice5() {
		/*
		2���� �迭�� ��� ���� ũ�⸦ ����ڿ��� ���� �Է¹޵�, 1~10���� ���ڰ� �ƴϸ�
		���ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.�� ��� �� �ٽ� ������ �ް� �ϼ���.
		ũ�Ⱑ ������ ������ �迭 �ȿ��� ���� �빮�ڰ� �������� ���� �� �� ����ϼ���.
		(char���� ���ڸ� ���ؼ� ���ڸ� ǥ���� �� �ְ� 65�� A�� ��Ÿ��, ���ĺ��� �� 26����)
		ex.
		�� ũ�� : 5
		�� ũ�� : 4
		T P M B
		U I H S
		Q M B H
		H B I X
		G F X I
		*/
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�� ũ�� (1~10����) : ");
			int row = sc.nextInt();
			System.out.print("�� ũ�� (1~10����) : ");
			int clm = sc.nextInt();
			char[][] arr = new char[row][clm];

			if (1 <= row && row <= 10 && 1 <= clm && clm <= 10) {
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < clm; j++) {
						arr[i][j] = (char) ((int) (Math.random() * 27 + 65));
					}
				}
			} else {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
				continue;
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(Arrays.toString(arr[i]));
				System.out.println();
			}
			break;
		}
	}
	public void practice6() {
		/*
		String[][] strArr = new String[][] {{"��", "��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��",
			"��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��", "��", "! ", "��", "!! "}};
			���� �ʱ�ȭ�Ǿ� �ִ� �迭�� ������ �Ʒ��� ��[�׸�] �ǽ�����4 �帧���� ���� ������� ����ϼ���.
			��, print()�� ����ϰ� �� ���̿� ����(�� ��)�� �����ϵ��� ����ϼ���.
		*/
		String[][]strArr = {{"��", "��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��","��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��", "��", "! ", "��", "!! "}};
		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				System.out.print(strArr[j][i]);
			}
			System.out.println();
		}
	}
	
	public void practice7() {
		/*
		����ڿ��� ���� ũ�⸦ �Է� �ް� �� ����ŭ�� �ݺ��� ���� ���� ũ�⵵ �޾�
		������ ���� �迭�� ���� �� �Ҵ��ϼ���.
		�׸��� �� �ε����� ��a������ �� �ε����� ������ŭ �ϳ��� �÷� �����ϰ� ����ϼ���.
		ex.
		���� ũ�� : 4
		0���� ũ�� : 2
		1���� ũ�� : 6
		2���� ũ�� : 3
		3���� ũ�� : 5
		a b
		c d e f g h
		i j k
		l m n o p
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ũ�� : ");
		int row = sc.nextInt();
		char[][] arr = new char[row][];
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+"���� ũ�� : ");
			int clm = sc.nextInt();
			arr[i] = new char[clm];
		}
		
		char a = 'a';
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (char)(a++);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		/*
		ex.
		== 1�д� ==
		���ǰ� ������
		����� �����
		���̹� �ں���
		== 2�д� ==
		�ۼ��� ������
		������ ��õ��
		��ǳǥ ȫ����
		
		�� �������� �ڸ� �踮 ��ġ�� ���� ������ �л� �̸��� �˻��Ͽ�
		�ش� �л��� ��� �ڸ��� �ɾҴ��� ����ϼ���.
		
		ex.
		== 1�д� ==
		���ǰ� ������
		����� �����
		���̹� �ں���
		== 2�д� ==
		�ۼ��� ������
		������ ��õ��
		��ǳǥ ȫ����
		============================
		�˻��� �л� �̸��� �Է��ϼ��� : ��õ��
		�˻��Ͻ� ��õ�� �л��� 2�д� �� ��° �� �����ʿ� �ֽ��ϴ�.
		*/
		
		Scanner sc = new Scanner(System.in);
		String[][] class1 = {{"���ǰ�","������"},{"�����","�����"},{"���̹�","�ں���"}};
		String[][] class2 = {{"�ۼ���","������"},{"������","��õ��"},{"��ǳǥ","ȫ����"}};
		System.out.print("�˻��� �л� �̸��� �Է��ϼ��� : ");
		String student = sc.nextLine();
		boolean flag = true;
		for (int i = 0; i < class1.length; i++) {
			for (int j = 0; j < class1[i].length; j++) {
				
				if(class1[i][j].equals(student)) {
					String row = null;
					String side = null;
					switch(i) {
					case 0 : row = "ù ��° �� "; break;
					case 1 : row = "�� ��° �� "; break;
					case 2 : row = "�� ��° �� "; break;
					}
					switch(j) {
					case 0 : side = "����"; break;
					case 1 : side = "������"; break;
					}
					System.out.println("�˻��Ͻ� " + student+"�л��� 1�д� " + row + side +"�� �ֽ��ϴ�.");
					flag = false;
					break;
				}
			}
		}
		for (int i = 0; i < class2.length; i++) {
			for (int j = 0; j < class2[i].length; j++) {
				
				if(class2[i][j].equals(student)) {
					String row = null;
					String side = null;
					switch(i) {
					case 0 : row = "ù ��° �� "; break;
					case 1 : row = "�� ��° �� "; break;
					case 2 : row = "�� ��° �� "; break;
					}
					switch(j) {
					case 0 : side = "����"; break;
					case 1 : side = "������"; break;
					}
					System.out.println("�˻��Ͻ� " + student+"�л��� 2�д� " + row + side +"�� �ֽ��ϴ�.");
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.println("�׷� �л��� ������");
		}
	}
	
	public void practice9() {
		/*
		String 2���� �迭 6�� 6���� ����� ���� �� ���� ���� �� ���� �� �ε����� �����ϼ���.
		�׸��� ����ڿ��� ��� ���� �Է� �޾� �ش� ��ǥ�� ���� 'X'�� ��ȯ�� 2���� �迭�� ����ϼ���.
		ex.
		�� �ε��� �Է� : 4
		�� �ε��� �Է� : 2
		0 1 2 3 4
		0
		1
		2
		3
		4 X
		*/
		
		Scanner sc = new Scanner(System.in);
		String[][] arr = new String[6][6];
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i][0] = " ";
				for (int j = 1; j < arr[i].length; j++) {
					arr[i][j] = j-1 + "";
				}
			} else {
				for (int j = 0; j < arr[i].length; j++) {
					if (j == 0) {
						arr[i][j] = i - 1 + "";
					} else {
						arr[i][j] = " ";
					}
				}
			}
		}
		
		System.out.print("�� �ε��� �Է� : ");
		int row = sc.nextInt();
		System.out.print("�� �ε��� �Է� : ");
		int clm = sc.nextInt();
		arr[row+1][clm+1] = "X";
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
