package com.kh.practice1;

import java.util.Scanner;

public class VariablePractice2 {
	
	public void practice2 () {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("ù��° ���� : ");
		int firstNum = sc.nextInt();
		
		System.out.print("�ι��� ���� : ");
		int secondNum = sc.nextInt();
		
		System.out.println("���ϱ� ��� : " + (firstNum + secondNum));
		System.out.println("���� ��� : " + (firstNum - secondNum));
		System.out.println("���ϱ� ��� : " + (firstNum*secondNum));
		System.out.println("������ �� ��� : " + (firstNum/secondNum));
	}

}
