
-- 1�� : �迭 ������ ������ ī�װ� ���̺��� ������� �Ѵ�. ������ ���� ���̺��� �ۼ��Ͻÿ�

CREATE TABLE TB_CATEGORY(
    NAME        VARCHAR2(10),
    USE_YN      CHAR(1) DEFAULT 'Y'
    );
    



-- 2�� : ���� ������ ������ ���̺��� ������� �Ѵ�. ������ ���� ���̺��� �ۼ��Ͻÿ�.

CREATE TABLE TB_CLASS_TYPE(
    NO      VARCHAR2(5) PRIMARY KEY,
    NAME    VARCHAR2(10)
);




-- 3�� : TB_CATEGORY ���̺��� NAME �÷��� PRIMARY KEY�� �����Ͻÿ�.
-- (KEY �̸��� �������� �ʾƵ� ������. ���� KEY �̸� �����ϰ��� �Ѵٸ� �̸��� ������ �˾Ƽ� ������ �̸��� ����Ѵ�)

ALTER TABLE TB_CATEGORY ADD CONSTRAINT CATEGORY_PK PRIMARY KEY (NAME);




-- 4�� : TB_CLASS_TYPE ���̺��� NAME �÷��� NULL ���� ���� �ʵ��� �Ӽ��� �����Ͻÿ�

ALTER TABLE TB_CLASS_TYPE MODIFY NAME NOT NULL;









