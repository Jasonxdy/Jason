package com.kh.chap2_ab_in.practice.model.vo;

public class GalaxyNote9 extends SmartPhone implements NotePen {

//	+ GalaxyNote9()
//	+ makeCall() : String
//	+ takeCall() : String
//	+ picture() : String
//	+ charge() : String
//	+ touch() : String
//	+ bluetoothPen() : boolean
//	+ printInformation() : String
	
	public GalaxyNote9() {
		super.setMaker("�Ｚ");
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
			return "1300�� ��� ī�޶�";
		}
	@Override
		public String charge() {
			// TODO Auto-generated method stub
			return "��� ����, ��� ���� ����";
		}
	@Override
		public String touch() {
			// TODO Auto-generated method stub
			return "������, ������ ����";
		}
	@Override
		public boolean bluetoothPen() {
			// TODO Auto-generated method stub
			return true;
		}
	@Override
		public String printInformation() {
			// TODO Auto-generated method stub
			return "������ ��Ʈ9�� "+ super.getMaker()+"���� ��������� ������ ������ ����.\r\n" + 
					makeCall()+ "\\n" + 
					takeCall()+ "\n" + 
					picture() + "\n" + 
					charge() + "\n" + 
					touch() + "\n" + 
					"������� �� ž�� ���� : " + bluetoothPen();
		}
}
