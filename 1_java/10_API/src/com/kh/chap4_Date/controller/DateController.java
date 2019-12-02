package com.kh.chap4_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateController {
	public void method1() {
		
	
	// ���� ��¥, �ð� ��� -> Date() �⺻ �����ڸ� �̿��Ͽ� ��ü ����
	
	// Date() �⺻ ������ : ��ü�� ������ ���� ����� �и��� ������ �ʱ�ȭ
	// 1ms = 1/1000s
	
	// �츮���� ����
	// java�� 1970�� 1�� 1�� ���� 9�� 0�� 0�ʸ� �������� �ð��� ms ������ ���
	
	Date today = new Date();
	System.out.println("����ð� : " + today);
	
	// ���� �ð� ���
	Date standard = new Date(0L);
	System.out.println("���ؽð� : "+ standard);
	
	// ��¥ ��� ���� ����
	SimpleDateFormat fmt = new SimpleDateFormat("G yyyy�� MM�� dd�� E���� hh�� mm�� ss��");
	String str = fmt.format(today);
	
	System.out.println("SimpleDateFormat�� ����� �ð� : " + str);
	//���� 2019�� 11�� 6�� ������ 3�� 36�� 50��
	
	}
}
