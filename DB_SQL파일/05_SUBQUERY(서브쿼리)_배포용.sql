
/*
  SELECT�� �ؼ� ����
  
  5 : SELECT �÷��� AS ��Ī, ����, �Լ���
  1 : FROM ������ ���̺�� 
     + JOIN
  2 : WHERE �÷��� | �Լ��� �񱳿����� �񱳰�
  3 : GROUP BY �׷��� ���� �÷���
  4 : HAVING �׷��Լ��� �񱳿����� �񱳰�
  6 : ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� [NULLS FIRST | LAST];
*/

----------------------------------------------------------------------------------------------------------------------------------

-- SUBQUERY(��������)
/*
- �ϳ��� SQL�� �ȿ� ���Ե� �Ǵٸ� SQL��.
- ���� ����(���� ����)�� ���� ���� ������ �ϴ� ������.
*/
         
-- SUBQUERY ����
-- 1) ���� ������ ����Ǳ� �� �ѹ��� ����
-- 2) �� ������ �����ʿ� ����ؾ� ��
-- 3) ���������� �ݵ�� ��ȣ�� ����� ��
-- 4) ���������� ���� �׸��� �ݵ�� ���������� SELECT�� �׸��� ������ �ڷ����� ��ġ���Ѿ� ��.

         
         
-- ���� �������� ���� 1
-- �μ��ڵ尡 ���ö����� ���� �Ҽ��� ������ 
-- �̸�, �μ��ڵ� ��ȸ�ϱ�

-- 1) ������� ���ö�� ����� �μ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';
    
-- 2) �μ��ڵ尡 D9�� ������ ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) �μ��ڵ尡 ���ö����� ���� �Ҽ��� ������ 
-- �̸�, �μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö');

-- ���� �������� ���� 2                   
-- �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ 
-- ���, �̸�, �����ڵ� ,�޿� ��ȸ

-- 1) �� ������ ��� �޿� ��ȸ 
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

-- 2) �� �������� �޿��� 3047663�� �̻��� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

-- 3) �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ 
-- ���, �̸�, �����ڵ� ,�޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT ROUND(AVG(SALARY))
                 FROM EMPLOYEE);


----------------------------------------------------------------------------------------------------------------------------------

/*  ���������� ����
     
     - ������ �������� : ���������� ��ȸ ��� ���� ������ 1���� ��������
     
     - ������ �������� : ���������� ��ȸ ��� ���� ������ �������� ��������
     
     - ���߿� �������� : ���������� SELECT���� ������ �׸� ���� �������� ��������
     
     - ������, ���߿� �������� : �������� ��ȸ ����� ���� ��, ���� �÷��� ���� ��������
    
     - ��� �������� : ���������� ���� ��� ���� ���� ������ �񱳿����� �� 
                      �������� ���̺��� ���� ����Ǹ� ���������� ��� ���� ����Ǵ� ��������
    
     - ��Į�� �������� : SELECT ���� ���Ǵ� ��������
    
     * ���������� ������ ���� �������� �տ� �ٴ� �����ڰ� �޶���.
    
*/
----------------------------------------------------------------------------------------------------------------------------------



-- 1. ������ �������� (SINGLE ROW SUBQUERY)
-- ���������� ��ȸ ��� ���� ������ 1���� ��������
-- ������ �������� �տ��� �� ������ ���
-- <, >, <=, >=, =, !=, <>, ^=





-- ���� 1-1
-- �� ������ �޿� ��պ��� ���� �޿��� �޴� ������ 
-- �̸�, ����, �μ�, �޿��� ���� ������ �����Ͽ� ��ȸ
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE)
                    --> ��ȸ�ϴ� �÷� 1��, ��� 1�� ��ȸ
ORDER BY JOB_CODE;





-- ���� 1-2                    
-- ���� ���� �޿��� �޴� ������
-- ���, �̸�, ����, �μ�, �޿�, �Ի����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);





