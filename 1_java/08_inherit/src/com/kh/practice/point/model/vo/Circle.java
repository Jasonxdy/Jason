package com.kh.practice.point.model.vo;

public class Circle {
	/*
	- radius : int
	+ Circle() : �⺻������
	+ Circle(x:int, y:int, radius:int) : �Ű����� ������
	+ getter/setter()
	+ toString() : String : �ʵ忡 ��� �����͸� ��ȯ�ϴ� �޼ҵ�
	*/
	
	private int radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
