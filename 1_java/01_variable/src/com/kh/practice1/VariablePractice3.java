package com.kh.practice1;

import java.util.Scanner;

public class VariablePractice3 {
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		double length = sc.nextDouble();
		System.out.print("���� : ");
		double width = sc.nextDouble();
		
		System.out.println("���� : " + (length*width));
		System.out.println("�ѷ� : " + (length + width)*2);
	}

}
