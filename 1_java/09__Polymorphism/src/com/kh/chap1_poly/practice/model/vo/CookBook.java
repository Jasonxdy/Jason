package com.kh.chap1_poly.practice.model.vo;

public class CookBook extends Book {
	
//	- coupon : boolean // �丮�п���������
//	+ CookBook()
//	+ CookBook(title:String, author:String,
//	publisher:String, coupon:boolean)
//	+ toString() : String
	
	private boolean coupon;
	
	public CookBook() {
		// TODO Auto-generated constructor stub
	}
	
	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}

	
	
	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "CookBook [" +super.toString()+ ", coupon=" + coupon + "]";
	}
	
	

	
	

}
