--�������ϸ� : exercise4.sql

-- 1. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����Ͻÿ�.(5��)
select emp.ename as �̸�, emp.job as ����, dept.dname as �μ��̸�
from emp, dept
where dept.loc = 'DALLAS' and emp.deptno = dept.deptno;    

-- 2. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����Ͻÿ�.(7��)
select emp.ename as �̸�, dept.dname as �μ��̸�
from emp,dept
where dept.deptno =emp.deptno and emp.ename like '%A%';    

-- 3. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������ 
--����ϴµ� ������ 3000�̻��� ����� ����Ͻÿ�. (3��)
select emp.ename as ����̸�, dept.dname as �μ���, emp.sal as ����
from emp, dept
where dept.deptno =emp.deptno and emp.sal>3000;

-- 4. ������ 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����Ͻÿ�. (4��)
SELECT EMP.JOB AS ����, EMP.ENAME AS ����̸�, DEPT.DNAME AS �μ��̸�
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO AND EMP.JOB = 'SALESMAN';   

-- 5. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����Ͻÿ�. (6��)
SELECT E.EMPNO AS �����ȣ, E.ENAME AS ����̸�, E.SAL AS ����, E.SAL+E.COMM AS �Ǳ޿�, S.GRADE AS �޿����
FROM EMP E, SALGRADE S
WHERE COMM IS NOT NULL AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

-- 6. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����Ͻÿ�. (3��)
SELECT E.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�, E.ENAME AS ����̸�, E.SAL AS ����, S.GRADE AS �޿����
FROM EMP E, DEPT D, SALGRADE S
WHERE D.DEPTNO = E.DEPTNO AND D.DEPTNO = 10 AND E.SAL BETWEEN S.LOSAL AND S.HISAL ;

-- 7. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�, 
-- ����̸�, ����, �޿������ ����Ͻÿ�. �׸��� �� ��µ� 
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������ �����Ͻÿ�. (8��)
SELECT E.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�, E.ENAME AS ����̸�, E.SAL AS ����, S.GRADE  AS �޿����
FROM EMP E, DEPT D, SALGRADE S
WHERE D.DEPTNO = E.DEPTNO AND D.DEPTNO IN(10,20) AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY D.DEPTNO, E.SAL DESC;

-- 8. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. (15��) 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� �̸��� '����'�̶��
-- ����Ѵ�.        
SELECT NVL(E.ENAME,'����') AS �̸�, D.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO(+); 

-- 9. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. (15��) 
-- ��, ���� �μ� ��ġ�� ������ ������  ����ϸ� �̰�� �μ���ȣ��  0 ����
-- ����Ѵ�. 
SELECT E.ENAME AS �̸�, NVL(D.DEPTNO,0) AS �μ���ȣ, D.DNAME AS �μ��̸�
FROM EMP E, DEPT D
WHERE D.DEPTNO(+) = E.DEPTNO;  

-- 10. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. (16��) 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� �̸��� �μ���ȣ�� '����'�̶��
-- ����Ѵ�. ���� �μ� ��ġ�� ������ ������  ����ϸ� �μ� ��ȣ�� �μ� �̸���
-- '����' �̶�� ����Ѵ�.     
SELECT NVL(E.ENAME,'����') AS �̸�, E.DEPTNO AS �μ���ȣ, NVL(D.DNAME,'����') AS �μ��̸�
FROM EMP E
FULL OUTER JOIN DEPT D ON(E.DEPTNO=D.DEPTNO);  

--11. Ŀ�̼��� ������ ��� ������ �̸�, Ŀ�̼�, �μ��̸�, ��ġ�� ��ȸ�ϴ� sql�� �ۼ��Ͻÿ�.
SELECT E.ENAME, E.COMM, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND COMM IS NOT NULL;        

-- 12. DALLAS���� �ٹ��ϴ� ����� �̸�,  ����, ����� ����Ͻÿ�.(5��)
SELECT E.ENAME AS �̸�, E.SAL AS ����, S.GRADE AS ���
FROM EMP E, SALGRADE S, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND D.LOC = 'DALLAS' AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

--13. 'DALLAS'���� �ٹ����� ������ ����� ������ ���� ������ ���� �������� �����Ͻÿ�.
SELECT '�������� ' || COUNT(*) || '���̰�, ������ ���� '|| SUM(EMP.SAL) ||' �Դϴ�.' AS ó�����
FROM DEPT, EMP
WHERE DEPT.DEPTNO = EMP.DEPTNO AND DEPT.LOC = 'DALLAS'; 

--14. �μ��� �ִ� ������ "�μ���", "�ִ����" ���� ����Ͻÿ�.(�ִ������ ū ��)
SELECT D.DNAME AS �μ���, MAX(E.SAL) AS �ִ����
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME
ORDER BY MAX(E.SAL) DESC;

--15. ���޺� �ּ� ������ 3000 �̻��� �Ǵ� ������ ���޸�� �ּ� ������  ����Ͻÿ�. 
SELECT E.JOB AS ���޸�, MIN(E.SAL) AS �ּҿ���
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
HAVING MIN(E.SAL) > 3000
GROUP BY E.JOB;

--16. �μ��� ��տ����� ����ϵ�, ��տ��ް� 2000����
-- ū �μ��� �μ� �̸��� ��տ����� ����Ͻÿ�.
SELECT D.DNAME AS �μ���, AVG(E.SAL) AS ��տ��� 
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
HAVING AVG(E.SAL) > 2000
GROUP BY D.DNAME;

--17. Ŀ�̼��� ������ ������ �߿��� �μ��� �ִ������ ����Ͻÿ�. 
--�ִ� ������ ���� ������ �����Ͽ� ����Ͻÿ�.
SELECT D.DNAME AS �μ���, MAX(E.SAL) AS �ִ����
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND COMM IS NOT NULL
GROUP BY D.DNAME;

--18. �μ��� �ٹ� ������ 5�� �̻��� �μ��� �μ���� �������� ����Ѵ�.
SELECT D.DNAME AS �μ���, COUNT(*) AS "�ٹ��ο� ��"
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME
HAVING COUNT(*) >= 5;
