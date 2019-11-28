package com.kh.chap5_properties.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Run {
	public static void main(String[] args) {
			
		// properties : K,V ��� String Ÿ���� Map
		
		Properties prop = new Properties(); // ������ Ÿ������ String����
		HashMap<String, String> map  // �̰� Generic�� �Ϻη� String���� �ɾ��� HashMap
			= new HashMap<String, String>();
		
		//Properties�� ������ K, V�� String�̱� ������, ������ ���׸��� ����� Ÿ�� ������ �ʿ����.
		
		// setProperty(key, value) : �� �߰�
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		System.out.println(prop);
			
		// getProperty(key) : key�� �Է� �� value�� ���� (map������ get�� ��ü�� �������� �ݸ� ���̰� ����)
		System.out.println(prop.getProperty("List"));
		
		
		// store (OutputStream os, String Comments)
		// -> Properties ��ü�� ��� K,V ���� ���Ϸ� ���
		try {
			prop.store(new FileOutputStream("test.properties"), "collections");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// .store�� 2����(����Ʈ����(~~Stream)/���ڴ���(Reader/Writer)
		
			
			
	}

}
