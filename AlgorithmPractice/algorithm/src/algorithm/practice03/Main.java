package algorithm.practice03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int maxNum = 0; // �ִ� ����
		int numCount = 1; // ���� ����
		
		int []arr = new int[10];
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(i + "��° ���� �Է� : ");
			arr[i] = sc.nextInt();
			sc.nextLine();
			if(i<0) {
				for(int j=0; j< i; j++) {
					if(arr[i] != arr[j]) {
						numCount++;
					}
				}
			}
			
		}
		
		System.out.println("�Է��� �迭 : " + Arrays.toString(arr));
		
		
		int countNext = 0; // ī��Ʈ ��
		int countBefore = 0; // ���� ī��Ʈ �� ����
		int num = 0;
		
		for(int j =0; j<=maxNum; j++) {
			countNext = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == j) {
					countNext++;
				}
			}
			
			if(countNext >= countBefore) {
				countBefore = countNext;
				num = j;
			}
			
		}
		
		System.out.println("���� : " + num + " (" + countBefore + "ȸ)");
		
	}

}
