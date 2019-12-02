package com.kh.chap2.loop;

import java.util.Scanner;

public class A_For {
	
	// 1. For��(���� for��)
	/*
	 *  for (�ʱ��; ���ǽ�; ������) {
	 *  	����� ����;
	 *  }
	 *  
	 *  1ȸ�� (ó�� for���� ����Ǵ� ���)
	 *  �ʱ�� -> ���ǽ� Test -> (���ǽ��� T�� ���) ���� ���� ���� -> ������ ���� : 4�ܰ� ����
	 *  
	 *  2ȸ�� ����
	 *  ���ǽ� Test -> (���ǽ��� T�� ���) ���� ���� ���� -> ������ ���� : 3�ܰ� ����
	 * 
	 * */
	
	//~���� ~���� ~~~�ϱ� : ������ �ݺ��� (�̶� ������ ������ ���� ���� while���ٴ� for�� ����� ��)
	
	public void method1() {
		
		// 1���� 5���� 1�� �����ϸ� ����ϱ�
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		// 0���� 10���� 1�� ����
		System.out.println();
		System.out.println();
		System.out.println();
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(i+"��° �ݺ�");
		}
	}
	
	public void method2() {
		
		// 1���� 10 ������ Ȧ���� ���
		
		for(int i = 1; i<=10; i+=2) {
			System.out.print(i + " ");
		}	
	}
	
	public void method3() {
		
		// 10���� 1���� ¦�� ���
		
		for (int i = 10; 1<=i; i-=2) {
			System.out.print(i + " ");
		}	
	}
	
	public void method4() {
	
		// 2���� 9������ ������ �Է¹޾� �ش� ���� ������ ����ϱ�
		// ��, 2-9 ���� ���� �ƴϸ� "�߸� �Է��ϼ̽��ϴ�" ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �Է�(2~9) : ");
		int input = sc.nextInt();
		
		if (2<=input&&input<=9) {
			for (int i=1; i<=9; i++) {
				System.out.printf("%d X %d = %2d\n", input, i, input*i);
			}
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	public void method5() {
		
		// 1���� 10 ���� ������ �� 5���� �հ� ���ϱ�
		//		  (����==random)

		int sum = 0; // �հ踦 ������ ����

		for (int i = 1; i <= 5; i++) { //5ȸ �ݺ�
			int ran = (int)(Math.random()*10+1); // ��������
			// 0 <= math.random() < 1�� �Ǽ�  
			// 0 <= math.random()*10 < 10�� �Ǽ� (0~9.99)
			// 1 <= math.random()*10 + 1 < 11�� �Ǽ� (0~10.99) ==> 1,2,3,4,5,6,7,8,9,10
			System.out.println(ran);
			sum += ran;
		}
		System.out.println("������ �� : " + sum);
	}

	public void method6() {
		// Ű����� �� ���� �Է¹޾� ���� ������ ū �������� ��� ������ �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("ù���� ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι��� ���� : ");
		int num2 = sc.nextInt();
		int sum = 0;
		
		if (num1>num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;				
			}
		// ���� ��ȯ�ϴ� ��� (�߿�)		
		
		
		for(int i = num1; i<=num2; i++) {
			sum += i;
		}
		
		System.out.println("�� ���� " +sum+"�Դϴ�");
	
		
	}
	
	
	
	// ==========================================================================================================================================
	// 2. ��ø for ��
	
	
	public void method7() {
		// 1���� 5���� ��µǴ� ������ 5�� ����ϱ� 
		for (int i = 1; i<=5; i++) {
			for (int j = 1; j<=6; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void method8() {
		// 0�� 0�к��� 23�� 59�б��� ����ϱ�
		// ex) 0�� 0��
		//     0�� 1��...
		
		for (int hour = 0; hour<24; hour++) {
			for (int min = 0; min<60; min++) {
				//System.out.println(hour+"�� "+ min +"��");
				System.out.printf("%d�� %d��\n",hour,min);
			}
		}
		
	}
	
	public void method9() {
		//2�ܺ��� 9�ܱ��� ��� ���
		
		for (int i = 2; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.printf("%-1d X %1d = %2d  ", i, j, i*j);
			}
			System.out.println();
		}
	}
	
	public void method10() {
		
		// �Է��� �� ��ŭ ������ ����ϴµ� �� ����� '*' ǥ�ø� 5���� ����Ͻÿ�
		// ex)
		// �Է� : 3
		// *****
		// *****
		// *****
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է� : ");
		int input = sc.nextInt();
		
		for (int i = 1; i<=input;i++) {
			for (int j = 1; j<=5; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
	}

	public void method11() {
		
		// ������ �Է¹޾� �� �� ��ŭ '*'�� ����Ͽ� �簢�� ��� �����
		// ��, �� ���� ĭ ���� ��ġ�ϴ� �κ��� �ش� �� ��ȣ ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		int input = sc.nextInt();
		
		for (int i = 1; i<=input; i++) {
			for(int j = 1; j<=input; j++) {
				if (i==j) {
					System.out.print(i);
				} else {
					System.out.print('*');
				}	
			}
			System.out.println();
		}
		
	}

	public void method12() {
		
	}







}
