package com.kh.practice.point.model.vo;

public class Rectangle {
	/*
	- width : int
	- height : int
	+ Rectangle() : �⺻������
	+ Rectangle(x:int, y:int, width:int, height:int) : �Ű����� ������
	+ getter/setter()
	+ toString() : String : �ʵ忡 ��� �����͸� ��ȯ�ϴ� �޼ҵ�
	*/
	
	private int width;
	private int height;
	
	public Rectangle() {
	}

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	
	
	
}