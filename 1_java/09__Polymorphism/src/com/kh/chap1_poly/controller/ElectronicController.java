package com.kh.chap1_poly.controller;

import com.kh.chap1_poly.model.vo.Computer;
import com.kh.chap1_poly.model.vo.Electronic;

public class ElectronicController {
	
	// �ʵ�
	// 1. �θ�Ÿ�� ��ü�迭�� ���� �� �Ҵ��Ͽ� �ڽ� ��ü���� �ϰ� ����
	private Electronic[] elec = new Electronic[3];
	
	// ��ü�迭�� ������ �߰� �� �ε����� ���� ���ִ� ���� ����
	public static int elecIndex = 0;
	
	
	// 2. ������ǰ ���
	// �ܺο��� ������ ��ü�� �ּҸ� ���޹޾� �ʵ忡 �ִ� ��ü�迭�� ������� �����ϴ� �޼ҵ� ����
	public void insert(Electronic el) {
		elec[elecIndex] = el;
		elecIndex++;
	}
	
	// 3. ������ǰ ���� ��ȸ
	// ���޹��� �ε����� �ش��ϴ� �迭 ����� ������ ���
	
	public Electronic select(int index) {
//  ����������	  ��ȯ�ڷ���	      �ڷ��
		return elec[index]; // elec[index] = ��ü �ּҸ� ��ȯ��
	}
	
	// 4. ��ǰ �Ǹ� ���ɿ��� üũ
	public String sell(Electronic e) {
		if(e instanceof Computer) {
			return "ǰ��";
		} else {
			return "�ǸŰ���";
		}
	}


}
