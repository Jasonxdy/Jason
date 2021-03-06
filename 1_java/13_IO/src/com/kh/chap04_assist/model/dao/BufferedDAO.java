package com.kh.chap04_assist.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedDAO {
	// Buffered 보조 스트림
	// 입출력에 관련된 데이터를 버퍼에 담아 두었다가 한꺼번에 입/출력하여
	// 실행 성능을 향상 시킴
	// 	--> (입출력 회수 감소로 인한 작업 속도 향상)
	
	public void fileSave() {
		// BufferedWriter : 문자 기반 출력 보조 스트림
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			// BufferedWriter 생성 시 버퍼 크기를 지정하지 않으면
			// 8192byte의 크기로 초기화된다
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다.");
			bw.newLine(); // 출력시 줄바꿈 추가해주는 메소드
			
			bw.write("밥 먹고와서 보죠.\n");
			// --> bw.write()는 파일이 아닌 버퍼에 출력하고 있음
			// 작업이 완료되거나 버퍼가 가득 찼을 때 파일로 버퍼의 내용을 출력해야 함.
			// --> flush(), close()
			bw.flush(); // or close()
			// flush() : 버퍼의 데이터를 파일로 출력
			// close() : flush() + 자원 반환
			
			
		} catch (IOException e) {
			 e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyBoardInput() {
		/* 키보드 입력 동작 원리
		 * 
		 * 키보드 입력 	->	키보드 입력 버퍼 -> 자바프로그램	
		 * (바이트)			(바이트)		 -> (바이트)
		 * : 운영체제에서 해석하는것
		 * 									  ^
		 * 							   바이트 -> 문자 변환 보조스트림
		 */
		
		BufferedReader br = null;
		try {
			br = new BufferedReader /* 문자스트림 성능 향상 */
					(new InputStreamReader /* 바이트 -> 문자 */
							(System.in /* 바이트기반 (키보드) */));
			System.out.print("입력 : ");
			String str = br.readLine();
			// .readLine() : 줄바꿈 문자가 나오기 전까지 읽어들임
			System.out.println("입력된 값 : " + str);
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
