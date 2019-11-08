package com.kh.chap1_list.practice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kh.chap1_list.practice.model.compare.DescSinger;
import com.kh.chap1_list.practice.model.vo.Music;

public class MusicController {
	// ArrayList ��ü ����
	
//	- list : List = new ArrayList<Music>()
//			+ addList(music:Music):int
//			+ addAtZero(music:Music):int
//			+ printAll():int
//			+ searchMusic(title:String):Music
//			+ removeMusic(title:String):Music
//			+ setMusic(title:String, music:Music):Music
//			+ ascTitle():int
//			+ descSinger():int
	
	private List<Music> list = new ArrayList<Music>();
	Scanner sc = new Scanner(System.in);
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
	
	public boolean addList(Music music) {
	// ������ ����Ʈ�� ��ü ����, 1 ����
		return list.add(music);
	}
	
	public int addAtZero(Music music) {
	// ù ��° ����Ʈ�� ��ü ����, 1 ����
		list.add(0, music);

		// list ���ο� ���޹��� music ��ü�� ���ԵǾ� �ִ� ���
		if(list.contains(music)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<Music> printAll() {
	// ��� ��ü �ܼ� â�� ���, 1 ����
		return list;
	}
	
	public Music searchMusic(String title) {
	// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.get(i);
			} 			
		}
		return null;
	}
	
	public Music removeMusic(String title) {
	// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.remove(i);
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
	// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.set(i, music);
			}
		}
		return null;
	}
	
	public int ascTitle() {
	// ����Ʈ �� �� �������� ����, ������ ������ ���� ������ �������� ����, 1 ����
		try { // ����ó�� try - catch ���� (Ư���� ���ǹ����� ����)
			Collections.sort(list); // Collections�� �迭�� Arrays������->������ ��� ��Ƴ���
			return 1;
		} catch (Exception e) { // catch : �õ� �߿� ���� ��Ȳ�� �߻��ϴ� ��� catch�ϰڴ�
			return 0;
		}
	}
	
	public int descSinger() {
	// ����Ʈ ���� �� �������� ����, 1 ����
		try {
			Collections.sort(list, new DescSinger()); // 2��° ���� : Comparator<? super T> c) -> Comparator�� ��ӹ��� ��ü�� ����
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	

}
