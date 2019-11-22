-- ���� �ּ�
-- ��ü ��� ���� ��ȸ
SELECT * FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���, �̸�, ���� ��� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

/*

���� �ּ�

*/
SELECT * FROM EMPLOYEE; -- ���� �� �����ؾ� ��

-- �ǽ����� --
-- 1. JOB ���̺��� ��� ������ ��ȸ
SELECT * FROM JOB;
-- 2. JOB ���̺��� ���޸� ��ȸ
SELECT JOB_NAME FROM JOB;
-- 3. DEPARTMENT ���̺��� ��� ���� ��ȸ
SELECT * FROM DEPARTMENT;
-- 4. EMPLOYEE ���̺��� �̸�, �̸���, ��ȭ��ȣ, ����� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE;
-- 5. EMPLOYEE ���̺��� �����, �����, ���� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY FROM EMPLOYEE;


-- �÷� �� ��� ����

-- EMPLOYEE ���̺��� ������ �̸��� ���� ��ȸ (���� - �޿� * 12)
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ������ �̸��� ���� (��Ī : ����(��))��ȸ, ���ʽ��� �ݿ��� ����(��Ī : �� �ҵ�(��))
-- ���ʽ��� �ݿ��� ���� = (�޿� + �޿�*���ʽ�) * 12

SELECT EMP_NAME, SALARY * 12, (SALARY + SALARY*BONUS) * 12
FROM EMPLOYEE;
-- ��� ���� �� NULL���� ���ԵǾ� ������ ����� NULL�̵�.

-- �ǽ� ���� --
-- 1. EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(����+���ʽ�), �Ǽ��ɾ�(�Ѽ��ɾ� - ����3%) ��ȸ
SELECT EMP_NAME, SALARY * 12, (SALARY + SALARY*BONUS) * 12, ((SALARY + SALARY*BONUS) * 12) * 0.97
FROM EMPLOYEE;

-- 2. EMPLOYEE ���̺��� �̸�, �����, �ٹ��ϼ�(���ó�¥ - �����) ��ȸ
-- DATE ���� ������ ��� ���� ����
-- ���� �ð�(��¥)�� ��ȸ�ϴ� ��ɾ� == SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;
-- 24������ �ð��� 10������ ��Ÿ���� ������� �̻��ϱ� ��

-- �÷� ��Ī
-- as ��Ī / "��Ī" / as "��Ī" : ��Ī�� Ư�����ڰ� ���Ե� �� �ֵ���ǥ ���
-- Ư������X    Ư������O

-- EMPLOYEE ���̺��� ������ �̸��� ���� (��Ī : ����(��))��ȸ, ���ʽ��� �ݿ��� ����(��Ī : �� �ҵ�(��))
SELECT EMP_NAME, SALARY * 12 AS "����(��)", (SALARY + SALARY*BONUS) * 12 "�� ����(��)"
FROM EMPLOYEE;


-- ���ͷ�
-- EMPLOYEE ���̺��� ������ ���, �̸�, �޿�, ����(������ : ��) ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY,
'��' AS ����
FROM employee;

-- DISTINCT
-- �÷��� ���Ե� �ߺ����� �� ������ ǥ���ϰ��� �� �� ����ϴ� Ű����

-- EMPLOYEE ���̺��� ������ ���� �ڵ� ��ȸ
SELECT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ������ ���� �ڵ� �ߺ� �����Ͽ� ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- WHERE ��
-- ��ȸ�� ���̺��� ������ �´� ���� ���� ���� ��󳻴� ����
/* [ǥ����]
SELECT �÷���
FROM ���̺��
WHERE ���ǽ�;
*/

-- * �񱳿�����
--  = (����), > (ũ��), < (�۴�), >= (ũ�ų� ����), <= (�۰ų� ����)
-- !=, ^=, <> (���� �ʴ�) : 3���� ����

-- EMPLOYEE ���̺��� �μ��ڵ尡 'D9'�� ������ �̸�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE ���̺��� �޿��� 4000000 �̻��� ������ �̸�, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D9�� �ƴ� ����� ���,�̸�, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE <> 'D9';

-- EMPLOYEE ���̺��� ��� ���ΰ� N�� ������ ��ȸ�ϰ� �ٹ� ���θ� '������'���� ǥ���Ͽ�
-- ���, �̸�, �����, �ٹ����θ� ��ȸ

