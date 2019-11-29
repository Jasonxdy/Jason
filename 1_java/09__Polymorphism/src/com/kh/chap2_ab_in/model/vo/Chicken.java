package com.kh.chap2_ab_in.model.vo;

public class Chicken extends Bird implements Animal {
	// �߻�Ŭ������ ����ؼ� ����ϸ�, �������̽��� ������ �״�� 
	private double crestLength;
	
	public Chicken() {
		// TODO Auto-generated constructor stub
	}
	
	public Chicken(int wing, double crestLength) {
		super(wing);
		this.crestLength = crestLength;
	}
	
	public double getCrestLength() {
		return crestLength;
	}

	public void setCrestLength(double crestLength) {
		this.crestLength = crestLength;
	}

	@Override
	public void fly() {
		System.out.println("���� ����");
	}
	
	@Override
	public void breathing() {
		System.out.println("�� ȣ��");
	}
	
	@Override
	public void move() {
		System.out.println("�ι߷� �ɾ�ٴ�");
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}
