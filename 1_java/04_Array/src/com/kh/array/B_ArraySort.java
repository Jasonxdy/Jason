package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class B_ArraySort {
	
	// �������� : 1 2 3 4 5
	// �������� : 5 4 3 2 1
	// temp�� �̿��� ��ȯ����� ������ �ݺ��ȴٰ� �����ϸ� ��
	
	public void method1() {
		//�迭 ��ҵ� ��ġ �ٲٱ�
		int arr[] = {2, 1, 3};
		
		
		/*
		// 1, 2, 3���� �ٲٱ�
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		*/
		
		// 3 2 1 (��������)
		int temp = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		
		for(int i =0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
		

	// ���� ���� (Insertion Sort) --> ��������� �ϳ��� ���Ե� �������� ���ĵǹǷ�
	// ���� �˰��򿡼� ���� �����ϰ� �⺻�� �Ǵ� �˰���.
	// ex) ī����� �� ������� ����
	// 3 4 2 1 5
	// �迭�� n��° �ε��� ���� (n�� 1���� ����) �������� �Ͽ� 0 ~ n-1�� �ε������� ���Ͽ� ���� (������ �ٲ�)
	public void method2() {
		
		int arr[] = {2,5,4,1,3};
		int count = 0;
		// ���� ���� (��������)
		
		// 1. �� ��ü�� ���ϴ� for�� ����
		for (int i=1;i<arr.length;i++) {
			// 2. �� ����� ���ϴ� for�� ����
			for (int j =0; j<i; j++) {
				// �񱳸� ���ؼ� �������� ���� : �� ��ü�� �� ��󺸴� ���� ��� ���� ��ȯ
				if(arr[i]<arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
				}
				
			}
			
		}
		
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println(count);
	}

	public void method3() {
		//�������� again
		
		int arr[] = { 7, 1, 5, 3, 4, 2, 6 };
		int count = 0;
		for (int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
				}
			}
		}
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(count);
	}
	
	public void method4() {
		
		// ���� ���� (��������)
		int arr[] = { 2, 5, 4, 1, 3 };
		
		// 1. �� ��ü�� ���ϴ� for �� ����
		for (int i = 1; i<arr.length;i++) {
			// 2. �� ����� ���ϴ� for �� ����
			for (int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					// ���������� ���������� �� ������ ���⸸ �ٸ��� �ݴ��!
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i =0; i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public void method5() {
		// ���� 5���� �Է¹޾� �迭�� ���� �� �������� ����(��������)�Ͽ� ���
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		/*
		for(int i=0;i<arr.length;i++){
			System.out.print(i+1+"��° ���� �Է� : ");
			arr[i] = sc.nextInt();
		}
		*/
		System.out.print("1��° ���� �Է� : ");
		arr[0] = sc.nextInt();
		for(int i=1;i<arr.length;i++) {
			System.out.print(i+1+"��° ���� �Է� : ");
			arr[i] = sc.nextInt();
			for(int j =0; j<i; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print("�������� ���� ��� :");
		for(int i = 0; i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
	// ���� ���� (Bubble sort)
	// ������ �� ���� ��Ҹ� �˻��Ͽ� �����ϴ� ���
	// �ڿ������� ������ �Ǿ����� ���� Ư¡
	// ���� : ������ ����, �̹� ���ĵ� �����͸� �ٽ� �����Ҷ� ���� ������.
	// ���� : �ٸ� ���Ŀ� ���� ���� �ӵ��� ����.
	
	public void method6() {
		
		int arr[] = { 2, 5, 4, 1, 3 };
		int count = 0;
		
		for (int i=arr.length-1;i>0;i--) {
			// 1. �� ȸ���� ���ο� �ִ� for���� �񱳸� �ݺ��� ȸ�� ����
			for (int j = 0; j<i;j++) {
				// 2. ������ Ƚ����ŭ �ݺ��ϸ� j��° index ��ҿ� j+1��° ��Ҹ� ���Ͽ� ����
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					count++;
				}
			}
		}
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(count);
	}
	
	public void method7() {
		// ���� ���� (��������)
		int arr[] = { 7, 1, 5, 3, 4, 2, 6 };
		int count = 0;
		for(int i = arr.length-1; i>0;i--) {
			for(int j = 0; j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					count++;
				}
			}
		}
		for (int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(count);
		
		
	}
	
	public void method8() {
		// ���� ���� (��������)
		int arr[] = { 7, 1, 5, 3, 4, 2, 6 };
		for(int i = arr.length-1; i>0;i--) {
			for(int j = 0; j<i;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		/*
		for (int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		*/
		System.out.println(Arrays.toString(arr));
	}
	
}
