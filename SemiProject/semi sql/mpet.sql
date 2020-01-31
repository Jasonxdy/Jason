CREATE TABLE MEMBER(
    MEM_ID VARCHAR2(36) PRIMARY KEY,
    MEM_NAME VARCHAR2(36) NOT NULL,
    MEM_PWD VARCHAR2(100) NOT NULL,
    MEM_EMAIL VARCHAR2(60) NOT NULL,
    MEM_PHONE CHAR(13) NOT NULL,
    MEM_WEB_TELL VARCHAR2(1) DEFAULT 'Y' CHECK(MEM_WEB_TELL IN ('Y','N')) NOT NULL,
    MEM_COMMENT_TELL VARCHAR2(1) DEFAULT 'Y' CHECK(MEM_COMMENT_TELL IN ('Y', 'N')) NOT NULL,
    MEM_ASK_TELL VARCHAR2(1) DEFAULT 'Y' CHECK(MEM_ASK_TELL IN ('Y','N')) NOT NULL,
    MEM_REALTIME_TELL VARCHAR2(1) DEFAULT 'Y' CHECK(MEM_REALTIME_TELL IN ('Y','N')) NOT NULL,
    MEM_EMAIL_CERTIFY VARCHAR2(1) DEFAULT 'N' CHECK(MEM_EMAIL_CERTIFY IN ('Y','N')) NOT NULL,
    MEM_STATUS VARCHAR2(1) DEFAULT 'N' CHECK(MEM_STATUS IN ('Y','N')) NOT NULL,
    MEM_GRADE VARCHAR2(1) DEFAULT 'N' CHECK(MEM_GRADE IN ('Y','N')) NOT NULL,
    MEM_SIGNUP_DT DATE DEFAULT SYSDATE NOT NULL,
    MEM_PRO_IMG VARCHAR2(1000) DEFAULT '/resources/uploadImages/default.png' NOT NULL
);

------------------------ MEMBER ���̺� ���� �� ������ ����
INSERT INTO MEMBER VALUES('admin', '������', 'admin', 'admin@iei.or.kr', '010-0000-0000',
    DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
    
    
    
-- 1:1 ���� ���̺� 2
CREATE TABLE ASK(
    ASK_NO NUMBER PRIMARY KEY,
    ASK_TITLE VARCHAR2(100) NOT NULL,
    ASK_CONTENT VARCHAR2(4000) NOT NULL,
    ASK_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    ASK_MODIFY_DT DATE,
    ASK_STATUS VARCHAR2(1) DEFAULT 'N' CHECK(ASK_STATUS IN ('Y', 'N')) NOT NULL,
    MEMBER_ID VARCHAR2(36) REFERENCES MEMBER NOT NULL
);


-- 1:1 ���� ���� ���̺� 3
CREATE TABLE ANSWER(
    ANSWER_NO NUMBER PRIMARY KEY REFERENCES ASK,
    ANSWER_CONTENT VARCHAR2(4000) NOT NULL,
    ANSWER_DATE DATE DEFAULT SYSDATE NOT NULL
);

-- ���� ǰ�� ���̺� 4
CREATE TABLE BREED(
    BREED_NO NUMBER PRIMARY KEY,
    BREED_NAME VARCHAR2(30) NOT NULL
);

-- ���� ���̺� 5 
CREATE TABLE ANIMAL(
    ANIMAL_CODE NUMBER PRIMARY KEY,
    ANIMAL_GENDER VARCHAR2(1) CHECK(ANIMAL_GENDER IN ('M', 'F', 'N')) NOT NULL,
    ANIMAL_TYPE VARCHAR2(20) NOT NULL,
    BREED_NO NUMBER REFERENCES BREED NOT NULL
);


-- �Խ��� ���� ���̺� 6
CREATE TABLE BOARD_TYPE(
    BOARD_CODE NUMBER PRIMARY KEY,
    BOARD_TYPE_NAME VARCHAR2(30) NOT NULL
);

-- �Խ��� ���̺� 7
CREATE TABLE BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(100) NOT NULL,
    BOARD_CONTENT CLOB NOT NULL,
    BOARD_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    BOARD_MODIFY_DT DATE DEFAULT SYSDATE,
    BOARD_COUNT NUMBER DEFAULT 0 NOT NULL,
    BOARD_URL VARCHAR2(1000),
    BOARD_STATUS VARCHAR2(1) DEFAULT 'N' CHECK(BOARD_STATUS IN ('Y', 'N')) NOT NULL,
    MEM_ID VARCHAR2(36) REFERENCES MEMBER NOT NULL,
    BOARD_CODE NUMBER REFERENCES BOARD_TYPE NOT NULL
);

-- ��� ���̺� 8
CREATE TABLE M_COMMENT(
    COMM_NO NUMBER PRIMARY KEY,
    COMM_CONTENT VARCHAR2(4000),
    COMM_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    COMM_MODIFY_DT DATE DEFAULT SYSDATE,
    COMM_STATUS VARCHAR2(1) DEFAULT 'N' CHECK(COMM_STATUS IN ('Y', 'N')) NOT NULL,
    MEM_ID VARCHAR2(36) REFERENCES MEMBER NOT NULL,
    BOARD_NO NUMBER REFERENCES BOARD NOT NULL
);


