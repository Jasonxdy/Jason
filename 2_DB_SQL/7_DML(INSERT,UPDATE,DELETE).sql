
-- DML (DATA MANIPULATION LANGUAGE)
-- ���̺� ���� �����ϰų�(INSERT), �����ϰų�(UPDATE), ����(DELETE)�ϴ� ����

------------------------------------------------------------------------------------------------------------------------------


-- 1. INSERT

-- ���ο� ���� �߰��ϴ� ����
    --> ���̺��� �� ���� ����

-- [ǥ����]
/*

    INSERT INTO ���̺�� [(�÷���, �÷���, �÷���, ....)]
    VALUES (������1, ������2, ������3, ....)
    
    -- INSERT�� ��� �÷��� �����͸� �߰��� ���
    -- (�÷���, �÷���, ...) ���� ����
    -- ��, �÷� ������ ���Ѽ� VALUES�� �ۼ��ؾ� ��
    
*/


-- EMPLOYEE ���̺� ���ο� �� �߰��ϱ�
INSERT INTO EMPLOYEE
VALUES (900, '��ä��', '901123-2080503', 'ch_jang@kh.or.kr', '01055569512', 'D1', 'J7', 'S3',4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);

-- ��ä�� ����� ��� ���� ��ȸ
SELECT * FROM EMPLOYEE
WHERE EMP_NAME = '��ä��';

COMMIT;
-- DCL, ������� �۾��� DML ������ DB�� �ݿ� (DBMS -> DB�� ���� �ִ� ����)


-- �ϴ� ���̺� ���� �ϳ� �����
CREATE TABLE EMP_01(
    EMP_ID          NUMBER,
    EMP_NAME        VARCHAR2(30),
    DEPT_TITLE      VARCHAR2(20)
);

-- INSERT�� VALUES ��� �������� ��� ���� (SELECT ����Ͽ� RESULT SET ���� �� �״�� TABLE�� ����)

INSERT INTO EMP_01 (EMP_ID, EMP_NAME, DEPT_TITLE)
            (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
            FROM EMPLOYEE
            LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));
            
SELECT
    *
FROM EMP_01;

--------------------------------------------------------------------------------------------------------------------------------

-- 2. INSERT ALL

-- INSERT�� ���������� ���(FROM)�ϴ� ���̺��� ���� ��� 
-- �� �� �̻��� ���̺� INSERT ALL�� �̿��Ͽ� �ѹ��� ���� ����.
-- ��, �� ���������� ������(WHERE)�� ���ƾ� ��.

-- INSERT ALL ������ ���̺� ����
CREATE TABLE EMP_DEPT
AS  SELECT EMP_ID, EMP_NAME, DEPT_CODE,HIRE_DATE
    FROM EMPLOYEE
    WHERE 1 = 0;
    -- WHERE���� ������ FALSE�̱� ������ �̸� �����ϴ� ���� ��� ���� ������� �ʰ�, �÷���� ������ Ÿ�Ը� ���簡 ��
    
SELECT * FROM EMP_DEPT;

CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1 = 0;

SELECT * FROM EMP_MANAGER;


-- EMP_DEPT ���̺� EMPLOYEE ���̺� �ִ� �μ��ڵ尡 D1�� ������ ��ȸ�� ���, �̸�, �μ��ڵ�, �Ի����� �����ϰ�,
-- EMP_MANAGER ���̺� EMPLOYEE ���̺� �ִ� �μ��ڵ尡 D1�� ������ ��ȸ�ؼ� ���, �̸�, �������� ����.

-- 1) ���� INSERT �ϴ� ���
INSERT INTO EMP_DEPT
            (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
             FROM EMPLOYEE
             WHERE DEPT_CODE = 'D1');
             
SELECT * FROM EMP_DEPT;


INSERT INTO EMP_MANAGER
            (SELECT EMP_ID, EMP_NAME, MANAGER_ID
            FROM EMPLOYEE
            WHERE DEPT_CODE = 'D1');
            
SELECT * FROM EMP_MANAGER;