-- ���� 1-3
-- ���ö ����� �޿����� ���� �޴� ������
-- ���, �̸�, �μ�, ����, �޿��� ��ȸ                 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '���ö');


-- ** ���������� WHERE�� �Ӹ� �ƴ϶� SELECT, HAVING, FROM�������� ��� ����!!





-- ���� 1-4
-- �μ���(�μ��� ���� ��� ����) �޿��� �հ� �� ���� ū �μ���
-- �μ���, �޿� �հ踦 ��ȸ 

-- 1) �μ��� �޿� �� �� ���� ū�� ��ȸ
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) �μ��� �޿����� 17700000�� �μ��� �μ���� �޿� �� ��ȸ
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
--> �μ��� ���� ������ �ֱ� ������ LEFT JOIN
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000;

-- 3) �μ���(�μ��� ���� ��� ����) �޿��� �հ� �� ���� ū �μ���
-- �μ���, �޿� �հ踦 ��ȸ 
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_CODE);
                    --> �÷� 1��, ����� 1��
                    
----------------------------------------------------------------------------------------------------------------------------------


-- 2. ������ ��������(MULTI ROW SUBQUERY)
-- ���������� ��ȸ ��� ���� ������ ���� ���� ��������
/*
   
    * ������ �������� �տ��� �Ϲ� �񱳿����� ��� X (���� �������� =, >,< ������)

    - IN / NOT IN
    -> ���� ���� ����� �� �ϳ��� ��ġ�ϴ� ���� �ִٸ�   
                                 ��ġ�ϴ� ���� ���ٸ�

    > ANY, < ANY : �������� ����� �߿��� �ϳ��� ū / ���� ��츦 ��Ÿ��
    --> �������� ��� �� �߿��� ���� ���� ������ ũ��? / ���� ū ������ �۳�?
    -- // ANY ���� �� '��� ��'���� �۴� / ũ��
    
    > ALL, < ALL : �������� ������� ��� ������ ū / ���� ��츦 ��Ÿ��
    --> ��� ����� �߿��� ���� ū ������ ũ��? / ���� ���� ������ �۳�?
    
    EXSIST / NOT EXIST : ���� �����ϳ�? / �������� �ʳ�?
    
*/




-- ���� 2-1
-- �μ��� �ְ� �޿��� �޴� ������ 
-- �̸�, ����, �μ�, �޿��� �μ� ������ �����Ͽ� ��ȸ
-- 1) �μ��� �ְ� �޿��� �޴� ������ �޿� ��ȸ
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE)
ORDER BY DEPT_CODE;




-- ���� 2-2
-- ����� �ش��ϴ� ������ ���� ��ȸ 
-- ���, �̸�, �μ���, ���޸�, ����(��� / ���)


-- 1) ����� �ش��ϴ� ��� ��ȣ ��ȸ
SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2) ������ ���, �̸�, �μ���, ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);

-- 3) ����� �ش��ϴ� ������ ���� ���� ���� ��ȸ(�� ��, ������ '���'��)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                  FROM EMPLOYEE
                  WHERE MANAGER_ID IS NOT NULL);

-- 4) �Ϲ� ������ �ش��ϴ� ����� ���� ��ȸ (�̶�, ������ '���'����)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT(MANAGER_ID)
                      FROM EMPLOYEE
                      WHERE MANAGER_ID IS NOT NULL);            
                        
-- 5) 3, 4�� ��ȸ ����� �ϳ��� ��ħ -> UNION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                  FROM EMPLOYEE
                  WHERE MANAGER_ID IS NOT NULL)

UNION

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT(MANAGER_ID)
                      FROM EMPLOYEE
                      WHERE MANAGER_ID IS NOT NULL);    

-- 6) 3, 4�� ��ȸ ����� �ϳ��� ��ħ ->SUBQUERY
-- SELECT �������� �������� ��� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
CASE
WHEN EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                  FROM EMPLOYEE
                  WHERE MANAGER_ID IS NOT NULL)
            THEN '���'
