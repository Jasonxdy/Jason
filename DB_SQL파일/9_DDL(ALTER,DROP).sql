
-- DDL



-- ALTER
-- ��ü�� �����ϴ� ����

/*
    [ǥ����]
    
    - ���̺� ��ü ���� ��
    ALTER TABLE ���̺��
    ������ ����
    
    
    - ������ ����
    1) �÷� �߰� / ���� / ����
    2) ���� ���� �߰� / ����
    3) �÷� �ڷ��� ����
    4) DEFAULT �� ����
    5) ���̺��, �÷���, �������Ǹ� ����
*/




-- 1. �÷� �߰�, ����, ���� 

SELECT * FROM DEPT_COPY;


-- �÷� �߰� (ADD)
ALTER TABLE DEPT_COPY
ADD (CNAME VARCHAR2(20));

SELECT * FROM DEPT_COPY;

-- �÷� �߰� �� DEFAULT �� ����
ALTER TABLE DEPT_COPY
ADD (LNAME VARCHAR2(40) DEFAULT '�ѱ�');

SELECT * FROM DEPT_COPY;



-- �÷� ���� (MODIFY)
ALTER TABLE DEPT_COPY
MODIFY DEPT_ID CHAR(3)
MODIFY DEPT_TITLE VARCHAR2(30)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY CNAME CHAR(20)
MODIFY LNAME DEFAULT '�̱�';

SELECT * FROM DEPT_COPY;

-- ����!
-- �÷��� ������ ���� ũ�⸦ ������ ��
-- ������ ��ϵ� ������ ���� ũ��δ� ���� �Ұ�

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(10);

-- LNAME �÷� DEFAULT�� '�ѱ�'���� �����ϱ�
ALTER TABLE DEPT_COPY
MODIFY LNAME DEFAULT '�ѱ�';

INSERT INTO DEPT_COPY
VALUES ('D11', '�����', 'L2', NULL, DEFAULT);

SELECT * FROM DEPT_COPY;




-- �÷� ���� (DROP COLUMN �÷���)

CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPT_COPY;

SELECT COLUMN_NAME, DATA_TYPE, NULLABLE, DATA_DEFAULT,COLUMN_ID, COMMENTS
FROM USER_TAB_COLUMNS -- ������ ���� �÷��� �ִ� ��ųʸ�
NATURAL JOIN USER_COL_COMMENTS -- ������ ���� �÷��� �ڸ�Ʈ�� �ִ� ��ųʸ�
WHERE TABLE_NAME = 'DEPT_COPY2';

-- �̶� DATA_DEFAULT���� ����� // �ֳĸ� ���̺� ���� �� NOT NULL ����� ���� �ȵ�


-- DEPT_ID �÷� ����
ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_ID;

-- Ȯ��
SELECT * FROM DEPT_COPY2;

SELECT COLUMN_NAME, DATA_TYPE, NULLABLE, DATA_DEFAULT,COLUMN_ID, COMMENTS
FROM USER_TAB_COLUMNS
NATURAL JOIN USER_COL_COMMENTS
WHERE TABLE_NAME = 'DEPT_COPY2';


-- ���̺��� ��� �÷� �����ϱ�

ALTER TABLE DEPT_COPY2
DROP COLUMN LNAME;

ALTER TABLE DEPT_COPY2
DROP COLUMN LOCATION_ID;

ALTER TABLE DEPT_COPY2
DROP COLUMN CNAME;

-- ������ ���̺��� ���� �Ұ�
ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_TITLE;
-- ORA-12983: cannot drop all columns in a table
--> ���̺� �����ִ� �÷��� ���ٸ� ���� �ǹ̰� �����Ƿ� �÷��� ������ ���� ����.


-- TCL�� �ۿ��� �� �ִ� ������ DML�� ����
-- DDL ������ ���ۿ� ������� �ʰ� �ٷ� DB�� �ݿ��� �ȴ�
    --> ����, DDL ���������� ROLLBACK �Ұ���
    
ROLLBACK;

SELECT * FROM DEPT_COPY2;


-- ���������� �����Ǿ��ִ� �÷� ����
CREATE TABLE TB1 (
    PK        NUMBER PRIMARY KEY,
    FK        NUMBER REFERENCES TB1,
    COL1      NUMBER, 
    CHECK (PK > 0 AND COL1 > 0) -- �ѹ��� 2�÷��� ���� �������� �ɱ�
);

SELECT * FROM TB1;


-- ���̺� ������ �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'TB1';


-- PK �÷� ����
ALTER TABLE TB1
DROP COLUMN PK;
--> �Ұ��� : ���� ���̺� �� �ٸ� �÷��� ������.. ���� ������ ���� ���Ἲ ����


-- ���� ��������(FK)�� �Բ� PK �÷� ����
ALTER TABLE TB1
DROP COLUMN PK CASCADE CONSTRAINTS;


