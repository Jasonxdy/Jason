package com.kh.chap2_ab_in.practice.model.vo;

public class V40 extends SmartPhone implements NotePen {
	
	public V40() {
		super.setMaker("LG");
	}
	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return "��ȣ�� ������ ��ȭ��ư�� ����";
	}
	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return "���� ��ư�� ����";
	}
	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return "1200, 1600�� Ʈ���� ī�޶�";
	}
	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return "��� ����, ��� ���� ����";
	}
	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return "������";
	}
	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String printInformation() {
		// TODO Auto-generated method stub
		return "V40�� "+ super.getMaker()+"���� ��������� ������ ������ ����.\r\n" + 
		makeCall()+ "\\n" + 
		takeCall()+ "\n" + 
		picture() + "\n" + 
		charge() + "\n" + 
		touch() + "\n" + 
		"������� �� ž�� ���� : " + bluetoothPen();
				
	}
}
