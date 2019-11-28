package com.kh.chap03_throws.controller;

import java.io.IOException;

public class ThrowsController {
	
	public void method1 () {
		System.out.println("method1() ȣ��");
		try {
			method2();			
		} catch (IOException e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}
	}
	
	public void method2 () throws IOException {
		System.out.println("method2() ȣ��");
		method3();
	}
	
	public void method3 () throws IOException, ArithmeticException {
								// ���� Exception�� ������ų ���� ����
		// �̶� �����Ǵ� Exception�� Checked�� ���
		// ȣ��ο��� �ݵ�� ����ó���� �ʿ�������,
		// Unchecked�� ��� ȣ��ο��� ����ó���� ���������� �ϸ� ��
		// method2���� ArithmeticException�� throws���� �ʾƵ� ������ ������ �ȳ��� ������
		// IOException�� Checked�̰�, ArithmeticException�� Unchecked�̱� ����!.
		
		System.out.println("method3() ȣ��");
		method4();
		
		int num = 2/0;
	}
	
	public void method4 () throws IOException {
		System.out.println("method4() ȣ��");
		
		// throw : ������ Exception �߻���Ű�� Ű����
		// throws : �߻��� Exception�� ȣ��η� �����ϴ� Ű����
		throw new IOException();
	}
	
	
	

}