-- �̶� 4���� �������� ��ü�� ������... ����
-- �ֳĸ�, CHECK�� ���� 2���� �ް� �ִ� ��� �Ѱ��� �����Ǿ ��Ʈ�� �����
-- �׸��� CASCADE�� ���־��� ������ FOREIGN KEY�� ������

--------------------------------------------------------------------------------------------------------------------------------

-- 2. �������� �߰� ����

-- DEPT_COPY ���̺��� �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';


-- �÷� �������� �߰� (ADD CONSTRAINT)
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DCOPY_DID_PK PRIMARY KEY (DEPT_ID)
ADD CONSTRAINT DCOPY_DTITLE_UNIQUE UNIQUE (DEPT_TITLE)
--> SQL ������ ���������� SQL DEVELPER ������ ���Ͽ� �������� ����
MODIFY LNAME CONSTRAINT DCOPY_LNAME_NN NOT NULL;

SELECT * FROM DEPT_COPY;



-- �������� ���� (DROP CONSTRAINT �������Ǹ�)
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DCOPY_DID_PK;



-- �������� ���� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';


-- DEPT_COPY ���̺� �ִ� ��� �������� ����
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DCOPY_DTITLE_UNIQUE
DROP CONSTRAINT DCOPY_LNAME_NN
DROP CONSTRAINT SYS_C007170
DROP CONSTRAINT SYS_C007171;

-- �������� ���� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';

-- NOT NULL �������� �������2
ALTER TABLE DEPT_COPY
MODIFY LNAME CONSTRAINT DCOPY_LNAME_NN NOT NULL;

-- �÷��� NULL ���� ����� �� �ְ� ����
ALTER TABLE DEPT_COPY
MODIFY LNAME NULL;

--------------------------------------------------------------------------------------------------------------------------------

-- 3. �÷���, �������Ǹ�, ���̺�� ����

-- �÷��� ���� (RENAME COLUMN �÷��� TO �����)
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY
RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

SELECT * FROM DEPT_COPY;


-- �������Ǹ� ���� (RENAME CONSTRAINT �������Ǹ� TO �����)
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DCOPY_DID_PK PRIMARY KEY (DEPT_ID)
ADD CONSTRAINT DCOPY_DTITLE_UNIQUE UNIQUE (DEPT_NAME)
MODIFY LNAME CONSTRAINT DCOPY_LNAME_NN NOT NULL;

-- DCOPY_DTITLE_UNIQUE ���������� 
-- DCOPY_DNAME_UNQ�� ����
ALTER TABLE DEPT_COPY
RENAME CONSTRAINT DCOPY_DTITLE_UNIQUE TO DCOPY_DNAME_UNQ;

-- �������Ǹ� ���� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';

--------------------------------------------------------------------------------------------------------------------------------


-- ���̺�� ���� (RENAME TO �����)

-- DEPT_COPY ���̺��� DEPT_TEST�� �̸� ����
ALTER TABLE DEPT_COPY
RENAME TO DEPT_TEST;

SELECT * FROM DEPT_COPY;
--> ���̺���� ����Ǿ� ��ȸ�� ���ٰ� ���� �߻�

SELECT * FROM DEPT_TEST;


--------------------------------------------------------------------------------------------------------------------------------


-- DROP
-- �����ͺ��̽� ��ü*�� �����ϴ� ����
-- * �����ͺ��̽� ��ü? TABLE, VIEW, SEQUENCE INDEX, SYNONYM, PROCEDURE���� ����

-- ���̺� ���� (DROP TABLE)
-- TB1 ���̺� ����
DROP TABLE TB1;

SELECT * FROM TB1;
--> �����Ǿ� ��ȸ �Ұ�

-- DEPT_TEST ���̺� ����
DROP TABLE DEPT_TEST;


CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

ALTER TABLE DEPT_COPY
ADD CONSTRAINT PK PRIMARY KEY (DEPT_ID);
-- Ȥ�� ADD PRIMARY KEY (DEPT_ID);

ALTER TABLE EMP_COPY
ADD CONSTRAINT FK FOREIGN KEY (DEPT_CODE) REFERENCES DEPT_COPY;
-- Ȥ�� ADD FOREIGN KEY (DEPT_CODE) REFERENCES DEPT_COPY;
-- �� CONSTRAINTġ�� CONSTRAINT���� ����� ��... �ణ ������ ����ϱ⵵ �ϳ�

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'EMP_COPY';


DROP TABLE DEPT_COPY;
--> EMP_COPY�� FOREIGN KEY �������ǿ� ���Ͽ� ���� �Ұ���

-- EMP_COPY�� FOREIGN KEY �������ǰ� �Բ� DEPT_COPY ���̺� �����ϱ�
DROP TABLE DEPT_COPY CASCADE CONSTRAINT;
-- ���ӵǾ��ִ� FOREIGN KEY�� �������ǵ� �����ȴ�!!











