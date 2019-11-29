package com.kh.chap2_ab_in.model.vo;

public abstract class Bird implements Animal {
	
	public static final int LEG = 2;
	
	private int wing;
	
	public Bird() {} // �⺻������
	
	public Bird(int wing) {
		this.wing = wing;
	}

	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}
	
	public void flappingWing() {
		System.out.println("���� �۴��Ÿ���");
	}
	
	// �߻� �޼ҵ�
	public abstract void fly();

}
