--���� ���ϸ� : exercise8.sql
-- jdbctest ��� ����ڷ� �����ؼ� �� ���̺���� �����Ѵ�.

--1. ���̺�� : visitor
--    �÷� ��� : name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
--                   writedate - ��¥�� �ð��� ������ �� �ְ� 
--                   memo - �ѱ� �������� �ִ� 60�ڸ� ������ �� �ְ�
--                   [visitor ���̺� �����͸� 3�� ���� �Է�]
--	      ��¥ ������ : 1�� : ����ð�,  
--                                      1�� : 2017�� 12�� 25��, 
--                                      1�� : 1999�� 8�� 11��

CREATE TABLE VISITOR(
NAME VARCHAR2(18), WRITEDATE DATE, MEMO VARCHAR2(180)
);
INSERT INTO VISITOR (WRITEDATE)
VALUES (SYSDATE);
INSERT INTO VISITOR (WRITEDATE)
VALUES (TO_DATE('1999��08��11��','YYYY"��"MM"��"DD"��"'));
INSERT INTO VISITOR (WRITEDATE)
VALUES (TO_DATE('2019��06��20��','YYYY"��"MM"��"DD"��"'));

SELECT * FROM VISITOR;



-- 2. ���̺�� : member
--    �÷� ��� : m_id -  ���� �������� �ִ� 12�ڸ� ������ �� �ְ� - primary key
--	     m_pwd - ���� �������� �ִ� 12�ڸ� ������ �� �ְ� - not null
--                   name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�  - not null
--                   joindate - ��¥�� �ð��� ������ �� �ְ�  - �⺻�� sysdate

CREATE TABLE MEMBER(
M_ID VARCHAR2(12) PRIMARY KEY,
M_PWD VARCHAR2(12) NOT NULL,
NAME VARCHAR2(18) NOT NULL,
JOINDATE DATE DEFAULT SYSDATE
);

DESC MEMBER;

 
-- 3. ���̺�� : news
--     �÷���� : id - ���̰� 8�� ���� Ÿ�� - primary key
--                    writer - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
--	      title - �ѱ� �������� �ִ� 40�ڸ� ������ �� �ְ�
--	      content - �ѱ� �������� �ִ� 300�ڸ� ������ �� �ְ�
--                     writedate - ��¥�� �ð��� ������ �� �ְ�
--                     cnt - ���̰� 8�� ���� Ÿ��
--     ������ ���� : news_seq - 1���� ����, 1�� ����

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



-- 4. ���̺�� : meeting
--     �÷���� : id - ���̰� 8�� ���� Ÿ�� - primary key
--                   name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
-- 	      title - �ѱ� �������� �ִ� 40�ڸ� ������ �� �ְ� 
--	      meetingdate - ��¥�� �ð��� ������ �� �ְ�
--
--      ������ ���� : meeting_seq - 1���� ����, 1�� ����

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



--5. ���̺�� : imgtest
--     �÷���� : name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ� - primary key
--                   imgcontent - �̹����� �����ͷ� ������ �� �ְ� (blob)

CREATE TABLE IMGTEST(
NAME VARCHAR2(18) PRIMARY KEY,
IMGCONTENT BLOB
);

DESC IMGTEST;
