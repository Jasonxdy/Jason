package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	
	// ���� ������
	
	// ���ǽ�? ��1 : ��2;
	
	// ���ǽ� : �ݵ�� ����� true �Ǵ� false�� ������ ��
	// �� 1 : ���ǽ��� true�� �� ����Ǵ� ��
	// �� 2 : ���ǽ��� false�� �� ����Ǵ� �� 
	
	public void method1() {
		// �Է¹��� ������ ¦���� "¦���Դϴ�" Ȧ���� "Ȧ���Դϴ�" ����ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		String result = (input%2 == 0)? "¦���Դϴ�" : "Ȧ���Դϴ�";
		System.out.println(result);
	}
	
	public void method2() {
		// �Է¹��� ������ ������� �������� 0���� �Ǻ��ϱ�
		Scanner sc = new Scanner (System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		String result = input>0 ? "���" : input==0? "0" : "����"; // ���� ������ ��ø ���
		System.out.println(result + "�Դϴ�.");
	}
	
	public void method3() {
		
		// �� ���� '+' �Ǵ� '-' �� �Է� �޾� �˸��� ��� ��� ����ϱ�
		// ��, '+' �Ǵ� '-' �̿��� ������ �Է� �� "�߸� �Է��ϼ̽��ϴ�" ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int num2 = sc.nextInt();
		sc.nextLine(); // ���ۿ� �����ִ� �ٹٲ� ���� (\n) ����
		System.out.print("������ (+ or -) : ");
		char op = sc.nextLine().charAt(0);
		// System.out.println(num1 + " / " + num2 + " / " + op);
		
		String result = op=='+'? num1 + num2 +"": op=='-'? num1-num2 + "" :"�߸� �Է��ϼ̽��ϴ�";
		
		System.out.println(result);
		
		
		
		
		
		
	}

	
	
}
