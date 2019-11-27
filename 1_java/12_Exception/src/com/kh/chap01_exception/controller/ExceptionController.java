package com.kh.chap01_exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionController {
	
	/* Unchecked Exception
	 * - ������ ����ó���� ���� �ʾƵ� �Ǵ� ���� (Exception)
	 * - �ַ� ���α׷����� �����Ƿ� ���� ��찡 ���� ������ 
	 * ����ó�� ���ٴ� ���ǹ� ���� �̿��� �ڵ� ���� �ʿ�
	 */
	
	public void method1() {

		// Scanner�� �̿��Ͽ� �� ���� �Է¹޾� ������ ���α׷� �ۼ�
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է¹��� �� �� ������");
		System.out.print("�Է� 1 : ");
		int num1 = sc.nextInt();
		System.out.print("�Է� 2 : ");
		int num2 = sc.nextInt();

		if (num2 == 0) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} else {
			System.out.println("num1 / num2 = " + num1 / num2);
		}
		// �̷������� ���ܸ� ���� �� �ִ�
	}
	
	// Checked Exception 
	// Ư�� �ڵ尡 ���ܸ� �߻���ų ���ɼ��� �����Ƿ� ��� �� �ݵ�� ����ó���� �ؾ��ϴ� ����.
	public void method2() {
		
		// Scanner�� ���� ������ Ű���� �Է� ��� �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.in -> Ű���� �Է��� ��Ÿ���µ� �̰� ����Ʈ�ڵ�� �ԷµǾ� �װ��� 
		// �츮�� �˾ƺ� �� �ִ� ���·� �ٲ��ִ� �ڵ�
		
		System.out.print("���ڿ� �Է� : ");
		try { 
			String str = br.readLine();
			
			System.out.println("�Է��� ���ڿ� : " + str);
			
		} catch (IOException e) {
			System.out.println("IOException �߻�");
		}
		
		
	}
	
}
