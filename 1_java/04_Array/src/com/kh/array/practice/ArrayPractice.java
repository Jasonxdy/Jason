package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	public void practice1() {
		/*
		���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ�
		������� �迭 �ε����� ���� �� �� ���� ����ϼ���.
		ex.
		1 2 3 4 5 6 7 8 9 10
		*/
		
		int[] arr = new int[10];
		for(int i=0; i<arr.length;i++) {
			arr[i] = i+1;
		}
		System.out.print(Arrays.toString(arr));
	}
	
	public void practice2() {
		/*
���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ�
�������� �迭 �ε����� ���� �� �� ���� ����ϼ���.
ex.
10 9 8 7 6 5 4 3 2 1
		 */
		
		
		int[] arr = new int[10];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = arr.length-i;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice3() {
		
		/*
����ڿ��� �Է� ���� ���� ������ŭ �迭 ũ�⸦ �Ҵ��ϰ�
1���� �Է� ���� ������ �迭�� �ʱ�ȭ�� �� ����ϼ���.
ex.
���� ���� : 5
1 2 3 4 5
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i =0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice4() {
		/*
���̰� 5�� String�迭�� �����ϰ� �������, ���֡�, ��������, �������ơ�, �����ܡ��� �ʱ�ȭ �� ��
�迭 �ε����� Ȱ���ؼ� ���� ����ϼ���.
ex.
��
		 */
		String[] arr = {"���","��","����","������","����"};
		System.out.println(arr[1]);
	}
	
	
	public void practice5() {
		/*
		���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭�� �ְ� �˻��� ���ڰ� ���ڿ��� �� �� �� �ִ���
		������ �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���.
		ex.
		���ڿ� : application
		���� : i
		application�� i�� �����ϴ� ��ġ(�ε���) : 4 8
		i ���� : 2
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		//charAt(index): ���ڿ��� �ش� index�� �ִ� ���� �ϳ��� ����
		
		//2. ����ڰ� �Է��� ���ڿ����� ���� �ϳ��ϳ��� char �迭�� �����ϱ�
		//2-1. ���ڿ��� ���̸�ŭ�� char �迭�� ���� �� �Ҵ�
		char[] arr= new char[str.length()];
		// ��Ʈ��.length() : �޼ҵ�
		// �׸� ���ø���!!
		
		//2-1. �ݺ����� ���� str.charAt(i)���� arr[i]�� ����
		for(int i = 0; i<arr.length;i++) { //�迭.length : ���� ���� (�޼ҵ�X)
			arr[i] = str.charAt(i);
		}
		
		//3. �˻��� ���ڰ� �迭 ���� ��� �ִ��� �˻� + �˻��� �ε��� ���
		
		int count = 0;
		// �ݺ��� ���� �� ���� ���
		System.out.print(str + "��" + ch + "�� �����ϴ� ��ġ (�ε���) : ");
		
		// �ݺ����� �̿��Ͽ� �迭�� �� ��ҿ� ����
		for (int i = 0; i<arr.length;i++) {
			if(arr[i]==ch) { // �ش� �ε����� ��Ұ� �˻��� ���ڿ� ���� ���
				System.out.print(i + " ");
				count++;
			}
		}
		
		System.out.println(); //�ٹٲ�
		
		// ��� ���
		System.out.println(ch + "���� : "+count);
		
		
	}

	public void practice6() {
		/*
		������ ~ ���ϡ����� �ʱ�ȭ�� ���ڿ� �迭�� ����� 0���� 6���� ���ڸ� �Է� �޾�
		�Է��� ���ڿ� ���� �ε����� �ִ� ������ ����ϰ�
		������ ���� ���ڸ� �Է� �� ���߸� �Է��ϼ̽��ϴ١��� ����ϼ���.
		ex.
		0 ~ 6 ���� ���� �Է� : 4 0 ~ 6 ���� ���� �Է� : 7
		�ݿ��� �߸� �Է��ϼ̽��ϴ�.
		*/
		Scanner sc = new Scanner(System.in);
		char[] arr = {'��','ȭ','��','��','��','��','��'};
		System.out.print("0~6 ���� ���� �Է� : ");
		int input = sc.nextInt();
		if (0<=input&&input<=6) {
			System.out.println(arr[input] + "����");
		} else {
			
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void practice7() {
		/*
		����ڰ� �迭�� ���̸� ���� �Է��Ͽ� �� ����ŭ ������ �迭�� ���� �� �Ҵ��ϰ�
		�迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է��Ͽ� ������ �ε����� ���� �ʱ�ȭ �ϼ���.
		�׸��� �迭 ��ü ���� �����ϰ� �� �ε����� ����� ������ ���� ����ϼ���.
		ex.
		���� : 5
		�迭 0��° �ε����� ���� �� : 4
		�迭 1��° �ε����� ���� �� : -4
		�迭 2��° �ε����� ���� �� : 3
		�迭 3��° �ε����� ���� �� : -3
		�迭 4��° �ε����� ���� �� : 2
		4 -4 3 -3 2
		�� �� : 2
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int count =0;
		for(int i=0; i<arr.length;i++) {
			System.out.print("�迭 "+i+"��° �ε����� ���� �� : ");
			arr[i] = sc.nextInt();
			count += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
	}

	public void practice8() {
		
		/*
		3�̻��� Ȧ�� �ڿ����� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
		�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
		��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
		�ٽ� ������ �޵��� �ϼ���.
		ex.
		���� : 4
		�ٽ� �Է��ϼ���.
		���� : -6
		�ٽ� �Է��ϼ���.
		���� : 5
		1, 2, 3, 2, 1
		*/
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("���� : ");
			int input = sc.nextInt();
			if (input % 2 == 1 && input >= 3) {
				// �Է¹��� ũ�⸸ŭ�� int�� �迭 ���� �� �Ҵ�
				int[] arr = new int[input];

				// �迭 ��ҿ� ������ ���� ���� ���� ����
				int value = 0;
				// �迭�� �߰������� value++, �迭 �߰� ���ĺ��ʹ� value--

				// �ݺ����� �̿��Ͽ� �迭 ��ҿ� �˸��� �� ����
				for (int i = 0; i < arr.length; i++) {
					if (i <= arr.length / 2) {
						value++;
					} else {
						value--;
					}
					// ���� �迭 ��ҿ� value ����
					arr[i] = value;
					System.out.print(arr[i] + " ");
				} // for end.
				break;
			} else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void practice9() {
		/*
		3�̻��� Ȧ�� �ڿ����� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
		�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
		��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
		�ٽ� ������ �޵��� �ϼ���.
		ex.
		���� : 4
		�ٽ� �Է��ϼ���.
		���� : -6
		�ٽ� �Է��ϼ���.
		���� : 5
		1, 2, 3, 2, 1
		*/
		
		Scanner sc = new Scanner(System.in);
		String[] chicken = {"���", "�Ķ��̵�", "����"};
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String search = sc.nextLine();
		boolean flag = true;
		for(int i =0; i<chicken.length; i++) {
			if(chicken[i].equals(search)) {
				System.out.println(search+"ġŲ ��� ����");
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println(search+"ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	public void practice10() {
		/*
		�ֹε�Ϲ�ȣ �����ڸ� ���ĺ��� *�� ������ ����ϼ���.
		��, ���� �迭 ���� ���� ���� �迭 ���纻���� �����ϼ���.
		ex.
		�ֹε�Ϲ�ȣ(-����) : 123456-1234567
		123456-1******
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String input = sc.nextLine();
		char[] pNum = new char[input.length()];
		for(int i=0;i<pNum.length;i++) {
			pNum[i] = input.charAt(i);		
		}
		char[] print = pNum;
		for(int i =0; i<print.length;i++) {
			if(i<8) {
				System.out.print(print[i]);
			} else {
				System.out.print("*");
			}
		}
	}
	
	public void practice11() {
		/*
		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
		1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ�� �� ����ϼ���.
		ex.
		9 7 6 2 5 10 7 2 9 6
		*/
		int[] arr = new int[10];
		for(int i =0; i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10+1);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice12() {
		/*
		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
		1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ ��
		�迭 ��ü ���� �� �� �߿��� �ִ밪�� �ּҰ��� ����ϼ���.
		ex.
		5 3 2 7 4 8 6 10 9 10
		�ִ밪 : 10
		�ּҰ� : 2
		*/
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
		}
		for(int i=1; i<arr.length;i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("�ִ밪 : " + arr[9]);
		System.out.println("�ּҰ� : " + arr[0]);
		
		
	}
	
	public void practice13() {
		
		/*
		10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
		1~10 ������ ������ �߻����� �ߺ��� ���� ���� �迭�� �ʱ�ȭ�� �� ����ϼ���.
		ex.
		4 1 3 6 9 5 8 10 7 2
		*/
		
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int j =0; j<i; j++) {
				if (arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	//13�� ���� Ʋ��
	
	public void practice14() {
		/*
		�ζ� ��ȣ �ڵ� ������ ���α׷��� �ۼ��ϴµ� �ߺ� �� ���� ������������ �����Ͽ� ����ϼ���.
		ex.
		3 4 15 17 28 40
		*/
		
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*45+1);
			for(int j=0; j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
				if(arr[j]>arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
// 14���� �ٽ� ���� (�������� ���� ����.. �����Ѱǵ� ��ư� ������)	
	
	public void practice15() {
		/*
		���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ������ �迭�� �����ϰ�
		������ ������ �Բ� ����ϼ���.
		ex.
		���ڿ� : application
		���ڿ��� �ִ� ���� : a, p, l, i, c, t, o, n
		���� ���� : 8
		*/
		// 1. ����ڿ��� ���ڿ� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		// 2. �Է¹��� ���ڿ��� char �迭�� ����
		char[] arr = new char[str.length()];
		for (int i = 0; i<arr.length;i++) {
			arr[i] = str.charAt(i);
		}
		System.out.print("���ڿ��� �ִ� ���� : ");
		
		// 3. �ݺ����� �̿��Ͽ� char �迭���� �ߺ����� �����ϴ� ��� ��� X
		
		// �� ���� ����
		int count = 0;
		for (int i = 0; i<arr.length; i++) {
			boolean flag = true; // ����� �ø��ų� �����ų� �ϴ� ���
			// �ߺ� üũ�� boolean
			
			for(int j = 0; j<i; j++) { // �� ��� ����
				if(arr[i]==arr[j]) {
					// ���ذ� �� ����� ���� ��� == �ߺ� �߻� ��
					flag = false;
					break;
				}
			}
			
			//�ߺ��� �߻����� ���� ��� ��� �� count ����
			if(flag) {
				if(i==0) {
					System.out.print(arr[i]);
				} else {
					System.out.print(", " + arr[i]);
				}
				count++;
			}
		}
		System.out.println();
		System.out.println("���� ���� : " + count);
	}
	
	public void practice16() {
		/*
		����ڰ� �Է��� �迭�� ���̸�ŭ�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
		�迭�� �ε����� ���� �� ���� ����ڰ� �Է��Ͽ� �ʱ�ȭ �ϼ���.
		��, ����ڿ��� �迭�� ���� �� ������ ����� �� ���� �� �Է��� ����,
		�ø� ���� � �����͸� ���� ������ ��������.
		����ڰ� �� �̻� �Է����� �ʰڴٰ� �ϸ� �迭 ��ü ���� ����ϼ���.
		�迭�� ũ�⸦ �Է��ϼ��� : 3
1��° ���ڿ� : �ڹ��� ����
2��° ���ڿ� : �˰���
3��° ���ڿ� : C���α׷���
�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : y
�� �Է��ϰ� ���� ���� : 2
4��° ���ڿ� : �ΰ�����
5��° ���ڿ� : �ڱ���
�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : y
�� �Է��ϰ� ���� ���� : 1
6��° ���ڿ� : ���ܾ�600
�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : n
[�ڹ��� ����, �˰���, C���α׷���, �ΰ�����, �ڱ���, ���ܾ�600]
		*/
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int input = sc.nextInt();
		sc.nextLine();
		String[] str = new String[input];
		for (int i = 0; i < str.length; i++) {
			System.out.print(i+"��° ���ڿ� : ");
			str[i] = sc.nextLine();
		}
		while(true) {
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�? (Y/N) : ");
			char choice = sc.nextLine().charAt(0);

			if (choice=='Y') {
				System.out.print("�� �Է��ϰ� ���� ���� : ");
				int add = sc.nextInt();
				sc.nextLine();
				String[] newArr = new String[str.length + add];

				for (int i = 0; i < newArr.length; i++) {
					if(i<str.length) {
						newArr[i] = str[i];
					} else {
						System.out.print(i+"��° ���ڿ� : ");
						newArr[i] = sc.nextLine();
					}
				}
				str = newArr;
			} else {
				break;
			}
		}
		
		System.out.println(Arrays.toString(str));
	}
	// �迭 ���簳��... �޸𸮰� �Ҵ������ �װ��� Ȯ���ϴ� ����� ������ �����Ͽ� �ű⿡ ���ο� ���� �߰��ϴ� ����...
	
	
	
}
