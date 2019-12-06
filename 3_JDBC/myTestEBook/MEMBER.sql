--------------------------------------------------------
--  파일이 생성됨 - 금요일-12월-06-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER"."MEMBER" 
   (	"MEMBER_ID" VARCHAR2(30 BYTE), 
	"MEMBER_PWD" VARCHAR2(30 BYTE), 
	"MEMBER_NAME" VARCHAR2(30 BYTE), 
	"GENDER" VARCHAR2(10 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PHONE" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(100 BYTE), 
	"AGE" NUMBER, 
	"ENROLL_DATE" DATE DEFAULT SYSDATE, 
	"CASH" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into MEMBER.MEMBER
SET DEFINE OFF;
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user01','pass01','홍길동','M','hong_gd@kh.or.kr','010-1234-1234','경기도 남양주시 지금동',20,to_date('19/12/04','RR/MM/DD'),10000);
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user02','pass02','김유신','M','kim_ys@kh.or.kr','010-1234-1234','경기도 시흥시 정왕동',19,to_date('19/12/04','RR/MM/DD'),10000);
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user03','pass03','이순신','M','lee_ss@kh.or.kr','010-1234-1234','서울시 강남구 역삼동',12,to_date('19/12/04','RR/MM/DD'),0);
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user04','pass04','김영희','M','kim_yh@kh.or.kr','010-1234-1234','서울시 관악구 봉천동',27,to_date('19/12/04','RR/MM/DD'),0);
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user05','pass05','박철수','M','park_cs@kh.or.kr','010-1234-1234','경기도 수원시 연무동',20,to_date('19/12/04','RR/MM/DD'),0);
Insert into MEMBER.MEMBER (MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,EMAIL,PHONE,ADDRESS,AGE,ENROLL_DATE,CASH) values ('user06','pass06','유재석','M','you_js@kh.or.kr','010-1234-1234','인천광역시 계양구 동양동',20,to_date('19/12/04','RR/MM/DD'),0);
--------------------------------------------------------
--  DDL for Index SYS_C007328
--------------------------------------------------------

  CREATE UNIQUE INDEX "MEMBER"."SYS_C007328" ON "MEMBER"."MEMBER" ("MEMBER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER"."MEMBER" ADD CHECK (CASH>=0) ENABLE;
  ALTER TABLE "MEMBER"."MEMBER" ADD PRIMARY KEY ("MEMBER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "MEMBER"."MEMBER" ADD CHECK (GENDER IN('M','F')) ENABLE;
  ALTER TABLE "MEMBER"."MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "MEMBER"."MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "MEMBER"."MEMBER" MODIFY ("MEMBER_NAME" NOT NULL ENABLE);
  ALTER TABLE "MEMBER"."MEMBER" MODIFY ("MEMBER_PWD" NOT NULL ENABLE);
