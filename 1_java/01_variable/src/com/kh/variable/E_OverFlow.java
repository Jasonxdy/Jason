package com.kh.variable;

public class E_OverFlow {
	
	// �����÷ο� Ȯ���ϱ�
	public void overflow() {
		
		// �����÷ο�� ���Կ����� �̿��� ��Ȳ���� �߻� ����
		byte bNum = 127; //����Ʈ ���� �ִ�
		System.out.println("���� �� : " + bNum); //127
		bNum = (byte)(bNum + 1);
		System.out.println("���� �� : " + bNum); // -128
		
		byte bNum2 = 127;
		int result = bNum2 + 1;
		System.out.println("result : " + result);
		
		float fNum = 12.001f;
		double dNum = fNum + 1;
		System.out.println("dNum = " + dNum);
		
	}

}
