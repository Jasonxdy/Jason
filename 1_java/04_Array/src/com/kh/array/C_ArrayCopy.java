package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayCopy {
	
	// �迭 ����
	/*
	 * - ���� ���� : �迭�� �ּҸ��� ����
	 * 
	 * - ���� ���� : �����Ϸ��� �迭�� ������ ũ���� ���ο� �迭�� ����� ���� ���� ������ ��� �����ϴ� ��
	 * 
	 */
	
	public void method1() {
		
		int[] origin = { 1, 2, 3, 4, 5 };
		// ���� ���� : ���� ������
		int[] copyArr = origin;
		
		System.out.println("���� ��");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		System.out.println();
		System.out.println("origin�� hashCode : " + origin.hashCode());
		System.out.println("copyArr�� hashCode : " + copyArr.hashCode());
		System.out.println(copyArr);
		
		
		System.out.println();// �ٹٲ�
		
		System.out.println("���� ��");
		copyArr[0] = 99; // ���� ������ ������ �̿��Ͽ� 0�� �ε��� �� ����
		
		// origin(����) �������� ������ �ִ��� Ȯ��
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
	}
	
	public void method2() {
		int[] origin = { 1, 2, 3, 4, 5 };
		// ���� ���� : ���� ������
		// --> ���� ���縦 �ϱ� ���ؼ��� �ּ� ������ ���� ũ���� �迭�� �ʿ���
		int[] copyArr = new int[origin.length];
		for (int i = 0; i<copyArr.length;i++) {
			//���� �迭�� �����͸� ���� ������ �迭�� ����
			copyArr[i] = origin[i];
		}
		System.out.println("���� ��");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		System.out.println();
		System.out.println("origin�� hashCode : " + origin.hashCode());
		System.out.println("copyArr�� hashCode : " + copyArr.hashCode());
		System.out.println(copyArr);
		
		
		System.out.println();// �ٹٲ�
		
		System.out.println("���� ��");
		copyArr[0] = 99; // ���� ������ ������ �̿��Ͽ� 0�� �ε��� �� ����
		
		// origin(����) �������� ������ �ִ��� Ȯ��
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
	}
	
	public void method3() {
		
		// System Ŭ�������� �����ϴ� arraycopy() �޼ҵ带 ����Ͽ� ���� �����ϱ�
		int[] origin = {9,8,7,6,5};
		
		// ������ �迭 ���� �� �Ҵ�
		int[] copyArr = new int[origin.length];
		
		// System.arraycopy(�����迭��,�����迭�� ���簡 ���۵� �ε���,���纻 �迭��,���纻�� ���� �������� ���縦 ������ �ε���,�������� �����ؿ� ������ ����); --> �� 5���� ��
		System.arraycopy(origin, 0, copyArr, 0, origin.length);
		System.out.println(Arrays.toString(copyArr));
	}
	
	// �迭�� ũ�⸦ �Է¹޾� �ش� ũ�⸸ŭ�� �迭�� �����ϰ� �迭�� ũ�⸸ŭ ������ �Է¹޾� ������� ����.
	// ���������� ���� ������ �� �߰��� ���� �Է¹����� Ȯ�� ('y','n')
	// 'y' ���� �� ������ų ũ�⸦ �Է¹޾� ���� �迭�� ũ�⸦ ������Ű�� �þ ũ�⸸ŭ �߰��� ���� �Է¹ޱ�.
	// 'n' ���� �� �迭 ����� ��� �� ���
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ũ�� �Է� : ");
		int size = sc.nextInt(); // ���� �迭 ����
		int[] arr = new int[size]; 
		
		int i = 0; // �ʱ��
		while (true) {
			System.out.print(i + "��° �ε��� �� : ");
			arr[i] = sc.nextInt();
			sc.nextLine(); // ���ۿ� �����ִ� �ٹٲ� ���� ����

			if (i == arr.length - 1) {
				System.out.print("�߰��� ���� �Է��Ͻðڽ��ϱ�? (y/n)  : ");
				char yn = sc.nextLine().charAt(0);
				if (yn == 'n') { // ���Ḧ ���Ҷ�
					break;
				} else { // y�� �Էµ� ���
					System.out.println("������ų �迭�� ũ�� : ");
					int addSize = sc.nextInt();
					// �迭 ũ�� ���� --> ũ�Ⱑ ������ ���ο� �迭�� ����� ���� �迭�� �����͸� �������� ��,
					// ���� �迭�� ������ ������ ���ο� �迭�� �����ϵ��� �ּҰ��� ����!
					int[] addArr = new int[addSize + arr.length];
					// ���� �迭 ũ�� + �߰� ũ�⸸ŭ�� ���ο� �迭 ����
					System.arraycopy(arr, 0, addArr, 0, arr.length);
					arr = addArr; // addArr�� ������ ������ ���� ���� -> addArr�� ���� �ּҸ� �����ϰ� �ְԵȴ�
				}
			}
			i++; // ������
		}
		System.out.println(Arrays.toString(arr));
		
		//
		/*
		System.out.println("������ �Ϸ��Ͽ����ϴ�. �߰� �� �Է�? (y,n) :");
		char decision = sc.nextLine().charAt(0);
		*/
		
	}
	
	// �������� + ��������  �� ���� �迭�� �ø��� ����... �� �ٽ� ����
	
	
	
	
	
	
	

}
