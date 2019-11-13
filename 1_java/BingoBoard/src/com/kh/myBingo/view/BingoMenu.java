package com.kh.myBingo.view;

import java.util.Scanner;

import com.kh.myBingo.controller.BingoController;

public class BingoMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BingoController bc =  new BingoController();
	
	public void mainMenu() {
		int sel = 0;
		do {
			System.out.print("========== ���� ���� ==========\n" + 
					"1. ���� ����\n" + 
					"0. ����\n" + 
					"�޴� ���� : ");
			sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1 : initGame(); break;
			case 0 : System.out.print("������ �����մϴ�"); return;
			default : System.out.println("�ٽ� �Է����ּ���");
			}
			System.out.println();
		} while(sel != 0);
	}
	
	private void initGame() {
		// ���� ũ�� �Է�
		System.out.print("���� ũ�� �Է� (ex. 5X5 ���� --> 5) : ");
		int bingoSize = sc.nextInt();
		sc.nextLine();
		
		// ���� �¸� ���� �Է�
		System.out.print("�¸� ��ǥ (���� ����) : ");
		int goal = sc.nextInt();
		sc.nextLine();
		
		// ������ ����
		bc.setBingo(bingoSize, goal);
		
		// ������ ���
		printBingo(bc.getBingo());
		
		// ���� ���� �޼ҵ� ���
		startGame();
	}
}