-- �����Խ��� �ΰ���� ���̺� 9
CREATE TABLE FREE(
    BOARD_NO NUMBER REFERENCES BOARD PRIMARY KEY,
    FREE_CATEGORY VARCHAR2(12) NOT NULL
);

-- �þ�� �ΰ���� ���̺� 10
CREATE TABLE SEE(
    BOARD_NO NUMBER REFERENCES BOARD PRIMARY KEY,
    SEE_LOCATION VARCHAR2(100) NOT NULL,
    SEE_PHONE CHAR(13) NOT NULL,
    SEE_DATE DATE NOT NULL,
    SEE_MAP VARCHAR2(1000),
    SEE_LOCATION_TELL VARCHAR2(1) DEFAULT 'N' CHECK(SEE_LOCATION_TELL IN ('Y', 'N')) NOT NULL,
    SEE_BREED_TELL VARCHAR2(1) DEFAULT 'N' CHECK(SEE_BREED_TELL IN ('Y', 'N')) NOT NULL,
    SEE_COMMENT_TELL VARCHAR2(1) DEFAULT 'N' CHECK(SEE_COMMENT_TELL IN ('Y', 'N')) NOT NULL,
    ANIMAL_CODE NUMBER REFERENCES ANIMAL NOT NULL
);

-- ã�ƿ� �ΰ���� ���̺� 11
CREATE TABLE FIND(
    BOARD_NO NUMBER REFERENCES BOARD PRIMARY KEY,
    FIND_LOCATION VARCHAR2(100) NOT NULL,
    FIND_REWARD NUMBER,
    FIND_PHONE CHAR(13) NOT NULL,
    FIND_DATE DATE NOT NULL,
    FIND_MAP VARCHAR2(1000),
    FIND_LOCATION_TELL VARCHAR2(1) DEFAULT 'N' CHECK(FIND_LOCATION_TELL IN ('Y', 'N')) NOT NULL,
    FIND_BREED_TELL VARCHAR2(1) DEFAULT 'N' CHECK(FIND_BREED_TELL IN ('Y', 'N')) NOT NULL,
    FIND_COMMENT_TELL VARCHAR2(1) DEFAULT 'N' CHECK(FIND_COMMENT_TELL IN ('Y', 'N')) NOT NULL,
    ANIMAL_CODE NUMBER REFERENCES ANIMAL NOT NULL
);

-- �о��մϴ� �ΰ���� ���̺� 12
CREATE TABLE ADOPT(
    BOARD_NO NUMBER REFERENCES BOARD PRIMARY KEY,
    ADOPT_LOCATION VARCHAR2(100) NOT NULL,
    ADOPT_COST NUMBER,
    ADOPT_PHONE CHAR(13) NOT NULL,
    ADOPT_MAP VARCHAR2(1000),
    ADOPT_NEUTRAL VARCHAR2(1) DEFAULT 'N' CHECK(ADOPT_NEUTRAL IN ('Y', 'N')) NOT NULL,
    ADOPT_VAC VARCHAR2(1) DEFAULT 'N' CHECK(ADOPT_VAC IN ('Y', 'N')) NOT NULL,
    ADOPT_HEALTH VARCHAR2(30) NOT NULL,
    ADOPT_DONE VARCHAR2(1) DEFAULT 'N' CHECK(ADOPT_DONE IN ('Y', 'N')) NOT NULL,
    ANIMAL_CODE NUMBER REFERENCES ANIMAL NOT NULL
);

-- ���� ��� ���̺� 13
CREATE TABLE IMG(
    IMG_NO NUMBER PRIMARY KEY,
    IMG_ORIGIN_NAME VARCHAR2(255) NOT NULL,
    IMG_CHANGE_NAME VARCHAR2(255) NOT NULL,
    IMG_PATH VARCHAR2(1000) NOT NULL,
    IMG_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    IMG_STATUS VARCHAR2(1) DEFAULT 'N' CHECK(IMG_STATUS IN('Y', 'N')) NOT NULL,
    IMG_LEVEL NUMBER DEFAULT '1' CHECK(IMG_LEVEL IN('0', '1')) NOT NULL,
    BOARD_NO NUMBER REFERENCES BOARD NOT NULL
);

-- �Ű� ���̺� 14
CREATE TABLE REPORT(
    REPORT_NO NUMBER PRIMARY KEY,
    REPORT_TITLE VARCHAR2(100) NOT NULL,
    REPORT_CONTENT VARCHAR2(4000) NOT NULL,
    REPORT_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    MEM_ID VARCHAR2(36) REFERENCES MEMBER NOT NULL,
    BOARD_NO NUMBER REFERENCES BOARD NOT NULL
);

-- Q&A ���̺�
CREATE TABLE QA(
    QA_NO NUMBER PRIMARY KEY,
    QA_TITLE VARCHAR2(100) NOT NULL,
    QA_CONTENT VARCHAR2(4000) NOT NULL,
    QA_CREATE_DT DATE DEFAULT SYSDATE NOT NULL,
    QA_MODIFY_DT DATE DEFAULT SYSDATE
);