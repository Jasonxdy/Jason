

-- VIEW
/*
    - SELECT ���� ������ ��� ȭ���� ������ ��ü
    - ������ ���� ���̺�
    - �������� �����͸� �����ϰ� ���� ����
    - ������ ���̺��� ����ϴ� �Ͱ� �����ϰ� ��� ����.
    
    
    [ǥ����]
    
    CREATE [OR REPLACE] [FORCE | NO FORCE] VIEW ���̸�
    AS ��������
    [WITH CHECK OPTION]
    [WITH READ ONLY];
    
*/

-- 1. VIEW ����

-- 1) ��� ���, �̸�, �μ���, �ٹ����� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
LEFT JOIN NATIONAL USING (NATIONAL_CODE);


-- 2) ������ ���̺��� VIEW�� �� 2)�� SELECT ����� ����
    --> VIEW ����

CREATE OR REPLACE VIEW V_EMPLYOEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
    LEFT JOIN NATIONAL USING (NATIONAL_CODE);

-- ORA-01031: insufficient privileges
--> VIEW ���� ������ ��� ���� �߻�

-- KH ������ VIEW ���� ���� �ο�
-- 1> SYS AS SYSDBA�� ���� ����
-- 2> KH ������ VIEW ���� ���� �ο�
GRANT CREATE VIEW TO KH;

-- 3> �ٽ� KH �������� ������ �����Ͽ� �� ����
CREATE OR REPLACE VIEW V_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
    LEFT JOIN NATIONAL USING (NATIONAL_CODE);

-- 3) ������ VIEW ��ȸ
SELECT * FROM V_EMPLYOEE;

COMMIT;



-- ���̽� ���̺��� ������ ����Ǹ�
-- �ش� ���̺�� ���� ������� VIEW�� �����͵� �����.

-- ����� 205�� ����� �̸��� '���߾�' ����

UPDATE EMPLOYEE
SET EMP_NAME = '���߾�'
WHERE EMP_ID = 205;

-- ���̽����̺�(EMPLOYEE)��ȸ
SELECT * FROM EMPLOYEE
WHERE EMP_ID = 205;

-- �׿� ���� VIEW�� ������ ��ȸ
SELECT * FROM V_EMPLOYEE
WHERE EMP_ID = 205;
-- �ζ��κ�� ���� ����




















