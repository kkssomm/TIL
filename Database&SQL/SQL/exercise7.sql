--���� ���ϸ� : exercise7.sql

-- ��� �ǽ������� EMP�� DEPT ���̺��� ������ ������ ���� ����� �����ϰ�
-- ����� ���� Ȯ���� ���� ROLLBACK ����� �����Ѵ�.

-- ������ Ȯ��
-- �������� �䱸�Ǵ� DML �� ����
-- ������ Ȯ��
-- rollback

-- 1. EMP ���̺��� �����ȣ�� 7499���� ����� ������ 5000�޷��� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
SET SAL = 5000
WHERE EMPNO = 7499;
ROLLBACK;

-- 2. EMP���̺��� �μ���ȣ�� 20���� ������� ������ ���� ���޿��� 10% �λ��� �ݾ����� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
SET SAL = SAL*1.1
WHERE DEPTNO = 20;
ROLLBACK;

-- 3. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 50, �μ���ġ: BOSTON,  �μ���: RESERCH
SELECT * FROM DEPT;
INSERT INTO DEPT(DEPTNO,LOC,DNAME)
VALUES(50,'BOSTON','RESERCH');
ROLLBACK;

-- 4. EMP ���̺� �Ʒ��� ���� �����͸� �����Ѵ�.
-- �����ȣ: 9900, ����̸�: JACKSON, ����: SALESMAN, �μ���ȣ: 10, ���� : 800
SELECT * FROM EMP;
INSERT INTO EMP(EMPNO, ENAME, JOB, DEPTNO, SAL)
VALUES(9900, 'JACKSON','SALESMAN', 10,800);
ROLLBACK;

-- 5. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 60, �μ���ġ: NULL,  �μ���: MARKETING
SELECT * FROM DEPT;
INSERT INTO DEPT(DEPTNO,LOC,DNAME)
VALUES(60,NULL,'MARKETING');
ROLLBACK;

-- 6. �����ȣ�� 7698���� ����� �μ���ȣ�� 7369�� ����� 
-- �μ���ȣ�� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
SET DEPTNO = (SELECT DEPTNO FROM EMP WHERE EMPNO= 7369)
WHERE EMPNO=7698;
ROLLBACK;

-- 7. 20�� �μ��� �������� ��� �����Ѵ�.
SELECT * FROM EMP;
DELETE FROM EMP
WHERE DEPTNO = 20;
ROLLBACK;

-- 8. ������ 1000 ������ �������� �����Ѵ�.
SELECT * FROM EMP;
DELETE FROM EMP
WHERE SAL <= 1000;
ROLLBACK;

-- 9. �����ȣ�� 7900 �� ������ ������ ���� ���޿��� 5% ������Ű�� �μ���ȣ�� 40���� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
SET SAL = SAL*1.05 , DEPTNO = 40
WHERE EMPNO = 7900;
ROLLBACK;

-- 10. ���縦 �������� �Ի����� 37�� �̻��� �����鿡 ���Ͽ� ������ 2��� �����ϰ� Ŀ�̼ǵ� 3000���� �����Ѵ�.
--(�Ի����� �⵵�� �������� �ݿø��Ͽ� ����Ѵ�.)
SELECT * FROM EMP;
UPDATE EMP
SET SAL = SAL*2, COMM =3000
WHERE ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) >= 38*12;
ROLLBACK;