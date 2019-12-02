package com.kh.variable;

import java.util.Scanner;

public class F_Print {
	
	public void printMethod() {
		
		System.out.println("A"); // A (����ϰ� �ٹٲ�)

		System.out.printf("%c\n" , 'A');
		//				     �������   , ���� or ��
		
		// %c : ���� �ϳ��� ��Ÿ���� ����
		// \n (�̽������� ����) : �ٹٲ� (new line)
		
		// A B (����ϰ� �ٹٲ�)
		
		System.out.println("A B");
		System.out.printf("%c %c\n%c %c\n",'A','B', 'C', 'D');
		System.out.printf("%s\n", "A B");
		
		int iNum1 = 100;
		//100(�ٹٲ�)
		System.out.println(iNum1);
		System.out.printf("%d\n" , iNum1);
		//%d : 10���� ���� ����
		
		double dNum = 1.123456;
		// 1.123456 (�ٹٲ�)
		System.out.println(dNum);
		System.out.printf("%f\n", dNum);
		
		//1.12 (�ٹٲ�) (��, dNum���) -> printf�� ����ϴ� ����
		System.out.println( ((int)(dNum * 100)) / 100.0);
		// ������ �ʹ� �����ϹǷ� printf �������
		System.out.printf("%.2f \n", dNum);
		
		// %f : 10���� �Ǽ� ����
		// %.2f :  �Ҽ��� �Ʒ� 2° �ڸ����� ǥ��
		//			---> �Ҽ��� �Ʒ� 3° �ڸ����� �ݿø� �Ѵٴ� ��
		
		Scanner sc = new Scanner(System.in);
		
		// 10ĭ�� �ְ� ������ �Է¹޾� ������ �����Ͽ� ���
		
		System.out.print("���� �Է� (10�ڸ�����): ");
		int input = sc.nextInt();
		System.out.printf("%10d", input);
		// %10d : 10ĭ�� ������ ����, ������ ���� ���
		
	}

}
