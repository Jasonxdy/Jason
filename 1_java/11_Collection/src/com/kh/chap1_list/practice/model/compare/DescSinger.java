package com.kh.chap1_list.practice.model.compare;

import java.util.Comparator;

import com.kh.chap1_list.practice.model.vo.Music;

public class DescSinger implements Comparator<Music> {
	
	// Music�� ���ǵ� ������ �������� �̿��� ������ ���Ͽ� ������ Ŭ����
	
	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		//o1�� �������� �ؼ� o1�� o2���� ū�� ������ ��
		
		return -o1.getSinger().compareTo(o2.getSinger()); // ��� ���� ������ ��Ģ�� ���� -�� �ٿ��� ��������? ���� �ϴµ�...
		// o1�� �� ���������� ���̸� ����, o1�� ���������� �ڸ� ���, o1 == o2�̸� 0�� ��ȯ
	}

}
