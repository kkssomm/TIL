--�������ϸ� : exercise5.sql
--ANSI(SQL-99) ���� ������ ����Ͽ� ������ �ذ��Ͻÿ�.
insert into emp values(7940,'MARRY','CLERK',7782,'1999-05-13',1000,null,null);

-- 1. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����Ͻÿ�.
SELECT E.ENAME AS �̸�, E.JOB AS ����, DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�
FROM EMP E NATURAL JOIN DEPT D
WHERE D.LOC = 'DALLAS';

-- 2. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����Ͻÿ�.
SELECT E.ENAME AS �̸�, D.DNAME AS �μ��̸�
FROM EMP E NATURAL JOIN DEPT D
WHERE E.ENAME LIKE '%A%';      

-- 3. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������ 
--����ϴµ� ������ 3000�̻��� ����� ����Ͻÿ�. 
SELECT E.ENAME AS ����̸�, D.DNAME AS �μ���, E.SAL AS ����
FROM EMP E JOIN DEPT D USING (DEPTNO)
WHERE SAL >=3000;

-- 4. ������ 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����Ͻÿ�. 
SELECT E.JOB AS ����, E.ENAME AS ����̸�, D.DNAME AS �μ��̸�
FROM EMP E JOIN DEPT D USING (DEPTNO)
WHERE E.JOB = 'SALESMAN';      

-- 5. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����Ͻÿ�.
SELECT E.EMPNO AS �����ȣ, E.ENAME AS ����̸�, E.SAL AS ����, E.COMM+E.SAL AS �Ǳ޿�, S.GRADE AS �޿����
FROM EMP E JOIN SALGRADE S ON (E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE E.COMM IS NOT NULL;

-- 6. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����Ͻÿ�. (3��)
SELECT E.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�, E.ENAME AS ����̸�, E.SAL AS ����, S.GRADE AS �޿����
FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE D.DEPTNO = 10;

-- 7. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�, 
-- ����̸�, ����, �޿������ ����Ͻÿ�. �׸��� �� ��µ� 
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������ �����Ͻÿ�.
SELECT D.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�, E.ENAME AS ����̸�, E.SAL AS ����, S.GRADE AS �޿����
FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE D.DEPTNO IN(10,20)
ORDER BY D.DEPTNO, E.SAL DESC;

-- 8. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� �̸��� '����'�̶��
-- ����Ѵ�.       
SELECT NVL(E.ENAME,'����') AS �̸�, D.DEPTNO AS �μ���ȣ, D.DNAME AS �μ��̸�
FROM DEPT D LEFT OUTER JOIN EMP E ON (E.DEPTNO = D.DEPTNO);    

-- 9. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ���� �μ� ��ġ�� ������ ������  ����ϸ� �̰�� �μ���ȣ��  0 ����
-- ����Ѵ�.        
SELECT E.ENAME AS �̸�, NVL(E.DEPTNO,0) AS �μ���ȣ, NVL(D.DNAME,0) AS �μ��̸�
FROM DEPT D RIGHT OUTER JOIN EMP E ON (E.DEPTNO = D.DEPTNO);

-- 10. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� �̸��� �μ���ȣ�� '����'�̶��
-- ����Ѵ�. ���� �μ� ��ġ�� ������ ������  ����ϸ� �μ� ��ȣ�� �μ� �̸���
-- '����' �̶�� ����Ѵ�. 
SELECT NVL(E.ENAME,'����') AS �̸�, NVL2(D.DEPTNO,TO_CHAR(D.DEPTNO),'����') AS �μ���ȣ, NVL(D.DNAME,'����') AS �μ��̸�
FROM DEPT D FULL OUTER JOIN EMP E ON (E.DEPTNO = D.DEPTNO);  

--11. Ŀ�̼��� ������ ��� ������ �̸�, Ŀ�̼�, �μ��̸�, ��ġ�� ��ȸ�ϴ� sql�� �ۼ��Ͻÿ�.
SELECT E.ENAME, E.COMM, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D USING (DEPTNO)
WHERE E.COMM IS NOT NULL;       

-- 12. DALLAS���� �ٹ��ϴ� ����� �̸�,  ����, ����� ����Ͻÿ�.
SELECT E.ENAME AS �̸�, E.SAL AS ����, S.GRADE AS ���
FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE D.LOC = 'DALLAS';    

--13. 'DALLAS'���� �ٹ����� ������ ����� ������ ���� ������ ���� �������� �����Ͻÿ�.
SELECT '�������� ' || COUNT(*) || '���̰�, ������ ���� '|| SUM(E.SAL) ||' �Դϴ�.' AS ó�����
FROM EMP E JOIN DEPT D ON(E.DEPTNO = D.DEPTNO)
WHERE D.LOC = 'DALLAS';

--14. �μ��� �ִ� ������ "�μ���", "�ִ����" ���� ����Ͻÿ�.(�ִ������ ū ��)
SELECT D.DNAME AS �μ���, MAX(E.SAL) AS �ִ����
FROM EMP E JOIN DEPT D USING (DEPTNO)
GROUP BY D.DNAME
ORDER BY MAX(E.SAL) DESC;

--16. �μ��� ��տ����� ����ϵ�, ��տ��ް� 2000����
-- ū �μ��� �μ� �̸��� ��տ����� ����Ͻÿ�.
SELECT D.DNAME AS �μ���, AVG(E.SAL) AS ��տ���
FROM EMP E JOIN DEPT D ON(E.DEPTNO = D.DEPTNO)
HAVING AVG(E.SAL) >= 2000
GROUP BY D.DNAME;

--17. Ŀ�̼��� ������ ������ �߿��� �μ��� �ִ������ ����Ͻÿ�. 
--�ִ� ������ ���� ������ �����Ͽ� ����Ͻÿ�.
SELECT D.DNAME AS �μ���, MAX(E.SAL) AS �ִ����
FROM EMP E JOIN DEPT D USING(DEPTNO)
WHERE E.COMM IS NOT NULL
GROUP BY D.DNAME
ORDER BY MAX(E.SAL) DESC;

--18. �μ��� �ٹ� ������ 5�� �̻��� �μ��� �μ���� �������� ����Ѵ�.
SELECT D.DNAME AS �μ���, COUNT(*) AS "�ٹ��ο� ��"
FROM EMP E NATURAL JOIN DEPT D
GROUP BY D.DNAME
HAVING COUNT(*) >= 5;

--19. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� �������� 
--   �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
--   '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����Ͻÿ�. 
      �����ڰ� ������ '����'�� ��� ����Ѵ�.
SELECT E1.EMPNO AS �����ȣ, E1.ENAME AS ����̸�, NVL2(E1.MGR,TO_CHAR(E1.MGR),'����') AS �����ڹ�ȣ, NVL(E2.ENAME,'����') AS �������̸�
FROM EMP E1 LEFT OUTER JOIN EMP E2 ON(E1.MGR = E2.EMPNO)