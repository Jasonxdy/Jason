-- 1. ������ ����� �����ִ� �μ������� ��ȸ�Ͻÿ� (��, �������� ����)
-- ���, �����, ��ȭ��ȣ, �����, �μ���
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������')
AND EMP_NAME != '������';





-- 2. ������� 2000�⵵ ������ ����� �� �޿��� ���� ���� �����
-- ���, �����, ��ȭ��ȣ, �޿�, ���޸��� ��ȸ�Ͻÿ�.

SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM
(SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= '2000'
ORDER BY SALARY DESC
)
WHERE ROWNUM = 1;





-- 3. ���ö ����� ���� �μ�, ���� ������ ����� ��ȸ�Ͻÿ�. (��, ���ö ����� ����)
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �μ���, ���޸�

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '���ö')
AND EMP_NAME ^= '���ö';





-- 4. 2000�⵵�� �Ի��� ����� �μ��� ������ ���� ����� ��ȸ�Ͻÿ�
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �����

-- 1) 2000�⵵�� �Ի��� ����� �μ��� ���� ��ȸ
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) = '2000';

-- 2) 1)�� ���� ��� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EXTRACT(YEAR FROM HIRE_DATE) = '2000');






-- 5. 77��� ���� ����� ������ �μ��̸鼭 ������ ����� ������ �ִ� ����� ��ȸ�Ͻÿ�
-- ���, �̸�, �μ��ڵ�, �����ȣ, �ֹι�ȣ, �����

-- 1) 77��� ���� ����� �μ��� ��� ��ȸ

SELECT E.DEPT_CODE,NVL((SELECT EMP_NAME
                        FROM EMPLOYEE M
                        WHERE E.MANAGER_ID = M.EMP_ID),'�������')
FROM EMPLOYEE E
WHERE SUBSTR(EMP_NO,1,2) = '77';

-- 2) 1)�� ������ �μ����� ����� ���� ��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID, EMP_NO, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, MANAGER_ID) = (SELECT DEPT_CODE, MANAGER_ID
                                FROM EMPLOYEE
                                WHERE SUBSTR(EMP_NO,1,2) = '77'
                                AND SUBSTR(EMP_NO,8,1) = '2');
                                
-- 6. �μ��� �Ի����� ���� ���� �����
-- ���, �̸�, �μ���(NULL�̸� '�ҼӾ���'), ���޸�, �Ի����� ��ȸ�ϰ�
-- �Ի����� ���� ������ ��ȸ�Ͻÿ�
-- ��, ����� ������ �����ϰ� ��ȸ..


SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '�ҼӾ���'), JOB_NAME, HIRE_DATE �Ի���
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING (JOB_CODE)
WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE)
                    FROM EMPLOYEE M
                    WHERE E.DEPT_CODE = M.DEPT_CODE
                    AND ENT_YN = 'N'
                    OR (E.DEPT_CODE IS NULL AND M.DEPT_CODE IS NULL)
                    )
ORDER BY �Ի���;

SELECT DEPT_CODE, MIN(HIRE_DATE)
FROM EMPLOYEE 
GROUP BY DEPT_CODE;


-- ������ Ǯ�� (������� �Ƚ�����)

SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '�ҼӾ���'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE
LEFT JOIN LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN (HIRE_DATE) FROM EMPLOYEE
                    WHERE ENT_YN = 'N'
                    GROUP BY DEPT_CODE)
ORDER BY HIRE_DATE;

-- ������ Ǯ�� (������� ���)

SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '�ҼӾ���'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN (HIRE_DATE) FROM EMPLOYEE M
                    WHERE E.DEPT_CODE = M.DEPT_CODE
                    AND ENT_YN = 'N'
                    OR (E.DEPT_CODE IS NULL AND M.DEPT_CODE IS NULL))
                    
ORDER BY HIRE_DATE;



-- 7. ���޺� ���̰� ���� � ������
-- ���, �̸�, ���޸�, ����, ���ʽ� ���� ������ ��ȸ�ϰ�
-- ���̼����� �������� �����ϼ���
-- �� ������ \124,800,000 ���� ��µǰ� �ϼ���. (\ : �� ���� ��ȣ)

SELECT EMP_ID, EMP_NAME, JOB_NAME, 
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) ����,
TO_CHAR(SALARY * (1 + NVL(BONUS,0)) * 12, 'L999,999,999') ���ʽ����Կ���
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))
= (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')))
FROM EMPLOYEE M
WHERE E.JOB_CODE = M.JOB_CODE)
ORDER BY ���� DESC;


