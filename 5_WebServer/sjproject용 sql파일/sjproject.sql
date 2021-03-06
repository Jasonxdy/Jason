CREATE USER server IDENTIFIED BY server;

GRANT CONNECT, RESOURCE TO server;

--------------------------------------------------
-------------- MEMBER 관련	----------------
--------------------------------------------------
--DROP TABLE MEMBER;
--DROP SEQUENCE SEQ_UNO;

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


-- 댓글

----------------------------------------------------
--------------   REPLY 관련         ----------------- 
----------------------------------------------------

CREATE TABLE REPLY(
  REPLY_NO NUMBER PRIMARY KEY,
  REPLY_CONTENT VARCHAR2(400) NOT NULL,
  BOARD_ID NUMBER REFERENCES BOARD NOT NULL,
  REPLY_WRITER NUMBER REFERENCES MEMBER NOT NULL,
  REPLY_CREATE_DT DATE DEFAULT SYSDATE,
  REPLY_MODIFY_DT DATE DEFAULT SYSDATE,
  REPLY_STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (REPLY_STATUS IN ('Y', 'N'))
);

CREATE SEQUENCE SEQ_RNO;
