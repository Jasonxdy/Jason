package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		
		// User ��ü ����
		/*
		 * User user1 = new User();
		
		user1.setUserId("admin");
		user1.setUserPwd("1234");
		user1.setUserName("������");
		user1.setAge(40);
		user1.setGender('��');
		
		System.out.println(user1.inform());*/
		
		
		// �Ű����� �ִ� �����ڸ� �̿��Ͽ� User ��ü ����
		User user2 = new User("user02", "pass02", "�����2", 20, '��');
		System.out.println(user2.inform());
		
		//
		User user3 = new User();  //--> �� ��쿡 ������ ���� ������ UserŬ������ �����ڰ� �Ű������� �ֱ� ������ JVM�� �ڵ����� ������ ��������� ����
		
	}
}
