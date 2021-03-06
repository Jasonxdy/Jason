--------------------------------------------------
--------------     NOTICE 관련	-------------------
--------------------------------------------------

-- MEMBER 테이블에서 누락된 MEMBER_ID UNIQUE 제약 조건
ALTER TABLE MEMBER
ADD UNIQUE(MEMBER_ID);

DROP TABLE NOTICE;
DROP SEQUENCE SEQ_NNO;

CREATE TABLE NOTICE(
  NOTICE_NO NUMBER PRIMARY KEY,
  NOTICE_TITLE VARCHAR2(100) NOT NULL,
  NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
  NOTICE_WRITER VARCHAR2(30) REFERENCES MEMBER(MEMBER_ID) NOT NULL,
  NOTICE_COUNT NUMBER DEFAULT 0,
  NOTICE_CREATE_DT DATE DEFAULT SYSDATE,
  NOTICE_MODIFY_DT DATE DEFAULT SYSDATE,
  NOTICE_STATUS VARCHAR2(1) DEFAULT 'Y' CHECK(NOTICE_STATUS IN ('Y','B','N'))
);

COMMENT ON COLUMN NOTICE.NOTICE_NO IS '공지사항 번호';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '공지사항 제목';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '공지사항 내용';
COMMENT ON COLUMN NOTICE.NOTICE_WRITER IS '공지사항 작성자(회원 아이디)';
COMMENT ON COLUMN NOTICE.NOTICE_COUNT IS '공지사항 조회 수';
COMMENT ON COLUMN NOTICE.NOTICE_CREATE_DT IS '공지사항 작성일';
COMMENT ON COLUMN NOTICE.NOTICE_MODIFY_DT IS '공지사항 수정일';
COMMENT ON COLUMN NOTICE.NOTICE_STATUS IS '공지사항 상태(Y:정상, B:블라인드, N:삭제)';


CREATE SEQUENCE SEQ_NNO;

INSERT INTO NOTICE
VALUES (SEQ_NNO.NEXTVAL, '첫 번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO NOTICE
VALUES (SEQ_NNO.NEXTVAL, '두 번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO NOTICE
VALUES (SEQ_NNO.NEXTVAL, '세 번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO NOTICE
VALUES (SEQ_NNO.NEXTVAL, '네 번째 공지사항입니다.', '환영합니다.', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT);

COMMIT;
