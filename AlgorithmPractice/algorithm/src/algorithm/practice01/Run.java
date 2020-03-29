package algorithm.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

	/*
	 * 1. �л��������� �����ϰ�, �л��̸����� �˻������� �й��� ����ϴ� ���α׷� �ۼ�.
	 * 
	 * - Student Ŭ���� ���� String name, no�� ���� (�̸��� �й�)
	 * 
	 * �л����� ArrayList�� ����1
	 * 
	 * �˻��� �ϰڴ��� y �����ϰ������ n
	 * 
	 * �л��̸����ִ°�� ���л��� �й��� ���� �л��̸��� ������, ���� �л��̸��̶�� ���
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("������"));
		list.add(new Student("��ȯ��"));
		list.add(new Student("����ȣ"));

		System.out.print("�˻��� �Ͻðڽ��ϱ�? (y/n) : ");
		char sel = sc.nextLine().charAt(0);

		if (sel == 'n') {
			System.out.println("���α׷��� �����մϴ�.");
		} else {
			System.out.print("�л��̸� �˻� : ");
			String name = sc.nextLine();

			boolean flag = true;

			for (Student student : list) {
				if (student.getName().equals(name)) {
					System.out.print("�ش� �л� �й� �Է� : ");
					int no = sc.nextInt();
					sc.nextLine();
					student.setNo(no);
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
			}

		}

	}

}
