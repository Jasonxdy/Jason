/*
    DCL (DATA CONTROL LANGUAGE) : ������ ���� ���
    
    - �����ͺ��̽�, �����ͺ��̽� ��ü�� ���� ���� ������ ����(�ο�,ȸ��)�ϴ� ���
    
    
    - DCL
    GRANT (���� �ο�)
    REVOKE (���� ȸ��)
    
    - TCL
    COMMIT
    ROLLBACK
    SAVEPOINT
    
*/

-- ������ ũ�� �ý���, ��ü �������� ������ ����


-- �ý��� ���� �ο� (GRANT)
-- ����ڿ��� ������ �ο��� �� ���

/*
    [ǥ���]
    
    GRANT ���� 1, ���� 2, ...
    TO ����ڰ�����

    * �ý��� ���� ����
    CREATE SESSION : �����ͺ��̽� ���� ����
    CREATE TABLE : ���̺� ����
    CREATE VIEW : �� ���� ����
    CREATE SEQUENCE : ������ ���� ����
    CREATE PROCEDURE : ���ν���(�Լ�) ���� ����
    CREATE USER : ���� ���� ����
    DROP USER : ���� ���� ����
    DROP ANY TABLE : ������ ���̺� ���� ����
*/


/*
    ������ ����
    - ������ ���� (SYS AS SYSDBA, SYSTEM)
    : �����ͺ��̽��� ������ ������ ����ϴ� �������� ��� ���Ѱ� å���� ������ ����
    
    - ����� ���� (EX. KH����)
    : �����ͺ��̽��� ���Ͽ� ����(SELECT), ����(DML), ���� �ۼ� ���� �۾��� ������ �� �ִ� ��������,
    ������ �ʿ��� �ּ����� ���Ѹ��� ������ ���� ��Ģ���� ��.
    
*/


-- �׽�Ʈ�� ���� SAMPLE ����
CREATE USER sample IDENTIFIED BY sample;
-- CMD -> SQLPLUS
    --> SAMPLE ���� �α��� �� USER SAMPLE LACKS CREATE SESSION PRIVILEGE; LOGON DENIED
    --> ���� ������ ��� �α��� �Ұ���
    
-- KH �������� SAMPLE ������ DB ���� ���� �ο�
GRANT CREATE SESSION TO SAMPLE;
--> ORA-01031: insufficient privileges
-- KH �������� DB ���� ������ �ο��� ������ ��� ���� �߻���

-- ������ �������� SAMPLE ������ DB ���� ���� �ο�
GRANT CREATE SESSION TO SAMPLE;
--> ���� ���� �ο� ����

-- SAMPLE �α��� ���� �� ���̺� ����
--> ORA-01950: no privileges on tablespace 'SYSTEM'
--> ���̺� ���� ������ ��� ���� �߻�

-- ������ �������� ���̺� ���� ������ �ο�

GRANT CREATE TABLE TO SAMPLE;
--> �ٽ� SQLPLUS���� ���̺� ����
--> ORA-01950: no privileges on tablespace 'SYSTEM'
--> �� ���� �߻�

-- ���̺� �����̽� (TABLE SAPCE)
-- ���̺�, ��, �ε��� �� DB ��ü���� ����Ǵ� ���� ����
-- ���̺� �����̽� �Ҵ緮 �ο�
ALTER USER SAMPLE QUOTA 2M ON SYSTEM;
-- �ٽ� SQLPLUS���� ���̺� ����

-----------------------------------------------------------------------------------------------------------------------------

-- ��ü ���� �ο�

-- ��ü ���� : Ư�� DB ��ü�� ������ �� �ִ� ������ �ο�
/*

    [ǥ���]
    
    GRANT �������� [(�÷���) | ALL]
    ON ��ü�� | ROLE �̸� | PUBLIC
    TO ����ڰ�����

    * ��ü ���� ����
    [���� ����]            [���� ��ü]
    SELECT(DML)           TABLE, VIEW, SEQUENCE
    INSERT(DML)           TABLE, VIEW
    UPDATE(DML)           TABLE, VIEW
    DELETE(DML)           TABLE, VIEW
    ALTER(DDL)            TABLE, SEQUENCE
    REFERENCES            TABLE
    INDEX                 TABLE
    EXECUTE(.EXE ����)     PROCEDURE
    
*/


