package com.kh.practice2;

import java.util.Scanner;

public class CastingPractice3 {
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println(iNum1/iNum2);
		System.out.println((int)(dNum));
		
		System.out.println(iNum2*dNum);
		System.out.println((double)(iNum1));
		
		System.out.println(((double)iNum1/iNum2));
		System.out.println(dNum);
		
		System.out.println((int)(fNum));
		System.out.println(iNum1/(int)(fNum));
		
		System.out.println(iNum1/fNum);
		System.out.println((double)(iNum1)/fNum);
		// �̰� ���� �����
		System.out.println("'"+ch+"'");
		System.out.println((int)(ch));
		System.out.println((int)(ch)+iNum1);
		// �̰͵� �������� : ch + iNum1 �ϸ� �� -> ch�� int�� ���� ����ȯ��
		System.out.println((char)(ch+iNum1));
		
	}

}
