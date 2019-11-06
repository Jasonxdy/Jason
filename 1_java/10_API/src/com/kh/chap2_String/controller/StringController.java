package com.kh.chap2_String.controller;

import java.util.Scanner;

public class StringController {
	
	// String Class
	// ���ڿ� ���� ���� �Ұ����� �Һ� (immutable) Ŭ���� // mutant�� ���������� ����� ����
	// ���ڿ� ���� ���� �� ���ο� ���ڿ��� �Ҵ�Ǿ� �� �ּҸ� ��ȯ����
	
	public void method1() {
		String str1 = "abc";
		
		// str1.hashCode() -> �̶� String�� hashCode�� �������̵� �س��� ������ �������� hashCode �� �� ����..
		// String.hashCode()�� char���� �ؽ��ڵ�ȭ��Ų ������ �� �ּҸ� �˷����� ���� --> ����, ���ϴ� �ּҰ��� ������ hashCode ��� �Ұ�
		
		
		// System.identifyHashCode(obj) ����ؾ� �� --> ��ü�� ���� �ּҸ� �̿��Ͽ� ���� hashCode�� ��ȯ���ִ� ���
		System.out.println("str1 : " + System.identityHashCode(str1));
		// ���� ��� : 796533847
		
		str1 += "def";
		System.out.println("str1 : " + System.identityHashCode(str1));
		// ���� ��� : 1449621165
		// �� ���ο� ��ü�� �����ߴٴ� �ǹ�..(������ str1�� �����ϴ� ��ü�� GC�� ������ ��)
		
		String str2 = "abcdef";
		System.out.println("str2 : " + System.identityHashCode(str2));
		// ���� ��� : 1627960023
		
		String str3 = "abcdef";
		System.out.println("str3 : " + System.identityHashCode(str3));
		// ���� ��� : 1627960023 (str2�� ����)
		// str2�� str3�� ���� String ��ü�� �����ϰ� �ִ�
		// --> �� String ���ͷ��� ���� ���� StringPool�� ����, ���Ŀ� �Ȱ��� String ���ͷ��� ����� �ɶ� ���Ӱ� �����Ǵ� ���� �ƴ϶� ������ ��������ִ� StringPool�� ������ �����Ǿ� �ִ� ���� �ּҸ� �����Ѵ�
		// cf> abc + def �Ѱ��� �ڹ� ������ ���� ���̿� �ִµ�...? �ּҰ� �ٸ�
		
		
		
		String s1 = "Hello";
		String s2 = new String("Hello"); //String Ŭ������ ������ Ȱ��
		
		System.out.println("s1 �� : "+s1);
		System.out.println("s2 �� : "+s2);
		// ��� : Hello�� ����
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		// ��� : �ּҰ��� �ٸ���..!
	}
	
	public void method2() {
		
		//StringBuffer �⺻������ ���� �� ���� ũ�� : 16
		StringBuffer sb = new StringBuffer();
		System.out.println("sb�� ���� ũ�� : " + sb.capacity());
		
		//StringBuffer �Ű����� �ִ� �� ���� �� ���� ũ�� : 8+24
		StringBuffer sb2 = new StringBuffer("java api");
		System.out.println("sb2�� ���� ũ�� : " + sb2.capacity());
		
		// ���� vs �Һ� Ȯ��
		System.out.println("sb�� �ؽ��ڵ� : " + sb.hashCode()); // �������̵� �ȵǾ��־ ��� ����... StringBuffer�̹Ƿ�
		
		//StringBuffer�� �� �߰�
		sb.append("Hello World"); // StringBuffer�� .append() ����ؾ� ��
		
		System.out.println("sb : " + sb);
		System.out.println("��ȭ�� sb�� �ؽ��ڵ� : " + sb.hashCode()); // ����� �Ŀ��� �ؽ��ڵ� ��ȭ ����
		
		sb.append(sb); // sb�� ���� sb���� �ѹ� �� �߰�
		System.out.println("sb : " + sb);
		System.out.println("sb ���� ũ�� : " + sb.capacity()); // ���� ũ�� : 34 = ���� 16*2 + 2
		System.out.println("�� ��ȭ�� sb�� �ؽ��ڵ� : " + sb.hashCode()); // ���� ũ�⸦ �÷��� �ؽ��ڵ� ��ȭ ����
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ���� �Է��ϼ��� : ");
		// 1 + 2 -> �ѹ��� �Է��ϵ�, ���⸦ �����ڷ� �����
		String input = sc.nextLine();
		
		//�����ڸ� ����Ͽ� string�� �迭�� �ϳ� �ϳ� ���� String �迭�� ������
		String arr[] = input.split(" "); // ������ �����ڷ� �Էµ� ������ String �迭�� ��ȯ
		
		// �Էµ� �� �� ���ںκ��� ������ ��ȯ
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[2]);
		
		switch(arr[1]) {
		case "+" : System.out.println(num1 + num2); break;
		case "-" : System.out.println(num1 - num2); break;
		case "*" : System.out.println(num1 * num2); break;
		case "/" : System.out.println(num1 / num2); break;
		case "%" : System.out.println(num1 % num2); break;
		default : System.out.println("�����ڸ� �߸��Է���.");
		}
		//"ȫ�浿,20,����,����" -> �̷������� �Է� �޾����� split �̿��Ͽ� ���� ����
		
		
	}

	
	
	
	
}
