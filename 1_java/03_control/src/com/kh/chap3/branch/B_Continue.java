package com.kh.chap3.branch;

public class B_Continue {
	
	public void method1() {
		
		//1���� 100 ������ ���� �� 4�� ����� ������ ������ �� ���ϱ�
		
		int sum =0;
		
		for (int i=1; i<=100; i++) { //������ ������ �����Ƿ� while���ٴ� for�� ����ϴ� ���� ����
			if (i%4==0) {
				continue;
			}
			sum+=i;
		}
		System.out.println("���� : " + sum);
	}
	
	public void method2() {
		//2~9�� ������ �� Ȧ�� �ܸ� ����ϱ�
		
		for (int i=2; i<=9;i++) {
			 if (i%2==0) {
				 continue;
			 }
			 
			 System.out.printf("====%d��====\n",i);
			 for(int j=1; j<=9; j++) {
				 System.out.printf("%d X %d = %2d \t", i,j,i*j);
				 
			 }
			 System.out.println();
		}
	}

}
