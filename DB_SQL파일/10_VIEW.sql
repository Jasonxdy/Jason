

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




-- VIEW�� ���� ���������� SELECT ���� �Լ��� ���� ���
-- VIEW ���� �� �ݵ�� �ش� �÷��� ��Ī�� �����ؾ� ��.

-- ��� ����� ���, �̸� ���޸�, ����, �ٹ������ ��� �����ϱ� (2���� ��� ����)

-- 1�� : ���������� ��Ī �����ϱ�
CREATE OR REPLACE VIEW V_EMP_JOB
AS SELECT EMP_ID ���, EMP_NAME �̸�, JOB_NAME ���޸�, DECODE(SUBSTR(EMP_NO, 8, 1), '1','��','2','��') ����,
    EXTRACT (YEAR FROM SYSDATE) - EXTRACT (YEAR FROM HIRE_DATE) �ٹ����
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE);

-- 2�� : VIEW �̸� ���� ��ȣ�� ������� �÷� ��Ī ǥ���ϱ�
CREATE OR REPLACE VIEW V_EMP_JOB2 (���, �̸�, ���޸�, ����, �ٹ����)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DECODE(SUBSTR(EMP_NO, 8, 1), '1','��','2','��'),
    EXTRACT (YEAR FROM SYSDATE) - EXTRACT (YEAR FROM HIRE_DATE)
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE);

SELECT * FROM V_EMP_JOB;
SELECT * FROM V_EMP_JOB2;



-- ������ VIEW�� ���� DML ���� ���� ���̽����̺� ��ȭ Ȯ��
COMMIT;

SELECT * FROM JOB;

CREATE OR REPLACE VIEW V_JOB
AS SELECT JOB_CODE, JOB_NAME
    FROM JOB;
    
SELECT * FROM V_JOB;

-- VIEW�� INSERT ���� ����غ���
INSERT INTO V_JOB VALUES ('J8', '����');

-- VIEW�� �߰��� ������ Ȯ��
SELECT * FROM V_JOB;

-- ���̽� ���̺� ���� �Ǿ����� Ȯ��
SELECT * FROM JOB;


INSERT INTO V_JOB
VALUES ('J0', NULL);

SELECT * FROM JOB;

--------------------------------------------------------------------------------------------------------------------------------


-- * DML ��ɾ�� VIEW ������ �Ұ����� ��� *
/*
1. �� ���ǿ� ���Ե��� ���� �÷��� �����ϴ� ���
2. �信 ���Ե��� ���� �÷� �߿� ���̽��� �Ǵ� �÷��� NOT NULL ���������� ������ ���
3. ��� ǥ�������� ���ǵ� ���
4. �׷��Լ��� GROUP BY���� ������ ���
5. DISTINCT�� ������ ���
6. JOIN�� �̿��� ���� ���̺��� ������ ���
*/


-- 1. �� ���ǿ� ���Ե��� ���� �÷��� �����ϴ� ���
CREATE OR REPLACE VIEW V_JOB3
AS SELECT JOB_CODE FROM JOB;


-- �信 ���ǵ��� ���� �÷�(JOB_NAME)�� �����غ���
INSERT INTO V_JOB3
VALUES ('J9', '�˹�');
-- ORA-00913: too many values
-- VIEW ��ü���� JOB_NAME�� ���� ������ ����

UPDATE V_JOB3
SET JOB_NAME = '����'
WHERE JOB_CODE = 'J8';
-- ORA-00904: "JOB_NAME": invalid identifier

DELETE FROM V_JOB3
WHERE JOB_NAME = '����';
-- ORA-00904: "JOB_NAME": invalid identifier

SELECT * FROM V_JOB4;


-- 2. �信 ���Ե��� ���� �÷� �߿� ���̽��� �Ǵ� �÷��� NOT NULL ���������� ������ ���
-- (�̰� �߿�)
 
CREATE OR REPLACE VIEW V_JOB4
AS SELECT JOB_NAME FROM JOB;

INSERT INTO V_JOB4
VALUES ('�˹�');
-- ORA-01400: cannot insert NULL into ("KH"."JOB"."JOB_CODE")
-- ���̽� ���̺��� JOB�� JOB_CODE �÷��� PRIMARY KEY ���� ������ �����Ǿ� �����Ƿ�
-- NULL ���� ���Ե� �� ����. --> ���� ���� �߻�


UPDATE V_JOB4
SET JOB_NAME = '����'
WHERE JOB_NAME = '����';
-- UPDATE�� ����

DELETE FROM V_JOB4
WHERE JOB_NAME IS NULL;
-- DELETE�� ����

-- �ֳĸ� INSERT�ʹ� �޸� ���� ������ �߰��Ǵ� ���� ����

SELECT * FROM V_JOB4;

-- 3) ��� ǥ�������� ���ǵ� ���
 CREATE OR REPLACE VIEW V_EMP_SAL
 AS SELECT EMP_ID, EMP_NAME, SALARY, (SALARY * (1+NVL(BONUS,0)) * 12) ����
     FROM EMPLOYEE;
     
