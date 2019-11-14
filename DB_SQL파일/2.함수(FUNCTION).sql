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
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR (EMAIL,'@')-1)
FROM EMPLOYEE;

----------------------------------------------------------------------------------------------------------

-- REPLACE
-- �÷��� ���� �Ǵ� ���������� Ư�� ����(��)�� ������ ����(��)�� ��ȯ �� ��ȯ
--> REPLACE(STRING, ��ȯ�� ����(��), ��ȯ �� ����(��))
SELECT REPLACE  ('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��')
FROM DUAL;

SELECT EMAIL, REPLACE(EMAIL,'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

------------------------------------------------------------------------------------------------------------

-- ROUND : �ݿø�
--> ROUND(���� | ���ڷε� �÷� [, ��ġ])   // ��ġ : �Ҽ��� ��°�ڸ����� �ݿø� �� ��
SELECT ROUND(123.456) FROM DUAL; -- �Ҽ��� �ݿø�
SELECT ROUND(123.678) FROM DUAL;
-- �ݿø��Ͽ� �Ҽ��� ù°�ڸ� ���� ��ȸ
SELECT ROUND(123.456, 1) FROM DUAL; -- 123.5

SELECT ROUND(123.456, 2) FROM DUAL; -- 123.46

SELECT ROUND(123.456, -2) FROM DUAL; -- 100

---------------------------------------------------------------------------------------------------------------

-- EXTRACT : ��, ��, �� ������ �����Ͽ� ��ȯ
-- EXTRACT (YEAR FROM ��¥Ÿ��) : �⵵ ��ȯ
-- EXTRACT (MONTH FROM ��¥Ÿ��) : �� ��ȯ
-- EXTRACT (DAY FROM ��¥Ÿ��) : �� ��ȯ

-- EMPLOYEE ���̺��� ��� ����� �̸�, �Ի� �⵵, �Ի� ��, �Ի� �� ��ȸ
SELECT EMP_NAME,
EXTRACT(YEAR FROM HIRE_DATE) "�Ի� �⵵",
EXTRACT(MONTH FROM HIRE_DATE) "�Ի� ��",
EXTRACT(DAY FROM HIRE_DATE) "�Ի� ��"
FROM EMPLOYEE;

---------------------------------------------------------------------------------------------------------------

------------- �ǽ�����----------------------------
-- 1. EMPLOYEE ���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ
-- ��, ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ϰ�
-- ��� ����ó��, ����� �ǵ��� ó��
SELECT EMP_NAME, FLOOR(ABS(HIRE_DATE-SYSDATE)) AS �ٹ��ϼ�1, FLOOR(SYSDATE-HIRE_DATE) AS �ٹ��ϼ�2
FROM EMPLOYEE;
-- �̶� FLOOR�� ABS �ڸ��� �ٲ�� �ȵ�... �������� �����°Ŷ� ������� �����°� �ٸ�

-- 2. EMPLOYEE ���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT
    *
FROM EMPLOYEE
-- WHERE MOD(EMP_ID, 2) = 1; -- �ڹٿʹ� �޸� ����Ŭ�� �˾Ƽ� ����ȯ�� �ؼ� �ۿ����ְ�, �ȵǸ� ������ (�ڵ����� ����ȯ ����)
-- �� ,��Ģ�����δ� ����ȯ�� ���� Ÿ���� �����ִ� ���� ���� (�ڵ� ����ȯ�� �۵��� ���� �ɸ��Ƿ�...)
WHERE MOD(TO_NUMBER(EMP_ID), 2) = 1;

-- 3. EMPLOYEE ���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
SELECT
    *
FROM EMPLOYEE
--WHERE (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE))  >= 20;
--WHERE MONTHS_BETWEEN (SYSDATE, HIRE_DATE) >= 240;
WHERE ADD_MONTHS(HIRE_DATE, 240) < SYSDATE;
-- 240������ ���Ѱ� ���� ��¥���� ������ 20�� �̻���

-- 4. EMPLOYEE ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ��� ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE AS "�Ի��� ���� �ٹ��ϼ�"
-- ���������δ� EXTRACT�ؼ� �ϼ� �̾Ƴ��� �� ����
FROM EMPLOYEE;