-- SQLPLUS���� SAMPLE �������� KH ������ EMPLOYEE ���̺� ��ȸ
SELECT * FROM kh.EMPLOYEE; -- ���� ġ�� ���� CMD���� �ľ���
--> ORA-00942: table or view does not exist
-- ���� ������ ��� ������ �ʴ� ����

-- ������ �������� SAMPLE �������� KH ������ EMPLOYEE ���̺� ��ȸ ���� �ο�
GRANT SELECT ON kh.EMPLOYEE TO SAMPLE;


-- ���� ȸ�� (REVOKE)

-- ������ �������� SAMPLE �������� �ο��� kh.EMPLOYEE ���̺� ��ȸ ������ ȸ���ϱ�
REVOKE SELECT ON KH.EMPLOYEE FROM SAMPLE;
-- ������ ȸ���Ǿ� KH.EMPLOYEE ��ȸ �� ���� �߻�



-- SAMPLE ���� DB ���� ���� ȸ��
REVOKE CREATE SESSION FROM SAMPLE;
-- ORA-01045: user SAMPLE lacks CREATE SESSION privilege; logon denied
-- ���� �Ұ�




/* (�߿�)

    ROLE : ����ڿ��� �㰡�� �� �ִ� ���ѵ��� ����.
            ROLE�� �̿��ϸ� ���� �ο��� ȸ���� ������.
    
    
    CONNECT : ����ڰ� ������ ���̽��� ���� �����ϵ��� �ϱ� ����
            CREATE SESSION ������ �ۼ��Ǿ� �ִ� ROLE // �̰� �ϳ��� ����.. ���� ���������� �����ϱ� ���� ��
    
    
    RESOURCE : CREATE ������ ���� ��ü ���� ���Ѱ� 
               INSERT, UPDATE, DELETE ������ ����� �� �ִ� ������ ��Ƴ��� ROLE

*/

-- ������ �������� SAMPLE ������ CONNECT, RESOURCE ROLE �ο�

GRANT CONNECT, RESOURCE TO SAMPLE;

--------------------------------------------------------------------------------------------------------------------------------

-- TCL (TRANSACTION CONTROL LANGUAGE) : Ʈ����� ���� ���

-- TRANSACTION �̶�?
/*

    - �����ͺ��̽��� ���� ���� ����
    - ������ ���� ������ ���� �ϳ��� Ʈ����ǿ� ��� ó����. // Ʈ����� �ָӴϰ��� ��
    - Ʈ������� ����� �Ǵ� SQL : INSERT, UPDATE, DELETE (DML) // Ʈ����� �������
    
    
    * COMMIT / ROLLBACK
    - COMMIT �Ǵ� ROLLBACK ����� �ԷµǱ� �� ������ ������ ���������
      �޸� ���ۿ� �ӽ� ����Ǿ� �ִ� ���·� ����.

    - COMMIT : �޸� ���ۿ� �ӽ� ����� �����͸� DB�� �ݿ�   
    - ROLLBACK : �޸� ���ۿ� �ӽ� ����� �����͸� �����ϰ� ������ COMMIT ���·� ���ư�
    
    
    * SAVEPOINT
    - ���� ������ �����ϸ� �ѹ��� �� Ʈ����ǿ� ���Ե� ��ü �۾��� �ѹ��ϴ� ���� �ƴ�
      �� �������� ������ SAVEPOINT���� Ʈ����� �Ϻθ� �ѹ�
      
*/

INSERT INTO MEMBER
VALUES('MEM5', '12345678', '�̼���', SYSDATE);

SELECT * FROM MEMBER;
-- �̶� �д°��� �޸𸮹��ۿ��� �д� ��

COMMIT; --> ���� ������� DB �ݿ�

DELETE FROM MEMBER
WHERE MEMBER_ID = 'MEM5';

SELECT * FROM MEMBER;

ROLLBACK; -- ��������� �ݿ����� �ʰ� �ֱ� COMMIT ���·� ���ư�

SELECT * FROM MEMBER;

DELETE FROM MEMBER
WHERE MEMBER_ID = 'MEM5';

-- MEM5�� ������ ���¸� SAVEPOINT�� ����
SAVEPOINT SP1;

-- MEM4�� �����غ���
DELETE FROM MEMBER
WHERE MEMBER_ID = 'MEM4';

SELECT * FROM MEMBER;

-- SP1���� ROLLBACK
ROLLBACK TO SP1;
-- �׳� ROLLBACK�ϸ� COMMIT������ ���ư�
































