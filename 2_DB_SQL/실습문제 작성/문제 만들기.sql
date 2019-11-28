/*
EMPLOYEE ���̺��� �μ���, �ش�μ��� ���� ���� ��("���� ������"), ���� ���� ��("���� ������")�� ��ȸ�Ͽ���.
(�̶� �μ��� ���� ��쿡�� '�Ҽ� ����'���� ǥ���ϸ�, ���� ���� '��'���� ǥ���� ��)
*/

SELECT NVL(DEPT_TITLE, '�Ҽ� ����'),
    (SELECT COUNT(E1.EMP_ID)
    FROM EMPLOYEE E1
    WHERE SUBSTR(E1.EMP_NO,8,1) = '1'
    AND (E3.DEPT_CODE = E1.DEPT_CODE
    OR (E1.DEPT_CODE IS NULL AND E3.DEPT_CODE IS NULL))
    )|| '��' "���� ���� ��",
        
    (SELECT COUNT(E2.EMP_ID)
    FROM EMPLOYEE E2
    WHERE SUBSTR(E2.EMP_NO,8,1) = '2'
    AND (E3.DEPT_CODE = E2.DEPT_CODE
     OR (E2.DEPT_CODE IS NULL AND E3.DEPT_CODE IS NULL))
     )|| '��' "���� ���� ��"
    
FROM EMPLOYEE E3
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, NVL(DEPT_TITLE, '�Ҽ� ����');