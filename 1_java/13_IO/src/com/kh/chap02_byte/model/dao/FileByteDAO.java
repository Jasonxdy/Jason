package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDAO {
	// DAO (Data Access Object) 
	// -> DBMS�� �����Ͽ� ���� �����͸� �����ϰų� ��� ���� ���� �޴µ� ���Ǵ� Ŭ����
	
	
	// ����Ʈ ��� ��Ʈ�� : 1byte ������ �����͸� �Է�/����ϴ� ��Ʈ��

	// FileInputStream : ����Ʈ ��� ���� �Է� ��Ʈ��
	// -> ���α׷� �ܺ� ������ ����Ʈ ������ �о���� ��� ���
	public void fileOpen() {
		
		FileInputStream fis = null;
		// FileInputStream ��ü ���� �� �ٷ� ���ϰ� ���� �����̵�.
		// ���� ������ ���ٸ� FileNotFoundException �߻�
		
		// �׷��� try �������� ĳġ�غ���!
		
		try {
			fis = new FileInputStream("a_byte.txt");
			// ���� ���α׷��� �ܺο� �ִ� a_byte.txt ������ �����͸� �о�� 
			// FileInputStream ��ü ���� (�ϴ� ������ �� ���·� ����)
			
			// InputStream.read()
			// ������ �����͸� 1����Ʈ �о�ͼ� ��ȯ
			// ���� ���̻� �о�� �����Ͱ� ������ -1�� ��ȯ
			/*
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			*/
			
			// read() �޼ҵ��� ��ȯ���� int�� ���� ����� ���� �ٸ��� ǥ�õ�
			// --> char�� ����ȯ ���ָ� �ذ�!
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
			// -> Hello World ���
			
			// while���� �̿��Ͽ� read () ��ȯ���� -1�� ������ ��� �о����
			// --> file�� ��� ������ �о�� �� ����
			
			// read()�� �о�� ���� �ӽ� ������ ���� value ����
			int value = 0;
			
			while((value = fis.read()) != -1) {
				System.out.print((char)value);
			}
			
			// �ѱ��� ������ ���� - �ѱ��� 2byte (�����ڵ�)�� 2byte�� �ѹ��� �ؼ��Ǿ��
			// �ѱ۷� �ν��� ��
			// - ����Ʈ ��� ��Ʈ���� 1����Ʈ ������ ������� �ϱ� ������
			// 2byte �ѱ� �����Ϳ� �ջ��� �߻���.
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� ����");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ����� ��Ʈ�� �ڿ� ��ȯ
			try {
				if(fis != null) {
					fis.close();
					System.out.println("FileInputStream ��ȯ��.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// ���α׷� ---> ���� (���)
	public void fileSave() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("a_byte2.txt"/*, true*/);
			// ������ �������� �ʴ� ��� �ڵ����� ����
			
			// ������ �����ϴ� ��� ���� ������ ���!
			// * ���� ���� �ʰ� �̾� ���� �ϴ� ���
			// -> FileOutputStream ��ü ���� �� �Ű����� �������� true �߰�
			
			// OutputStream.write()
			// ���α׷����� 1����Ʈ�� �ܺη� ���
			// -> IOException�� �߻���ų ���ɼ��� ���� -- '�ܺ�'�� ����ϱ� ������
			
			fos.write('A');
			fos.write('B');
			fos.write(97); // 'a'
			fos.write('��');
			// ������ ���� ����ص� �ش� ��ȣ�� ��ġ�ϴ� �ƽ�Ű�ڵ�ǥ�� ���ڰ� ��µ�.
			
			fos.write('\n');
			
			// Hello World!! �ѹ��� ����ϱ�
			String str = "Hello World!";
			for (int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� ����");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
					System.out.println("FileOutputStream ��ȯ �Ϸ�.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}