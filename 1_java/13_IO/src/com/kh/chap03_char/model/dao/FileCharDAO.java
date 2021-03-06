package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDAO {
	
	// FileReader : 문자 기반 파일 입력 스트림
	// 프로그램 <--- 파일
	
	public void fileOpen() {
		FileReader fr = null;
		// FileReader 객체가 생성될 때 파일과 직접 연결됨
		// -> 연결될 파일이 없는 경우 FileNotFoundException 발생
		try {
			fr = new FileReader("a_byte.txt");
			
			int value = 0;
			
			// Reader.read()는 2바이트 문자 단위로 입력이 됨 (읽어옴)
			while ((value = fr.read()) != -1) {
				System.out.print((char)value);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public void fileSave() {
		
		// FileWriter : 문자 기반 파일 출력 스트림
		// 프로그램 --> 파일
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("b_char.txt" /* , true */);
											// 이어쓰기 옵션
			// 매개변수 파일이 존재하지 않으면 자동으로 파일 생성
			
			// Writer.write() : 2바이트 문자단위로 외부로 출력
			// -> IOException 발생 가능
			
//			fw.write('배');
//			fw.write('고');
//			fw.write('파');
			
			
			// Hello World! 출력하기
			fw.write("Hello World!\n");
			fw.write("이따가 JDBC 할꺼에요. ");
			fw.write("재밌겠죠??? ");
			fw.write("그렇다고 해용");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
