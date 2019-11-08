package com.kh.chap1_poly.model.vo;

public class Member {
	
//	- name : String // ȸ����
//	- age : int // ȸ������
//	- gender : char // ����
//	- couponCount : int // �丮�п��������� = 0
//	+ Member()
//	+ Member(name:String, age:int, gender:char)
//	+ toString() : String
	
	private String name;
	private int age;
	private char gender;
	private int couponCount;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, int age, char gender, int couponCount) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.couponCount = couponCount;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", couponCount=" + couponCount + "]";
	}
	
	

}
