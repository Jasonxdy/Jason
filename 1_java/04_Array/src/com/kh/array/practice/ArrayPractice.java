package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	public void practice1() {
		/*
		���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ�
		������� �迭 �ε����� ���� �� �� ���� ����ϼ���.
		ex.
		1 2 3 4 5 6 7 8 9 10
		*/
		
		int[] arr = new int[10];
		for(int i=0; i<arr.length;i++) {
			arr[i] = i+1;
		}
		System.out.print(Arrays.toString(arr));
	}
	
	public void practice5() {
		/*
		���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭�� �ְ� �˻��� ���ڰ� ���ڿ��� �� �� �� �ִ���
		������ �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���.
		ex.
		���ڿ� : application
		���� : i
		application�� i�� �����ϴ� ��ġ(�ε���) : 4 8
		i ���� : 2
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		//charAt(index): ���ڿ��� �ش� index�� �ִ� ���� �ϳ��� ����
		
		//2. ����ڰ� �Է��� ���ڿ����� ���� �ϳ��ϳ��� char �迭�� �����ϱ�
		//2-1. ���ڿ��� ���̸�ŭ�� char �迭�� ���� �� �Ҵ�
		char[] arr= new char[str.length()];
		// ��Ʈ��.length() : �޼ҵ�
		// �׸� ���ø���!!
		
		//2-1. �ݺ����� ���� str.charAt(i)���� arr[i]�� ����
		for(int i = 0; i<arr.length;i++) { //�迭.length : ���� ���� (�޼ҵ�X)
			arr[i] = str.charAt(i);
		}
		
		//3. �˻��� ���ڰ� �迭 ���� ��� �ִ��� �˻� + �˻��� �ε��� ���
		
		int count = 0;
		// �ݺ��� ���� �� ���� ���
		System.out.print(str + "��" + ch + "�� �����ϴ� ��ġ (�ε���) : ");
		
		// �ݺ����� �̿��Ͽ� �迭�� �� ��ҿ� ����
		for (int i = 0; i<arr.length;i++) {
			if(arr[i]==ch) { // �ش� �ε����� ��Ұ� �˻��� ���ڿ� ���� ���
				System.out.print(i + " ");
				count++;
			}
		}
		
		System.out.println(); //�ٹٲ�
		
		// ��� ���
		System.out.println(ch + "���� : "+count);
		
		
	}

	public void practice8() {
		
		/*
		3�̻��� Ȧ�� �ڿ����� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
		�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
		��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
		�ٽ� ������ �޵��� �ϼ���.
		ex.
		���� : 4
		�ٽ� �Է��ϼ���.
		���� : -6
		�ٽ� �Է��ϼ���.
		���� : 5
		1, 2, 3, 2, 1
		*/
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("���� : ");
			int input = sc.nextInt();
			if (input % 2 == 1 && input >= 3) {
				// �Է¹��� ũ�⸸ŭ�� int�� �迭 ���� �� �Ҵ�
				int[] arr = new int[input];

				// �迭 ��ҿ� ������ ���� ���� ���� ����
				int value = 0;
				// �迭�� �߰������� value++, �迭 �߰� ���ĺ��ʹ� value--

				// �ݺ����� �̿��Ͽ� �迭 ��ҿ� �˸��� �� ����
				for (int i = 0; i < arr.length; i++) {
					if (i <= arr.length / 2) {
						value++;
					} else {
						value--;
					}
					// ���� �迭 ��ҿ� value ����
					arr[i] = value;
					System.out.print(arr[i] + " ");
				} // for end.
				break;
			} else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void practice15() {
		/*
		���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ������ �迭�� �����ϰ�
		������ ������ �Բ� ����ϼ���.
		ex.
		���ڿ� : application
		���ڿ��� �ִ� ���� : a, p, l, i, c, t, o, n
		���� ���� : 8
		*/
		// 1. ����ڿ��� ���ڿ� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		// 2. �Է¹��� ���ڿ��� char �迭�� ����
		char[] arr = new char[str.length()];
		for (int i = 0; i<arr.length;i++) {
			arr[i] = str.charAt(i);
		}
		System.out.print("���ڿ��� �ִ� ���� : ");
		
		// 3. �ݺ����� �̿��Ͽ� char �迭���� �ߺ����� �����ϴ� ��� ��� X
		
		// �� ���� ����
		int count = 0;
		for (int i = 0; i<arr.length; i++) {
			boolean flag = true; // ����� �ø��ų� �����ų� �ϴ� ���
			// �ߺ� üũ�� boolean
			
			for(int j = 0; j<i; j++) { // �� ��� ����
				if(arr[i]==arr[j]) {
					// ���ذ� �� ����� ���� ��� == �ߺ� �߻� ��
					flag = false;
					break;
				}
			}
			
			//�ߺ��� �߻����� ���� ��� ��� �� count ����
			if(flag) {
				if(i==0) {
					System.out.print(arr[i]);
				} else {
					System.out.print(", " + arr[i]);
				}
				count++;
			}
		}
		System.out.println();
		System.out.println("���� ���� : " + count);
	}
}