ROLLBACK;
-- DCL, ������� �ۼ��� DML ������ DB�� �ݿ����� �ʰ� �� �������� (���� ���·� �ǵ���)


-- 2) INSERT ALL ���
INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';


-- EMPLOYEE ���̺��� �Ի��� �������� 2000�� 1�� 1�� ������ �Ի��� ����� ���, �̸�, �Ի���, �޿��� ��ȸ�ؼ�
-- EMP_OLD ���̺� �����ϰ� �� �Ŀ� �Ի��� ����� ������ EMP_NEW ���̺� ����

CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE 1 = 0;

CREATE TABLE EMP_NEW
AS  SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE 1 = 0;
    
INSERT ALL
WHEN HIRE_DATE < '2000/01/01'
THEN INTO EMP_OLD VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2000/01/01'
THEN INTO EMP_NEW VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;    


-------------------------------------------------------------------------------------------------------------------------------

-- 3. UPDATE
-- ���̺� ��ϵ� �÷��� ���� �����ϴ� ����
-- ���̺� ��ü ���� �������� ��ȭ�� ����

-- [ǥ����]
/*
    UPDATE ���̺��
    SET �÷���1 = ������ ��1,
    SET �÷���2 = ������ ��2,
    SET �÷���3 = ������ ��3,
    ...
    [WHERE �÷��� �񱳿����� �񱳰�];
*/
-- WHERE�� �Ȱɸ� �÷� ��ü�� ���� ����ȴ�...!


-- DEPARTMENT ���̺� ���� (�ǽ��� �׻� ���纻 ���� �غ���)
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;

COMMIT;

-- DEPT_COPY ���̺��� �μ��ڵ尡 'D9'�� ���� �μ�����
-- '������ȹ��'���� ����

UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��';
--> ���� ������ �������� ������ ��� �÷����� �����.

UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��'
WHERE DEPT_ID = 'D9';


-- UPDATE �������� �������� ���

-- [ǥ����]
/*
    UPDATE ���̺��
    SET �÷��� = (������ ��������) // ������ �������� : �൵, ���� 1���� ��
*/

-- ��� �� ����� ����� �η����ϴ� ���� ����� �޿��� ���ʽ����� ����� �����
-- �����ϰ� �������ֱ�� �ߴ�.
-- �̸� �ݿ��ϴ� UPDATE���� �ۼ��Ͻÿ�

CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
    FROM EMPLOYEE;

-- EMP_SALARY ���̺��� �����, ���� ������ ��ȸ
SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN ('�����', '����');

COMMIT;

UPDATE EMP_SALARY
SET SALARY  =  (SELECT SALARY
                FROM EMP_SALARY
                WHERE EMP_NAME = '�����'),
    BONUS =    (SELECT BONUS
                FROM EMP_SALARY
                WHERE EMP_NAME = '�����')
WHERE EMP_NAME = '����';
                



-- ������, ���߿� ���������� ����� UPDATE

-- ���߿�
-- ���� ����� �޿� �λ� �ҽ��� ���ص��� �ٸ� ������� ��ü�� �ľ��ߴ�.
-- �̸� �ذ��ϱ� ���� ���ö, ������, ������, �ϵ��� ����� �޿��� ���ʽ���
-- ����� ����� ���� �����ϴ� UPDATE���� �ۼ��Ͻÿ�

SELECT *
FROM EMP_SALARY
WHERE EMP_NAME IN ('���ö', '������', '������', '�ϵ���');

UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                        FROM EMP_SALARY
                        WHERE EMP_NAME = '�����') -- �� ���������� ���߿��� ��
WHERE EMP_NAME IN ('���ö', '������', '������', '�ϵ���');


-- ������
-- EMP_SALARY ���̺��� �ƽþ� ������ �ٹ��ϴ� ������ ���ʽ����� 0.3���� ����


-- �ƽþ� ������ �ٹ��ϴ� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS, LOCAL_NAME
FROM EMP_SALARY
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
WHERE LOCAL_NAME LIKE 'ASIA%';