ELSE '���'
END ����
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);




-- ���� 2-3
-- �븮 ������ ������ �߿��� ���� ������ �ּ� �޿����� ���� �޴� ������
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, > ANY Ȥ�� < ANY �����ڸ� ����ϼ���


-- 1) ������ �븮�� �������� ���, �̸�, ���޸�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮';

-- 2) ������ ������ ������ �޿� ��ȸ
SELECT SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����';

-- 3) �븮 ������ ������ �߿��� ���� ������ �ּ� �޿����� ���� �޴� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY < ANY (SELECT SALARY
                  FROM EMPLOYEE
                  LEFT JOIN JOB USING (JOB_CODE)
                  WHERE JOB_NAME = '����');

-- �̶� ���������� SELECT MIN(SALARY)�� �ۼ��ص� ���� ��������
-- �̰��� ������ ���������̹Ƿ� ������ ���� > ANY �����





-- ���� 2-4
-- ���� ���� �޿��� ���� ū ������ ���� �޴� ���� ������ ����
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, > ALL Ȥ�� < ALL �����ڸ� ����ϼ���

---- 1) ���� ������ ����
--SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
--FROM EMPLOYEE
--LEFT JOIN JOB USING (JOB_CODE)
--WHERE JOB_NAME = '�븮';
--
---- 2) ���� ������ �޿�
--SELECT SALARY
--FROM EMPLOYEE
--LEFT JOIN JOB USING (JOB_CODE)
--WHERE JOB_NAME = '����';

-- 3) ���� ���� �޿��� ���� ū ������ ���� �޴� ���� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����'
AND SALARY > ALL (SELECT SALARY
                   FROM EMPLOYEE
                   LEFT JOIN JOB USING (JOB_CODE)
                   WHERE JOB_NAME = '����');


-- ** �������� ��ø ���[����]

-- NATIONAL_CODE�� KO�� �μ����� �ٹ��ϰ� �ִ� ������ 
-- ��� ���� ��ȸ

-- LOCATION ���̺��� NATIONAL_CODE�� KO�� LOCAL_CODE ��ȸ
SELECT LOCAL_CODE
FROM LOCATION
WHERE NATIONAL_CODE = 'KO';

-- DEPARTMENT ���̺��� LOCATION_ID�� 'L1'�� DEPT_ID
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE
                     FROM LOCATION
                     WHERE NATIONAL_CODE = 'KO');

-- ���������� �μ��� �ѱ��� ������ �ٹ��ϰ� �ִ� ���� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_ID
                    FROM DEPARTMENT
                    WHERE LOCATION_ID = (SELECT LOCAL_CODE
                                          FROM LOCATION
                                          WHERE NATIONAL_CODE = 'KO'));


                              
                              
----------------------------------------------------------------------------------------------------------------------------------

-- 3.  ���߿� ��������
-- �������� SELECT ���� ������ �÷� ���� �������� ���� ����

-- ���� 3-1
-- ����� �������� ���� �μ�, ���� ���޿� �ش��ϴ�
-- ����� �̸�, ����, �μ�, �Ի����� ��ȸ        

-- 1) ����� ������ ��ȸ
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
AND SUBSTR(EMP_NO,8,1) = '2';

-- 2) ����� �������� ���� �μ�, ���� ���� (���Ͽ� (=������) ǥ�� �� -> �ϳ��� �÷��� ��)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
-- ����� �������� ���� �μ�
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE ENT_YN = 'Y'
                    AND SUBSTR(EMP_NO,8,1) = '2')
-- ����� �������� ���� ����
AND     JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE ENT_YN = 'Y'
                    AND SUBSTR(EMP_NO,8,1) = '2')
-- ���� �������� ���� (���¸� ����)
AND ENT_YN = 'N';
             
