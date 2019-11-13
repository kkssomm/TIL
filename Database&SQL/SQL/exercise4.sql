--제출파일명 : exercise4.sql

-- 1. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 출력하시오.(5개)
select emp.ename as 이름, emp.job as 직위, dept.dname as 부서이름
from emp, dept
where dept.loc = 'DALLAS' and emp.deptno = dept.deptno;    

-- 2. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하시오.(7개)
select emp.ename as 이름, dept.dname as 부서이름
from emp,dept
where dept.deptno =emp.deptno and emp.ename like '%A%';    

-- 3. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 
--출력하는데 월급이 3000이상인 사원을 출력하시오. (3개)
select emp.ename as 사원이름, dept.dname as 부서명, emp.sal as 월급
from emp, dept
where dept.deptno =emp.deptno and emp.sal>3000;

-- 4. 직위가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하시오. (4개)
SELECT EMP.JOB AS 직위, EMP.ENAME AS 사원이름, DEPT.DNAME AS 부서이름
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO AND EMP.JOB = 'SALESMAN';   

-- 5. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하시오. (6개)
SELECT E.EMPNO AS 사원번호, E.ENAME AS 사원이름, E.SAL AS 연봉, E.SAL+E.COMM AS 실급여, S.GRADE AS 급여등급
FROM EMP E, SALGRADE S
WHERE COMM IS NOT NULL AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

-- 6. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하시오. (3개)
SELECT E.DEPTNO AS 부서번호, D.DNAME AS 부서이름, E.ENAME AS 사원이름, E.SAL AS 월급, S.GRADE AS 급여등급
FROM EMP E, DEPT D, SALGRADE S
WHERE D.DEPTNO = E.DEPTNO AND D.DEPTNO = 10 AND E.SAL BETWEEN S.LOSAL AND S.HISAL ;

-- 7. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름, 
-- 사원이름, 월급, 급여등급을 출력하시오. 그리고 그 출력된 
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로 정렬하시오. (8개)
SELECT E.DEPTNO AS 부서번호, D.DNAME AS 부서이름, E.ENAME AS 사원이름, E.SAL AS 월급, S.GRADE  AS 급여등급
FROM EMP E, DEPT D, SALGRADE S
WHERE D.DEPTNO = E.DEPTNO AND D.DEPTNO IN(10,20) AND E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY D.DEPTNO, E.SAL DESC;

-- 8. 사원들의 이름, 부서번호, 부서이름을 출력하시오. (15개) 
-- 단, 직원이 없는 부서도 출력하며 이경우 이름을 '미정'이라고
-- 출력한다.        
SELECT NVL(E.ENAME,'미정') AS 이름, D.DEPTNO AS 부서번호, D.DNAME AS 부서이름
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO(+); 

-- 9. 사원들의 이름, 부서번호, 부서이름을 출력하시오. (15개) 
-- 단, 아직 부서 배치를 못받은 직원도  출력하며 이경우 부서번호는  0 으로
-- 출력한다. 
SELECT E.ENAME AS 이름, NVL(D.DEPTNO,0) AS 부서번호, D.DNAME AS 부서이름
FROM EMP E, DEPT D
WHERE D.DEPTNO(+) = E.DEPTNO;  

-- 10. 사원들의 이름, 부서번호, 부서이름을 출력하시오. (16개) 
-- 단, 직원이 없는 부서도 출력하며 이경우 이름과 부서번호를 '미정'이라고
-- 출력한다. 아직 부서 배치를 못받은 직원도  출력하며 부서 번호와 부서 이름을
-- '미정' 이라고 출력한다.     
SELECT NVL(E.ENAME,'미정') AS 이름, E.DEPTNO AS 부서번호, NVL(D.DNAME,'미정') AS 부서이름
FROM EMP E
FULL OUTER JOIN DEPT D ON(E.DEPTNO=D.DEPTNO);  

--11. 커미션이 정해진 모든 직원의 이름, 커미션, 부서이름, 위치를 조회하는 sql을 작성하시오.
SELECT E.ENAME, E.COMM, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND COMM IS NOT NULL;        

-- 12. DALLAS에서 근무하는 사원의 이름,  월급, 등급을 출력하시오.(5개)
SELECT E.ENAME AS 이름, E.SAL AS 월급, S.GRADE AS 등급
FROM EMP E, SALGRADE S, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND D.LOC = 'DALLAS' AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

--13. 'DALLAS'에서 근무중인 직원의 명수와 월급의 합을 다음과 같은 형식으로 추출하시오.
SELECT '직원들은 ' || COUNT(*) || '명이고, 월급의 합은 '|| SUM(EMP.SAL) ||' 입니다.' AS 처리결과
FROM DEPT, EMP
WHERE DEPT.DEPTNO = EMP.DEPTNO AND DEPT.LOC = 'DALLAS'; 

--14. 부서별 최대 월급을 "부서명", "최대월급" 으로 출력하시오.(최대월급이 큰 순)
SELECT D.DNAME AS 부서명, MAX(E.SAL) AS 최대월급
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME
ORDER BY MAX(E.SAL) DESC;

--15. 직급별 최소 월급이 3000 이상이 되는 직급의 직급명과 최소 월급을  출력하시오. 
SELECT E.JOB AS 직급명, MIN(E.SAL) AS 최소월급
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
HAVING MIN(E.SAL) > 3000
GROUP BY E.JOB;

--16. 부서별 평균월급을 출력하되, 평균월급가 2000보다
-- 큰 부서의 부서 이름과 평균월급을 출력하시오.
SELECT D.DNAME AS 부서명, AVG(E.SAL) AS 평균월급 
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
HAVING AVG(E.SAL) > 2000
GROUP BY D.DNAME;

--17. 커미션이 정해진 직원들 중에서 부서별 최대월급을 출력하시오. 
--최대 월급이 높은 순으로 정렬하여 출력하시오.
SELECT D.DNAME AS 부서명, MAX(E.SAL) AS 최대월급
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO AND COMM IS NOT NULL
GROUP BY D.DNAME;

--18. 부서별 근무 직원의 5명 이상인 부서의 부서명과 직원수를 출력한다.
SELECT D.DNAME AS 부서명, COUNT(*) AS "근무인원 수"
FROM EMP E, DEPT D
WHERE D.DEPTNO = E.DEPTNO
GROUP BY D.DNAME
HAVING COUNT(*) >= 5;
