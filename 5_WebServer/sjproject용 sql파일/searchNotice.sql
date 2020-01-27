-- 1) NOTICE 테이블에서 제목에 
-- '공지사항' 이라는 단어가 포함된 공지글 모두 조회
SELECT * FROM NOTICE WHERE NOTICE_TITLE LIKE '%공지사항%'; 

-- 2) NOTICE 테이블에서 내용에 
-- '환영합니다' 이라는 단어가 포함된 공지글 모두 조회
SELECT * FROM NOTICE WHERE NOTICE_CONTENT LIKE '%환영합니다%';

-- 3) NOTICE 테이블에서 제목 또는 내용에 
-- '공지' 이라는 단어가 포함된 공지글 모두 조회
SELECT * FROM NOTICE WHERE NOTICE_TITLE LIKE '%공지%' OR NOTICE_CONTENT LIKE '%공지%';

-- 조회가 가능한 게시물 조회
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT,
    BOARD_COUNT, BOARD_MODIFY_DT, 
    BOARD_TYPE, MEMBER_ID, CATEGORY_NM 
FROM BOARD
JOIN MEMBER ON(BOARD_WRITER = MEMBER_NO)
JOIN CATEGORY ON (BOARD_CATEGORY = CATEGORY_CD)
WHERE BOARD_STATUS='Y';

-- VIEW 생성
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
--> VIEW 생성 권한이 없을 경우 나타나는 에러
-- 관리자 계정으로 접속하여 VIEW 생성 권한 부여
GRANT CREATE VIEW TO server;

SELECT * FROM V_BOARD WHERE BOARD_TYPE=1;

-- BOARD 목록 조회 시
-- LIMIT 만큼의 범위로 잘라서 조회

-- V_BOARD에서 ROWNUM이 1~5사이 이고
-- 게시판 타입이 1인 행의 
-- ROWNUM, 글번호, 글제목, 조회수
-- 수정일, 작성자, 카테고리명 조회

-- ROWNUM: 조회가 된 후에 붙여지는 숫자
SELECT RNUM, BOARD_NO, BOARD_TITLE,
    BOARD_COUNT, BOARD_MODIFY_DT,
    MEMBER_ID, CATEGORY_NM
FROM (SELECT ROWNUM RNUM, BOARD_NO, BOARD_TITLE,
                BOARD_COUNT, BOARD_MODIFY_DT,
                MEMBER_ID, CATEGORY_NM, BOARD_TYPE
            FROM V_BOARD WHERE BOARD_TYPE=1)
WHERE RNUM BETWEEN 1 AND 5; -- 이런 조건으로 조회할 때 ROWNUM은 1부터 시작으로만 쓸 수 있다


SELECT RNUM, BOARD_NO, BOARD_TITLE, BOARD_COUNT, BOARD_MODIFY_DT, MEMBER_ID, CATEGORY_NM FROM (SELECT ROWNUM RNUM, BOARD_NO, BOARD_TITLE, BOARD_COUNT, BOARD_MODIFY_DT, MEMBER_ID, CATEGORY_NM, BOARD_TYPE FROM V_BOARD WHERE BOARD_TYPE=?) WHERE RNUM BETWEEN ? AND ?
ORDER BY BOARD_NO DESC;
commit;
BEGIN
    FOR N IN 1..500 LOOP
    
        INSERT INTO BOARD
        VALUES (SEQ_BNO.NEXTVAL,
                    N || ' 번째 게시글',
                    N || ' 번째 게시글입니다.',
                    DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1, 
                    CEIL(DBMS_RANDOM.VALUE(1,6)) * 10,
                    1);
    END LOOP;
END;
/   -- 끝 표식

