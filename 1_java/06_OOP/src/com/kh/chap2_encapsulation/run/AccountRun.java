package com.kh.chap2_encapsulation.run;

import com.kh.chap2_encapsulation.model.vo.Account;
import com.kh.chap3_field.model.vo.Korean;

public class AccountRun {
	
	public static void main(String[] args) {
		//ĸ��ȭ
		/*
		 * �߻�ȭ�� ���� ���ǵ� �Ӽ�, ����� �ϳ��� ���� �����ϴ� ���
		 * �� �� Ŭ���� ������ ������ (�ʵ� or �������)�� ���� ������ �����ϴ� ���� ��Ģ�̹Ƿ� private ���� �����ڸ� ���.
		 * 
		 * ���� ������ ����Ͽ� ���� �����Ϳ� ������ ���� ���� ���ٹ�� (��� == �޼ҵ�)�� Ŭ���� ���ο� �ۼ�.
		 * == getter / setter �޼ҵ�
		 * 
		 */
		
		Account acc = new Account();
		//������ : ��ü ���� �� �ʱ� �ʵ尪�� �������ڸ��� ������ ����� �ۼ��ϴ� �κ�
		
		// acc.name = "ȫ�浿";
		// --> Account ��ü ������ name �ʵ尡 private�̹Ƿ� �ܺ� ���� ���� �Ұ�
		// ���� , ���� ���� ��� ����ؾ� ��
		acc.setName("ȫ�浿");
		acc.setAccountNumber("01022471339");
		acc.setPassword("��й�ȣ");
		acc.setBankCode(10);
		acc.setBalance(100000000);
		
		System.out.println(Korean.nCode);
		
		System.out.println("���� ����");
		System.out.println(acc.getName());
		System.out.println(acc.getAcocuntNumber());
		System.out.println(acc.getPassword());
		System.out.println(acc.getBankCode());
		System.out.println(acc.getBalance());
		
		acc.deposit(100000000);
		System.out.println(acc.getBalance());
	}

}
