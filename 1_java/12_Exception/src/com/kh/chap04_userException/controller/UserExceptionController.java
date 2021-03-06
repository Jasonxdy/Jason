package com.kh.chap04_userException.controller;

import java.util.Scanner;

import com.kh.chap04_userException.model.exception.UserException;

public class UserExceptionController {
	// 숫자 3개를 입력받아 합을 출력하는 메소드
	// 단, 0 입력 시 바로 프로그램 종료
	
	public void method1() {
		try {
			method2();
			System.out.println("프로그램 정상 종료");
		} catch (UserException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}
	
	
	public void method2() throws UserException{
		Scanner sc = new Scanner (System.in);
		
		int sum = 0;
		int input = 0;
		for (int i = 1; i < 4; i++) {
			System.out.print("입력 " + i + " : ");
			input = sc.nextInt();
			if(input == 0) {
				throw new UserException("프로그램 강제 종료");
			}
			sum += input;
		}
		
		System.out.println("합 : " + sum);
	
	}
	
	
}
