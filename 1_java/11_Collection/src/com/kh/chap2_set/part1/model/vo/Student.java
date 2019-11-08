package com.kh.chap2_set.part1.model.vo;

public class Student {
	
	private String name;
	private int age;
	private int score;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {  // equals�� object�� �޼ҵ�
//		// ��ü�� ������ �ִ� ���� �������� �Ǻ��ϴ� �޼ҵ�
//		if(!(obj instanceof Student)) {
//			return false;
//		} // Ÿ���� ���� ������� �񱳵� ���� ����
//		
//		// ���� Ÿ���� ��� ���� �� �ְ� obj�� Student Ÿ������ �ٿ�ĳ����
//		Student other = (Student)obj;
//		
//		if(!name.equals(other.name)) {
//			// name ���� ���� ���� ���
//			return false;
//		}
//		
//		if(age != other.age) {
//			return false;
//		}
//		
//		if(score != other.score) {
//			return false;
//		}
//		return true;
//	}
//	
//	@Override
//	public int hashCode() {
//		// ���� �ʵ尪�� ������ ������ ���� ������ ���� �� �ֵ��� �������̵�
//		
//		final int PRIME = 31; // prime : �Ҽ�
//		// 31�̶�� ���� �ؽ��ڵ�� ��ȯ �� �ߺ��� ���� �ּ�ȭ�ϸ鼭 ����ӵ��� ���� ����� ����
//		// 2 * 31 = 62 --> ��ǻ�ʹ� �̰� ��û �����ɸ���.. 2�� 31�� ����(���ϱⰡ ���)
//		// 2 << 5 - 2 = 62 2�� ���������� 5ĭ �������� �̵�... ���
//		
//		int result = 1;
//		result = PRIME * result + age;
//		result = PRIME * result + score;
//		result = PRIME * result + (name == null? 0 : name.hashCode()/*String�� �ؽ��ڵ�*/);
//		return result;
//	}
	
	
	
	
	
	
	
	

}
