package com.kh.array;

import java.util.Scanner;

public class A_Array {
	
	// �迭
	// - ���� �ڷ����� ������ �ϳ��� �������� �ٷ�� ��.
	// - ����� ������ �ε����� �����ȴ�.
	// (index�� 0���� ���۵ȴ�)
	
	public void method1() {
		// �迭�� ������� �ʰ� int �� ���� 5���� ���� ����� ���� �ʱ�ȭ�ϰ� ����ϱ�
		/*
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int num4 = 4;
		int num5 = 5; // �� ���� �͵��� stack�� ���� �Ҵ� �� �����
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		*/
		// �ʹ� �ڵ尡 ���� ����
		
		// 1�ܰ� : �迭 ����
		// �ڷ��� [] �迭��; or �ڷ��� �迭�� [];
		int[] arr;
		
		// 2�ܰ� : �迭 �Ҵ�
		// - ���� ���� ������ �� �ִ� �迭 ���� �Ҵ� (==����)
		// �迭�� = new �ڷ��� [�迭ũ��];
		
		arr = new int [5];
		
		for (int i = 0; i<arr.length; i++) { //length : ���̸� return
			arr[i]=i+1;// i�� index�� i����...
		}
		
		for (int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	
		
		/*
		// ����ó�� �� �ε��� ��ҿ� �����Ͽ� �� ���� ����.
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		// ����ó�� �� �迭��ҿ� �����Ͽ� ��µ� ����
		System.out.println("=====�迭 ���=====");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		*/// �̰� �� �迭�� ������ �츮�� ����
		
	}
	
	public void method2() {
		// ����ڰ� ������ ũ�⸸ŭ�� �迭�� �Ҵ��ϰ� �� �迭�� 1���� ������ ũ�⸸ŭ�� ���ڸ� ���� �� ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		// �Է¹��� ũ�� ��ŭ�� �迭 ���� �� �Ҵ�
		int[] arr = new int[input];
		for (int i=0; i<arr.length;i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
		
	}

	public void method3() {
		
		// ���, �ٳ���, ������, ���ξ���, Ű��
		// �ټ����� ������ ����Ǿ� �ִ� �迭�� �ִ�.
		// �ε����� �Է¹޾� �ش� �ε����� ����� ������ ���.
		
		Scanner sc = new Scanner(System.in);
		// String �迭�� ����� ���ÿ� �ʱ�ȭ -> �����Ϸ��� �˾Ƽ� �迭�� ũ�⸦ �Ҵ��ϰ�, �� ��ҿ� ���� ������.
		String[] fruit = {"���", "�ٳ���","������","���ξ���","Ű��"};
		System.out.print("�ε��� �Է� : ");
		int index = sc.nextInt();
		if (0<=index&&index<fruit.length) {
			System.out.print(fruit[index]);
		} else {
			System.out.println("�߸��� �ε����Դϴ�");
		}
	}
	
	public void method4() {
		// ���, �ٳ���, ������, ���ξ���, Ű��
		// �ټ����� ������ ����Ǿ� �ִ� �迭�� �ִ�.
		// ���� ���� �Է¹޾� �ش� ������ ���° �ε����� ����Ǿ� �ִ��� ���

		Scanner sc = new Scanner(System.in);
		String fruit[] = { "���", "�ٳ���", "������", "���ξ���", "Ű��" };
		System.out.print("���ϸ� �Է� : ");
		String input = sc.nextLine();

		boolean isTrue = true;
		for (int i = 0; i < fruit.length; i++) {
			// ���� ������ �迭 ����� ���� �Է��� ���� ���� ���
			if (fruit[i].equals(input)) {
				System.out.println("�ش� ������ " + i + "��° �ε����Դϴ�");
				isTrue = false;
				break; // ���� �޼� �� break�� �׻� ����� �ٰ�
			}
			}
		if (isTrue) {
			System.out.println("�ش� ������ ����� �ε����� �����ϴ�");
		}
	}
	// �迭�� �̿��� �˻� ��� ---> �������.. �ٽ� �� ��
	
	public void method5() {
		// ���ڿ� 3���� ������ �� �ִ� �迭�� ���� �� �Ҵ��ϰ� ���ڿ� 3���� �Է¹޾� �迭�� ������� ���� ��
		// �˻��� ���ڿ��� �Է¹޾� �迭�� ���° �ε����� ����Ǿ� �ִ��� ���
		
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[3];
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "��° �ε����� �Ҵ��� ���ڿ� : ");
			arr[i] = sc.nextLine();
		}

		System.out.print("�˻��� ���ڿ��� �Է��ϼ��� : ");
		String input = sc.nextLine();

		boolean isTrue = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(input)) {
				System.out.println("�ش� ���ڿ��� " + i + "��° �ε����� ����Ǿ� �ֽ��ϴ�");
				isTrue = false;
				break;
			}
		}
		if (isTrue) {
			System.out.println("�ش� ���ڿ��� ����Ǿ� ���� �ʽ��ϴ�");
		}
	}
	
	public void method6() {
		// 5���� Ű�� �Է¹޾� �迭�� ���� �� 5���� ��� Ű ���
		Scanner sc = new Scanner(System.in);
		double height[] = new double[5];
		//�Ǽ��� �迭 height ���� �� 5ĭ �Ҵ�
		double sum = 0;
		
		for(int i =0; i<height.length;i++) {
			System.out.print(i+1+"��° ����� Ű : ");
			height[i]=sc.nextDouble();
			sum+=height[i];
		}
		System.out.println(height.length+"���� ��� Ű : "+sum/height.length+"cm�Դϴ�");
	}
	
	
	
	
	
	
	
}
