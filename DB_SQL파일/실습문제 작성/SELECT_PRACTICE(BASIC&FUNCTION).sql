
-------------- BASIC SELECT ------------------

-- 1번
SELECT DEPARTMENT_NAME AS "학과 명", CATEGORY AS "계열"
FROM TB_DEPARTMENT;

-- 2번
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다'AS "학과 별 정원"
FROM TB_DEPARTMENT;

-- 4번
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
ORDER BY 1 DESC;

-- 5번
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6번
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE department_no IS NULL;

-- 7번
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE department_no IS NULL;

-- 8번
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9번
SELECT DISTINCT(CATEGORY)
FROM TB_DEPARTMENT
ORDER BY CATEGORY;

-- 10번
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'N'
AND student_address LIKE '%전주시%'
AND SUBSTR(ENTRANCE_DATE, 1, 2) = '02'
ORDER BY STUDENT_NAME;


----------------------------- ADDITIONAL SELECT - 함수 -------------------------------

-- 1번
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, TO_CHAR(ENTRANCE_DATE,'YYYY-MM-DD') 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 002
ORDER BY STUDENT_NAME;

-- 2번
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) <> 3;

-- 3번
SELECT PROFESSOR_NAME 교수이름, EXTRACT(YEAR FROM SYSDATE)
- (EXTRACT(YEAR FROM TO_DATE(SUBSTR(PROFESSOR_SSN,1,2), 'YY'))-100) AS "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8,1) = '1'
ORDER BY 나이;

-- 선생님 방법
SELECT PROFESSOR_NAME 교수이름,
   FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('19'||SUBSTR(PROFESSOR_SSN, 1, 6),'YYYYMMDD'))/12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY 나이;


-- 4번
SELECT SUBSTR(PROFESSOR_NAME, 2, 2) 이름
FROM TB_PROFESSOR;

-- 5번
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT (YEAR FROM ENTRANCE_DATE)
- EXTRACT(YEAR FROM (TO_DATE(SUBSTR(STUDENT_SSN,1,2),'RR'))) > 19;


-- 6번
SELECT TO_CHAR(TO_DATE('20/12/25', 'YY/MM/DD'), 'DAY')
FROM DUAL;


-- 7번

SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'), 'YYYY-MM-DD-DAY'), TO_CHAR(TO_DATE('49/10/11', 'YY/MM/DD'),'YYYY-MM-DD-DAY')
FROM DUAL;

SELECT TO_CHAR(TO_DATE('99/10/11', 'RR/MM/DD'), 'YYYY-MM-DD-DAY'), TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'),'YYYY-MM-DD-DAY')
FROM DUAL;


-- 8번
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

-- 9번
SELECT ROUND(AVG(POINT),1) AS 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10번
SELECT DEPARTMENT_NO 학과번호, COUNT(STUDENT_NAME) "학생수(명)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 학과번호;

-- 11번
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12번
SELECT SUBSTR(TERM_NO,1,4) 년도,
ROUND((SUM(POINT)/COUNT(TERM_NO)),1) "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY 년도;


-- 13번
SELECT DEPARTMENT_NO 학과코드명, SUM(DECODE(ABSENCE_YN, 'Y', 1, 0)) "휴학생 수"
FROM TB_STUDENT
GROUP BY  DEPARTMENT_NO
ORDER BY 학과코드명;


-- 14번
SELECT STUDENT_NAME 동일이름, COUNT(STUDENT_NAME) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME)>1;


-- 15번

SELECT
NVL(SUBSTR(TERM_NO,1,4),' ') 년도,
NVL(SUBSTR(TERM_NO,5,2),' ') 학기,
ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2))
--HAVING SUBSTR(TERM_NO,1,4) IS NOT NULL
ORDER BY SUBSTR(TERM_NO,1,4);



