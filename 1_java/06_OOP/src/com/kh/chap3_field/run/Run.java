package com.kh.chap3_field.run;

import com.kh.chap1_Abstraction.model.vo.Person;
import com.kh.chap3_field.model.vo.Korean;

public class Run {
	
	public static void main(String[] args) {
		
		// �ʵ� (Field)
		// C���� ���ϴ� '��������'�� ����� �������� �ش� Ŭ���� ���� ��𼭵� ���� ������ ����
		// + ���� ������ �Ǵ� �����(ex: static)�� ���� ���� ���� Ȯ��
		
		// ��������
		// �޼ҵ�, ������, ��� ���� ��({ }) ���ο��� ����� ������ �ش� ����� ��� �������� ��� ����
		// ���� �ֱ� (life cycle) : ������ ���� (�� �ڵ尡 ����� ����) ~ �ش� �޼ҵ尡 ����Ǵ� ���� 

		
		// �ʵ��� ����
		/*
		 * 1. ��� ���� (== �ν��Ͻ� ���� : �ν��Ͻ� �ȿ� �����Ǵ� �����̱� ����)
		 *  ���� : new�� ���� �ν��Ͻ� (��ü) ���� �� �޸𸮿� �Ҵ�
		 *  �Ҹ� : �ν��Ͻ��� �Ҹ�� �Ҹ�
		 * 
		 * 2. Ŭ���� ����(== static ���� ) : � Ŭ������������ ����� �� �ֱ⶧���� �̷��� �θ� ;;
		 * --> static ���� ���� ����
		 *  ���� : ���α׷� ���� �� static ������ �޸� �Ҵ�
		 *  �Ҹ� : ���α׷� ���� �� �Ҹ�
		 */
		
		// ���α׷� ���� �� static ������ �޸𸮰� �Ҵ� �Ǵ��� Ȯ��
		System.out.println(Korean.nCode);
		// ��Ű�� �� �ƹ��������� �ҷ��� �� ����... static �����̹Ƿ� ���α׷� �����ϸ� �ϴ� �� �ܾ static������ ������ ���ε�
		
		// ���� ��ü���� static ���� ���� Ȯ��
		Korean k1 = new Korean();
		Korean k2 = new Korean();
		System.out.println("k1�� ����");
		System.out.println("age : "+ k1.getAge());
		System.out.println("nCode : "+ k1.nCode);
		System.out.println("k2�� ����");
		System.out.println("age : "+ k2.getAge());
		System.out.println("nCode : "+ k2.nCode);
		
		k1.setAge(10);
		k2.setAge(20);
		
		System.out.println("k1�� ����");
		System.out.println("age : "+ k1.getAge());
		System.out.println("nCode : "+ k1.nCode);
		System.out.println("k2�� ����");
		System.out.println("age : "+ k2.getAge());
		System.out.println("nCode : "+ k2.nCode);
		
		// Static ������ ����� Korean.nCode �� ���� ����
		Korean.nCode = 1;
		System.out.println("k1�� ����");
		System.out.println("age : "+ k1.getAge());
		System.out.println("nCode : "+ k1.nCode);
		System.out.println("k2�� ����");
		System.out.println("age : "+ k2.getAge());
		System.out.println("nCode : "+ k2.nCode);
		
		//k1.nCode �� ���� �� ���� Ȯ��
		k1.nCode = 2;
		System.out.println("k1�� ����");
		System.out.println("age : "+ k1.getAge());
		System.out.println("nCode : "+ k1.nCode);
		System.out.println("k2�� ����");
		System.out.println("age : "+ k2.getAge());
		System.out.println("nCode : "+ k2.nCode);
		

		
	}

}