-- 3) ����� �������� ���� �μ�, ���� ���� (���� �� ��������)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE)/*�� ���� �ϳ��� ���� �÷��̶�� ��� �ϱ����� ��ȣ*/ =
(SELECT DEPT_CODE, JOB_CODE
 FROM EMPLOYEE
 WHERE ENT_YN = 'Y'
 AND SUBSTR(EMP_NO,8,1) = '2')
 
 AND ENT_YN = 'N';



             
----------------------------------------------------------------------------------------------------------------------------------        
           
-- 4. ������ ���߿� ��������
-- ���������� ��ȸ ��� �� ����, �÷� ���� �������� ��������

-- ���� 4-1
-- ���� ������ ��� �޿��� �ް� �ִ� ������
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, �޿��� �޿� ����� ���������� ����ϼ��� TRUNC(�÷���, -5)      

-- 1) �޿��� 200, 600�� �޴� ���� (200��, 600���� ��ձ޿��� ���� �� ���)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN ('2000000', '6000000');

-- 2) ���޺� ��� �޿�
SELECT JOB_CODE, TRUNC(AVG(SALARY),-4)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 3) ���� ������ ��� �޿��� �ް� �ִ� ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN  (SELECT JOB_CODE, TRUNC(AVG(SALARY),-4)
                                            FROM EMPLOYEE
                                            GROUP BY JOB_CODE);


-- �̶� WHERE���� (JOB_CODE, SALARY)���� SALARY�� ��� ���������� ��Ģ �� Ÿ�԰� ������ ������ �ȴٴ� ��Ģ ������
-- ���� ���� �ȸ��絵 �ȴٴ� �Ϳ� ������ ��!!


 
---------------------------------------------------------------------------------------------------------------------------------- 

-- 5. ��[ȣ��]�� �������� (�ſ� �����.. ���� �Ұ�)
-- ��� ������ ���������� ����ϴ� ���̺� ���� ���������� �̿��ؼ� ����� ����� ��������
-- ���� ������ ���̺� ���� ����Ǹ� ���������� ������� �ٲ�� ��
-- �ӵ������� ������ ���� ����

-- ���� 5-1
-- ����� �ִ� ������ ���, �̸�, �μ���, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID
FROM EMPLOYEE E
WHERE EXISTS (SELECT EMP_ID
                FROM EMPLOYEE M
                WHERE E.MANAGER_ID = EMP_ID);
                -- E.MANAGER_ID�� EMP_ID�� �����ϴ� ����� EMP_ID�� �ö�..
                
-- ���� ����, �� ���� ���̺��� ���������� ������ �ؾ� �Ҷ� ��� ������ �ַ� ����Ѵ�!


-- ���� 5-2
-- ���޺� �޿� ��պ��� �޿��� ���� �޴� ������ 
-- �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEE M
                WHERE E.JOB_CODE = M.JOB_CODE);
--              E.JOB_CODE�� �� (EX: J1)�� ���� M.JOB_CODE�� (J1��)�� �̾Ƴ��� ���ο� ���̺� ����
--              �� �� �� ���̺��� SALARY ����� ���ϴ� ���� ����...


---------------------------------------------------------------------------------------------------------------------------------- 

-- 6. ��Į�� ��������
-- SELECT ���� ���Ǵ� ��������
-- ����� 1�ุ ��ȯ
-- * SQL���� ���� ���� '��Į��'��� ��


-- ���� 6-1
-- �����, ����, �� �������� ���� ������ �޿� ��� ��ȸ
SELECT EMP_NAME, JOB_CODE,
FLOOR((SELECT AVG(SALARY)
FROM EMPLOYEE M
WHERE E.JOB_CODE = M.JOB_CODE)) �������
FROM EMPLOYEE E
GROUP BY EMP_NAME, JOB_CODE;

-- �̶� ��� ������ ��Į�� ���������� ����ϴ� ������ JOIN�̳� �̷� �ͺ��� �� 30������ ���̰� ��
-- �׷��� �������

