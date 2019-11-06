package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employ = new Employee[3];
		
		employ[0] = new Employee(0, null, null, null, 0, '0', 0, 0, null, null);
		employ[1] = new Employee(1, "ȫ�浿", null, null, 19, 'M', 0, 0.0, "01022223333", "���� ���");
		employ[2] = new Employee(2, "������", "������", "����", 20, 'F', 1000000, 0.01, "01011112222", "���� ����");
		
		for (int i = 0; i < employ.length; i++) {
			System.out.println("employ["+i+"] : " + employ[i].toString());
		}
		
		//emp[0] : 0, �踻��, ������, ����, 30, M, 3000000, 0.2, 01055559999, ���� ����
		employ[0].setEmpName("�踻��");
		employ[0].setDept("������");
		employ[0].setJob("����");
		employ[0].setAge(30);
		employ[0].setGender('M');
		employ[0].setSalary(3000000);
		employ[0].setBonusPoint(0.2);
		employ[0].setPhone("01055559999");
		employ[0].setAddress("���� ����");
		
		//emp[1] : 1, ȫ�浿, ��ȹ��, ����, 19, M, 4000000, 0.3, 01022223333, ���� ���
		employ[1].setDept("��ȹ��");
		employ[1].setJob("����");
		employ[1].setSalary(4000000);
		employ[1].setBonusPoint(0.3);
		
		System.out.println("================================================================================");
		
		for (int i = 0; i < employ.length-1; i++) {
			System.out.println("employ["+i+"] : " + employ[i].toString());
		}
		
		// ���� ������ ���ʽ��� ����� 1�� ������ ����Ͽ� ���
		// ���� = (�޿� + (�޿� * ���ʽ�����Ʈ)) * 12
		/*
		�踻���� ���� : 43200000��
		ȫ�浿�� ���� : 62400000��
		�������� ���� : 12120000��
		*/
		System.out.println("================================================================================");
		
		int sum = 0;
		for (int i = 0; i < employ.length; i++) {
			System.out.println(employ[i].getEmpName() + "�� ���� : " + (int)(employ[i].getSalary()+(employ[i].getSalary()*employ[i].getBonusPoint()))*12);
			sum += (int)(employ[i].getSalary()+(employ[i].getSalary()*employ[i].getBonusPoint()))*12;
		}
		// 3���� ������ ���� ����� ���Ͽ� ���
		// �������� ������ ��� : 39240000��
		System.out.println("������ ������ ��� : " + sum/3);
	}
}
