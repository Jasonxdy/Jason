package com.kh.chap1_list.part1.controller;

import java.util.ArrayList;

import com.kh.chap1_list.part1.model.vo.Student;

public class StudentController {
	// Collection �� ArrayList�� �̿��Ͽ� Student ��ü ����
	
	// �л� ��ü�� ������ ArrayList ����
	ArrayList<Student> list = new ArrayList<Student>();
	// <Student> --> Generics(���׸�) : ���� ������ ��Ȯ���ϱ� ������ E�� ǥ���ϴ� ��
	// �ش� �÷��ǿ� ������ ��ü�� Ÿ���� ����
	
	public void method() {
		// ���׸� Ÿ�� ���� �׽�Ʈ
		ArrayList list1 = new ArrayList();
		ArrayList<Student> list2 = new ArrayList<Student>();
		
		// Student ��ü �߰�
		list1.add(new Student());
		list2.add(new Student());
		
		// String ��ü �߰�
		list1.add(new String("aaa"));
		// list2.add(new String("aaa")); -> list2�� ������ ��ü Ÿ���� �����Ǿ� �ֱ� ������
		
		// Ÿ������ �� �ϴ°�?
		// Ÿ�� ������ ���� ���¿��� Student ��ü�� setName() �޼ҵ� ȣ���ϱ�
		// list1.get(0).setName("�̸�") : �̰� �ȵ�...��? -> get�� ��ȯ�ϴ� ���� �θ� ��ü�� Object�̱� ������ (.get ġ�� ��ȯ�� ����.. �̰� Ÿ�� ������ ���ؼ� �̷���),
		if (list1.get(0) instanceof Student) { // 0��° ��ü�� Student Ÿ������ Ȯ�α��� ������ϰ�
			((Student) list1.get(0)).setName("�л��̸�1"); // �̷������� DownCasting ����� �� -> object�� ��ȯ�ϱ� ������
		}
		
		// Ÿ�������� �� ����Ʈ���� Student ��ü�� setName() �޼ҵ� ȣ���ϱ�
		list2.get(0).setName("�л��̸�1");
	}
	
	// ArrayList�� �л� ��ü �߰� �޼ҵ�
	public void insertStudent(Student std) {
		list.add(std);
	}
	
	// ArrayList�� ����Ǿ� �ִ� ��� ������ ���
	public void printStudent() {
		for (int i = 0; i < list.size(); i++) { // .size : ���� ��ü�� ��� ���� ��ȯ Returns the number of elements in this list.
			System.out.println(list.get(i));
			// �̶� ��ü �迭���� �ٸ��� list.size�� ������� ������ List�� �⺻������ 10ĭ�� �����Ѵٰ� �ص� null�� ��µ��� ����
		}
		
	}

	
	// �Ű������� ���޹��� index�� �ش��ϴ� ��� ����
	public void removeStudent(int index) {
		// TODO Auto-generated method stub
		list.remove(index);
		
	}
	
	

}
