--생성 파일명 : exercise8.sql
-- jdbctest 라는 사용자로 접속해서 이 테이블들을 생성한다.

--1. 테이블명 : visitor
--    컬럼 사양 : name - 한글 기준으로 최대 6자를 저장할 수 있게
--                   writedate - 날짜와 시간을 저장할 수 있게 
--                   memo - 한글 기준으로 최대 60자를 저장할 수 있게
--                   [visitor 테이블에 데이터를 3개 행을 입력]
--	      날짜 데이터 : 1개 : 현재시간,  
--                                      1개 : 2017년 12월 25일, 
--                                      1개 : 1999년 8월 11일

CREATE TABLE VISITOR(
NAME VARCHAR2(18), WRITEDATE DATE, MEMO VARCHAR2(180)
);
INSERT INTO VISITOR (WRITEDATE)
VALUES (SYSDATE);
INSERT INTO VISITOR (WRITEDATE)
VALUES (TO_DATE('1999년08월11일','YYYY"년"MM"월"DD"일"'));
INSERT INTO VISITOR (WRITEDATE)
VALUES (TO_DATE('2019년06월20일','YYYY"년"MM"월"DD"일"'));

SELECT * FROM VISITOR;



-- 2. 테이블명 : member
--    컬럼 사양 : m_id -  영문 기준으로 최대 12자를 저장할 수 있게 - primary key
--	     m_pwd - 영문 기준으로 최대 12자를 저장할 수 있게 - not null
--                   name - 한글 기준으로 최대 6자를 저장할 수 있게  - not null
--                   joindate - 날짜와 시간을 저장할 수 있게  - 기본값 sysdate

CREATE TABLE MEMBER(
M_ID VARCHAR2(12) PRIMARY KEY,
M_PWD VARCHAR2(12) NOT NULL,
NAME VARCHAR2(18) NOT NULL,
JOINDATE DATE DEFAULT SYSDATE
);

DESC MEMBER;

 
-- 3. 테이블명 : news
--     컬럼사양 : id - 길이가 8인 숫자 타입 - primary key
--                    writer - 한글 기준으로 최대 6자를 저장할 수 있게
--	      title - 한글 기준으로 최대 40자를 저장할 수 있게
--	      content - 한글 기준으로 최대 300자를 저장할 수 있게
--                     writedate - 날짜와 시간을 저장할 수 있게
--                     cnt - 길이가 8인 숫자 타입
--     시퀀스 생성 : news_seq - 1부터 시작, 1씩 증가

CREATE TABLE NEWS(
ID NUMBER(8) PRIMARY KEY,
WRITER VARCHAR2(18),
TITLE VARCHAR2(120),
CONTENT VARCHAR2(900),
WRITEDATE DATE,
CNT NUMBER(8)
);
CREATE SEQUENCE NEWS_SEQ
INCREMENT BY 1
START WITH 1;

DESC NEWS;
SELECT * FROM USER_SEQUENCES;



-- 4. 테이블명 : meeting
--     컬럼사양 : id - 길이가 8인 숫자 타입 - primary key
--                   name - 한글 기준으로 최대 6자를 저장할 수 있게
-- 	      title - 한글 기준으로 최대 40자를 저장할 수 있게 
--	      meetingdate - 날짜와 시간을 저장할 수 있게
--
--      시퀀스 생성 : meeting_seq - 1부터 시작, 1씩 증가

CREATE TABLE MEETINGDATE(
ID NUMBER(8) PRIMARY KEY,
NAME VARCHAR2(18),
TITLE VARCHAR2(120),
MEETINGDATE DATE
);
CREATE SEQUENCE MEETING_SEQ
INCREMENT BY 1
START WITH 1;

DESC MEETINGDATE;
SELECT * FROM USER_SEQUENCES;



--5. 테이블명 : imgtest
--     컬럼사양 : name - 한글 기준으로 최대 6자를 저장할 수 있게 - primary key
--                   imgcontent - 이미지를 데이터로 저장할 수 있게 (blob)

CREATE TABLE IMGTEST(
NAME VARCHAR2(18) PRIMARY KEY,
IMGCONTENT BLOB
);

DESC IMGTEST;
