package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDAO {
	// DAO (Data Access Object) 
	// -> DBMS에 접속하여 실제 데이터를 전송하거나 결과 값을 전달 받는데 사용되는 클래스
	
	
	// 바이트 기반 스트림 : 1byte 단위로 데이터를 입력/출력하는 스트림

	// FileInputStream : 바이트 기반 파일 입력 스트림
	// -> 프로그램 외부 파일을 바이트 단위로 읽어들일 경우 사용
	public void fileOpen() {
		
		FileInputStream fis = null;
		// FileInputStream 객체 생성 시 바로 파일과 직접 연결이됨.
		// 만약 파일이 없다면 FileNotFoundException 발생
		
		// 그래서 try 구문으로 캐치해보자!
		
		try {
			fis = new FileInputStream("a_byte.txt");
			// 현재 프로그램의 외부에 있는 a_byte.txt 파일의 데이터를 읽어올 
			// FileInputStream 객체 생성 (일단 연결이 된 상태로 만듬)
			
			// InputStream.read()
			// 파일의 데이터를 1바이트 읽어와서 반환
			// 만약 더이상 읽어올 데이터가 없으면 -1을 반환
			/*
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			System.out.print(fis.read());
			*/
			
			// read() 메소드의 반환형은 int로 실제 저장된 값과 다르게 표시됨
			// --> char로 형변환 해주면 해결!
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
			// -> Hello World 출력
			
			// while문을 이용하여 read () 반환값이 -1인 경우까지 계속 읽어오기
			// --> file의 모든 내용을 읽어올 수 있음
			
			// read()로 읽어온 값을 임시 저장할 변수 value 선언
			int value = 0;
			
			while((value = fis.read()) != -1) {
				System.out.print((char)value);
			}
			
			// 한글이 깨지는 이유 - 한글은 2byte (유니코드)로 2byte가 한번에 해석되어야
			// 한글로 인식이 됨
			// - 바이트 기반 스트림은 1바이트 단위로 입출력을 하기 때문에
			// 2byte 한글 데이터에 손상이 발생됨.
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 사용한 스트림 자원 반환
			try {
				if(fis != null) {
					fis.close();
					System.out.println("FileInputStream 반환됨.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 프로그램 ---> 파일 (출력)
	public void fileSave() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("a_byte2.txt"/*, true*/);
			// 파일이 존재하지 않는 경우 자동으로 생성
			
			// 파일이 존재하는 경우 기존 파일을 덮어씀!
			// * 덮어 쓰지 않고 이어 쓰기 하는 방법
			// -> FileOutputStream 객체 생성 시 매개변수 마지막에 true 추가
			
			// OutputStream.write()
			// 프로그램에서 1바이트씩 외부로 출력
			// -> IOException을 발생시킬 가능성이 있음 -- '외부'로 출력하기 때문에
			
			fos.write('A');
			fos.write('B');
			fos.write(97); // 'a'
			fos.write('가');
			// 정수로 값을 출력해도 해당 번호와 일치하는 아스키코드표의 문자가 출력됨.
			
			fos.write('\n');
			
			// Hello World!! 한번에 출력하기
			String str = "Hello World!";
			for (int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
					System.out.println("FileOutputStream 반환 완료.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