-- ��¥ ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
-- R : 2000�� ���ķ� �ν�
-- Y : 0�� ���ķ� �ν�

------------------------------------------------------------------------------------------------------------------------------

-- 4. ����ȯ �Լ�
-- TO_CHAR(��¥ | ���� [,����])
--> ��¥ �Ǵ� ������ �����͸� ������ �����ͷ� ����
---> ������ �����Ǿ� ������ �ش� ���� ���·� ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') FROM DUAL;
--> 5ĭ�� ���� �� ������ ����, ��ĭ�� �������� ä��

SELECT TO_CHAR(1234, '00000') FROM DUAL;
--> 5ĭ�� ���� �� ������ ����, ��ĭ�� 0���� ä��

SELECT TO_CHAR(1234, 'L99999') FROM DUAL;
--> ���� ������ ������ ȭ�� ���� ��ȯ (L)

SELECT TO_CHAR(1234, '$99999') FROM DUAL;
--> �޷��� �׳� �Է�

SELECT TO_CHAR(1234, 'L999,999,999') FROM DUAL;
--> �ڸ��� �޸� ����

SELECT TO_CHAR(1234, '000,000,000') FROM DUAL;
--> �޸� �����ϸ鼭 ��ĭ 0���� ä��

SELECT TO_CHAR(1000, '9.9EEEE') FROM DUAL;
--> �ε��Ҽ������� ǥ�� (1.0E+03)

SELECT TO_CHAR(1000, '999') FROM DUAL;
--> ������ ������ ������ �Ѿ ��� #���� ��µ�

-- EMPLOYEE ���̺��� �����, �޿� ��ȸ
-- ��, �޿��� '\9,000,000' �������� ǥ���� ��
SELECT EMP_NAME, TO_CHAR(SALARY, 'L9,999,999') AS �޿�
FROM EMPLOYEE;

-------------------------------------------------------------------------------------------------------------------------------

-- TO_DATE
SELECT TO_CHAR (SYSDATE) FROM DUAL;
SELECT TO_CHAR (SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
-- ���� MM, ���� MI
SELECT TO_CHAR (SYSDATE, 'AM HH:MI:SS') FROM DUAL;
-- PM, AM�� �� ���� ������ ������ �ʴ�.. �׳� �� �ĵ� ���ĸ� ���Ķ��, �����̸� �����̶�� ����
SELECT TO_CHAR (SYSDATE, 'YYYY-MM-DD DY PM HH:MI:SS') FROM DUAL;

SELECT TO_CHAR (SYSDATE, 'YEAR, Q') || '�б�' FROM DUAL;

-- EMPLOYEE ���̺��� ��� ����� �̸�, ����� ��ȸ
-- ��, ������� '2019-11-14' �������� ��ȸ�� ��
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��"')
FROM EMPLOYEE;

---------------------------------------------------------------------------------------------------------
-- TO_DATE : ���� �Ǵ� ������ �����͸� ��¥������ ��ȯ
SELECT TO_DATE(20191114) FROM DUAL; -- �׳� �Ƚᵵ �ǰ�
SELECT TO_DATE('20191114', 'YYYYMMDD') FROM DUAL; --> ���ڸ� ��¥��
SELECT TO_DATE(20191114, 'YYYYMMDD') FROM DUAL; --> ���ڸ� ��¥��
SELECT TO_CHAR (TO_DATE(191114), 'YYYY-MM-DD') FROM DUAL; 

SELECT TO_DATE('981114', 'YYMMDD') FROM DUAL;
SELECT TO_CHAR (TO_DATE(981114, 'YYMMDD'), 'YYYY-MM-DD') FROM DUAL;
--> 2000�⵵�� �����̶� 2098�� ����
-- �׷��� RR �����

-- EMPLOYEE ���̺���
-- 2000�⵵���� �Ի��� ����� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE >= TO_DATE(20000101,'YYYYMMDD');

------------------------------------------------------------------------------------------------------------

-- TO_NUMBER

SELECT TO_NUMBER('123456789') FROM DUAL;
SELECT '100' + '100' FROM DUAL;
--> ���� �� ���ο� ���ڸ� �����ϹǷ� ����Ŭ�� �ڵ����� ���ڷ� ����ȯ�� ������

SELECT '1,000' + '1,000' FROM DUAL;
--> ���ڰ� ���ΰ� ���� + ������ ���·� �ڵ� ����ȯ �Ұ�
--> ���� TO_NUMBER �ʿ�

SELECT TO_NUMBER('1,000', '9,999') +
TO_NUMBER('1,000', '9,999') FROM DUAL;
--> �޸� ��� ���ڷ� �νĽ�ų�� ��
SELECT TO_NUMBER('1,000', '9,999') +
TO_NUMBER('1,000', '9,999') FROM DUAL;

-------------------------------------------------------------------------------------------------------------

-- 5. NULL ó�� �Լ�
-- NVL (�÷���, �÷����� NULL�� �� ������ ��)

SELECT EMP_NAME, NVL(BONUS, 0)
FROM EMPLOYEE;

SELECT EMP_NAME, (SALARY * 12) + (SALARY * NVL(BONUS, 0) * 12) AS �Ѽ��ɾ� -- NULL�� ����ϸ� ������ NULL�̹Ƿ�.. 0���� ������� �ʿ� ����
FROM EMPLOYEE;

-- NVL2(�÷���, ���氪1, ���氪2)
-- �ش� �÷��� ���� ������ ���氪1�� ����
-- �ش� �÷��� NULL�̸� ���氪2�� ����

-- EMPLOYEE ���̺��� ���� ���ʽ��� �޴� ����� �Ӻ��ʽ��� 0.8��
-- ���ʽ��� ���� ���ߴ� ����� �Ӻ��ʽ��� 0.3���� �����Ͽ�
-- �̸�, ���� ���ʽ�, ����� ���ʽ� ��ȸ

SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.8, 0.3)
FROM EMPLOYEE;

