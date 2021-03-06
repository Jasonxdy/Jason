--------------------------------------------------
-------------- MEMBER 관련	----------------
--------------------------------------------------
DROP TABLE MEMBER;
DROP SEQUENCE SEQ_UNO;

-- MEMBER 테이블 생성
CREATE TABLE MEMBER (
  MEMBER_NO NUMBER PRIMARY KEY,
  MEMBER_ID VARCHAR2(30) NOT NULL,
  MEMBER_PWD VARCHAR2(100) NOT NULL,
  MEMBER_NM VARCHAR2(15) NOT NULL,
  MEMBER_PHONE VARCHAR2(13),
  MEMBER_EMAIL VARCHAR2(100),
  MEMBER_ADDR VARCHAR2(100),
  MEMBER_INTEREST VARCHAR2(100),
  MEMBER_ENROLL_DATE DATE DEFAULT SYSDATE,
  MEMBER_STATUS VARCHAR2(1) DEFAULT 'Y' CHECK(MEMBER_STATUS IN('Y', 'N')) ,
  MEMBER_GRADE VARCHAR2(1) DEFAULT 'G' CHECK(MEMBER_GRADE IN('A', 'G')) 
);

-- 멤버 테이블 컬럼별 코멘트
COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원 번호';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NM IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_PHONE IS '전화번호(- 포함)';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.MEMBER_ADDR IS '주소';
COMMENT ON COLUMN MEMBER.MEMBER_INTEREST IS '관심사';
COMMENT ON COLUMN MEMBER.MEMBER_ENROLL_DATE IS '가입일';
COMMENT ON COLUMN MEMBER.MEMBER_STATUS IS '회원 상태(Y:정상, N:탈퇴)';
COMMENT ON COLUMN MEMBER.MEMBER_GRADE IS '회원 등급(A:관리자 ,G:일반회원)';

-- 회원 번호 시퀀스 생성
CREATE SEQUENCE SEQ_UNO;


-- 샘플 데이터 삽입
INSERT INTO MEMBER 
VALUES (SEQ_UNO.NEXTVAL, 'admin', 'admin', '김관리', '010-1111-1111', 'admin@kh.or.kr', '서울시 강남구 역삼동', NULL, SYSDATE, DEFAULT, 'A');

INSERT INTO MEMBER 
VALUES (SEQ_UNO.NEXTVAL, 'user01', 'pass01', '홍길동', '010-1234-1234', 'user01@kh.or.kr', '서울시 양천구 목동', NULL, SYSDATE, DEFAULT, DEFAULT);

COMMIT;






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





-- 연습용 SQL
SELECT * FROM MEMBER WHERE MEMBER_ID = 'admin' AND MEMBER_PWD = 'admin' AND MEMBER_STATUS = 'Y';
UPDATE MEMBER SET MEMBER_PHONE = '010-1111-1111', MEMBER_EMAIL = 'user03@naver.com', MEMBER_ADDR = ',,', MEMBER_INTEREST = '운동' WHERE MEMBER_ID = 'user03';
rollback;

