package com.kh.chap3_field.model.vo;

public class Korean {
	
	private int age;
	public static int nCode;
	// static���� ����� ������(==�ʵ��) ���� �����ڸ� public���� �ϴ� ���� ����
	// (static ������ ������ ������ �� �ֱ� ����)
	
	// ���� + ��� : ��ΰ� �����ϵ� ������ ���� ���� �����
	public static final double PI = 3.141592;
	
	
	// �ν��Ͻ� �ʱ�ȭ ��
	// �ν��Ͻ� ������ �ʱ�ȭ ��Ű�� ��
	// ��ü ������ ���� �ʱ�ȭ
	{
		age = 1;
	}
	
	// static �ʱ�ȭ ��
	// Ŭ���� ������ �ʱ�ȭ��Ű�� ��
	// ���α׷� ���� �� �� �ѹ� �ʱ�ȭ ���� 
	static {
		nCode = 82;
	}

	
	// ������ : ������ �����
	public Korean() {}
	
	// �޼ҵ�
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	
	
}
