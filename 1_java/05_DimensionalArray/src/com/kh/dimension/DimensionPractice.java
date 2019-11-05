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
						arr[i][j] = (char)((int) (Math.random() * 27 + 65));
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
	
}
