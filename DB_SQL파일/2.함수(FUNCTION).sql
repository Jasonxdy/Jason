-- �Լ�(FUNCTION)
-- �÷��� ���� �о ����� ����� ������

-- ������(SINGLE ROW) �Լ�
--> �÷��� ��ϵ� N���� ���� �о N���� ����� ���� (���� ��ŭ ��� �� ����)

-- �׷� (GROUP) �Լ�
--> �÷��� ��ϵ� N���� ���� �о 1���� ����� ����

------------------------------------------------------------------------------------
-- 1. ���� ���� �Լ�

-- LENGTH / LENGTHB (B: ����Ʈ)

SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL; -- DUAL : DUMMY TABLE (���� ���̺�) : DUMMY�� �׽�Ʈ, �����
-- ���� ��� : 3 �̶� 9 (���� �ϳ��ϳ��� 3����Ʈ�� �ν�.. �� ����(XE)�� �׷��ٴ� �� //������� �˾Ƶ� ��)
/*
����Ŭ EXPRESS EDITION (XE)�� �ѱ��� 3BYTE�� �ν�
2BYTE�� �νĽ�Ű�� ���� ��� ����Ǵ� �÷��� Ÿ���� NVARCHAR2�� ����
*/

-- EMPLOYEE ���̺��� ��� ����� �̸�, �̸���, �̸��� ����, �̸��� ����Ʈ ũ�� ��ȸ
SELECT EMP_NAME, EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;
-- ���� ��� : ���� ���� = ����Ʈ�� // �ֳĸ� ����� ���ڴ� 1BYTE�� ���.... �̷��� �ѱ۰� �ٸ�


-- INSTR
--> INSTR ('���ڿ�'|�÷���, '����', ã�� ��ġ�� ���۰�, [���� (������ ������ 1)])
SELECT INSTR('AABAACAABBAA', 'B', 1, 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1, 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1, 2) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 4, 2) FROM DUAL;

-----------------------------------------------------------------------------------------------

-- TRIM
-- �־��� �÷��̳� ���ڿ��� �� / �� / ���ʿ� �ִ� ������ ���� ����
-- ���ڸ� �������� ���� ��� ���� ��������
-- ������ ��ġ�� �������� ���� ��� ������ �⺻��
SELECT TRIM ('            �鵿��                ') FROM DUAL;

-- ���� ���� ����
SELECT TRIM ('Z' FROM 'ZZZKHZZZ') FROM DUAL;
-- SELECT TRIM (BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL; �̰͵� ����

-- ���� ���� ����
SELECT TRIM (LEADING 'Z' FROM 'ZZZKHZZZ') FROM DUAL; -- ó������ �ٸ� �� ���ö� ����

-- ���� ���� ����
SELECT TRIM (TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL; 

------------------------------------------------------------------------------------------------

-- ** SUBSTR
-- �÷��̳� ���ڿ����� ������ ��ġ���� ������ ������ ���ڿ��� �߶󳻾� ��ȯ
-- (�ڹٿ� String.subString()�� ������)
--> SUBSTR(STRING, POSITION, [LENGTH])
--> STRING : ���� Ÿ�� �÷� �Ǵ� ���ڿ�
--> POSITION : ���ڿ��� �߶� ��ġ, ����� ���۹������, ������ ������
----> LENGTH : ��ȯ�� ���� ���� (���� �� ������)
----> (���� �ۼ� �� NULL ����)
SELECT SUBSTR('SHOWMETHEMONEY', 1, 4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL; -- ME
SELECT SUBSTR('SHOWMETHEMONEY',7, 3) FROM DUAL; -- THE
SELECT SUBSTR('SHOWMETHEMONEY',-8, 3) FROM DUAL; -- THE / LENGTH�� ����̹Ƿ� ������ ����

-- EMPLOYEE ���̺��� EMP_NAME�� EMAIL @ ���ĸ� ������ ���̵� ��ȸ
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;