package com.kh.chap1_list.part1.controller;

import com.kh.chap1_list.part1.model.vo.Student;

public class ObjectArrayController {
	// ��ü �迭�� �̿��Ͽ� Student ��ü ����
	
	// �л� ��ü �迭 ����
	private Student[] arr = new Student[3];
	
	// ��ü �迭�� �ε��� �� ���� ����� ��� ���� ������ ����
	private int size = 0;
	
	// ��ü �迭�� ���޹��� Student ��ü �߰� �޼ҵ�
	public void insertStudent(Student std) {
		
		if(size >= arr.length) {
			// ���� ũ�⺸�� �ι� ū �迭�� ���� ���� �迭 ������ ���� �� ���� ������ �迭�� �ּҸ� arr�� �����ϰ� �����
			Student[] newArr = new Student[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr; // ũ�Ⱑ ������ �迭�� �ּҸ� ���� �迭 ������ ������ �����ϰ� ���� (���� ����)
		}
		arr[size] = std;
		size++;
	}
	
	// ��ü �迭�� ����Ǿ� �ִ� ��� ������ ��� 
	public void printStudent() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) break;
			System.out.println(arr[i]); // == System.out.println(arr[i].toString()); ���� �����Ϸ��� �ڵ����� ��������..�ֳĸ� Student�� toString �������̵� �س��� 
			}
	}

	
	// �Ű������� ���޵� �ε����� �ִ� ��Ҹ� �����ϰ� �߰��� ������ ������ ����ֱ�
	public void removeStudent(int index) {
		// TODO Auto-generated method stub --> Menu���� �޼ҵ� ����� �������� �κ� ���� create~ ������ �ڵ�����
		
		// ���� ������ �迭 ��ҿ� ���� �迭 ��Ҹ� ����(�����)
		// �������� �������� �����ִ°� ��ĭ�� ����� -> �׸��� ������ null�� �ٲ�
		for (int i = index; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		
		// ������ �ڸ��� null�� ����
		arr[arr.length-1] = null;
		size--; // �߰��Ҷ����� size�� �ϳ��� �߰������Ƿ�... ������ �Է��� ���� size ����
		
	}
	


	// �̷������� ������ �����ϱ� ������ Collection ���
	
}
