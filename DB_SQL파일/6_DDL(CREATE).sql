/*
    ������ ��ųʸ���?
    - �ڿ��� ȿ�������� �����ϱ� ���� �پ��� ������ �����ϴ� �ý��� ���̺�
    - ������ ��ųʸ��� ����ڰ� ���̺��� �����ϰų� ����ڸ� �����ϴ� ����
    �۾��� ������ �� �����ͺ��̽� ������ ���� �ڵ����� ���ŵǴ� ���̺�
    
    - USER_TABLES : ����� ������ ������ ���̺��� ������ ��ȸ�� �� �ִ� ��ųʸ� ��
    - USER_TAB_COLUMNS : ����ڰ� �ۼ��� ���̺��� �÷��� ���õ� ���� Ȯ�ο� VIEW
    - USER_CONSTRAINTS : ����ڰ� �ۼ��� ���������� Ȯ���ϴ� VIEW
    - USER_CONS_COLUMNS : ���� ������ �ɷ��ִ� �÷� Ȯ�ο� VIEW
    
    
    // ORACLE DBMS�� �ڵ����� ������ָ� �ڿ��� ������ ���� ������� ���� �ɵ�
*/



/*

    DDL (DATA DEFINITION LANGUAGE) : ������ ���� ���
    
    - ��ü (OBJECT)�� ����� (CREATE), �����ϰ� (ALTER), ���� (DROP)�ϴ� ���� 
    �������� ��ü���� ������ �����ϴ� ���� �ַ� DB������, �����ڰ� ����ϴ� ���
    
    * ����Ŭ���� ��ü(OBJECT) ����
      ���̺� (TABLE), �� (VIEW), ������ (SEQUENCE), �ε��� (INDEX), ��Ű��(PACKAGE),
      Ʈ���� (TRIGGER), ���ν��� (PROCEDURE), �Լ� (FUNCTION), ���Ǿ� (SYNONYM), ����� (USER)
      
*/
    ---------------------------------------------------------------------------------------
 
 /*
    <CREATE>
    - ���̺��̳� �ε���, �� �� �پ��� DB ��ü�� �����ϴ� ����
    
    1. ���̺� �����
    - ���̺��̶�?
        ��(ROW)�� ��(COLUMN)���� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü
    
    �����ͺ��̽� ������ ��� �����ʹ� ���̺��� ���� �����.
    
    
    [ǥ����]
    CREATE TABLE ���̺��(
        �÷���  �ڷ���(ũ��)  [��������]  [�⺻��],
        �÷���  �ڷ���(ũ��)  [��������]  [�⺻��],
        ... //���ϴ¸�ŭ
        
        [��������]
    );

 */
 
 CREATE TABLE MEMBER (
 MEMBER_ID          VARCHAR2(20),
 MEMBER_PWD         VARCHAR2(20),
 MEMBER_NAME       VARCHAR2(30),
 ENROLL_DATE        DATE DEFAULT SYSDATE --> �⺻��
 );
 
 
 -- ���̺� ���� Ȯ��
 SELECT * FROM MEMBER;
 
 SELECT * FROM USER_TABLES;
 -- USER_TABLES : ����ڰ� �ۼ��� ���̺��� Ȯ���� �� �ִ� ������ ���̺� (== VIEW)
 -- ������ ��ųʸ��� ���ǵǾ� ����
 
 
 -- �÷� �ڸ�Ʈ(�ּ�) �߰�
 COMMENT ON COLUMN MEMBER.MEMBER_ID IS 'ȸ�����̵�';
 COMMENT ON COLUMN MEMBER.MEMBER_PWD IS 'ȸ����й�ȣ';
 COMMENT ON COLUMN MEMBER.MEMBER_NAME IS 'ȸ���̸�';
 COMMENT ON COLUMN MEMBER.ENROLL_DATE IS 'ȸ��������';
 
 
 -- ������ ���̺� �÷� ���� Ȯ��
 SELECT * FROM USER_TAB_COLUMNS
 WHERE TABLE_NAME = 'MEMBER';
 -- USER_TAB_COLUMNS : ����ڰ� �ۼ��� ���̺��� �÷��� ���õ� ���� Ȯ�ο� VIEW

 DESC MEMBER;
