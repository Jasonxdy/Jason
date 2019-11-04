package com.kh.chap1_poly.view;

import com.kh.chap1_poly.controller.ElectronicController;
import com.kh.chap1_poly.model.vo.Computer;
import com.kh.chap1_poly.model.vo.Tablet;

public class ElectronicView {
	
	public void display() {
		// 1. ElectronicController ��ü ����
		ElectronicController ec = new ElectronicController();
		
		// 2. ElectroniceController�� insert() �޼ҵ带 �̿��Ͽ� ������ǰ�� ��ü �迭�� �߰��ϱ�
		
		ec.insert(new Computer("�Ｚ", "�Ｚ��ǻ��", 2000000, "i9-9700X", "RTX2080")); // Heap������ ���� ������ Computer��ü (= Electronic ��ü�� �θ�� ����)�� �ּҰ��� �Ű������� �ȴ� --> elec[0] = �ּҰ��� �����
		ec.insert(new Tablet("�Ｚ", "��������S6", 1000000, true));
		ec.insert(new Tablet("����", "�����е�7����", 1200000, false));
		
		// 3. �ݺ����� �̿��Ͽ� ��ü�迭�� ����� ��ǰ ���� ��� ���
		
		for(int i =0; i<ElectronicController.elecIndex; i++) {
			System.out.println(ec.select(i)); // �̶� ���� toString�� �ƴ� inform �޼ҵ带 ��������� ec.select(i).inform�� �߾�� ������ toString�� �������⸸ �ϸ� �׳� ��ü �ּҸ� �ҷ����� ��ü ������ (?..��������...) ��ȯ��
			/*
			 ���� ���� up-casting�ε� toString�� �ڽ��� ���� ����� ���� : ���� ���ε� ���� (�ѹ� ���������� �����غ�)
			 ���� ���̳��ϸ�, �����ϴ�� vs ���α׷��� ����ɶ� �޼ҵ尡 �������̵��� �� �߿� ��� �������� �ؼ��ϴ� ���̷� �������ε�, �������ε� vs �������ε����� ������
			 System.out.println(ec.select(i).toString());�� �ϸ� .toString�� Electronic�� �޼ҵ����� �˰� ����. (���� ���ε�)
			 �׷��� ������ �׳� �����ϸ� ��ǻ�Ͱ� �����ϴٰ� �������̵��� Computer.toString()�� �߰��ϰ� �̰ɷ� �ٲ۴� (���� up-casting�Ǹ� �ڽİ�ü ���� �޼ҵ�� ������ �ʴ� �ݸ�, �̰� ����Ǿ���� ����)
			 �� ���� ���ε��� up-casting�� �̷���� ��쿡�� ����ٰ�....
			 */
			
			// 4. ���޹��� ��ü�� Ÿ���� Computer�̸� "ǰ��" �ƴϸ� "�Ǹ� ����" ���
			System.out.println(ec.sell(ec.select(i)));
		}
	}

}
