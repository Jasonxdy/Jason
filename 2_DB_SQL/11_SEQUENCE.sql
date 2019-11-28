

-- SEQUENCE
-- ���������� ���� ���� �ڵ����� �����ϴ� ��ü
-- �ڵ� ��ȣ �߻��� ������ ��
    --> ���� PRIMARY KEY�� �����ϴ� ���ҿ� ����. (������ �߰��Ȱ��� ����ϰ� ����� ���� �����ϱ�..)

/*  [ǥ����]
    CREATE SEQUENCE ��������
�� [START WITH ����]               ->       ó�� �߻���ų ���� ��, �⺻�� 1
�� [INCREMENT BY ����]             ->       ���� ���� ���� ����ġ, �⺻�� 1
�� [MAXVALUE ���� | NOMAXVALUE]    ->       �߻���ų �ִ밪, 10�� 27��-1���� ����
�� [MINVALUE ���� | NOMINVALUE]    ->       �߻���ų �ּҰ�, -10�� 26��
�� [CYCLE | NOCYCLE]               ->      �������� �ִ밪���� ���� �Ϸ� ��
                                            CYCLE�� START WITH ���� ������ ���ư�
                                            NOCYCLE�� ���� �߻�
�� [CACHE | NOCACHE]              ->       CACHE�� �޸� �󿡼� ������ �� ����
                                            �⺻�� 20
*/


CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

-- ����ڰ� ������ ������ Ȯ��
SELECT * FROM USER_SEQUENCES;
-- ���⼭ LAST_NUMBER : ���������� SEQUENCE�� �ҷ��� ��


--------------------------------------------------------------------------------------------------------------------------------


--  SEQUENCE ���
/*
    ��������.CURRVAL // CURRENT VALUE : ���� ������ �������� �� (=LAST_VALUE)
    
    ��������.NEXTVAL : �������� ������Ų ��
            -���� ������ ������ INCREMENT BY�� ������ ũ�⸸ŭ ������ ��
            
*/

-- ** ������ ���� NEXTVAL�� ������ �Ŀ��� CURRVAL ȣ���� ������
/*
    CURRVAL�� ���������� ������ NEXTVAL�� ���� �����Ͽ� �����ִ� �ӽ� ��
    // �� NEXTVAL�� �����ؾ����� CURRVAL�� ����� ��
    
    ������ ���� ���� �ѹ��� NEXTVAL�� ȣ������ ������ ������ �߻���.
*/

-- NEXTVAL �������� �ʰ� CURRVAL ȣ���ϱ�
SELECT SEQ_EMPID.CURRVAL FROM DUAL; --> ���� �߻� (���� ���۵� ���ߴµ� CURRVAL�� ����ĸ鼭 ������)

-- NEXTVAL ���� �� CURRVAL ȣ���ϱ�
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
--> NEXTVAL�� ������ ���� �� ó������ ����� ��� START WITH ���� ��ȯ�Ѵ�

SELECT SEQ_EMPID.CURRVAL FROM DUAL;
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 315? --> ���� �߻�
--> ������ MAXVALUE ���� �ʰ��� �� ����

SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- 310
--> CURRVAL�� ���������� ������ ������ NEXTVAL ���� ��ȯ



-- ����� ������ ���ο� �������� �����Ͽ� ���ο� ��� �߰�
CREATE SEQUENCE SEQ_EID
START WITH 300
--INCREMENT BY 1 : ���� �� 1�� ������ �⺻��
MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, 'ȫ�浿', '000101-1234567', 'gd_hong@kh.or.kr', '01043214321','D2', 'J7', 'S5',
2500000,0.1, 200, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE; -- 300���� ȫ�浿�� �߰���

INSERT INTO EMPLOYEE
VALUES (SEQ_EID.NEXTVAL, 'ȫ���', '000101-2234567', 'gs_hong@kh.or.kr', '01043214321','D2', 'J7', 'S5',
2500000,0.1, 200, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE; -- 301���� ȫ����� �߰���



-- ������ ���� (�׳� �����ϸ� ��)
DROP SEQUENCE SEQ_EMPID;


-- ������ �����ϱ�
-- START WITH�� ���� �Ұ���!

ALTER SEQUENCE SEQ_EID
-- START WITH 400
-- ORA-02283: cannot alter starting sequence number
INCREMENT BY 2
MAXVALUE 5000
NOCYCLE
CACHE 20;


-- * CACHE ����
-- �̸� ���� �۾��� ����� ����� �δ� �޸�
--> ����� �ϼ��Ǿ� �ֱ� ������ ȣ�� �� ��ȯ�� �ϸ� �ǹǷ� �ӵ��� ������ ����
--> ���, �̸� ���� ������ �����ϰ� �����Ƿ� ������ ũ�⸦ ������ ���� �߿��ϴ�.

-- * SEQUENCE���� CACHE
-- ������ ���� ��ŭ ������ ���� NEXTVAL�� ������� �̸� �����ص�

SELECT * FROM USER_SEQUENCES;


-----------------------------------------------------------------------------------------------------------------------------

-- �ǽ� ���� : USER_TEST ���̺� �����


CREATE TABLE USER_TEST (
    USER_NO             NUMBER PRIMARY KEY,
    USER_ID             VARCHAR2(20) UNIQUE,
    USER_PWD            VARCHAR2(20) NOT NULL,
    PNO                 VARCHAR2(20) NOT NULL UNIQUE,
    GENDER              VARCHAR2(3),
    PHONE               VARCHAR2(20),
    ADDRESS             VARCHAR2(100),
    STATUS              VARCHAR2(3) DEFAULT 'N' NOT NULL,
    CHECK (GENDER IN ('��','��') AND STATUS IN ('Y','N'))
);

COMMENT ON COLUMN USER_TEST.USER_NO IS  'ȸ����ȣ';
COMMENT ON COLUMN USER_TEST.USER_ID IS  'ȸ�����̵�';
COMMENT ON COLUMN USER_TEST.USER_PWD IS  '��й�ȣ';
COMMENT ON COLUMN USER_TEST.PNO IS  '�ֹε�Ϲ�ȣ';
COMMENT ON COLUMN USER_TEST.GENDER IS  '����';
COMMENT ON COLUMN USER_TEST.PHONE IS  '����ó';
COMMENT ON COLUMN USER_TEST.ADDRESS IS  '�ּ�';
COMMENT ON COLUMN USER_TEST.STATUS IS  'Ż�𿩺�';

DROP TABLE USER_TEST;