-- DESC(DESCRIBE, ������ ����) : ���̺��� ������ ������ ǥ���ϴ� ����
--  �� ����Ŭ������ ����� �� �ִ�

 
 
 -- ���� ������ ����
 INSERT INTO MEMBER
 VALUES ('MEM1', '1234ABCD','ȫ�浿','2019-11-20' /*�̷������� �ᵵ DATE���·� �˾Ƽ� ��ȯ*/);
 
 INSERT INTO MEMBER
 VALUES ('MEM2', 'QWER1234','�迵��', SYSDATE);
 
 INSERT INTO MEMBER
 VALUES ('MEM3', '1Q2W3E4R','��ö��', DEFAULT); -- DEFAULT�� �ص� �����س��� ������
 
 INSERT INTO MEMBER (MEMBER_ID, MEMBER_PWD, MEMBER_NAME) -- ���� �� ���� ����
 VALUES ('MEM4', 'ZXCV9876','������');
 -- DEFAULT�� ������ �÷��� ���� �������� �ʾƵ� �⺻������ �����
 
 
 SELECT
     *
 FROM MEMBER;
 
 ----------------------------------------------------------------------------------------------------------
 
 
 -- ���� ����(CONSTRAINTS)
 /*
    - ����ڰ� ���ϴ� ������ �����͸� �����ϱ� ���ؼ� Ư�� �÷��� �����ϴ� ����
    // ���� ��� MEMBER_ID�� ��� �ߺ��Ǹ� �ȵǱ� ������ �ߺ� ������ �������� �Ǵٴ���..
    
    - ���̺� �ۼ� �� �÷��� ���� �� ��Ͽ� ���� �������� ���� ����
    
    - �������� ���Ἲ�� �����ϱ� ���ؼ� ���
    
    - �Է� �����Ϳ� ������ ������ �ڵ����� �˻��� �������� ���
    
    - �������� ����/���� ���� ���� �˻� �������� ���
    // RDBMS�� ��� ���̺���� ���������� ���� (JOIN)�Ǿ� �ִµ� �ϳ��� ���� Ȥ�� ���� ��
    ����Ǿ� �ִ� ���̺��̶� ���踦 ���� ������ �����ϱ� ���� ���
    
    
    * ���� ������ ����
    PRIMARY KEY
    UNIQUE
    NOT NULL
    CHECK
    FOREIGN KEY
    
 */
 
 
 
 -- NOT NULL ��������
 -- �ش� �÷��� �ݵ�� ���� ��ϵǾ�� �ϴ� ��쿡 ����ϴ� ���� ����
 -- ������ ����, ���� �� NULL ���� ������� �ʵ���
 -- ** �÷� �������� ����
 
 
 CREATE TABLE MEM_NOCONST (
    MEM_NO      NUMBER,
    MEM_ID      VARCHAR2(20),
    MEM_PWD     VARCHAR2(20),
    MEM_NAME    VARCHAR2(30),
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50)
 );
 
 INSERT INTO MEM_NOCONST
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_NOCONST
 VALUES (2, NULL, NULL, NULL, NULL, '010-1234-5678','aaa@kh.or.kr');
 -- �ʼ� �Է»����� ���̵�, ��й�ȣ�� ����... ���� ������ �ɾ��!
 SELECT
     *
 FROM MEM_NOCONST;
 
 -- NOT NULL ���� ������ ������ ���̺� ����
 
 -- ���̺� ���� �� �������� ���� ���
 -- 1) �÷� ���� ��� : �÷� ���� �� �÷� ���ʿ� �������� �߰� ���
 -- 2) ���̺� ���� ��� : ���̺� ���� ���� �������� ������ ���� ���� �߰�
 
 
 CREATE TABLE MEM_NOTNULL (
    MEM_NO      NUMBER NOT NULL,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50)
 );
 
 -- ���� ���� Ȯ��
 SELECT * FROM USER_CONSTRAINTS;
 -- USER_CONSTRAINTS : ����ڰ� �ۼ��� ���������� Ȯ���ϴ� VIEW
 
 SELECT * FROM USER_CONS_COLUMNS;
 -- USER_CONS_COLUMNS : ���� ������ �ɷ��ִ� �÷� Ȯ�ο� VIEW
 
 INSERT INTO MEM_NOTNULL
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_NOTNULL
 VALUES (2, NULL, NULL, NULL, NULL, '010-1234-5678','aaa@kh.or.kr');
 --> NOT NULL ���� ������ �����Ͽ� ���� �߻�! (ORA-01400)
 
 SELECT
     *
 FROM MEM_NOTNULL;
 
 
 ------------------------------------------------------------------------------------------
 -- * UNIQUE ��������
 -- �÷� �Է� ���� ���ؼ� �ߺ��� �����ϴ� ���� ����
 -- �÷��� �����ϴ� ������ ������ �� �ߺ��� ������ �ȵ�.
 -- �÷�����, ���̺��� ��� ���� ����
 
 INSERT INTO MEM_NOTNULL
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 -- ������ �ߺ��� ���� �������� UNIQUE�� ������ ���̺� ����
 CREATE TABLE MEM_UNIQUE (
    MEM_NO      NUMBER NOT NULL UNIQUE,
    MEM_ID      VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50)
 );
 -- �÷� ������ �������� ���� �� ���⸦ ���� ���� �� ���� ����
 
 INSERT INTO MEM_UNIQUE
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 SELECT * FROM MEM_UNIQUE;
 
 
 -- ���� ���� ��Ÿ�� �������Ǹ��� �̿��Ͽ� �ش� ���������� ������ ���̺��, �÷���, �������� Ÿ�� ��ȸ
 
 SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME, UC.CONSTRAINT_TYPE
 FROM USER_CONSTRAINTS UC, USER_CONS_COLUMNS UCC -- ����Ŭ ��� JOIN
 WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME 
 AND UCC.CONSTRAINT_NAME = 'SYS_C007053';
 
 
 
 -- ���̺� ���� �������� ���� ����
 -- [CONSTRAINT �������Ǹ�] ��������(�÷���)
  -- ���̺� ���� �������� ���� ���
 
 CREATE TABLE MEM_UNIQUE2 (
    MEM_NO      NUMBER NOT NULL,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50),
    CONSTRAINT MEM_UNIQUE2_MEM_NO /*�̸��� �������� Ȯ�ν� Ȯ���ϱ� ���� �̸����� ����*/ UNIQUE(MEM_NO),
    CONSTRAINT MEM_UNIQUE2_MEM_ID UNIQUE(MEM_ID)
 );
 --// ��...���̺������� �������� ���� �� �׳� �������� Ȯ���ϱⰡ ���ٴ� ������ �ִ°ǰ�..?
 
 INSERT INTO MEM_UNIQUE2
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 
 
 ----------------------------------------------------------------------------------------------------------
 
 
 -- ����Ű
 -- �ΰ� �̻��� �÷��� ��� �������� ����
 -- UNIQUE, PRIMARY KEY ����
 -- * �ݵ�� ���̺� �����θ� ����
 
 CREATE TABLE MEM_UNIQUE3 (
    MEM_NO      NUMBER NOT NULL,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50),
    UNIQUE(MEM_NO, MEM_ID)
 );
 
 -- // ����Ű�� ��� ���������� ���� �ɾ��� �������� �÷����� �׵��� ���ļ� �ߺ� �˻縦 �ϱ� ������
 -- // 1, A �ְ� 2, A�־ �ٸ��ɷ� �ν��� (�÷�����, ���̺����� �ٸ� ����)
 
 INSERT INTO MEM_UNIQUE3
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_UNIQUE3
 VALUES (2,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_UNIQUE3
 VALUES (2,'user02', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_UNIQUE3
 VALUES (2,'user02', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 SELECT * FROM MEM_UNIQUE3;
 
 
 
 -- �÷� ������ �������� �����ϱ�
 
 CREATE TABLE MEM_NOTNULL2 (
    MEM_NO      NUMBER CONSTRAINT MEM_NN2_NO_NN NOT NULL,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50)
 );
 
 -- ���� ���� �̸� Ȯ��
 
 SELECT * FROM
 USER_CONS_COLUMNS C1
 JOIN USER_CONSTRAINTS C2 USING (CONSTRAINT_NAME)
 WHERE C2.TABLE_NAME = 'MEM_NOTNULL2';
 
 ------------------------------------------------------------------------------------------------------
 
 -- CHECK ���� ����
 -- �÷��� ��ϵǴ� ���� ������ �� �ִ� ��������
 -- CHECK(�÷���  �񱳿�����  �񱳰�)
 --> �񱳰����δ� ���ͷ��� ��� ���� (���� �� �ִ� ���̳�, �Լ��� ��� �Ұ���!!!!)
 -- �÷�, ���̺� ���� ��� ���� ����
 
 
 CREATE TABLE MEM_CHECK (
    MEM_NO      NUMBER NOT NULL,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1) CHECK (MEM_GENDER IN ('M', 'F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50),
    CONSTRAINT MEM_CHECK_MEM_NO UNIQUE(MEM_NO),
    CONSTRAINT MEM_CHECK_MEM_ID UNIQUE(MEM_ID)
    -- CHECK (MEM_GENDER IN ('M', 'F')) // ���⿡ �δ� ��� ���̺��� 
 );
 
 INSERT INTO MEM_CHECK
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_CHECK
 VALUES (2,'user02', 'pass02', 'ȫ���', 'F', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_CHECK
 VALUES (3,'user03', 'pass03', 'ȫ�浿', 'A', '010-1234-1234','gd_hong123@kh.or.kr');
 -- ������ M �Ǵ� F�� �ƴ϶� CHECK ������
 -- ���� FRONT END �ܿ��� �ٷιٷ� ó���ǹǷ� ���� ���� ������ ����..
 
 SELECT * FROM MEM_CHECK;
 
 ------------------------------------------------------------------------------------------------------
 
 -- PRIMARY KEY (�⺻Ű) ���� ����
 -- ���̺��� �� ���� ������ �ĺ��� �� �ְ� �ϱ� ���Ͽ� ����� �÷��� �߰��ϴ� ���� ����
 --> �� ����� ������ �� �ִ� �ĺ��� ������ ������ ��� ���
 -- EX) ȸ����ȣ, �μ��ڵ�, �����ڵ�, ��������ȣ, �ֹε�Ϲ�ȣ
 
 -- PRIMARY KEY�� NOT NULL �������� + UNIQUE ��������
 -- // �� NOT NULL �̸鼭 UNIQUE��� PRIMARY KEY�� �ƴϴ�!
 -- �� ���̺�� '�ѹ���' (�� �÷� �Ǵ� ����Ű) ���� ����
 -- �÷�, ���̺� ���� ��� ���� ����
 
 
 CREATE TABLE MEM_PRIMARYKEY (
    MEM_NO      NUMBER PRIMARY KEY,
    MEM_ID      VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1) CHECK (MEM_GENDER IN ('M', 'F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50)
    -- PRIMARY KEY (MEM_NO)
    -- CONASTRAINT MEM_PK PRIMARY KEY (MEM_NO) : �̰͵��� ���̺� ���� ��������
 );
 
 -- NOT NULL + UNIQUE ���� ������ �� �÷��� �����Ͽ��� �ش� �÷��� PRIMARY KEY�� ���� �ƴϴ�.
 -- PRIMARY KEY�� ���̺� ������ �� ����� �ĺ�(����)���ִ� ������ ���� �����ϴ� ���̱� ������
 -- �ߺ� X, NULL �� ���� X�� ���� ���������̾ �ǹ̰� �ٸ���.
 
 INSERT INTO MEM_PRIMARYKEY
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_PRIMARYKEY
 VALUES (1,'user02', 'pass02', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 -- UNIQUE CONSTRAINT ������
 
 INSERT INTO MEM_PRIMARYKEY
 VALUES (NULL,'user02', 'pass02', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 -- NULL �������� ������
 
 
 SELECT * FROM MEM_PRIMARYKEY;
 
 
 
 
 -- PRIMARY KEY ����Ű ��� --> ���̺� ������ ����
 
 CREATE TABLE MEM_PRIMARYKEY2 (
    MEM_NO      NUMBER,
    MEM_ID      VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    MEM_GENDER  CHAR(1) CHECK (MEM_GENDER IN ('M', 'F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(50),
    CONSTRAINT MEM_PK2_PK PRIMARY KEY(MEM_NO, MEM_ID)
 );
 
 -- PRIMARY KEY�� ����Ű�� ����� ��� �ӵ������� ������ ����
 INSERT INTO MEM_PRIMARYKEY2
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM_PRIMARYKEY2
 VALUES (1,'user02', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 -- ������ ����Ű�� ������ �Ǿ� �ֱ⶧���� �ѽ��� INDEX�� ��
 
 INSERT INTO MEM_PRIMARYKEY2
 VALUES (NULL,'user02', 'pass01', 'ȫ�浿', 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 -- ���󿡼��� ���� ���� ���̵�, �̸����� PRIMARY KEY�� ����
 
 SELECT * FROM MEM_PRIMARYKEY2;
 
 ------------------------------------------------------------------------------------------------------------------
 
 -- *****  FOREIGN KEY (�ܷ�Ű) ���� ����
 -- �ش� �÷��� ������ �ٸ� ���̺��� �����ϴ� ���� ����� �� �ֵ��� �ϴ� ���� ����
 -- // ���� : �ڹٿ����� ������ ���� (��ü ��� ���̺��� �����Ѵٰ� �����ϸ� ��)
 -- // �ٸ� ���̺��� �����ϴ� ���� CHECK ��������ó�� ����Ѵٰ� �����ϸ� �ɵ�
 
 
 -- ������ �����ͺ��̽� (RDBMS)
 -- �� ���踦 �α� ���� ����ϴ� ���������� FOREIGN KEY
    --> ���̺��� ����� ����
 -- �̶�, �θ� ���̺� (�����ϴ� ���̺�)�� PRIMARY KEY�� �ڽ� ���̺�(������ �ϴ� �÷��� ������ ���̺�)��
 -- FOREIGN KEY�� ������ �ϰԵ�
 -- �÷�, ���̺� ���� ��� ����
 
 -- ȸ�� ����� ��Ÿ���� ���̺� (�θ����̺�)
 CREATE TABLE MEM_GRADE(
    GRADE_CODE          NUMBER PRIMARY KEY,
    GRADE_NAME          VARCHAR2(30) NOT NULL
 );
 
 INSERT INTO MEM_GRADE VALUES (10, '�Ϲ�ȸ��');
 INSERT INTO MEM_GRADE VALUES (20, '���ȸ��');
 INSERT INTO MEM_GRADE VALUES (30, 'Ư��ȸ��');
    
 SELECT * FROM MEM_GRADE;
 
 -- ȸ�� ���̺� ���� (�ڽ����̺�)
 CREATE TABLE MEM (
    MEM_NO      NUMBER PRIMARY KEY,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    GRADE_CODE  NUMBER REFERENCES MEM_GRADE (GRADE_CODE),
    MEM_GENDER  CHAR(1) CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(20)
    -- FOREIGN KEY (GRADE_CODE) REFERENCES MEM_GRADE[(GRADE_CODE)]
                                                    --> FOREIGN KEY ���� �� �ڵ����� �θ� �⺻Ű(PRIMARY KEY)�� �����ϹǷ�
                                                    --  [����] �����ϴ�...!!!
 );
 
 --> ȸ�� ����� 10, 20, 30, NULL�� ����
    --> �θ� ���̺� (MEM_GRADE�� GRADE_CODE�� �ִ� ���� ����...!)
 INSERT INTO MEM
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 10, 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM
 VALUES (2,'user02', 'pass02', 'ȫ���', 20, 'F', '010-1234-1111','gd_hong1234@kh.or.kr');
 
 INSERT INTO MEM
 VALUES (3,'user03', 'pass03', '�̼���', 30, 'M', '010-1234-2222','gd_hong1235@kh.or.kr');
 
 INSERT INTO MEM
 VALUES (4,'user04', 'pass04', '������', NULL, 'M', '010-1234-3333','gd_hong1236@kh.or.kr');
 
 INSERT INTO MEM
 VALUES (5,'user05', 'pass05', '�ȵɵ�', 40, 'M', '010-1234-3333','gd_hong1236@kh.or.kr');
 -- �Է��Ϸ��� �� �� GRADE_CODE�� �θ� ���̺� �������� �ʾ� ã�� �� ���� (= ������ �� ����)��� ������ �߻���Ŵ
 -- //integrity constraint (KH.SYS_C007106) violated - parent key not found
        --> �̷� ��Ȳ�� ���� ���Ἲ�� ����� ��Ȳ�̶�� ��.
 
 -- ���� ���Ἲ
 -- �����ϴ� ���̺��� �÷� ���� ���� �����͸� ������ �� �����ϴ� ��
 -- // �����ϴ� ���̺��� �÷� ���� ���� �����͸� �����ϴ� ��� �������� ���ϼ��� ������ ������ RELATIONAL�� �ǹ̰� ����Ǿ� ������..!
 
 SELECT * FROM MEM;
 
 -- FOREIGN KEY�� ����� ������ �ϱ� ������ ���̺��� �����Ͽ� ��ȸ�ϴ� JOIN ������ ����� �÷����� ����.
 
 -- JOIN�ؼ� ��ȸ�ϱ�
 SELECT MEM_ID, MEM_NAME, GRADE_CODE, GRADE_NAME
 FROM MEM
 LEFT JOIN MEM_GRADE USING (GRADE_CODE);
 
 
 
 -- �θ� ���̺��� ���� ������ ���
 DELETE FROM MEM_GRADE
 WHERE GRADE_CODE = 10;
 -- �ڽ� ���̺��� GRADE_CODE�� 10�� ���� ����� �Ǿ� �־� ���� �� ���� ���Ἲ�� �����ϰ� �Ǿ� ������ �߻���.
 
 
 
 -- FOREIGN KEY ���� �ɼ�
 -- �θ� ���̺��� ������ ���� �� �ڽ� ���̺� ��ϵ� �����͸� ���� �Ǵ� NULL�� ��ȯ�ϴ� �ɼ�
 
 -- 1) ON DELETE SET NULL
 -- �θ� ���̺� ������ ���� �� �ڽ� ������ NULL�� �����ϴ� �ɼ�
 
 
 CREATE TABLE MEM2 (
    MEM_NO      NUMBER PRIMARY KEY,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    GRADE_CODE  NUMBER REFERENCES MEM_GRADE (GRADE_CODE) ON DELETE SET NULL,
    MEM_GENDER  CHAR(1) CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(20)
 );
 
 INSERT INTO MEM_GRADE
 VALUES(40, 'VVVIP');
 
 INSERT INTO MEM2
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 10, 'M', '010-1234-1234','gd_hong123@kh.or.kr');
 
 INSERT INTO MEM2
 VALUES (2,'user02', 'pass02', 'ȫ���', 20, 'F', '010-1234-1111','gd_hong1234@kh.or.kr');
 
 SELECT * FROM MEM2;
 
 -- �ڽ� ���̺� �� �ƹ��� �����ϰ� ���� ���� �� 40�� ����
 DELETE FROM MEM_GRADE
 WHERE GRADE_CODE = 40;
 --> ������ �����ص� ���� ���Ἲ�� ������ �����Ƿ� ����
 
 -- �ǽ��� ���� �ٽ� �߰�
 INSERT INTO MEM_GRADE
 VALUES (40, 'VVVIP');
 
 -- �ڽ� ���̺� GRADE_CODE = 40�� ������ �߰�
 INSERT INTO MEM2
 VALUES (3,'user03', 'pass03', '��浿', 40, 'M', '010-1234-1235','gd_hong123@kh.or.kr');
 
 -- �ϴ� Ȯ��
 SELECT * FROM MEM2;
 SELECT * FROM MEM_GRADE;
 
 -- �θ� ���̺��� �ڽĿ� ���� ���ϰ� �ִ� �÷� �� ����
 DELETE FROM MEM_GRADE WHERE GRADE_CODE = 40;
 
 -- ���� �� �ڽ� ���̺� Ȯ��
 SELECT * FROM MEM2;
 --> GRADE_CODE�� 40�� �÷� ���� NULL�� ��ȯ
    --> ���� ���Ἲ�� ������
    
 
 -- 2) ON DELETE CASCADE �ɼ�
 -- �θ� ���̺� ������ ���� �� �ش� �����͸� �����ϰ� �ִ� �ڽ� ���̺��� ���� ������Ű�� �ɼ�
 
 -- // �̷��� '��ܽ� ����'��� ��
 
 CREATE TABLE MEM3 (
    MEM_NO      NUMBER PRIMARY KEY,
    MEM_ID      VARCHAR2(20) NOT NULL,
    MEM_PWD     VARCHAR2(20) NOT NULL,
    MEM_NAME    VARCHAR2(30) NOT NULL,
    GRADE_CODE  NUMBER REFERENCES MEM_GRADE (GRADE_CODE) ON DELETE CASCADE,
    MEM_GENDER  CHAR(1) CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE   VARCHAR2(20),
    MEM_EMAIL   VARCHAR2(20)
 );
 
 
 INSERT INTO MEM_GRADE
 VALUES(40, 'VVVIP');
 
 INSERT INTO MEM3
 VALUES (1,'user01', 'pass01', 'ȫ�浿', 10, 'M', '010-1234-1234','gd_hong123@kh.or.kr');

 INSERT INTO MEM3
 VALUES (2,'user02', 'pass02', 'ȫ���', 20, 'F', '010-1234-1111','gd_hong1234@kh.or.kr');
 
 INSERT INTO MEM3
 VALUES (3,'user03', 'pass03', '��浿', 40, 'M', '010-1234-1235','gd_hong123@kh.or.kr');
 
 SELECT * FROM MEM3;
 SELECT * FROM MEM_GRADE;
 
 -- �θ� ���̺��� �÷��� �� ���� ���ϰ� �ִ� �� ����
 DELETE FROM MEM_GRADE
 WHERE GRADE_CODE = 40;
 
 -- ���� �� �ڽ� ���̺� Ȯ��
 SELECT * FROM MEM3;
 
 
 ------------------------------------------------------------------------------------------------------------
 
 -- SUBQUERY�� �̿��� ���̺� ����
 -- ���̺� ����, Ư�� ��ȸ ���¸� ������ ���̺� ����
 -- �÷���, ������Ÿ��, �÷� ���� ��� ����ǰ� 
 -- ���������� NOT NULL�� ���簡 ��...(!!)
 
 
 -- EMPLOYEE ���̺� ����
 CREATE TABLE EMPLOYEE_COPY
 AS SELECT * FROM EMPLOYEE;
 -- DDL���� ���Ǵ� SUBQUERY�� ��ȣ �Ƚᵵ ��...? ������ ����������?
 
 SELECT * FROM EMPLOYEE;
 
 
 -- ���, �̸�, �޿�, �μ���, ���޸��� �����ϰ� �ִ� ���̺� ����
 CREATE TABLE EMPLOYEE_COPY2
 AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE, JOB_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN JOB USING (JOB_CODE);
 
 SELECT * FROM EMPLOYEE_COPY2;
    --> �̷��� �̾Ƽ� ���̺� ������ �����ϴ�
    
 
 -- ���̺��� �÷�, ������ Ÿ�Ը� �����ϱ�
 CREATE TABLE EMPLOYEE_COPY3
 AS SELECT * FROM EMPLOYEE
 WHERE 1 = 0;
    --> WHERE���� �װ� ���� ����� �ุ ��ȸ��... ���� �ƿ� ������ ���� �����ϸ�
    -- �÷�, ������Ÿ�Ը� ����ȴ�!
 
 SELECT * FROM EMPLOYEE_COPY3;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 