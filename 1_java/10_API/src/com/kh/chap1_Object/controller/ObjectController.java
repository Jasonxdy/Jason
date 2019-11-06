package com.kh.chap1_Object.controller;

import com.kh.chap1_Object.model.vo.Student;

public class ObjectController {
	// API (Application Programming Interface)
	// ���� ���α׷��� ���� �� ���α׷��� �� �����ϴ� ��ɵ��� ������ �� �ִ� �������̽��� �����ϴ� ��
	
	
	// Object Ŭ���� 
	/*
	 * �ʵ尡 �������� �ʰ�, 11���� �޼ҵ常 ����.
	 * - ��� Ŭ������ �ֻ��� �θ��̱� ������ � Ŭ���������� �ٷ� ��� ����
	 */
	
	public void method1() {
		Student std1 = new Student("ȫ�浿", "A������",20, 80);
		System.out.println(std1); // System.out.println(std1.toString()); �����δ� �̷������� ��
		// �� ������ : com.kh.chap1_Object.model.vo.Student@15db9742 //15db9742 16������ ��ȣȭ�� ��ġ?
		Student std2 = new Student("ȫ�浿", "A������",20, 80);
	
		
		// ���ü (hashCode()) / ���ϰ�ü (equals())
		// ���ü : ������ ���� ��ü
		// ���ϰ�ü : ���� ������ ���� ��ü
		System.out.println("���� ������ ��ü?" + std1.equals(std2)); //equals : true/false����
		
	}



}
