package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	/*
	-sc:Scanner = new Scanner(System.in)
	-cc:CircleController = new CircleController
	-rc:RectangleController = new
	RectangleController
	+ mainMenu() : void
	+ circleMenu() : void
	+ rectangleMenu():void
	+ calcCircum():void
	+ calcCircleArea():void
	+ calcPerimeter():void
	+ calcRectArea():void
	*/
	
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		
//		===== �޴� =====
//				1. ��  circleMenu()
//				2. �簢��  rectangleMenu()
//				9. ������
//				�޴� ��ȣ :
		
		//int sel = 0; // ��ȣ ���� ���� ����
		while(true)	{
			System.out.println("===== �޴� =====");
			System.out.println("1. ��");
			System.out.println("2. �簢��");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch (sel) {
			case 1 : circleMenu(); break;
			case 2 : rectangleMenu(); break;
			case 9 : System.out.println("���α׷��� �����մϴ�"); return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�"); continue;
			}
			break;
		}
	}
	
	public void circleMenu() {
		/*
		===== �� �޴� =====
		1. �� �ѷ�  calcCircum()
		2. �� ����  calcCircleArea()
		9. ��������
		�޴� ��ȣ :
		*/
		
		System.out.println("===== �� �޴� =====");
		System.out.println("1. �� �ѷ�");
		System.out.println("2. �� ����");
		System.out.println("3. ��������");
		System.out.print("�޴� ��ȣ : ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1:
			calcCircum();
			break;
		case 2:
			calcCircleArea();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	public void rectangleMenu() {
		/*
		===== �޴� =====
		1. �簢�� �ѷ�  calcPerimeter()
		2. �簢�� ����  calcRectArea()
		3. ��������
		�޴� ��ȣ :
		*/
		System.out.println("===== �簢�� �޴� =====");
		System.out.println("1. �簢�� �ѷ� ");
		System.out.println("2. �簢�� ����");
		System.out.println("3. ��������");
		System.out.print("�޴� ��ȣ : ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1:
			calcPerimeter();
			break;
		case 2:
			calcRectArea();
			break;
		case 3:
			mainMenu();
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	
	public void calcCircum(){
		/*
		x ��ǥ :
		y ��ǥ :
		������ :
		// �����͸� CircleController(cc)�� calcCircum()�� �Ű������� ���� ��ȯ �� ���
		*/
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int r = sc.nextInt();
		
		System.out.println(cc.calcCircum(x,y,r));
	}
	
	public void calcCircleArea() {
		
//		x ��ǥ :
//		y ��ǥ :
//		������ :
//		// �����͸� CircleController(cc)�� calcArea()�� �Ű������� ���� ��ȯ �� ���
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int r = sc.nextInt();
		
		System.out.println(cc.calcArea(x,y,r));
	}
	
	public void calcPerimeter() {
//		x ��ǥ :
//		y ��ǥ :
//		���� :
//		�ʺ� :
//		// �����͸� RectangleController(rc) calcPerimeter()�� �Ű������� ���� ��ȯ�� ���
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int h = sc.nextInt();
		System.out.print("�ʺ� : ");
		int w = sc.nextInt();
	
		System.out.println(rc.calcPerimeter(x,y,h,w));

	}
	
		public void calcRectArea() {
//		x ��ǥ :
//		y ��ǥ :
//		���� :
//		�ʺ� :
//		// �����͸� RectangleController(rc) calcArea()�� �Ű������� ���� ��ȯ�� ���
			System.out.print("x ��ǥ : ");
			int x = sc.nextInt();
			System.out.print("y ��ǥ : ");
			int y = sc.nextInt();
			System.out.print("���� : ");
			int h = sc.nextInt();
			System.out.print("�ʺ� : ");
			int w = sc.nextInt();
			
			System.out.println(rc.calcArea(x,y,h,w));
	
		
	}
	
	
	
	
	
	
	

}
