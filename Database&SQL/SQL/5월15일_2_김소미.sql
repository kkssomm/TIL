@C:\exercise_table.sql

--1
desc employees;

--2
select * from employees;

--3
select employee_id, last_name, salary 
from employees;

--4
select last_name, first_name, salary 
from employees 
order by salary desc;

--5
select employee_id, job_id, department_id
from employees 
where job_id='IT_PROG';

--6
select last_name, commission_pct 
from employees 
where commission_pct is not null
order by last_name;

--7
select employee_id, last_name, sal * 12 as "annual salary"
from employees;
-- last_name 과 sal 사이 콤마
-- sal*12
-- "annual salary"
-- as

--8
select employee_id as "Emp#", last_name as "Employee", job_id as "Job", hire_date as "Hire date"
from employees;

--9
select concat(last_name,job_id) as "Employee and Title "
from employees;

--10
select last_name, salary
from employees 
where salary >=12000;

--11
select last_name, salary 
from employees 
where salary between 5000 and 12000;

--12
select last_name, job_id, hire_date
from employees 
where last_name ='Matos' or last_name = 'Taylor'
order by hire_date;

--13
select last_name, department_id 
from employees
where department_id in(20,50);

--14
select last_name as "Employee", salary as "Monthly salary"
from employees
where salary between 5000 and 12000 AND department_id in(20,50);

--15
select last_name, hire_date
from employees 
where hire_date like '04%';

--16
select last_name, job_id
from employees 
where manager_id is null;

--17
select last_name, salary, commission_pct
from employees 
where commission_pct is not null
order by salary desc, commission_pct desc;

--18
select last_name
from employees 
where last_name like '__a%';

--19
select last_name
from employees 
where last_name like '%a%e%';

--20
select last_name, job_id, salary
from employees
where job_id in('IT_PRPG', 'SA_REP') and salary not in(480,7500,10000);

--21
select last_name as "Employee", salary as "Monthly Salary", commission_pct as "Commission"
from employees
where salary between 5000 and 12000 and department_id in(20, 80) and commission_pct = 0.2;

--22
select emp_id, emp_name, hobby
from temp
where hobby is not null and lev = '과장'; 

--23
select lev, emp_id, emp_name
from temp
order by lev, emp_id desc;

--24
select emp_id, emp_name
from temp
where emp_name BETWEEN '가' AND '깋';

--25
select emp_id, emp_name, birth_date, lev
from temp
where lev in('과장','대리')
order by birth_date;