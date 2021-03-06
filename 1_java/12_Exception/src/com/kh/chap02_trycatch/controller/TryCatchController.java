package com.kh.chap02_trycatch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchController {
	
	
	/* try ~ catch 구문 : Exception이 발생한 곳에서 직접 처리하는 예외 처리 방법
	 * 
	 * - try : 예외가 발생할 가능성이 있는 코드를 try 블록{} 내에 넣고 시도
	 * 
	 * - catch : try 블록 내에서 발생하는 (던져지는 throws) Exception을 잡아내서 처리하는 방법을 기술
	 * 
	 * - finally : try~catch 수행 후 마지막으로 반드시 실행해야하는 코드를 작성하는 부분
	 * 
	 */
	
	public void method1() {
		// Scanner를 이용하여 입력된 두 수 나누기
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("입력된 두 수 나누기");
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.println("입력1/입력2 : " + num1/num2);
			
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수는 없습니다");
		} catch (InputMismatchException e) {
			// catch 구문은 여러개 작성 가능함.
			// 단, 여러 개 작성 시 상속 관계를 고려해야 함..!
			System.out.println("잘못 입력하셨습니다. 정수만 입력해주세요");
		} catch (Exception e) { // 모든 exception의 조상인 Exception 클래스를 작성
			System.out.println("예외 상황 발생");
//			catch 구문을 여러개 작성할 경우,
//			상속 관계에서 가장 자식에 위치한 Exception을 먼저 작성할 것..!
//			-> 왜냐면, try 블록에서 exception이 발생하면 
//			catch구문의 가장 윗부분부터 Exception 일치 여부를 검사하는데
//			부모타입의 Exception이 윗부분에 자리잡게 되면 해당 타입의 자식 Exception까지
//			모두 검출하게 됨
		}
	}
	
	
	public void method2() {
		System.out.println("BufferedReader를 이용하여 두 수 나누기");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			// 객체 생성을 try catch문 안에서 하는 이유 : 도구를 사용하는 것과 같으므로
			// 생성단계부터 try ~ catch 안에서 사용해주는 것이 좋음
			System.out.print("입력 1 : ");
			int num1 = Integer.parseInt(br.readLine()); // Integer wrapper class의 parseInt()사용
			
			if(num1 == 1) return;
			
			System.out.print("입력 2 : ");
			int num2 = Integer.parseInt(br.readLine());
			
			System.out.println("num1/num2 : " + num1/num2);
			// 여기서 보통 ArithmeticException이 발생할 수 있어서 if문으로 걸르지만 연습하기 위해서
		} catch (IOException e) {
			System.out.println("입력 중 예외 발생.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (NumberFormatException e) {
			System.out.println("정수만 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("예외 상황 발생.");
		} finally {
			// finally : Exception 발생 여부와 관계 없이 반드시 처리해야 하는 로직을 기술하는 부분

			
			// 사용 완료된 버퍼 반환
			try {
				System.out.println("BufferedReader 반환");
				br.close();
				System.out.println("프로그램 종료.");
			} catch (IOException e) {
				System.out.println("BufferedReader 반환 중 예외 발생");
			}
		}
		//System.out.println("프로그램 종료.");
		
	}
	
	public void method3() {
		// try ~ with ~ resource
		// try 구문 선언 시 매개변수로 try 내부에서 사용할 자원을 미리 함께 선언하여
		// try 구문 종료 시 자동으로 반환하게 하는 구문.
		
		
		System.out.println("BufferedReader를 이용하여 두 수 나누기");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){


			System.out.print("입력 1 : ");
			int num1 = Integer.parseInt(br.readLine());
			
			System.out.print("입력 2 : ");
			int num2 = Integer.parseInt(br.readLine());
			
			System.out.println("num1/num2 : " + num1/num2);

		} catch (IOException e) {
			System.out.println("입력 중 예외 발생.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (NumberFormatException e) {
			System.out.println("정수만 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("예외 상황 발생.");
		} finally {

			System.out.println("프로그램 종료.");
		}
	}

}
