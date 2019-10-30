package com.kh.chap2.loop;

import java.util.Scanner;

public class B_While {
	
	//1. �ܵ� while��
	
	public void method1() {
		int i = 1; // �ʱ��
		while(i<=10) { // ���ǽ�
			System.out.printf("%2d ���\n",i);
			i++;// ������
		}
		
		for (int j=1; j<=10; j++) {
			System.out.printf("%2d ���\n",j);
		}
	}
	
	public void method2() {
		int i = 10;
		while (i>=1) {
			System.out.printf("%2d ���\n", i);
			i--;
		}
		
		for (int j=10; 1<=j;j--) {
			System.out.printf("%2d ���\n", j);
		}
	}
	
	public void method3() {
		
		// ���� 0�� �Էµ� ������ �Է¹��� ��� ���� ���Ͽ� ��� ��� --> �̷������� ���� ���Ǹ� �ƴ� ���
		
		Scanner sc = new Scanner(System.in);
		int input = -1; // �Է¹��� ������ ������ ���� : -1�� �ϴ� ���� 0�� ��� while�� ������ ����
		int sum = 0; // ������ ���� ������ ����
		
		while(input!=0) {
			System.out.print("�Է� : ");
			input = sc.nextInt(); // input�� -1�� �־��µ� �� �������� ���� input�� ����
			sum+=input; // �� �� �� �κ��� 0�� �Է� �ǰ� �ѹ� �� ����Ǵϱ� �ڵ������� ȿ�������� �ʴٴ°��� �˾Ƶ� ��
		}
		System.out.println("���� : " + sum);
	}
	
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		int input=0; //�Է°��� ������ ����
		int sum=0;//�������� ���� ������ ����
		boolean check = true; // �ݺ����� �ݺ� ���θ� ������ ���� ����!
		
		while(/*���ǽ� : ����� �����̶�� ��*/check) {
			System.out.print("�Է� : ");
			input = sc.nextInt();
			if (input==0) { // �Է°��� 0�̸�
				check = false; // �ݺ��� ���Ḧ ���� check ���� false�� ����
			} else {
				sum += input;
			}			
		}
		System.out.println("���� : " + sum);		
	}
	
	// ��ø while��
	// ���� ����!!
	// - while�� �ϳ� �����ε� ���� ������ ���ɼ��� �ٺ���
	// - while���� ��ø�ؼ� ����ϴ� ��� ���� ������ ���輺�� �þ
	// ---> ���� ������ Ȯ���� ��Ÿ�� �� �ִ� ��쿡�� ���
	
	public void method5() {
		// method3 do~while �������� ����
		
		Scanner sc = new Scanner (System.in);
		int input = -1;
		int sum = 0;
		
		do {
		System.out.print("�Է� : ");
		input = sc.nextInt(); // input�� -1�� �־��µ� �� �������� ���� input�� ����
		sum+=input;
		} while(input!=0); // do~while���� while�� ������ ������ �����ݷ� (;) �ݵ�� �߰�
	}
	
	public void method6() {
		// Ű����� �Է��� ���ڿ��� ��� �� �������� ����� ���
		// ��, exit �Է� �� ����
		
		Scanner sc = new Scanner(System.in);
		String str = null; // �Է�         cf> == String str = ""; (�� �� ����ִ� ���ڿ� ����� ���)
		String sum = ""; // ���� ����
		
		do {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
			if (!str.equals("exit")) {
			sum +=str;
			}
		} while(!str.equals("exit"));
		
		System.out.println(sum);
	}
	
	public void method7() {
		//do~while�� �̿��Ͽ� �޴�ȭ�� �����ϱ�
		Scanner sc = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("1. �޼ҵ�1 ����");
			System.out.println("2. �޼ҵ�2 ����");
			System.out.println("3. �޼ҵ�3 ����");
			System.out.println("4. �޼ҵ�4 ����");
			System.out.println("5. �޼ҵ�5 ����");
			System.out.println("6. �޼ҵ�6 ����");
			System.out.println("0. ����");
			System.out.print("�޴� ���� ==> ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 4: method4(); break;
			case 5: method5(); break;
			case 6: method6(); break;
			case 0: System.out.println("���α׷��� �����մϴ�"); break;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
			}
		} while (input!=0);
		
	}
		
}

