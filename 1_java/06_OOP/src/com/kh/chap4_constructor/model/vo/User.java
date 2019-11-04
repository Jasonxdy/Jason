package com.kh.chap4_constructor.model.vo;

public class User {
	
	//�ʵ�
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;
	
	// ������
	/*
	 * �����ڸ� ����ϴ� ����
	 * 1. ��ü�� �������ֱ� ���� ����
	 * 2. �Ű������� ���޹��� ���� �ʵ忡 �ʱ�ȭ�� ����
	 *  
	 * ������ ��� �� ���ǻ���
	 * 1. �����ڸ��� �ݵ�� Ŭ������� ���ƾ� �Ѵ�.
	 * 2. ��ȯ���� �������� �ʴ´�. (ex: void������ ���)
	 * 3. �Ű����� �ִ� ������ �ۼ� �� �⺻ �����ڸ� �ݵ�� �ۼ��ؾ� �Ѵ�.
	 * 	--> JVM�� �⺻ �����ڸ� �ڵ� �������� ���ϱ� ����
	 */
	
	// �⺻ ������ : �Ű������� ���� ������
	/*
	public User() {
		// ���� ��ü�� ������ �� �� ���
		// �� �ʱ�ȭ ���� Ʋ�� �����δ� ��
		
		// ���� Ŭ���� ���ο� �ƹ� �����ڵ� �ۼ����� �ʾҴٸ� JVM�� �ڵ����� ������ �ڵ忡 ��������
		System.out.println("User ��ü�� ������");
	}
	*/
	
	
	// �Ű����� �ִ� ������
	// ��ü ������ ���ÿ� �Ű������� ���޵� ������ �ش� ��������� �ʱ�ȭ�ϴ� �������� ���

	public User(String userId, String userPwd, String userName) {
		// �Ű������� ������ �ٸ��Ƿ� �����ε� ����
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	/*
	public User(String userId, String userPwd, int age) {
		// �Ű������� ������ 3���� ������ ������ �Ű������� �ڷ����� �ٸ��Ƿ� �����ε� ����
		this.userId = userId;
		this.userPwd = userPwd;
		this.age = age;
	}
	
	public User(int age, String userId, String userPwd) {
		// �Ű������� ����, �ڷ����� ��� ������ ������ �ٸ� ��� �����ε� ����
		
	}
	*/
	
	public User(String userId, String userPwd, String userName, int age, char gender) {
		/*
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		*/
		
		// this ������
		// �ݵ�� ù��° �ٿ� �ۼ�!
		
		this(userId, userPwd, userName);
		this.age = age;
		this.gender = gender;
		System.out.println("�Ű����� �ִ� �����ڷ� ��ü ����");
	}
	
	
	
	// �����ε�(Over Loading)
	// �� Ŭ���� ������ ������ �̸��� �޼ҵ带 ������ �ۼ��ϴ� ���
	// (�����ڴ� ��ü�� ������ �� ���Ǵ� Ư���� �޼ҵ��̱� ������ �����ε� ����)

	// �����ε� ����
	// 1) �޼ҵ���� �����ؾ� ��
	// 2) ��, �Ű������� �޶����
	// - �Ű������� ����
	// - �ٸ� �ڷ���
	// - �Ű������� ����
	// * ��, �Ű��������� �����ε� �������ǰ� ���� ����. (�Ű��������� ������ �޶� ���� �ڷ����̸� �ȵȴ� -> �ڷ����� ������ �޶����)

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}
	
	
	// ���� ��ü�� �������ִ� ��� �ʵ��� ������ ��ȯ�ϴ� �޼ҵ� (���)
	public String inform() {
		return userId + ", " + userPwd + ", " + userName + ", " + age + ", " + gender;
	}
	
}
