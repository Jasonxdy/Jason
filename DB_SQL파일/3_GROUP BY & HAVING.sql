

/*
SELECT ���� �ؼ� ���� (����Ŭ �ϸ鼭 �׻� �����ؾ� �ϴ� ��)

5 : SELECT �÷��� AS ��Ī, ����, �Լ���, .... -- SELECT ��
1 : FROM ������ ���̺�� -- FROM ��
2 : WHERE �÷��� | �Լ���  �񱳿�����  �񱳰� -- WHERE ��
3 : GROUP BY �׷����� ���� �÷��� -- GROUP BY ��
4 : HAVING  �׷��Լ���  �񱳿�����  �񱳰� -- HAVING ��
6 : ORDER BY �÷��� | ��Ī | �÷�����   ���Ĺ��  [NULLS FIRST/LAST]; -- ORDER BY �� (�׻� ���� ������)

(SELECT ���� �̰� ����) -> FROM���� ������� �ؼ��ϴٰ�, SELECT -> ORDER BY ������ �����Ѵٰ� ����
*/

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�
-- ��, �μ��ڵ尡 D5, D6, D9�� ������ ������ ��ȸ
-- => CASE ���� ���
-- �μ��ڵ� ������������ ����

SELECT DEPT_CODE,
CASE 
WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
WHEN DEPT_CODE = 'D9' THEN '������'
END AS �μ�
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9')
ORDER BY DEPT_CODE;


-- GROUP BY��
-- ���� ������ ������ ��ϵ� �÷��� ������
-- ���� ������ �ϳ��� �׷����� �����ִ� ����.

-- GROUP BY �÷���|�Լ��� [�÷���|�Լ���, ....]
--> �������� ���� ��� �ϳ��� ó���� �������� ���
-- �׷����� ���� ���� ���ؼ� SELECT ������ �׷��Լ��� �����

-- SELECT DEPT_CODE, SUM(SALARY)
-- FROM EMPLOYEE; -- ���� �߻�
-- ���� : DEPT_CODE�� �÷��� ���� ������, �׷��Լ��� SUM�� ���� 1��. ���� ����

SELECT DEPT_CODE, SUM(SALARY) -- 3. �� SUM���� �� �׷���� ���� ��
FROM EMPLOYEE -- 1. EMPLOYEE ���̺��� ��������
GROUP BY DEPT_CODE;  -- 2. DEPT_CODE�� ������ �ϳ��� �׷���� �ǰ�
-- ���⼭ NULL�� �׷��� ������

-- EMPLOYEE ���̺��� �μ��ڵ�, �׷� �� �޿��� �հ� ,�׷캰 �޿��� ���(����ó��),
-- �ο����� ��ȸ�ϰ� �μ� �ڵ� ������ ����
SELECT DEPT_CODE �μ��ڵ�, SUM(SALARY) �հ�, FLOOR(AVG(SALARY)) ���, COUNT(*) �ο���
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE ���̺��� �μ��ڵ�� �׷캰 ���ʽ��� �޴� ����� ���� ��ȸ�ϰ�
-- �μ��ڵ� ������ ����
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
--WHERE BONUS IS NOT NULL
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;
-- �̶� WHERE���� �ֳ� ���Ŀ� ���� ���� �ٸ��� �̴� �ؼ� ���� �����̴�..

-- EMPLOYEE ���̺��� ������ ���� �� �޿� ��� (���� ó��),
-- �޿� �հ�, �ο� �� ��ȸ�ϰ� �ο����� �������� ����
SELECT DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��') AS ����,
FLOOR(AVG(SALARY)) ���, SUM(SALARY) �հ�, COUNT(*) �ο���
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��') -- �̶� ��Ī���� �ϸ� �ȵǴ� ���� : �ؼ� ���� ����!!
ORDER BY �ο��� DESC; -- �̶� ORDER BY�� �ؼ� ���� �������̶� ��Ī ��� ����!


-- EMPLOYEE ���̺��� �μ��ڵ庰�� ���� ������ ����� �޿� �հ踦 ��ȸ�ϰ�, �μ��ڵ� ������ ����
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE;
-- �̶� SUM(SALARY)�� 300���� �̻��� ����� ���� ���� ���... WHERE�� ���Ұ� (�ֳĸ� WHERE�� GROUP BY ���� ����ó����)
-- ����... ����ϴ� ���� �Ʒ�!

-------------------------------------------------------------------------------------------------------------------

-- HAVING ��
-- �׷� �Լ��� ���ؿ� �׷쿡 ���� ������ ������ �� ����ϴ� ����
-- HAVING �÷���|�Լ���   �񱳿�����      �񱳰�

-- �μ��� �޿� ����� 300�� �̻��� �μ� ��ȸ (HAVING �� ��� X : ���ϴ� ��� �ȳ���)
SELECT DEPT_CODE, FLOOR(AVG(SALARY)) �޿����
FROM EMPLOYEE
WHERE SALARY >= 3000000
--> ���� : �� �μ����� �޿��� 300�� �̻��� �������� �޿��� ��հ��� ���Ǿ� ��ȸ��..
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- �μ��� �޿� ����� 300�� �̻��� �μ� ��ȸ (HAVING �� ��� O)
SELECT DEPT_CODE, FLOOR(AVG(SALARY)) �޿����
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING FLOOR(AVG(SALARY)) >= 3000000
ORDER BY DEPT_CODE;


-- EMPLOYEE ���̺��� �μ��� �׷��� �޿� �հ� �� 900������ �ʰ��ϴ� �μ��� �μ��ڵ�� �޿� �հ踦 ��ȸ
-- �μ��ڵ� ������ ����
SELECT DEPT_CODE, SUM(SALARY) �޿��հ�
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 9000000
ORDER BY DEPT_CODE;

-- [����] : ���� ���� (������ �ȿ� �ִ� ������..!)
-- �޿� �հ谡 ���� ���� �μ��� �μ��ڵ�� �μ��հ踦 ��ȸ
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 
    (SELECT MAX(SUM(SALARY))
    FROM EMPLOYEE
    GROUP BY DEPT_CODE);

---------------------------------------------------------------------------------------------------------

-- SET OPERATION (���� ����)
/*
- ���������� ������ ���� �� �׿� �ش��ϴ� ���� ���� ������� �����ϰ� ���� �� ����ϴ� ����
- �ʺ��ڵ��� ����ϱ� ���ٴ� ������ �ִ�.
 --> ������ ��� ����� �ϴ��� �����ϱ� ���� ����
 --> ���, ��������� �þ�� ������ �ӵ� ���ϰ� �߻�
 

    UNION (������) == OR
    INTERSECT (������) == AND
    UNION ALL == UNION + INTERSECT
     --> �ߺ��� ����� 2�� ���Ե�
    MINUS (������) --> �ߺ� ����
*/    


-- UNION : ���� ���� ���� ����� �ϳ��� ��ġ�� ������
-- �ߺ��� ������ �ϳ��� ��ħ

-- EMPLOYEE ���̺��� �μ� �ڵ尡 'D5'�� ������ �޿��� 300�� �ʰ��� ������
-- ���, �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- �� �������� OR �����ڸ� �̿��ؼ� ��ȸ�ϱ�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY >= 3000000;


-- INTERSECT : ������

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'

INTERSECT

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;


-- UNION ALL : ������ �տ���

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'

UNION ALL

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;


-- MINUS : ������

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'

MINUS

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;













