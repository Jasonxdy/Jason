package com.kh.chap2_set.practice.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		<�ǽ�����>
//		Ŭ������ : com.kh.chap2_set.practice.run.Run.java >> main()�޼ҵ忡 ��� ����
//		1~45 ������ ���� 6���� �ߺ��� �����ʰ� ���� �� Iterator�� �̿��Ͽ� ���
//		����� ���� �ڵ� �������� ���ĵǰ� ó���ϴ� Set �迭 ��ü�� ���� �� ���� for���� �̿��Ͽ� ���

		Set<Integer> num = new HashSet<Integer>();
		while (num.size()!=6) {
			num.add(new Integer((int)((Math.random()*45+1))));
		}	
		Iterator<Integer> it = num.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println();
		
		List<Integer> list = new ArrayList<Integer>(num);
		Collections.sort(list);
		
		Set<Integer> lotto = new LinkedHashSet<Integer>();
		lotto.addAll(list);
		for (Integer integer : lotto) {
			System.out.print(integer + " ");
		}
		
	}

}
