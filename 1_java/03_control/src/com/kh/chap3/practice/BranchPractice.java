package com.kh.chap3.practice;

import java.util.Scanner;

public class BranchPractice {

	public void practice1() {

		/*
		 * ����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���. ��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�. ����
		 * 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡰�� ����ϼ���. 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ�
		 * �Է����ּ��䡱�� ��µǸ鼭 �ٽ� ����ڰ� ���� �Է��ϵ��� �ϼ���. ex. 1�̻��� ���ڸ� �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� :
		 * 0 1 2 3 4 1 �̻��� ���ڸ� �Է����ּ���. 1�̻��� ���ڸ� �Է��ϼ��� : 8 1 2 3 4 5 6 7 8
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int input = sc.nextInt();
			if (input < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է��ϼ���~~");
				continue;
			}
			for (int i = 0; i <= input; i++) {
				System.out.printf("%d ", i);
			}
			System.out.println();
			break; // while break
		}
	}

	public void practice2() {
		/*
		 * ����ڷκ��� �� ���� ���� �Է� �޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���. ��, �Է��� ���� 1���� ũ�ų� ���ƾ� �մϴ�.
		 * 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡱�� ��µǸ鼭 �ٽ� ����ڰ� ���� �Է��ϵ��� �ϼ���. ex. 1�̻��� ���ڸ�
		 * �Է��ϼ��� : 4 1�̻��� ���ڸ� �Է��ϼ��� : 0 4 3 2 1 1 �̻��� ���ڸ� �Է����ּ���. 1�̻��� ���ڸ� �Է��ϼ��� : 8 8 7
		 * 6 5 4 3 2 1
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int input = sc.nextInt();
			if (input < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է��ϼ���~~");
				continue;
			}
			for (int i = input; i >= 1; i--) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}

	}

	public void practice3() {

		/*
		 * ����ڷκ��� �� ���� ���� �Է� �޾� �� ������ ���ڸ� ��� ����ϼ���. ���� 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ�
		 * �Է����ּ��䡰�� ����ϼ���. 1 �̸��� ���ڰ� �Էµƴٸ� ��1 �̻��� ���ڸ� �Է����ּ��䡱�� ��µǸ鼭 �ٽ� ����ڰ� ���� �Է��ϵ���
		 * �ϼ���. ex. ù ��° ���� : 8 ù ��° ���� : 4 ù ��° ���� : 9 �� ��° ���� : 4 �� ��° ���� : 8 �� ��° ����
		 * : 0 4 5 6 7 8 4 5 6 7 8 1 �̻��� ���ڸ� �Է����ּ���. ù ��° ���� : 6 �� ��° ���� : 2 2 3 4 5 6
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("ù���� ���� : ");
			int num1 = sc.nextInt();
			System.out.print("�ι��� ���� : ");
			int num2 = sc.nextInt();
			if (num1 < 1 || num2 < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
				continue;
			}
			if (num1 > num2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			for (int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public void practice4() {
		/*
		 * ����ڷκ��� �Է� ���� ������ �ܺ��� 9�ܱ��� ����ϼ���. ��, 9�� �ʰ��ϴ� ���ڰ� ������ ��9 ������ ���ڸ� �Է����ּ��䡱��
		 * ����ϼ���. 9�� �ʰ��ϴ� ���ڰ� �Էµƴٸ� �� 9 ������ ���ڸ� �Է����ּ��䡱�� ��µǸ鼭 �ٽ� ����ڰ� ���� �Է��ϵ��� �ϼ���. ����
		 * : 4 ���� : 10 ===== 4�� ===== 9 ������ ���ڸ� �Է����ּ���. ===== 5�� ===== ���� : 8 ===== 6��
		 * ===== ===== 8�� ===== ===== 7�� ===== ===== 9�� ===== ===== 8�� ===== ===== 9��
		 * ===== (�ش� ���� ������� ���� �� ����)
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("���� : ");
			int input = sc.nextInt();
			if (input > 9) {
				System.out.println("9 ������ ���ڸ� �Է����ּ���~");
				continue;
			}
			for (int i = input; i <= 9; i++) {
				System.out.printf("=====%d��=====\n", i);
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d X %d = %2d\n", i, j, i * j);
				}
				System.out.println();
			}

		}

	}

	public void practice5() {
		/*
		 * ����ڷκ��� ���� ���ڿ� ������ �Է� �޾� ������ ������ ���ڰ� Ŀ���ų� �۾����� ���α׷��� �����ϼ���. ��, ��µǴ� ���ڴ� ��
		 * 10���Դϴ�. ���������� ���ڵ� ���̿��� ������ ������ ���� �����ϴ� ���� ���Ѵ�. ex) 2, 7, 12, 17, 22 �� 5 5 5 5
		 * => ���⼭ ������ 5 ex. ���� ���� : 4 ���� : 3 4 7 10 13 16 19 22 25 28 31
		 */

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("���� ���� : ");
			int sNum = sc.nextInt();
			System.out.print("���� : ");
			int dif = sc.nextInt();
			int count = 0;
			for (int i = sNum;; i += dif) {
				System.out.print(i + " ");
				count++;
				if (count == 10) {
					break;
				}
			}
			/*
			 * for (int i =sNum, count =0; count<=10; i+=num,count++){
			 * 	System.out.print(i + " ");
			 * }  -> �ڵ� ��ü�� ������ �ʹ� �������� �����Ƽ� �� �Ⱦ���.. for�� �ȿ����� ���� �ϳ� ���� �ϳ�
			 */
			System.out.println();
		}
	}

	public void practice6() {
		/*
		 * ���� ���� ȭ��ó�� �۾��� �����ϴ� ���α׷��� �����Ͻÿ�. [����ȭ��] ������(+, -, *, /, %) : + ����1 : 10 ����2 :
		 * 4 10 + 4 = 14 ������(+, -, *, /, %) : / ������(+, -, *, /, %) : / ����1 : 10 ����1 : 10
		 * ����2 : 4 ����2 : 0 10 / 4 = 2 0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���. ������(+, -, *, /, %) : ^
		 * ������(+, -, *, /, %) : exit ����1 : 10 ���α׷��� �����մϴ�. ����2 : 4 ���� �������Դϴ�. �ٽ� �Է����ּ���.
		 */

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("������(+, -, *, /, %) : ");
			String op = sc.nextLine();
			if (op.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			System.out.print("���� 1 : ");
			int num1 = sc.nextInt();
			System.out.print("���� 2 : ");
			int num2 = sc.nextInt();
			sc.nextLine(); // ���ۿ� �����ִ� �ٹٲ� ���� ��

			switch (op) {
			case "+": System.out.printf("%d + %d = %d", num1, num2, num1 + num2);break;
			case "-": System.out.printf("%d - %d = %d", num1, num2, num1 - num2);break;
			case "*": System.out.printf("%d * %d = %d", num1, num2, num1 * num2);break;
			case "/":
				if (num2 != 0)
					System.out.printf("%d / %d = %d", num1, num2, num1 / num2);
				else
					System.out.print("0���� ���� �� �����ϴ�."); break;
			case "%": System.out.print(num1 + " + " + num2 + " = " + num1 % num2);break;
			default: System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���."); continue;
			}
			System.out.println();
		}

	}
}