SELECT * FROM V_EMP_SAL;
     
INSERT INTO V_EMP_SAL
VALUES(800, '������', 3000000);
-- ORA-01733: virtual column not allowed here

SELECT * FROM V_EMP_SAL;

UPDATE V_EMP_SAL
SET ���� = 8000000
WHERE EMP_ID = 200;
-- ���� ���̽� ���̺��� �����̶�� �÷��� �������� �ʾƼ� ���� ���� �� ����

-- ��� ǥ������ ���ǵ� �信�� INSERT, UPDATE �Ұ�!
COMMIT;

DELETE FROM V_EMP_SAL
WHERE ���� = 124800000;
-- �� , DELETE�� ��� �������� ã�� ���� �ٸ� �÷����� ���̽����̺� �����ϱ� ������ ���� �����ϴ� ���� ����

-- ��, DELETE�� ����!

ROLLBACK;

SELECT * FROM V_EMP_SAL;
SELECT * FROM EMPLOYEE;



-- 4. �׷��Լ��� GROUP BY���� ������ ���

SELECT SUM (SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
--> �׷� �Լ� �Ǵ� GROUP BY �� ����Ͽ� �� ���� �� �並 ���� ��ȸ�Ǵ� �� ���� ���̽����̺��� � ���� ������
--> �� �� ����..!
    --> ���� INSERT, UPDATE, DELETE�� ��� ���� �߻�
    
CREATE OR REPLACE VIEW V_GROUPDEPT
AS SELECT DEPT_CODE, SUM(SALARY) �հ�, AVG(SALARY) ���
    FROM EMPLOYEE
    GROUP BY DEPT_CODE;
INSERT INTO V_GROUPDEPT VALUES('D10', 6000000, 4000000);
DELETE FROM V_GROUPDEPT WHERE DEPT_CODE = 'D1';


--5. DISTINCT�� ������ ���
-- // �� ��쿡�� �ߺ��� ���ŵǾ��� ������ � ���� ��Ī�ϴ��� ���� �Ұ���

CREATE OR REPLACE VIEW V_DT_EMP
AS SELECT DISTINCT JOB_CODE
    FROM EMPLOYEE;
INSERT INTO V_DT_EMP VALUES('J9');
DELETE FROM V_DT_EMP WHERE JOB_CODE = 'J1';



--6. JOIN�� �̿��� ���� ���̺��� ������ ���
CREATE OR REPLACE VIEW V_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
    
-- INSERT/UPDATE ���� �߻�
INSERT INTO V_JOINEMP
VALUES(888,'������','�λ������');
-- DEPARTMENT ���̺��� ��� PK�� DEPT_ID�̹Ƿ� DEPT_TITLE�� ���� �߰� �� PK�� NULL�� �Ǿ�
-- ���� ���Ἲ�� ����ǰ� �ȴ�..

--> �׷��� JOIN�� ��� INSERT/UPDATE�� �Ұ����ϴ�

DELETE FROM V_JOINEMP
WHERE EMP_ID = 200;
-- �̰� ���ϰ� �Ѿ��..���� ���߿� TEST �غ� ��


-- * VIEW ���� Ȯ���ϱ�
-- ����� ���� �並 Ȯ���� �� �ִ� ������ ��ųʸ� (USER_VIEWS)
SELECT * FROM USER_VIEWS;
-- //Ȯ���غ��� VIEW�ȿ��� �׳� ���������� ����Ǿ� �ְ� ȣ�� �� �ش� �������� ����Ǿ�
-- // RESULT SET�� �����ִ� ��

--------------------------------------------------------------------------------------------------------------------------------

-- VIEW �ɼ�

-- 1) OR REPLACE
-- ������ ������ �̸��� ���� �䰡 �����ϴ� ��� 
-- �ش� �並 ����� ���� ��� ���ο� �並 ������

CREATE VIEW V_EMP2
AS SELECT EMP_NO, EMP_NAME
    FROM EMPLOYEE;

-- ���� Ȯ��
SELECT * FROM V_EMP2;

-- ���� �̸����� EMP_ID�� �����Ͽ� REPLACE
CREATE OR REPLACE VIEW V_EMP2
AS SELECT EMP_ID, EMP_NAME
    FROM EMPLOYEE;
-- Ȯ��
SELECT * FROM V_EMP2;


-- 4) WITH READ ONLY : �信 ���� ��ȸ�� �����ϰ� �ϴ� �ɼ� (DML �Ұ�)

CREATE OR REPLACE VIEW V_DEPT
AS SELECT * FROM DEPARTMENT
WITH READ ONLY;

SELECT * FROM V_DEPT;

DELETE FROM V_DEPT;
-- ORA-42399: cannot perform a DML operation on a read-only view


-- ���� �ǹ������� WITH READ ONLY�� �����







