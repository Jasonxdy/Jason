package com.kh.practice2;

import java.util.Scanner;

public class CastingPractice1 {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.print("���� : ");
		char letter = sc.nextLine().charAt(0);
		System.out.printf("%c unicode : %d",letter,(int)letter);
		*/
		
		System.out.print("���� : ");
		int letNum = sc.nextInt();
		System.out.printf("%d unicode : %c",letNum,(char)letNum);
	}

}
