package com.kh.chap1_Object.model.vo;

public class Student extends Object { // extends Object�� ������ ��.. JVM�� �߰����ֳ�?
	
	// �ʵ�
	private String name;
	private String classRoom;
	private int age;
	private int point;
	
	// Ctrl + space + enter
	public Student() {}

	// Shift + Alt + S -> O
	public Student(String name, String classRoom, int age, int point) {
		super();
		this.name = name;
		this.classRoom = classRoom;
		this.age = age;
		this.point = point;
	}

	// �޼ҵ�
	// get/setter
	// Shift + Alt + S -> R
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom (String classRoom) {
		this.classRoom = classRoom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	// Object.toString()
	// ��ü�� ���� (�ʵ�)�� String ���·� ��ȯ�ϴ� �޼ҵ�
	// ��ü ���� ��� ������ �Ѵ��� �ľ��� �� �ֵ��� ���ڿ��� ��� ��ȯ�� �������� ���ǵ� �޼ҵ�
	// --> �̷��� �뵵�� ���ؼ� Object�� ������ �ϰ��ִ�.
	// --> �ʿ��� ���·� �������̵��Ͽ� ���.
	
	
	//Alt + Shift + S --> toString Generate ����ؼ� �� �����
	@Override
	public String toString() {
		return "Student [name=" + name + ", classRoom=" + classRoom + ", age=" + age + ", point=" + point + "]";
	}
	// �������̵����� �ʰ� �׳� ��ü ���� ��½� API�����ó�� ��ü�� ���������� ����
	
	
	// Object.equals() : ��ü�� ������ �ִ� '��'�� ������ �������� �Ǻ��ϴ� ���
	@Override
	public boolean equals(Object obj) { //Object�� ���� : ��� Ŭ������ object�� �ļ��̹Ƿ�, Ŭ������ �Ű����� ���� Object���ص� ��
		if(! (obj instanceof Student)) {
			// ���޹��� ��ü�� Student Ÿ���� ��ü���� �Ǵ� Student�� ��ӹ��� �ڽ� ��ü���� �˻�
			return false;
		}
		
		Student other = (Student)obj; // �ڽ� ��ü�� �ʵ带 ������ �� �ְ� Down-Casting����

		// ������ �ٸ��� ���ϴ� �˰��� --> ������ ���ϴ� �ͺ��� �ٸ��� �ϳ��� ���ִ°� �� ����
		if (!name.equals(other.name)) {  // �� equals�� String Ŭ������ �������̵��� equals
			return false;
		}
		if (!classRoom.equals(other.classRoom)) { 
			return false;
		}
		if (age!=other.age) {
			return false;
		}
		if (point!=other.point) {
			return false;
		}
		return true;
	}
	
	// VO Ŭ���� �ۼ� �� �� �ۼ��ؾ� �ϴ� ����
	// 1. �ʵ�
	// 2. ������
	// 3. getter()/setter()
	// 4. toString()
	// 5. equals()
	

}
