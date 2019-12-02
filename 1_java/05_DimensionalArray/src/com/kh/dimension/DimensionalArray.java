package com.kh.dimension;

import java.util.Arrays;

public class DimensionalArray {
	
	// 2���� �迭 : 1���� �迭 �������� �ϳ��� ���� ����ϴ� ��
	
	public void method1() {
		// 2���� �迭�� ���� �� �Ҵ�
		
		int[][] arr1;
		int arr2[][];
		int[] arr3[]; 
		// �� [] == �迭 1������ �ǹ���
		
		// 2���� �迭 �Ҵ�
		arr1 = new int[3][5];
		
		//Heap ������ int�� 2���� �迭 3�� 5�� �Ҵ�
		
		// ���� ���� (�����ΰ�?) Ȯ��
		System.out.println("���� ���� : " + arr1.length);
		// �ֳĸ� arr�� 1���� �迭�� �����ϰ� �ִ� �迭
		
		// ���� ���� (�� ĭ�ΰ�?) Ȯ��
		System.out.println("���� ���� : " + arr1[0].length);
		
		// 3�� 5���� int�� 2���� �迭�� ��� ĭ�� ���� 1 ä���
		// 2���� �迭�� �ʱ�ȭ
		for (int i = 0; i < arr1.length; i++) { // ���� ������ŭ �ݺ�
			for (int j = 0; j < arr1[i].length; j++) { // ���� ������ŭ �ݺ�
				arr1[i][j] = 1;
				//System.out.print(arr1[i][j]+ " "); -> ��¿�
			}
			//System.out.println(); -> �ٷ� ��¿�
		}
		
		//2���� �迭 ���� : 2���� �迭�� �� ��ҿ� ����� �� ����ϱ�
		for(int i=0;i<arr1.length; i++) {
			for(int j =0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void method2() {
		// 2���� �迭 ����� ���ÿ� �ʱ�ȭ
		int[][] arr = {{0,1,2,3},
					   {4,5,6,7},
					   {8,9,10,11}};
		
		// �ʱ�ȭ�� 2���� �迭 �� ��� ����ϱ�
		for (int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("arr["+i+"]["+j+"] = "+arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void method3() {
		//4�� 4��¥�� int�� 2���� ���� �� �Ҵ��ϰ� �� ��ҿ� 1~16������ ���� ������� �����ϰ� ���
		int[][] arr = new int[4][4];
		int count =1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = count++;
				System.out.printf("%2d\t",arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void method4() {
		// ���� ������ ������ ������, �� �࿡ ���� ���� ������ �������� ���� 2���� �迭

		int[][] arr = new int[4][];

		arr[0] = new int[3];
		arr[1] = new int[4];
		arr[2] = new int[5];
		arr[3] = new int[2];

		// �迭�� �� ��ҿ� ��¥ 0 (int �⺻��)�� ����ִ��� Ȯ��
		for (int i = 0; i < arr.length; i++) { // �� ����
			for (int j = 0; j < arr[i].length; j++) { // �� ����
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(); // �ٹٲ�
		}

		System.out.println();
		System.out.println();

		int value = 1;
		for (int i = 0; i < arr.length; i++) { // �� ����
			for (int j = 0; j < arr[i].length; j++) { // �� ����
				arr[i][j] = value++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(); // �ٹٲ�
		}

	}

}
