package com.kh.practice2;

import java.util.Scanner;

public class CastingPractice2 {
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		double lang = sc.nextDouble();
		System.out.print("���� : ");
		double eng = sc.nextDouble();
		System.out.print("���� : ");
		double mat = sc.nextDouble();
		
		
		System.out.println("���� : " + (int)(lang+eng+mat));
		System.out.println("��� : " + (int)((lang+eng+mat)/3));
		
		System.out.printf("���� : %d\n���: %d\n", (int)(lang+eng+mat), 
										(int)(((lang+eng+mat))/3));
	}
 
}
