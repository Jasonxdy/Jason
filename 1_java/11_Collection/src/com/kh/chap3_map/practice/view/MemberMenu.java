package com.kh.chap3_map.practice.view;

import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.controller.MemberController;
import com.kh.chap3_map.model.vo.Member;

public class MemberMenu {

//	- sc:Scanner = new Scanner(System.in)
//			- mc : MemberController
//			= new MemberController()
//			+ mainMenu() : void
//			+ memberMenu() : void
//			+ joinMembership() : void
//			+ logIn() : void
//			+ changePassword() : void
//			+ changeName() : void
//			+ sameName() : void
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
//		System.out.println("========== KH ����Ʈ ==========");
//		******* ���� �޴� *******
//		1. ȸ������ // joinMembership() ����
//		2. �α��� // logIn() ���� �� memberMenu() ����
//		3. ���� �̸� ȸ�� ã�� // sameName()
//		9. ���� // �����α׷� ����.�� ��� �� main()���� ����
//		�޴� ��ȣ ���� : >> �Է� ����
//		// �޴� ȭ�� �ݺ� ���� ó��
//		// �� �� �Է� �Ͽ��� ��� "�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���" ��� �� �ݺ�
		
		System.out.println("========== KH ����Ʈ ==========");
		int sel = 0;
		do {
			System.out.println(
					"=====***** ���� �޴� *****=====\r\n" + 
							"1. ȸ������\r\n" + 
							"2. �α���\r\n" + 
							"3. ���� �̸� ȸ�� ã��\r\n" + 
					"9. ����");
			System.out.println();
			System.out.print("�޴� ��ȣ �Է� : ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1 : joinMembership(); break;
			case 2 : logIn(); break;
			case 3 : sameName(); break;
			case 9 : System.out.println("���α׷� ����."); return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		} while (sel != 9);
	}
		public void memberMenu() {
//		******* ȸ�� �޴� *******
//		1. ��й�ȣ �ٲٱ� // changePassword() ����
//		2. �̸� �ٲٱ� // changeName()
//		3. �α׾ƿ� // ���α׾ƿ� �Ǿ����ϴ�.�� ��� �� mainMenu()�� ����
//		�޴� ��ȣ ���� : >> �Է� ����
//		// �޴� ȭ�� �ݺ� ���� ó��
//		// �� �� �Է� �Ͽ��� ��� "�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���" ��� �� �ݺ�
			int sel = 0;
			do {
				System.out.println(
						"=====***** ȸ�� �޴� *****=====\r\n" + 
								"1. ��й�ȣ �ٲٱ�\r\n" + 
								"2. �̸� �ٲٱ�\r\n" + 
						"3. �α׾ƿ�");
				System.out.print("�޴� ��ȣ ���� : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch (sel) {
				case 1 : changePassword(); break;
				case 2 : changeName(); break;
				case 3 : System.out.println("�α׾ƿ� �Ǿ����ϴ�."); break;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���"); continue;
				}
			} while(sel != 3);
			
			
		}
		public void joinMembership() {
//		ȸ�������ϱ� ���� ���̵�, ��й�ȣ, �̸��� �ް� ��й�ȣ�� �̸���
//		Member��ü�� ��� id�� ��ü�� MemberController�� joinMembership()�� ����.
//		���� ����� ���� true�� ������������ ȸ������ �Ϸ��Ͽ����ϴ�.��,
//		false�� ���ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.�� ���
			
			while(true) {
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				System.out.print("��й�ȣ : ");
				String password = sc.nextLine();
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				if(mc.joinMembership(id, new Member(password, name))) {
					System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�");
					break;
				} else {
					System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���");
				}
			}
		}
		
		
		public void logIn() {
//		���̵�� ��й�ȣ�� ����ڿ��� �޾� MemberController�� logIn()�޼ҵ�� �Ѱ� ��.
//		��ȯ �� ������ ��OOO��, ȯ���մϴ�!�� ��� �� �α��� �� ȭ������(memberMenu()),
//		������ ��Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
			
			while(true) {
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				System.out.print("��й�ȣ : ");
				String password = sc.nextLine();
				if(mc.logIn(id, password) != null) {
					System.out.println(mc.logIn(id, password) +"��, ȯ���մϴ�");
					memberMenu(); break;
				} else {
					System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
				}
			}
		}
		
		public void changePassword() {
//		���̵�� ��й�ȣ, ������ ��й�ȣ�� �޾� MemberController��
//		changePassword()�� ����.
//		���� ��� ���� true�� ����й�ȣ ���濡 �����߽��ϴ�.��,
//		false�� ����й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
			
			while(true) {
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				System.out.print("��й�ȣ : ");
				String oldPw = sc.nextLine();
				System.out.print("������ ��й�ȣ : ");
				String newPw = sc.nextLine();
				
				if(mc.changePassword(id, oldPw, newPw) == true) {
					System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
					break;
				} else {
					System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}
		}
		
		public void changeName() {
//		���̵�� ��й�ȣ�� �޾� MemberController�� logIn()���� �Ѱ�
//		���� ����Ǿ� �ִ� �̸��� �ް�
//		����ڿ��� ���� ����Ǿ� �ִ� �̸��� ����Ͽ� ������.
//		������ �̸��� �޾� MemberController�� chageName()�� id�� �Բ� �ѱ��
//		���̸� ���濡 �����Ͽ����ϴ�.�� ���
//		���� logIn()�κ��� ����Ǿ� �ִ� �̸��� ���� �� �ߴٸ�
//		���̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ��䡱 ��� �� �ݺ�
			while(true) {
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				System.out.print("��й�ȣ : ");
				String password = sc.nextLine();
				if(mc.logIn(id, password) != null) {
					System.out.println("���� ������ �̸� : " + mc.logIn(id, password));
					System.out.print("������ �̸� : ");
					String newName = sc.nextLine();
					mc.changeName(id, newName);
					break;
				} else {
					System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���");
				}
			}
		}
		public void sameName(){
//		�˻��� �̸��� �ް� mc�� sameName()�޼ҵ�� �ѱ�.
//		��ȯ ���� ������ entrySet()�� �̿��Ͽ� ���̸�-���̵� �������� ���
			while(true) {
				System.out.print("�˻��� �̸� : ");
				String name = sc.nextLine();
				
				if(mc.sameName(name) != null) {
					Set<Entry<String, Member>> entrySet = mc.sameName(name).entrySet();
					Iterator<Entry<String, Member>> it = entrySet.iterator();
					Entry<String, Member> entry = it.next();
					System.out.println(entry.getKey() + " - " +entry.getValue().getName());
					break;
				} else {
					System.out.println("�˻��Ͻ� �̸��� �����ϴ�.");
				}
			}
		}
	
	
}
