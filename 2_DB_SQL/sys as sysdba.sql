select username from dba_users;

CREATE USER kh IDENTIFIED BY kh; /*kh��� ������ kh��� ��й�ȣ�� ����*/
GRANT RESOURCE, CONNECT TO kh; /*resource(��ü)�� ���� ����(role)�� �ο�*/
/*CONNECT : ���ѵ��� ���Ƽ� ��Ƴ���*/