package com.kh.variable;

public class A_Variable {
	
	// ������ ������� �ʴ� ���
	public void noVariable () {
		
		System.out.println("====== ���� ��� X ======");
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 * 10);
		System.out.println(3.141592653589793 * 10 * 10 * 20);
		System.out.println(4 * 3.141592653589793 * 10 * 10);
		
	}
	
	// ������ ����� ���
	public void usingVariable() {
		
		double pi = 3.141592653589793; // ������
		int r = 10; // ������
		int h = 20; // ����
		
		System.out.println("===== ���� ��� O =====");
		System.out.println(2 * pi * r); // ���� �ѷ�
		System.out.println(pi * r * r); // ���� ����
		System.out.println(pi * r * r * h); // ������� ����
		System.out.println(4 * pi * r * r); // ���� �ѳ���
		
	}	

	// ���� ����
	public void declareVariable() {
		
		// 1. ����
		boolean isTrue; // 1byte �Ҵ� - true / false
		
		// 2. ������
		byte bNum; // 1byte == 8bit == 2^8��
		short sNum; // 2byte == 16bit == 2^16��
		int iNum; // 4byte == 32bit == 2^32�� -> ������ �⺻ �ڷ���
		long lNum; // 8byte == 64bit == 2^64��
		
		// 3. �Ǽ��� -> �ε� �Ҽ��� ���
		float fNum; // 4byte
		double dNum; // 8byte -> �Ǽ��� �⺻ �ڷ���

		// 4. ������
		char ch; // 2byte �����ڵ� (���ڴ� ��Ī�Ǵ� ���� ����)
				 // ���� ����Ǵ� ���� ��������, ��Ī�Ǵ� ���ڰ� ��µ�
		
		// 5. ���ڿ� (������)
		String str; //
		
		// ���� �� ����
		isTrue = true;
		// ������ ���ͷ��� true �Ǵ� false 2���ۿ� ����
		
		// ������ �� ����
		iNum = 100;
		// �Ϲ� ������ int�� ���ͷ� ǥ���� (�ڿ� ǥ�� ���� �͵�)
		
		lNum = 200l;
		// long�� ���ͷ��� ���� �ڿ� l �Ǵ� L�� ǥ��
		
		bNum = 127;
		sNum = 32767;
		// byte, short �ڷ����� ���� �ڵ���� ȣȯ�� ���� �������� (������ �޸� ������ ��)
		// -> ���� ���ͷ� ǥ������ ��� int ǥ������ ���� ���
		
		fNum = 1.1234567f;
		// float�� ���ͷ��� �Ǽ� �ڿ� f �Ǵ� F�� ǥ��
		// float�� �Ҽ��� �Ʒ� 8��° �ڸ����� �ݿø���.
		
		dNum = 1.123456789012345;
		// double�� �Ҽ��� �Ʒ� 16��° �ڸ����� �ݿø���.
		// double���� ���ͷ��� d �����൵ ������µ� ������ �����ν� �Ⱦ�
		// �Ϲ� �Ǽ��� double�� ���ͷ� ǥ����(�ڿ� ǥ�� ���� �͵�)
		
		// ������ �� ����
		ch = 'A'; //char�� ���ͷ��� '' (Ȧ����ǥ) ���� �� ����
		
		// ���ڿ� �� ����
		str = "���� ������";// String�� ���ͷ��� " " ���� ���ڿ�
		
		// ������ ����� �� ���
		System.out.println("isTrue : " + isTrue);
		System.out.println("bNum : " + bNum);
		System.out.println("sNum : " + sNum);
		System.out.println("iNum : " + iNum);
		System.out.println("lNum : " + lNum);
		
		System.out.println("fNum : " + fNum);
		System.out.println("dNum : " + dNum);
		
		System.out.println("ch : "+ ch);
		System.out.println("str : " + str);
		
	}

	// ���� ����� ���ÿ� �ʱ�ȭ
	public void initVariable() {
		boolean isTrue = false;
		byte bNum = -128; // 1byte
		short sNum = 500; // 2byte
		int iNum = 100000; // 4byte
		long lNum = 12345678901L; // 8byte
		
		float fNum = 1.1234567F; // 4byte
		double dNum = 1.123456789012345; // 8byte
		
		char ch = 'A'; // 2byte
		String str = "Hello World"; // 4byte (�������� ��� 4byte)
	}

}
