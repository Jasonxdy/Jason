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
