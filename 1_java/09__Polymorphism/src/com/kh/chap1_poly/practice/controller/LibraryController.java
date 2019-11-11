package com.kh.chap1_poly.practice.controller;

import com.kh.chap1_poly.model.vo.Member;
import com.kh.chap1_poly.practice.model.vo.AniBook;
import com.kh.chap1_poly.practice.model.vo.Book;
import com.kh.chap1_poly.practice.model.vo.CookBook;

public class LibraryController {

//	- mem : Member // null�� ����ʱ�ȭ
//	- bList : Book[] // ũ�� 5 �Ҵ�
//	+ insertMember(mem:Member) : void
//	+ myInfo() : Member
//	+ selectAll() : Book[]
//	+ searchBook(keyword:String) : Book[]
//	+ rentBook(index:int) : int
	
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	{
		bList[0] = new CookBook("�������� ����", "������", "tvN", true);
		bList[1] = new AniBook("�ѹ� �� �ؿ�", "��Ƽ", "�����", 19);
		bList[2] = new AniBook("������ ���ǽ�", "����", "japan", 12);
		bList[3] = new CookBook("�������� �󸶳� ���ְԿ�", "������", "����", false);
		bList[4] = new CookBook("������ �� �����غ�", "������", "�ұ�å", true);
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return mem;
	}
	
	public Book[] selectAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		return null;
	}
	
	public int rentBook(int index) {
		return 0;
	}
	
}
