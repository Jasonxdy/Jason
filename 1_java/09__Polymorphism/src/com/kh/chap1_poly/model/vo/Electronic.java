package com.kh.chap1_poly.model.vo;

public class Electronic {
	
	private String brand;
	private String name;
	private int price;
	
	
	// ctrl + space ---> enter
	public Electronic() {
		
	}
	 
	// alt + shift + s ---> o
	public Electronic(String brand, String name, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	// alt + shift + s ---> r (space�� üũ �� ����)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() { //toString �޼ҵ� ��ü�� Object Ŭ������ �޼ҵ��̹Ƿ�  �������̵��� ����
		return brand + ", " + name + ", " + price;
	}
	
	
}
