package com.kh.chap2_encapsulation.model.vo;

public class Account {

	// Ŭ���� ����
	/*
	 * Ŭ���� ����� (==Class Signature) {
	 * 
	 * 		// �ʵ� (== ��� (Ŭ������ �����ϴ� �������� �ǹ�)����)
	 * 
	 * 		// ������
	 * 
	 * 		// �޼ҵ�
	 * }
	 * 
	 */
	
	//�ʵ�
	private String name; // ������
	private String accountNumber; // ���¹�ȣ
	private String password; // ��й�ȣ
	private int bankCode; // �����ڵ�
	private int balance; // �ܾ�
	
	//������ : ��ü ���� �� �ʱ� �ʵ尪�� �������ڸ��� ������ ����� �ۼ��ϴ� �κ�
	public Account() {}
	
	// �޼ҵ�
	
	// getter / setter : getter�� ���� ���, setter�� ���� �ִ� �޼ҵ�
	// name�� ���� getter/setter
	
	public void setName(String name) {
		this.name = name;
		// �ʵ� name  ���޹��� name
	}
	
	public String getName() {
		return name;
	}
	
	// accountNumber�� getter/setter
	/*
	 * < setter �ۼ� ��� >
	 * public void set�ʵ��(�ʵ����ڷ��� ������(==�ʵ��)){
	 * this.�ʼ��� = ������;
	 * }
	 */
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/*
	 * getter �ۼ� ���
	 * public ��ȯ�� get�ʵ��() {
	 * return �ʵ��;
	 * }
	 */
	
	public String getAcocuntNumber() {
		return accountNumber;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	
	public int getBankCode() {
		return bankCode;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// �Ա� ��� 
	public void deposit(int money) {
						// �Ա��ϰ��� �ϴ� �ݾ��� int money�� ���޵Ǿ� �Ѿ��
		balance += money;
		System.out.println(name+"���� ���¿� "+ money + "���� �Աݵ�.");
	
	
	}
	
}
