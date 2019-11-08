package com.kh.chap2_set.part1.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.kh.chap2_set.part1.model.vo.Student;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set --> ���� ���� X, �ߺ� ���� X
		// index�� ���� �Ұ� (�Ϲ� for�� ��� �Ұ�)
		
		Set<String> testSet = new HashSet<String>(); // HashSet�� Set�� �ļ�Ŭ���� (������)
		
		testSet.add(new String("���� 30�� ��"));
		testSet.add(new String("�� ��÷� ������?"));
		testSet.add(new String("���� �ʹ� ����Ŀ�"));
		testSet.add(new String("�Ұ�� �԰�ʹ�."));
		
		System.out.println(testSet.toString());
		// ���� ���� X Ȯ��
		
		testSet.add(new String("���� 30�� ��"));
		System.out.println(testSet);
		// �ߺ� ���� Ȯ��
		// String�� �̹� hashCode(), equals()�� �������̵��� �Ǿ����� -> HashSet ���� �� �ߺ��� ���ŵ�
		
		//Set<Student> hs = new HashSet<Student>();
		Set<Student> hs = new LinkedHashSet<Student>();
		// ������ �����Ǵ� HashSet
		
		hs.add(new Student("������", 27, 100));
		hs.add(new Student("�����", 27, 80));
		hs.add(new Student("������", 30, 60));
		hs.add(new Student("������", 27, 100));
		
		System.out.println(hs);
		// 1) �������̵� �� --> �ߺ� ���Ű� ���� ����
		// 2) equals() �������̵� �� --> �ߺ����Ű� ���� ����
		// why? HashSet�� ���� hashCode()���� ���������� �Ǻ��� �ϱ� ������ equals() ����� true���� hashCode() ���� �ٸ��� ���� �ٸ� ��ü�� �ν���
		// 3) hashCode() �������̵�
		
		// Set�� ����� ��ü�� �ϳ��� �����ϴ� ���
		
		// 1. Set -> List�� ��� �� �� �����ϱ�
		List<Student> list = new ArrayList<Student>(hs);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=========================================");
		
		// 2. �ݺ��� Iterator ����Ͽ� ����
		Iterator<Student> it = hs.iterator();
		// �������� �����Ǿ� �ִ� HashSet�� iterator�� ����Ͽ� �ݺ��� �� �ִ� ���·� ���� �� it��� ������ ����
		
		while(it.hasNext()/*������ ������ �ֳ� ���� �Ǻ��ϴ� ���*/) {
			// Iterator���� ���� ����Ű�� �ִ� ��ġ ���� �κп� ���� ������� true, ������ false
			System.out.println(it.next()/*�������� ��������*/);
			//��, �������� �մ��� ���� ������ �������� �ݺ�
		}
		
		System.out.println("=========================================");
		
		// 3. ���� for�� (for-each��) --> �̰� �Ƹ� ���� ���� ����ҵ�..
		
		// for(������ : �迭 �Ǵ� Collection) {}
		// ---> �������� �迭 �Ǵ� Collection�� ��Ҹ� �ϳ��� ���������� �����ϴ� ������ �ݺ���
		for (Student s : hs) {
			// for�� �ѹ� �������� s�� �ϳ��� hs�� ������
			System.out.println(s);
		}
		
	}
}
