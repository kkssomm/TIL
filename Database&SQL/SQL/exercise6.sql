--QUESTION
--�������ϸ� : exercise6.sql
--��� ���������� ����ؼ� �ذ��մϴ�.

-- 1. 'DALLAS'���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ�� ����Ͻÿ�.
SELECT ENAME AS �̸�, JOB AS ����, DEPTNO AS �μ���ȣ
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

--2. 'SMITH'���� ������ ���� �޴� ������� �̸��� ���� �׸��� �μ����� ����Ѵ�.
SELECT E.ENAME AS �����, E.SAL AS �޿�, D.DNAME AS �μ���
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

--3. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����, 
--   �μ���ȣ�� ����Ѵ�.(10���μ� �����ϰ�)
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE DEPTNO = 10);

--4. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ� 'BLAKE'�� ���� ����Ѵ�. 
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE') AND ENAME != 'BLAKE';

--5. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����Ѵ�.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

--6. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
--   �ִ� ����� �����ȣ�� �̸��� ����Ѵ�.
SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--7 �ڽ��� �޿��� ��ձ޿����� ����,�̸��� S�ڰ� ���� ����� ������
--  �μ����� �ٹ��ϴ� ��� ����� �����ȣ,�̸� �� �޿��� ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%S%');

--8. 30�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
--   ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����Ѵ�. 
--   (��, ALL �Ǵ� ANY �����ڸ� ����� ��)
SELECT ENAME AS �̸�, DEPTNO AS �μ���ȣ, SAL AS ����
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

--10. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����Ѵ�.
with
D as (select * from dept where dname = 'SALES'),
E as (select * from emp)
SELECT E.DEPTNO,E.ENAME, E.JOB
FROM E, D
WHERE E.Deptno = D.deptno;

--11. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����Ѵ�. 
--     (KING���� �����ϴ� ����̶� mgr�� KING�� ����� �ǹ���) 
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');