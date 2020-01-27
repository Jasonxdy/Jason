-- 1) NOTICE ���̺��� ���� 
-- '��������' �̶�� �ܾ ���Ե� ������ ��� ��ȸ
SELECT * FROM NOTICE WHERE NOTICE_TITLE LIKE '%��������%'; 

-- 2) NOTICE ���̺��� ���뿡 
-- 'ȯ���մϴ�' �̶�� �ܾ ���Ե� ������ ��� ��ȸ
SELECT * FROM NOTICE WHERE NOTICE_CONTENT LIKE '%ȯ���մϴ�%';

-- 3) NOTICE ���̺��� ���� �Ǵ� ���뿡 
-- '����' �̶�� �ܾ ���Ե� ������ ��� ��ȸ
SELECT * FROM NOTICE WHERE NOTICE_TITLE LIKE '%����%' OR NOTICE_CONTENT LIKE '%����%';

-- ��ȸ�� ������ �Խù� ��ȸ
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT,
    BOARD_COUNT, BOARD_MODIFY_DT, 
    BOARD_TYPE, MEMBER_ID, CATEGORY_NM 
FROM BOARD
JOIN MEMBER ON(BOARD_WRITER = MEMBER_NO)
JOIN CATEGORY ON (BOARD_CATEGORY = CATEGORY_CD)
WHERE BOARD_STATUS='Y';

-- VIEW ����
CREATE OR REPLACE VIEW V_BOARD AS 
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT,
    BOARD_COUNT, BOARD_MODIFY_DT, 
    BOARD_TYPE, MEMBER_ID, CATEGORY_NM 
FROM BOARD
JOIN MEMBER ON(BOARD_WRITER = MEMBER_NO)
JOIN CATEGORY ON (BOARD_CATEGORY = CATEGORY_CD)
WHERE BOARD_STATUS='Y'
ORDER BY BOARD_NO DESC;

-- *ORA-01031: insufficient privileges
--> VIEW ���� ������ ���� ��� ��Ÿ���� ����
-- ������ �������� �����Ͽ� VIEW ���� ���� �ο�
GRANT CREATE VIEW TO server;

SELECT * FROM V_BOARD WHERE BOARD_TYPE=1;

-- BOARD ��� ��ȸ ��
-- LIMIT ��ŭ�� ������ �߶� ��ȸ

-- V_BOARD���� ROWNUM�� 1~5���� �̰�
-- �Խ��� Ÿ���� 1�� ���� 
-- ROWNUM, �۹�ȣ, ������, ��ȸ��
-- ������, �ۼ���, ī�װ��� ��ȸ

-- ROWNUM: ��ȸ�� �� �Ŀ� �ٿ����� ����
SELECT RNUM, BOARD_NO, BOARD_TITLE,
    BOARD_COUNT, BOARD_MODIFY_DT,
    MEMBER_ID, CATEGORY_NM
FROM (SELECT ROWNUM RNUM, BOARD_NO, BOARD_TITLE,
                BOARD_COUNT, BOARD_MODIFY_DT,
                MEMBER_ID, CATEGORY_NM, BOARD_TYPE
            FROM V_BOARD WHERE BOARD_TYPE=1)
WHERE RNUM BETWEEN 1 AND 5; -- �̷� �������� ��ȸ�� �� ROWNUM�� 1���� �������θ� �� �� �ִ�


SELECT RNUM, BOARD_NO, BOARD_TITLE, BOARD_COUNT, BOARD_MODIFY_DT, MEMBER_ID, CATEGORY_NM FROM (SELECT ROWNUM RNUM, BOARD_NO, BOARD_TITLE, BOARD_COUNT, BOARD_MODIFY_DT, MEMBER_ID, CATEGORY_NM, BOARD_TYPE FROM V_BOARD WHERE BOARD_TYPE=?) WHERE RNUM BETWEEN ? AND ?
ORDER BY BOARD_NO DESC;
commit;
BEGIN
    FOR N IN 1..500 LOOP
    
        INSERT INTO BOARD
        VALUES (SEQ_BNO.NEXTVAL,
                    N || ' ��° �Խñ�',
                    N || ' ��° �Խñ��Դϴ�.',
                    DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1, 
                    CEIL(DBMS_RANDOM.VALUE(1,6)) * 10,
                    1);
    END LOOP;
END;
/   -- �� ǥ��

