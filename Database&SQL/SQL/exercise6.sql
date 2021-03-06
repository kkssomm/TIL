--QUESTION
--제출파일명 : exercise6.sql
--모두 서브쿼리를 사용해서 해결합니다.

-- 1. 'DALLAS'에서 근무하는 사원의 이름, 직위, 부서번호를 출력하시오.
SELECT ENAME AS 이름, JOB AS 직위, DEPTNO AS 부서번호
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

--2. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급 그리고 부서명을 출력한다.
SELECT E.ENAME AS 사원명, E.SAL AS 급여, D.DNAME AS 부서명
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.SAL > (SELECT SAL FROM EMP WHERE ENAME = 'SMITH');

--3. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급, 
--   부서번호를 출력한다.(10번부서 제외하고)
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE DEPTNO = 10);

--4. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데 'BLAKE'는 빼고 출력한다. 
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE') AND ENAME != 'BLAKE';

--5. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력한다.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

--6. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
--   있는 사원의 사원번호와 이름을 출력한다.
SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--7 자신의 급여가 평균급여보다 많고,이름에 S자가 들어가는 사원과 동일한
--  부서에서 근무하는 모든 사원의 사원번호,이름 및 급여를 출력하시오.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
AND DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%S%');

--8. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
--   많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력한다. 
--   (단, ALL 또는 ANY 연산자를 사용할 것)
SELECT ENAME AS 이름, DEPTNO AS 부서번호, SAL AS 월급
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

--10. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력한다.
with
D as (select * from dept where dname = 'SALES'),
E as (select * from emp)
SELECT E.DEPTNO,E.ENAME, E.JOB
FROM E, D
WHERE E.Deptno = D.deptno;

--11. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력한다. 
--     (KING에게 보고하는 사원이란 mgr이 KING인 사원을 의미함) 
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');