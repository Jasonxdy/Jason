package com.kh.myBingo.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
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
		for (int i = 0; i < bingoSize * bingoSize; i++) {
			random = (int)(Math.random()*(bingoSize * bingoSize)+1);
			if(bingoBoard.put(""+random, ""+random) == null) {
				
			}
		}
		
	}

}