---------------------------------------------------------------------------------------------------------------------------------- 

-- 7. �ζ��� ��(INLINE-VIEW)
-- ���������� ���� ����� ���� (RESULT SET)�� ���̺� ��� ���

-- ���� 7-1 : �ζ��κ並 Ȱ���� TOP-N�м�
-- �� ���� �� �޿��� ���� ���� 5����
-- ����, �̸�, �޿� ��ȸ

-- * ROWNUM : ��ȸ�� ������� 1���� ��ȣ�� �ű�� �÷�
-- ROWNUM�� ��� ��µǴ��� ��ȣ �ű�� �� Ȯ��
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE;

-- �޿� �������� �����Ͽ� ��ȣ �ű��
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
--> ORDER BY�� �ؼ� ������ �������̱� ������ ��ȣ���� �Ű��� �� �޿� ������������ ���ĵ�

-- ���������� �̿��Ͽ� ���� ����� ���� ���� �� ROWNUM�� �̿��Ͽ� ���� �ű��
-- ���� ���� ����� �����
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- ROWNUM���� ��ȣ �ű��
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
      FROM EMPLOYEE
      ORDER BY SALARY DESC)  --> '�ζ��κ�'
WHERE ROWNUM <= 5;
-- �̶� ROWNUM�� �ٸ��͵�� �ٸ��� SELECT������ �������� WHERE���� ����ص� �ؼ� ������ ������ ����


-- ���� 7-2
-- �޿� ����� 3�� �ȿ� ��� �μ��� 
-- �μ��ڵ�� �μ���, ��ձ޿��� ��ȸ

SELECT ROWNUM, DEPT_CODE, DEPT_TITLE, ��ձ޿� -- �̶� FLOOR(AVG(SALARY))��� �ϸ� �ȵ�..
                                                -- �ֳĸ� FROM�� ���� �����Ǿ��� ������
FROM 
    (SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) ��ձ޿�
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
    GROUP BY DEPT_CODE, DEPT_TITLE
    ORDER BY ��ձ޿� DESC)
WHERE ROWNUM <= 3;

---------------------------------------------------------------------------------------------------------------------------------- 


-- 8. WITH
-- ���������� �̸��� �ٿ��ְ� ���� ���� ��� �� �̸��� �ҷ� ����ϰ� ��
-- �ζ��κ�� ���� ���������� �ַ� ����.
-- ���� �ӵ��� ��������, ���� ������ ���������� ������ ����


-- ���� 8-1
-- �� ������ �޿� ���� 
-- ����, �̸�, �޿� ��ȸ
WITH TOPN_SAL AS (SELECT EMP_NAME, SALARY
                  FROM EMPLOYEE
                  ORDER BY SALARY DESC) -- �����ݷ�(;) ����

SELECT ROWNUM, EMP_NAME, SALARY
FROM TOPN_SAL;

---------------------------------------------------------------------------------------------------------------------------------- 

-- 9. RANK() OVER / DENSE_RANK() OVER
-- // ROWNUMó�� ���� �ű�� ��� , IN-LINE VIEW ���� �����൵ ��


--  RANK() OVER : ������ ���� ������ ����� ������ �ο� �� ��ŭ �ǳ� �ٰ� ���
--  EX) ���� 1�� 2�� --> 1��, 1��, �� ������ 3��... �̷���

-- �� ���� �޿� ����
SELECT EMP_NAME, SALARY,
        RANK() OVER(ORDER BY SALARY DESC) AS ����
FROM EMPLOYEE;
-- 19, 19, 21

-- DENSE_RANK() OVER : ������ ���� ������ ����� �ǳʶ��� �ʰ� ���ʴ�� ����
SELECT EMP_NAME, SALARY,
        DENSE_RANK() OVER(ORDER BY SALARY DESC) AS ����
FROM EMPLOYEE;
-- 19, 19, 20