SELECT EMP_ID, EMP_NAME, HIRE_DATE, '������' /*AS (�־ ��� ����)*/ �ٹ�����
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- EMPLOYEE ���̺��� �Ǽ��ɾ�(�Ѽ��ɾ� - (����*���� 3%))�� 5õ���� �̻��� �����
-- �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME, SALARY, (SALARY + (SALARY*BONUS))*12 - SALARY*12*0.03 �Ǽ��ɾ�, HIRE_DATE
FROM EMPLOYEE
WHERE (SALARY + (SALARY*BONUS))*12 - SALARY*12*0.03 >= 50000000;
/*�̶� ���ǽĿ� ��Ī ����ϸ� �ȵ�...�ϴ� ��� �ֱ��ѵ� ������ �ȵ�*/

-- EMPLOYEE ���̺��� �μ��ڵ尡 'D6'�̰� �޿��� 200�� �̻� �޴� ������ �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY >= 2000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 'D6'�̰ų� �޿��� 200�� �̻� �޴� ������ �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY >= 2000000;

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���Ϸ� �޴� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE 3500000 <= SALARY AND SALARY <= 6000000;

-- 1. EMPLOYEE ���̺� ������ 4000000 �̻��̰�, JOB_CODE�� J2�� ����� ��ü ���� ��ȸ
SELECT
    *
FROM EMPLOYEE
WHERE SALARY>=4000000
AND JOB_CODE = 'J2';

-- 2. EMPLOYEE ���̺� DEPT_CODE�� D9�̰ų� D5�� ��� �� ������� 02�� 1�� 1�Ϻ��� ���� ����� �̸�, �μ��ڵ�, ����� ��ȸ
-- TIP : ���� ������ ��� ���� �߿�!
-- ���� ������ �˻��ؾߵǴ� ��� ��ȣ�� ���� ��
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9'
OR DEPT_CODE = 'D5')
AND HIRE_DATE < '02/01/01'; --�̷��� �ۼ��ϴ� ��� ��¥�� �νĵ� (���ͷ�)


-- BETWEEN 'A' AND 'B' (���̰��� �ѹ��� ó���� �� �ִ� ���)
-- >> A �̻� B ���� (�̻�/���϶�� �Ϳ� ����)

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���Ϸ� �޴� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY BETWEEN '3500000' AND '6000000';

-- NOT ����ϱ�
-- EMPLOYEE ���̺��� �޿��� 350���� �̸� 600���� �ʰ��� �޴� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN '3500000' AND '6000000';
-- WHERE NOT SALARY BETWEEN '3500000' AND '6000000'; �� ����
-- NOT Ű����� �÷��� �Ǵ� BETWEEN �տ� ���̴°� ����

-- EMPLOYEE ���̺��� ������� '90/01/01' ~ '01/01/01'�� ����� ��� ���� ��ȸ
SELECT
    *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';


-- ���� ������(||)
-- ���� �÷��� �ϳ��� �÷��� �� ó�� �����ϰų� �÷��� ���ͷ��� ������ �� �ִ�.
-- EMPLOYEE ���̺��� ���, �̸�, �޿��� �����Ͽ� ��ȸ

SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- �÷��� ���ͷ� ����
SELECT EMP_NAME || '���� ������ ' || SALARY || '�� �Դϴ�.' AS �޼���
FROM EMPLOYEE;


-- ** LIKE (�߿�)
/*
���Ϸ��� ���� ������ Ư�� ������ ������Ű���� ��ȸ�� �� 
�񱳴���÷��� LIKE '��������'
�������� �˻� ����.

- ���� ����
'A%' (A�� �����ϴ� ��)
'%A' (A�� ������ ��)
'%A%' (A�� ���ԵǴ� ��) : �߰��� �ƴԿ� ����

- ���� ��
'_' (�ѱ���)
'__' (�α���)
*/

--EMPLOYEE ���̺��� ���� ������ ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';


-- EMPLOYEE ���̺��� �̸��� '��'�� ���Ե� ������ �̸�, �ֹι�ȣ, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE ���̺��� ��ȭ��ȣ �׹�° �ڸ��� 7�� �����ϴ� ����� ���, �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___7%';

-- EMPLOYEE ���̺��� �̸��� �� �ձ��ڰ� 3�ڸ��� ����� ���, �̸�, �̸��� �ּ� ��ȸ

