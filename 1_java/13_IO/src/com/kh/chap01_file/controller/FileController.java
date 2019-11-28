package com.kh.chap01_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	
	public void method1() {
		
		File f1 = new File("test.txt"); // �޸� �� �ϴ� �������� �����س��� ����
		try {
			// 1. ���� ������Ʈ�� test.txt ���� �����ϱ�
			f1.createNewFile(); 
			
			// 2. ������ �����ϴ� ������ ������ ����
			File f2 = new File("C:\\dev\\test.txt"); // �̶� \�� String���� �˰� 2�������
			f2.createNewFile();
			
			// 3. ������ ���� ������ ���� ����
			// File f3 = new File("C:\\dev\\temp\\test.text");
			// f3.createNewFile();
			// -> ���� ��ο��� ���� ���� �Ұ��� (IOException �߻�)
			
			// ���� ����
			File f3 = new File("c:\\dev\\temp");
			f3.mkdir(); // ���� ���� �޼ҵ�
			
			File f4 = new File("c:\\dev\\temp\\test.txt");
			f4.createNewFile();
			
			File f5 = new File("c:\\dev\\temp2\\test");
			f5.mkdirs(); // ��λ� ���� ��� ���� ����
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public void method2() {
		// c:\\dev\\temp3 ������ �ִ��� �˻� �� ������ �����ϰ�
		// temp3 ������ person.txt�� ����
		// --> ���� ���� �� ���� �޼��� ���
		
		File folder = new File("c:\\dev\\temp3");
		if(!folder.exists()) { // temp3 ������ �������� ������ 
			folder.mkdir(); // ���� ����
			System.out.println(folder.getName() + " ������ �����Ͽ����ϴ�.");
		}
		
		try {
			File file = new File("c:\\dev\\temp3\\person.txt");
			if(file.createNewFile()) { // person.txt ���� ���� ��
				System.out.println(file.getName() + " ������ �����Ͽ����ϴ�.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
