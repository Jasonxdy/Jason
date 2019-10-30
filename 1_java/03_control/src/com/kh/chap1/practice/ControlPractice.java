package com.kh.chap1.practice;

import java.util.Scanner;

public class ControlPractice {
	
	public void practice1() {
		/*
		 * �Ʒ� ���ÿ� ���� �޴��� ����ϰ� �޴� ��ȣ�� ������ ��OO�޴��Դϴ١���,
���� ��ȣ�� ������ �����α׷��� ����˴ϴ�.���� ����ϼ���.
ex.
1. �Է�
2. ����
3. ��ȸ
4. ����
7. ����
�޴� ��ȣ�� �Է��ϼ��� : 3
��ȸ �޴��Դϴ�.
		 * 
		 * */
		Scanner sc = new Scanner (System.in);
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt();
		switch (num) {
		case 1 : System.out.println("�Է� �޴��Դϴ�"); break;
		case 2 : System.out.println("���� �޴��Դϴ�"); break;
		case 3 : System.out.println("��ȸ �޴��Դϴ�"); break;
		case 4 : System.out.println("���� �޴��Դϴ�"); break;
		case 7 : System.out.println("���α׷��� ����˴ϴ�"); break;
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	public void practice2() {
		/*
		 * Ű����� ������ �Է� ���� ������ ����̸鼭 ¦���� ���� ��¦���١��� ����ϰ�
¦���� �ƴϸ� ��Ȧ���١��� ����ϼ���.
����� �ƴϸ� ������� �Է����ּ���.���� ����ϼ���.
ex.
���ڸ� �� �� �Է��ϼ��� : -8
����� �Է����ּ���
*/
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num =sc.nextInt();
		if (num>0) {
			switch (num%2) {
			case 0 : System.out.println("¦����"); break;
			case 1 : System.out.println("Ȧ����"); break;
			}
		} else {
			System.out.println("����� �Է����ּ���.");
		}		
	}

	public void practice3() {
		/*
		 * ����, ����, ���� �� ������ ������ Ű����� �Է� �ް� �հ�� ����� ����ϰ�
�հ�� ����� �̿��Ͽ� �հ� / ���հ� ó���ϴ� ����� �����ϼ���.
(�հ� ���� : �� ������ ������ ���� 40�� �̻��̸鼭 ����� 60�� �̻��� ���)
�հ� ���� ��� ���� �� ������ �հ�, ���, �������մϴ�, �հ��Դϴ�!���� ����ϰ�
���հ��� ��쿡�� �����հ��Դϴ�.���� ����ϼ���.
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� : ");
		int lan = sc.nextInt();
		System.out.print("�������� : ");
		int mat = sc.nextInt();
		System.out.print("�������� : ");
		int eng = sc.nextInt();
		int tot = lan + mat + eng;
		double avg = tot/3;
		
		if (lan>=40&&mat>=40&&eng>=40&&avg>=60) {
			System.out.println("���� : " + lan);
			System.out.println("���� : " + mat);
			System.out.println("���� : " + eng);
			System.out.println("�հ� : " + tot);
			System.out.println("��� : " + avg);
			System.out.println("�����մϴ�, �հ��Դϴ�");
		} else {
			System.out.println("���հ��Դϴ�.");
		}
	}
	
	public void practice4() {
		/*
		 * ���� �ڷ�(7page)���� if������ �Ǿ��ִ� ��, ����, ����, �ܿ� ������ switch������ �ٲ㼭 ����ϼ���.
ex 1.
1~12 ������ ���� �Է� : 8
8���� �����Դϴ�.
ex 2.
1~12 ������ ���� �Է� : 99
99���� �߸� �Էµ� ���Դϴ�.
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 ������ ���� �Է� : ");
		int mth = sc.nextInt();
		switch(mth) {
		case 3: case 4 : case 5: System.out.println(mth+"���� ���Դϴ�"); break;
		case 6: case 7 : case 8: System.out.println(mth+"���� �����Դϴ�"); break;
		case 9: case 10 : case 11: System.out.println(mth+"���� �����Դϴ�"); break;
		case 12: case 1 : case 2: System.out.println(mth+"���� �ܿ��Դϴ�"); break;
		default : System.out.println(mth+"���� �߸� �Էµ� ���Դϴ�.");
		}	
	}
	
	public void practice5() {
		/*
		 * ���̵�, ��й�ȣ�� ���صΰ� �α��� ����� �ۼ��ϼ���.
�α��� ���� �� ���α��� ������,
���̵� Ʋ���� �� �����̵� Ʋ�Ƚ��ϴ�.��,
��й�ȣ�� Ʋ���� �� ����й�ȣ�� Ʋ�Ƚ��ϴ�.���� ����ϼ���.
		 * */
		Scanner sc = new Scanner(System.in);
		// ��Ʈ���� �������̹Ƿ� �񱳰� �Ұ����ϴ�!!
		/* ���ڿ�(String)������ �� �� ���
		 * 
		 * String �ڷ����� == (�񱳿�����)�δ� ���� ������ �� �Ұ�
		 * 
		 * ** equals()��� String ���� �޼ҵ带 ����ؾ� ��.
		 * 
		 * ex)
		 * String str = "abc";
		 * 
		 * str == "abc"  -> false (�� �Ұ�)
		 * 
		 * str.equals("abc")  -> true (�� ����)
		 * 
		 * 
		 * */
		
		System.out.print("���̵� : ");
		String inputId =sc.nextLine();	
		
		System.out.print("��й�ȣ : ");
		String inputPwd =sc.nextLine();
		
		/*
		if (inputId.equals("myId")&&inputPwd.equals("myPassword")==true) {
			System.out.println("�α��� ����");
		} else if (inputId.equals("myId")||inputPwd.equals("myPassword")==false) {
			System.out.println("���̵� �� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
		} else {
			if (inputId.equals("myId")==false) {
				System.out.println("���̵� Ʋ�Ƚ��ϴ�");
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
			}
			
		}
		*/
		
		switch (inputId) {
		case "myId" :
			switch(inputPwd) {
			case "myPassword" : System.out.println("�α��� ����"); break;
			default : System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			} break;
		default :
			switch(inputPwd) {
			case "myPassword" : System.out.println("���̵� Ʋ�Ƚ��ϴ�"); break;
			default : System.out.println("���̵� �� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		
		}
	}
	
	public void practice6() {
		/*
		 * ����ڿ��� ������, ȸ��, ��ȸ�� �� �ϳ��� �Է� �޾� �� ����� ���� �� �ִ� ������ ����ϼ���.
��, �����ڴ� ȸ������, �Խñ� ����, �Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ��� �����ϰ�
ȸ���� �Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ��� �����ϰ�
��ȸ���� �Խñ� ��ȸ�� �����մϴ�.
ex.
������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ������
ȸ������, �Խñ� ���� �Խñ� �ۼ�, ��� �ۼ� �Խñ� ��ȸ
		 * */
		Scanner sc = new Scanner (System.in);
		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		String grade = sc.nextLine();
		switch (grade) {
		case "������" : System.out.print("ȸ������, �Խñ� ����,");
		case "ȸ��" : System.out.print (" �Խñ� �ۼ�, ��� �ۼ�,");
		case "��ȸ��" : System.out.print (" �Խñ� ��ȸ"); break;
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}		
	}
	
	public void practice7() {
		/*
Ű, �����Ը� double�� �Է� �ް� BMI������ ����Ͽ� ��� ����� ����
��ü��/����ü��/��ü��/���� ����ϼ���.
BMI = ������ / (Ű(m) * Ű(m))
BMI�� 18.5�̸��� ��� ��ü�� / 18.5�̻� 23�̸��� ��� ����ü��
BMI�� 23�̻� 25�̸��� ��� ��ü�� / 25�̻� 30�̸��� ��� ��
BMI�� 30�̻��� ��� �� ��
ex.
Ű(m)�� �Է��� �ּ��� : 1.65
������(kg)�� �Է��� �ּ��� : 58.4
BMI ���� : 21.45087235996327
����ü��
*/
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();
		System.out.print("������ (kg)�� �Է��� �ּ��� : ");
		double weight = sc.nextDouble();
		double bmi = weight/(height*height);
		String result;
		if (30<=bmi) {
			result = "�� ��";
		} else if (25<=bmi) {
			result = "��";
		} else if (23<=bmi) {
			result = "��ü��";
		} else if (18.5<=bmi) {
			result = "���� ü��";
		} else {
			result = "��ü��";
		}
		
		System.out.println("BMI ���� : " + bmi);
		System.out.println(result);
		
	}
	
	public void practice8() {
		/*
		 * Ű����� �� ���� ������ ���� ��ȣ�� �Է� �޾� ���� ��ȣ�� ���� ���� ����� ����ϼ���.
(��, �� ���� ���� ��� ����� ���� �۵��ϸ� ���� ���� ��ȣ�� �Է� ���� ��
���߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.�� ���)
ex.
�ǿ�����1 �Է� : 15
�ǿ�����2 �Է� : 4
�����ڸ� �Է�(+,-,*,/,%) : /
15 / 4 = 3.750000
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		char op  = sc.nextLine().charAt(0);
		if (num1>0&&num2>0) {
			switch(op) {
			case '+' : System.out.println(num1 + " + " + num2 + " = " + num1+num2); break;
			case '-' : System.out.println(num1 + " - " + num2 + " = " + (num1-num2)); break;
			case '*' : System.out.println(num1 + " * " + num2 + " = " + num1*num2); break;
			case '/' : System.out.println(num1 + " / " + num2 + " = " + num1/num2); break;
			case '%' : System.out.println(num1 + " % " + num2 + " = " + num1%num2); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			}
			
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}
		
		/*
		if (num1>0&&num2>0&&((op=='+')||(op=='-')||(op=='*')||(op=='/')||(op=='%')) {
			
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.")
		}
		*/
		
		
	}
	
	public void practice9() {
	/*	�߰����, �⸻���, ��������, �⼮ȸ���� �Է��ϰ� Pass �Ǵ� Fail�� ����ϼ���.
		�� ������ �߰���� 20%, �⸻��� 30%, ���� 30%, �⼮ 20%�� �̷���� �ְ�
		�� ��, �⼮ ������ �⼮ ȸ���� �� ���� ȸ�� 20ȸ �߿��� �⼮�� ���� ���� ������ ����ϼ���.
		70�� �̻��� ��� Pass, 70�� �̸��̰ų� ��ü ���ǿ� 30% �̻� �Ἦ �� Fail�� ����ϼ���.
	*/
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰� ��� ���� : ");
		double mid = sc.nextInt()*0.2;
		System.out.print("�⸻ ��� ���� : ");
		double fin = sc.nextInt()*0.3;
		System.out.print("���� ���� : ");
		double hw = sc.nextInt()*0.3;
		System.out.print("�⼮ Ƚ�� : ");
		int atd = sc.nextInt();
		double atdp = atd;
		double sum = mid+fin+hw+atd;
		
		if (atd>14) { // �⼮�� ���� ������... �̷��� ���ϴ°� �Ƿ��ε��ϴ� (�� ���� ���ǹ����� �Ÿ���)
			if(sum>=70) {
				System.out.println("========= ��� =========");
				System.out.println("�߰� ��� ���� (20) : " + mid);
				System.out.println("�⸻ ��� ���� (30) : " + fin);
				System.out.println("���� ���� (30) : " + hw);
				System.out.println("�⼮ ���� (20) : " + atdp);
				System.out.println("���� : " + sum);
				System.out.println("PASS");
			} else {
				System.out.println("FAIL [���� �̴�]");
			}
		} else {
			System.out.println("FAIL [�⼮ ȸ�� ���� ("+atd+"/20)]");
		}
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		System.out.print("���� : ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1 : practice1(); break;
		case 2 : practice2(); break;
		case 3 : practice3(); break;
		case 4 : practice4(); break;
		case 5 : practice5(); break;
		case 6 : practice6(); break;
		case 7 : practice7(); break;
		case 8 : practice8(); break;
		case 9 : practice9(); break;
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	
	
	
	
	
	
}
