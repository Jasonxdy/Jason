package com.kh.chap2_ab_in.practice.model.vo;

public interface Phone {
//	
//	+ NUMBERPAD : char[] = {'1', '2',
//			'3', '4', '5', '6', '7', '8', '9', '*', '0', '#'}
//			+ makeCall() : String // ��ȭ �ɱ�
//			+ takeCall() : String // ��ȭ �ޱ�
	
	public char NUMBERPAD[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'};
	String makeCall();
	String takeCall();
}
