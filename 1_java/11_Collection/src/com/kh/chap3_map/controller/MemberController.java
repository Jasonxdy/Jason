package com.kh.chap3_map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap3_map.model.vo.Member;

public class MemberController {
	
//	- map:HashMap = new HashMap()
//			+ joinMembership(id:String, m:Member)
//			:boolean
//			+ logIn(id:String, password:String):String
//			+ changePassword(id:String, oldPw:String,
//			newPw:String):boolean
//			+ changeName(id:String,
//			newName:String):void
//			+ sameName(name:String) : Map

	
	private HashMap<String, Member> map = new HashMap<String, Member>();
	// HashMap ��ü ����
	
	public boolean joinMembership(String id, Member m){
	// ���� ���� id�� ���ٸ� id�� m�� map�� �߰� �� true ��ȯ
	// �ִٸ� false �� ��ȯ
		if(map.containsKey(id)) {
			// map�� key�� �� ���޹��� id�� ���ԵǾ� �ִٸ�
			return false;
		} else {
			map.put(id, m);
			return true;
		}
	}
	public String logIn(String id, String password){
	// ���� ���� id�� �����ϴ��� Ȯ�� �� �����ϸ� Member�� ����� ��й�ȣ��
	// ����ڰ� �Է��� ��й�ȣ�� ������ ��.
	// ���ٸ� ����� Member�� �̸� ��ȯ, �� �� ��� ��Ȳ���� null ��ȯ
		if(map.containsKey(id)) {
			if(map.get(id).getPassword().equals(password)) {
				return map.get(id).getName();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	public boolean changePassword(String id, String oldPw, String newPw){
	// ���̵� �����ϸ鼭 ����� ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ(oldPw)��
	// ���� �� ���ο� ��й�ȣ�� �ٲٰ� true ��ȯ, �ƴ϶�� false ��ȯ
		if(map.containsKey(id)) {
			if(map.get(id).getPassword().equals(oldPw)) {
				return map.replace(id, map.get(id), new Member(newPw, map.get(id).getName()));
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public void changeName(String id, String newName) {
	//���� ���� id�� ���� Member�� �̸��� ���� �Է��� �̸����� ����
		map.replace(id, new Member(map.get(id).getPassword(), newName));
	}
	public Map sameName(String name){
	// ���� ���� name�� ����� �������� �̸��� ������
	// HashMap ��ü�� �ش� id�� �̸� ���� �� ��ü ��ȯ
	// ��, ������Ʈ �ϳ��� �̾Ƴ��� �������� keySet()�� �� ��
		Set<String> set = map.keySet();
		for (String s : set) {
			if(map.get(s).getName().equals(name)){
				return map;
			} else {
				return null;
			}
		}
		return null; 
	} 
}