-- NULLIF(�񱳴��1, �񱳴��2)
-- �� ���� ���� �����ϸ� NULL, �ٸ��� �񱳴��1 ��ȯ
SELECT NULLIF('123','9123') FROM DUAL; --> 123 ��ȯ
SELECT NULLIF('123','123') FROM DUAL; --> NULL ��ȯ





-- �Լ� ���� ����

--1. EMPLOYEE ���̺���
--  ������� �ֹι�ȣ�� ��ȸ
--  ��, �ֹι�ȣ 9��° �ڸ����� �������� '*'���ڷ� ä��
--  �� : ȫ�浿 771120-1******
-- HINT. ���� ������

SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8)||'******' AS �ֹι�ȣ
FROM EMPLOYEE;

--2. EMPLOYEE ���̺���
--  ������, �����ڵ�, ����(��) ��ȸ
--  ��, �Ѽ��ɾ��� ��57,000,000 ���� ǥ��
--  (�Ѽ��ɾ��� ���ʽ��� ����� 1��ġ �޿�)
SELECT EMP_NAME, JOB_CODE, TO_CHAR(SALARY*(1+NVL(BONUS,0))*12, 'L999,999,999')
FROM EMPLOYEE;

-- 3. EMPLOYEE ���̺���
--   �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ 
--   ��� ����� �μ��ڵ� �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D9')
AND EXTRACT(YEAR FROM HIRE_DATE) = '2004';
-- ������ ���
-- AND TO_NUMBER(SUBSTR(HIRE_DATE,1,2)) = 4;

-- 4. EMPLOYEE ���̺���
--   ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
--   ��, �Ի��� ���� �ٹ��ϼ��� �����ؼ� +1 �� ��
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1 AS �ٹ��ϼ�
FROM EMPLOYEE;


--5. EMPLOYEE ���̺���
--  ������, �μ��ڵ�, �������, ����(��) ��ȸ
--  ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--  ������ ������ �����Ϸ� ��µǰ� ��.
--  ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, ���.
SELECT EMP_NAME, DEPT_CODE, TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6)), 'YY"��" MM"��" DD"��"') AS �������, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,6)))+1 AS "����(��)"
FROM EMPLOYEE;



