package com.kh.chap04_userException.model.exception;

public class UserException extends Exception {
	
	// ����� ���� ���� Ŭ���� ���� ���
	// -> ������ Java�� �������ִ� Exception Ŭ���� �� �ϳ��� ��ӹ����� ��.
	// ���� Exception �Ǵ� RuntimeException�� ��� ����. -- �뵵 (Unchecked, Checked)�� ���� �ٸ�
	
	public UserException() {
		super();
	}
	
	public UserException(String msg) {
		super(msg);
	}
	
	

}
