package com.kh.variable;

public class D_Cast {
	
	/* ����ȯ���� �� ������ ����
	 * 
	 * 1. �ڵ� ����ȯ
	 *  - ���� �ٸ� �ڷ��� ���� �� �����Ϸ��� ���� ������ ���� �ڷ����� ū �ڷ������� ��ȯ�ϴ� ��
	 * 
	 * 2. ���� ����ȯ 
	 *  - ���� ������ ū �ڷ����� ���� �ڷ������� ���������� ��ȯ��Ű�� ��.
	 *  - ���� ����ȯ �� �������� �ս��� �߻��� �� �����Ƿ� �̸� �����ϰ� ���.
	 *  - �����Ϸ��� �ϴ°��� �ƴ� ����� �ϴ� ��
	 *  
	 * */
	
	public void rule1() { // �ڵ� ����ȯ �׽�Ʈ
		
		int a = 12;
		double d = 3.3;
		double result = a + d;
		// a(int) --> a(double)���� �ڵ� ����ȯ ��
		
		System.out.println("result1 : " + result);
		
		//int -> long
		int iNum = 2147483647; // int�� ���� �� �ִ� ���� ū ��
		long lNum = 1000000000L;
		long result2 = iNum + lNum;
		
		System.out.println("result2 : " + result2);
		
		// long -> float
		// long���� byte�� �� ũ���� float�� ���� ������ �� ũ�Ƿ� �ڵ� ����ȯ ����
		long lNum2 = 1234567890123456789L;
		float fNum = 10000000000000000000F;
		float result3 = lNum2 + fNum;
		
		System.out.println("result3 : " + result3);
		
		// char -> int
		// char�� ���� ���ڰ� �ƴ� ������ ����ǰ� ����� ���� ��Ī�Ǵ� ���ڰ� ��µǴ� ��
		// �׷��Ƿ� char�� �����δ� �������̴�.
		
		char ch = '��';
		int iNum3 = ch; // =�� ���� ������
		
		System.out.println("iNum3 : " + iNum3);
		
		char ch2 = 65; // char�� �����δ� �������̱� ������ ������ ���� �� �ʱ�ȭ�� ����
		
		System.out.println("ch2 : " + ch2);
		
	}
	
	
	public void rule2() { // ���� ����ȯ �׽�Ʈ
		int iNum = 10;
		double dNum = 5.89;
		
		// iNum + dNum --> �Ǽ��� ��� (�ڵ� ����ȯ)
		double result = iNum + dNum;
		
		//But, iNum + dNum --> ������ ��� (���� ����ȯ)
		//int result2 = iNum + (int)dNum;
		int result2 = (int)(iNum + dNum);
		
		// �ڵ� ����ȯ ���
		System.out.println("result : " + result);
		// ���� ����ȯ ���
		System.out.println("result2 : " + result2);
		
		//byte, short ���� �� ���ǻ���
		//
		byte bNum1 = 1;
		byte bNum2 = 10;
		
		byte result3 = (byte)(bNum1 + bNum2);
		
	}
	
	
	// ������ �ս� Ȯ��
	public void dataloss() {
		int iNum = 290;
		System.out.println("iNum : " + iNum); // 290
		
		// ���� ����ȯ �� ������ �ս� �׽�Ʈ
		byte bNum = (byte)(iNum);
		System.out.println("bNum : " + bNum);
	}
}
