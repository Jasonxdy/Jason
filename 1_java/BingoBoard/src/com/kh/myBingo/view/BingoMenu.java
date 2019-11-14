package com.kh.myBingo.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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

	private void startGame() {
		// TODO Auto-generated method stub
		String input = null;
		while(true) {
			System.out.println();
			System.out.print("���ڸ� �Է��ϼ��� : ");
			input = sc.nextLine();
			int bingoCount = bc.checkBingo(input);
			for (int i = 0; i < 10; i++) System.out.println();
			printBingo(bc.getBingo());
			System.out.println();
			System.out.println("���� ���� �� : " + bingoCount);
			
			if(bingoCount == BingoController.goal) {
				System.out.println("BINGO!");
				break;
			}
		}
	}

	private void printBingo(Map<String, String> bingoBoard) {
		Set<String> bingoSet = bingoBoard.keySet();
		Iterator<String> it = bingoSet.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
