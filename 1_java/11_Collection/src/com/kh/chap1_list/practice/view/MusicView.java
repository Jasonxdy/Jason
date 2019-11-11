package com.kh.chap1_list.practice.view;

import java.util.Scanner;

import com.kh.chap1_list.practice.controller.MusicController;
import com.kh.chap1_list.practice.model.vo.Music;

public class MusicView {
	
//	- sc:Scanner = new Scanner(System.in)
//			- mc:MusicController = new MusicController();
//			+ mainMenu() : void
//			+ addList() : void
//			+ addAtZero() : void
//			+ printAll() : void
//			+ searchMusic() : void
//			+ removeMusic() : void
//			+ setMusic() : void
//			+ ascTitle() : void
//			+ descSinger() : void

	Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	// ��ĳ�� ��ü ����
	// MusicController ��ü ����
	public void mainMenu () {
//	******* ���� �޴� *******
//	1. ������ ��ġ�� �� �߰� // addList() ����
//	2. ù ��ġ�� �� �߰� // addAtZero()
//	3. ��ü �� ��� ��� // printAll()
//	4. Ư�� �� �˻� // searchMusic()
//	5. Ư�� �� ���� // removeMusic()
//	6. Ư�� �� ���� ���� // setMusic()
//	7. ��� �������� ���� // ascTitle()
//	8. ������ �������� ���� // descSinger()
//	9. ���� // �����ᡱ ��� �� main()���� ����
//	�޴� ��ȣ ���� : >> �Է� ����
//	// �޴� ȭ�� �ݺ� ���� ó��
		
		int sel = 0;
		
		do {
			System.out.println(
					"=====***** ���� �޴� *****=====\n" + 
					"1. ������ ��ġ�� �� �߰�\n" + 
					"2. ù ��ġ�� �� �߰�\n" + 
					"3. ��ü �� ��� ���\n" + 
					"4. Ư�� �� �˻�\n" + 
					"5. Ư�� �� ����\n" + 
					"6. Ư�� �� ����\n" + 
					"7. �� �� �������� ����\n" + 
					"8. ���� �� �������� ����\n" + 
					"9. ����\n");
			System.out.println();
			System.out.print("�޴� ��ȣ �Է� : ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1 : addList(); break;
			case 2 : addAtZero(); break;
			case 3 : printAll(); break;
			case 4 : searchMusic(); break;
			case 5 : removeMusic(); break;
			case 6 : setMusic(); break;
			case 7 : ascTitle(); break;
			case 8 : descSinger(); break;
			case 9 : System.out.println("���α׷� ����"); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
			}
			
		} while (sel != 9);
		
		
		
		
	}
	public void addList() {
//	****** ������ ��ġ�� �� �߰� ******
//	// �� ��� ���� ���� ����ڿ��� �Է� �޴´�.
//	// MusicController�� addList()�� �̿��ؼ� �Է��� ������ �ѱ��
//	// �߰� ���� �� ���߰� ������, �߰� ���� �� ���߰� ���С� �ܼ�â�� ���
		
		System.out.println("****** ������ ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		
		boolean result = mc.addList(new Music(title, singer));
		if(result) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
		
	}
	public void addAtZero() {
//	****** ù ��ġ�� �� �߰� ******
//	// �� ��� ���� ���� ����ڿ��� �Է� �޴´�.
//	// MusicController�� addAtZero()�� �̿��ؼ� �Է��� ������ �ѱ��
//	// �߰� ���� �� ���߰� ������, �߰� ���� �� ���߰� ���С� �ܼ� â�� ���
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		
		if(mc.addAtZero(new Music(title, singer))==1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
	}
	
	public void printAll() {
//		****** ��ü �� ��� ��� ******
//		// MusicController�� printAll()�� ���� ���� (������ 1�� �д�)
//		// ���� �� ����� ������, ���� �� ����� ���С� �ܼ� â�� ���
		
		System.out.println("****** ��ü �� ��� ��� ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
//		****** Ư�� �� �˻� ******
//		// ����ڿ��� �� �̸��� �ް� MusicController�� �ִ� searchMusic���� ���� �ѱ��.
//		// searchMusic()�� ��ȯ ���� ���� ��ȯ ���� ������ ���˻��� ���� �����ϴ�.��
//		// ��ȯ ���� ������ ���˻��� ���� 000(�� ��, ���� ��) �Դϴ�.�� �ܼ� â�� ���
		System.out.println("****** Ư�� �� �˻� ******");
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		if(mc.searchMusic(title)!=null) {
			System.out.println("�˻��� ���� ("+ mc.searchMusic(title).getTitle()+", "+ mc.searchMusic(title).getSinger()+")�Դϴ�");
		} else {
			System.out.println("�˻��� ���� �����ϴ�");
		}
		
	}

	public void removeMusic() {
//		****** Ư�� �� ���� ******
//		// ����ڿ��� ������ ���� �̸��� ���� �ް� MusicController�� removeMusic����
//		// ���� �ѱ��. removeMusic()�� ��ȯ ���� ���� ��ȯ ���� ������ �� ������ ���� �����ϴ�.��
//		// ��ȯ ���� ������ ��000(�� ��, ���� ��)�� ���� �߽��ϴ١� �ܼ� â�� ���
		
		System.out.println("****** Ư�� �� ���� ******");
		System.out.print("������ �� �� : ");
		String title = sc.nextLine();
		
		Music save = mc.removeMusic(title);
		
		if (save!=null) {
			System.out.println("("+save.getTitle()+", "+save.getSinger()+")�� �����߽��ϴ�.");
		} else {
			System.out.println(title + "��� ���� �����ϴ�");
		}
	}

	public void setMusic() {
//		****** Ư�� �� ���� ���� ******
//		// ����ڿ��� ������ ���� �Է� �Ͽ� MusicController�� setMusic���� �˻� �� �� �ְ�
//		// ���� �ѱ�� ������ �� ��� ���� ���� �޾� setMusic���� ���� �ѱ��.
//		// �˻� ��� ���� ������ �������� ���� �����ϴ�.��, �˻� ��� ���� �ְ�
//		// ���� ������ ��000(�� ��, ���� ��)�� ���� ���� �Ǿ����ϴ�.�� �ܼ� â�� ���
		System.out.println("****** Ư�� �� ���� ���� ******");
		System.out.print("�˻��� �� �� : ");
		String searchTitle = sc.nextLine();
		
		System.out.println("������ �� �� : ");
		String title = sc.nextLine();
		System.out.println("������ ������ : ");
		String singer = sc.nextLine();
		
		Music m = mc.setMusic(searchTitle, new Music(title,singer));
		
		if(m != null) {
			System.out.println(m + "�� ���� ����Ǿ����ϴ�");
		} else {
			System.out.println("������ ���� �����ϴ�.");
		}
		//if(mc.setMusic(title, music))
		
		
	}

	public void ascTitle() {
//		****** �� �� �������� ���� ******
//		// MusicController�� ascTitle()�� ���� ���� ���� �� ������ ������, ���� �� ������ ���С�
		if(mc.ascTitle()==1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

	public void descSinger() {
//		****** ���� �� �������� ���� ******
//		// musicController�� descSinger()�� ���� ���� ���� �� ������ ������, ���� �� ������ ���С�
		if (mc.descSinger()==1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

}