-- �ƽþ� ������ �ٹ��ϴ� ������ ���ʽ� 0.3���� ����
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
                FROM EMP_SALARY
                LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
                WHERE LOCAL_NAME LIKE 'ASIA%');

---------------------------------------------------------------------------------------------------------------------------------
COMMIT;

-- UPDATE�� ������ ���� �ش� �÷��� ���� ���������� ������� �ʰ� �ؾ� �� (���Ἲ ħ��).
UPDATE EMPLOYEE
SET DEPT_CODE = 'A5'
WHERE DEPT_CODE = 'D6';
-- FOREIGN KEY �������� ����

--------------------------------------------------------------------------------------------------------------------------------

-- 4. MERGE (����)
-- ������ ���� �� ���� ���̺��� �ϳ��� ��ġ�� ���.
-- ���̺��� �����ϴ� ������ ���� �����ϸ� UPDATE
                                    --> WHEN MATCHED THEN
-- ���� ���� ������ INSERT
            --> WHEN NOT MATCHED THEN

-- PDF ����

--------------------------------------------------------------------------------------------------------------------------------


-- 5. DELETE
-- ���̺��� ���� �����ϴ� ����
    --> ���̺� ���� ������ �پ��

-- [ǥ����]
/*

    DELETE FROM ���̺��
    [WHERE �÷��� �񱳿����� �񱳰�];
    
    -- // WHERE���� �������� ������ ���̺��� ��� �����Ͱ� ������
*/

COMMIT;

SELECT * FROM EMPLOYEE;

-- ��ä�� ����
DELETE FROM EMPLOYEE
WHERE EMP_NAME = '��ä��';

ROLLBACK;

-- ��ü ����
SELECT * FROM EMPLOYEE_COPY;
DELETE FROM EMPLOYEE_COPY;
ROLLBACK; -- �ѹ�

-- DELETE�� ������� �ʴ� ���
DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
--> �ڽ� ���̺� 'D1' ���� ����� �Ǿ��־� ���� �� ���� ���Ἲ�� ����ǹǷ� ���� �߻�

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D3';
--> FOREIGN KEY ���������� ������ �Ǿ� �־ ���� �������� �ʾҴٸ� ���� ������!
ROLLBACK;


-- FOREIGN KEY ������������ ���� ������ �Ұ����� ��Ȳ
    --> ���������� ��Ȱ����Ű�� ���� ����
ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT SYS_C007157 CASCADE; -- CASCADE : ??

-- ��Ȱ��ȭ �� �ٽ� D1 ����
DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';

SELECT * FROM DEPARTMENT;

SELECT * FROM EMPLOYEE;
-- D1�� �������� (�������� ����� �����̹Ƿ�)

ROLLBACK;

-- ��Ȱ��ȭ �� ���� ������ �ٽ� Ȱ��ȭ
ALTER TABLE EMPLOYEE
ENABLE CONSTRAINT SYS_C007157; 

-- Ȱ��ȭ �� �ٽ� D1 ����
DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
--> �������� �ٽ� �����Ǿ ���� �Ұ�

--------------------------------------------------------------------------------------------------------------------------------

-- TRUNCATE
-- ���̺��� ��ü ���� �����ϴ� DDL
-- DELETE���� ����ӵ��� ����.
-- DB�� �޸� ������ Ȯ���� �ȴ�.

-- COMMIT, ROLLBACK�� ����� �� �ִ� ���
    --> DML ������ ���ؼ��� ��� ����

-- DML ������ �ۼ��ϴٰ� DDL ������ �ۼ��ϸ� �տ��� �ۼ��� DML ������ ��� COMMIT��
    --> ROLLBACK �Ұ�!

SELECT * FROM EMP_SALARY;

-- DELETE�� �̿��ؼ� ��� ����
DELETE FROM EMP_SALARY;

SELECT * FROM EMP_SALARY;

-- DELETE�� DML �����̹Ƿ� ROLLBACK ����
ROLLBACK;

-- TRUNCATE�� ����
TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
-- ROLLBACK�ص� �ȵ��ƿ�.... TRUNCATE�� DDL�����̹Ƿ�










