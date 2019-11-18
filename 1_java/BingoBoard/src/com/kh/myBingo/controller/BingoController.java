package com.kh.myBingo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BingoController {

	private Map<String, String> bingoBoard;
	private int bingoSize;
	public static int goal;
	
	public void setBingo(int bingoSize, int goal) {
		// �������� ������ ���ο� LinkedHashMap��ü ����
		bingoBoard = new LinkedHashMap<String, String>();
		
		this.bingoSize = bingoSize;
		this.goal = goal;
		
		createBingo();
		
	}
	
	public Map<String, String> getBingo() {
		return bingoBoard;
	}

	private void createBingo() {
		// bingoSize ��ŭ�� key ������ �� key�� �ش��ϴ� ��ü
		
		int random = 0;
		for (int i = 0; i < bingoSize * bingoSize;) {
			random = (int)(Math.random()*(bingoSize * bingoSize)+1);
			if(bingoBoard.put(""+random, ""+random) == null) {
				i++;
			}
		}
	}

	public int checkBingo(String input) {
		if(bingoBoard.containsKey(input)) {
			bingoBoard.replace(input, "X");
		}
		
		List<String> list = new ArrayList<String>(bingoBoard.values());
		boolean rowCheck = true;
		boolean colCheck = true;
		boolean diaCheck1 = true;
		boolean diaCheck2 = true;
		int bingoCount = 0;
		
		for (int i = 0; i < bingoSize; i++) {
			// ���� ���� üũ
			rowCheck = true;
			for (int j = i*bingoSize; j < (i+1)*bingoSize; j++) {
				if(!list.get(j).equals("X")) {
					rowCheck = false;
					break;
				}
			}
			if(rowCheck) bingoCount++;
			
			// ���� ���� üũ
			colCheck = true;
			if(!list.get(i*bingoSize).equals("X")) {
				colCheck = false;
			}
			if(colCheck) bingoCount++;
			
			for (int j = bingoSize*i + i; j < bingoSize; j++) {
				
			}
		}
		
		
		
		return bingoCount;
	}

}