-- ESCAPE OPTIONS ��� X
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- ����� ������ �ȵż� �� ��ȸ ����

-- ESCAPE OPTIONS ��� O
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___@_%' ESCAPE '@'; -- ����� ������ �ȵż� �� ��ȸ ����

-- NOT LIKE
-- Ư�� ������ �������� �ʴ� ���� ��ȸ

-- EMPLOYEE ���̺��� �达 ���� �ƴ� ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE /*NOT*/ EMP_NAME NOT LIKE '��%';


-------------- �ǽ� ���� -------------------

-- 1. EMPLOYEE ���̺��� �̸� ���� '��'���� ������ ����� �̸� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- 2. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 3. EMPLOYEE ���̺���
-- �����ּ� '_'�� ���� 4�� �̸鼭 DEPT_CODE�� D9 �Ǵ� D6�̰�
-- ������� 90/01/01 ~ 00/12/01�̰�,
-- �޿��� 270�� �̻��� ����� ��ü�� ��ȸ
SELECT
    *
FROM EMPLOYEE
WHERE EMAIL LIKE '____@_%' ESCAPE '@' 
AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
AND SALARY >= 2700000;

-- IS NULL : �÷����� NULL�� ���
--  IS NOT NULL : �÷����� NULL�� �ƴ� ���

-- EMPLOYEE ���̺��� ���ʽ��� ���� �ʴ� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- EMPLOYEE ���̺��� ���ʽ��� �޴� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- EMPLOYEE ���̺��� �����ڵ� ���� �μ� ��ġ�� ���� ���� ����� �̸�, ������, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL
AND DEPT_CODE IS NULL;

-- EMPLOYEE ���̺��� �μ���ġ�� �޾����� ���ʽ��� ���޹��� ���ϴ� ����� �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
AND BONUS IS NULL;

-- EMPLOYEE ���̺��� �μ���ġ�� �޾����� ���ʽ��� ���޹��� ���ϴ� ����� �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL
AND BONUS IS NOT NULL; 

-- IN
-- ���Ϸ��� ���� ��Ͽ� ��ġ�ϴ� ���� ������ TRUE�� ��ȯ�ϴ� ������
-- �񱳴���÷��� IN (XXX, XXX, XXX, ...);

-- EMPLOYEE ���̺��� D6 �μ��� D8 �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ

-- IN ��� X
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
OR DEPT_CODE = 'D8';
-- IN ��� O
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6', 'D8');
-- �ڵ� ���̰� ª������ ���ٴ� ������ �ִ�


-- ������ �켱����
/*
1. ��� ������
2. ���� ������
3. �� ������
4. IS NULL /IS NOT NULL, LIKE, IN, NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. NOT
7. AND
8. OR
--> ������ �� ����Ұ�!!
*/

--------------------------------------------------------------------------------------------------
-- *** (�� 3��¥��) ORDER BY ��
-- SELECT�� ���(RESULT SET)�� ������ �� �ۼ��ϴ� ����
-- SELECT ���� ���� �������� �ۼ�
-- SELECT ���� ���� �� ���� ������!
/*
SELECT �÷��� [, �÷���, �÷���, ...]
FROM ���̺��
[WHERE ���ǽ�]
[ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� [NULLS FIRST|LAST]]
-- CF> DB�ʿ��� �Ǵ��� | �Ѱ���
*/

-- NULLS FIRST : ���� ������ �÷��� NULL ���� ������ �պκп� �����ϱ�
-- NULLS LAST : ���� ������ �÷��� NULL ���� ������ �޺κп� �����ϱ�

-- EMPLOYEE ���̺��� �޿� �������� ������� �̸�, �޿�, �μ��ڵ�, �����ڵ�, ����� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
ORDER BY SALARY; -- ASC : ��������(��������// �⺻���� �Ǿ��ִ�)

-- EMPLOYEE ���̺��� ���� �������� ������� �̸�, �޿�, �μ��ڵ�, �����ڵ�, ����� ��ȸ�ϱ�
SELECT EMP_NAME, SALARY*12 AS ����, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
-- ORDER BY SALARY*12 DESC; -- DESC : ����
-- ORDER BY ���� DESC; -- ��Ī�� ����
ORDER BY 2 DESC; -- �÷� ����(2��°)�� ���� // �� ������ �ʴ´�.. �÷��� �ٲ� �� �־




