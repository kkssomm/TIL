--�������ϸ� : exercise2.sql
--QUESTION
--1. ��� ���̺��� ����̸��� ù���ڴ� �빮�ڷ�, �������� �ҹ��ڷ� ����Ͻÿ�.
select initcap(ename) as ����̸�
from emp;

--2. ������̺��� ����̸��� �̰� �� �̸��� �ι�° ���ں��� �׹�° ���ڱ���
-- ����Ͻÿ�.
select ename as ����̸�, substr(ename,2,3) as "2-4����"
from emp;

--3. ������̺��� ��� �̸��� ���� ������ ����Ͻÿ�.
select length(ename) as ���ڰ���
from emp;

--4. ������̺��� ��� �̸��� �� ���� �ϳ��� ������ ���� �ϳ��� ����ϵ� 
-- ��� �ҹ��ڷ� ���� ����Ͻÿ�.
select lower(substr(ename,1,1)) as �ձ���, lower(substr(ename,-1)) as ����������
from emp;

--5. 3456.78�� �ݿø��Ͽ� �Ҽ��� �Ʒ� ù��° �ڸ� ������ ��Ÿ���ÿ�.
select round(3456.78,1)
from dual;

select sal*55
from emp;

-------------------------------------------------------------------
--6. ���޿� 55�� ���ϰ� �ʴ����� �����Ͽ� ����ϴµ� ���޵ڿ� '��'�� ���̰� 
--    õ�������� ','�� �ٿ��� ����Ѵ�.
select (to_char(trunc(sal*55,-2),'999,999')||'��') as �����
from emp;
--[���]	��� ���
-----------------
--          40,000��
--	80,000��
-- 	62,500��
--	148,700��

--7. ���� �̸��� Ŀ�̼� ���� ���θ� ����ϴµ� �����Ǿ����� '����'
--    �������� �ʾ����� '����'�� ����Ͻÿ�.
select ename as �����̸�, nvl2(comm,'����','����') as Ŀ�̼Ǽ�������
from emp;
--    	SMITH	����	
--	ALLEN	����	300
--	WARD	����	200
--	JONES	����	30

--8. ���� �̸��� �μ���ȣ �׸��� �μ���ȣ�� ���� �μ����� ����Ͻÿ�.
--    �μ��� ���� ������ '����' �� ����Ͻÿ�.
--    (�μ��� : 10 �̸� 'A �μ�', 20 �̸� 'B �μ�', 30 �̸� 'C �μ�')
select ename as �����̸�, deptno as �μ���ȣ, 
decode(deptno,
10, 'A�μ�',
20, 'B�μ�',
30, 'C�μ�',
'����')as �μ���
from emp;

--9. ������ 'SALESMAN'�̰� ������ 1000�̻��� �����
-- �̸��� ������ ����Ͻÿ�.
select ename as �̸�, sal as ����
from emp
where job = 'SALESMAN' and sal>=1000;

--10. ���ó�¥�� ���ó�¥���� 10���� ���� ��¥�� ����Ͻÿ�.
select sysdate, sysdate+10
from dual;

--11. ���� �ð��� "....�� ..�� ..�� ..�� ..��" ���� ����Ͻÿ�.
select to_char(sysdate, 'yyyy"��"mm"��"dd"��"hh24"��":mi"��') as ���糯¥�ð�
from dual;

--12. ������ �̸�, ���޿�, ������ ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ�.
--(��, ������ ������ $200�� �� ���ʽ��� �����Ͽ� ����մϴ�.)
select ename as �̸�, sal as ���޿�, sal*12+200 as ����
from emp;

--13.  5��16��_�߰�.docx �� ��ü
select ename as �̸�, sal as ����,
case
when sal < 1000 then 'A'
when sal <2000 then 'B'
when sal<3000 then 'C'
when sal<4000 then 'D'
else 'E'
end as �ڵ�
from emp;

--14. 5��16��_�߰�.docx �� ��ü
select ename as �̸�, deptno as �μ���ȣ, 
decode(deptno,
10, 'A',
20, 'B',
30, 'C',
'F')as �ڵ�
from emp;

--15.  ���̸��� Employee and Job Title�̰�, �޸��� �������� ���е� �����̸��� 
--������ ����ǵ��� �ϴ� ���Ǹ� �ۼ��Ͻÿ�.
select ename || ',' || job as "Employee and Job Title"
from emp;

--16. �̸��� �ι�° ���ڰ� ��A���� ��� ������ �̸��� ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ� 
select ename
from emp
where substr(ename,2,1) = 'A';

--17. �̸�, �Ի���, �Ի��� ������ ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ�
--�Ի��� ������ �������� �������� �����մϴ�.(�̶� ���ؿ����� �����Ϸ� �մϴ�)
--(�̶�, �̸�, �Ի��� �Ի���� ��Ī�� ����մϴ�.)
select ename as �̸�, 
to_char(hiredate,'yyyy"��"mm"��"dd"��"') as �Ի���,
to_char(hiredate,'day') as �Ի����
from emp;

--18.   ��� ������ �̸��� ��������� �Ի�Ⱓ�� ������(���� ����� ���� �ݿø��� ��)�� 
--   ��ȸ�ϴ� ���Ǹ� �ۼ��Ͻÿ�
--   (�̶�, �Ի�Ⱓ�� �ش��ϴ� ����Ī�� ��MONTHS WORKED���� �ϰ�, 
--    �Ի�Ⱓ�� ���� ���� ���������� �����մϴ�.)
select ename,
round(months_between(sysdate, hiredate)) as "MONTHS WORKED"
from emp
order by round(months_between(sysdate, hiredate)) ASC;

--19. ������̺��� ����̸��� ������� ���� ��¥������ �ٹ��ϼ��� ���Ͻÿ�.
select ename as ����̸�, 
trunc(sysdate-hiredate) as �ٹ��ϼ�
from emp;

------------------------------------------------------
------------------------------------------------
--20. 1981�⵵�� �Ի��� �������� �̸�, ���� �׸��� �Ի�����
--         �Ի��� ������ ����Ͻÿ�.
select ename as �̸�, job as ����, hiredate as �Ի���
from emp
where to_char(hiredate, 'yyyy') = 1981
order by hiredate;

--21. �������� �������� ������ ����ϴ� SQL  ����� �ۼ��Ͻÿ�.
select to_char(to_date('19950301','yyyy-mm-dd'),'day')
from dual;

--22. ���縦 �������� ���� �¾�� �� ���� �Ǿ����� �� �� �ִ� 
--      SQL ����� �ۼ��Ͻÿ�.
select trunc(months_between(sysdate,to_date('19950301','yyyy-mm-dd'))) as �¾��x����
from dual;


--23. �������� �̸��� ���� �׸��� Ŀ�̼� ������ ����ϴµ�
--     Ŀ�̼��� �������� ���� ������ "����"�̶�� ����Ͻÿ�.
select ename as�̸�, sal as����, nvl2(comm,to_char(comm),'����') as Ŀ�̼�����
from emp;

--24. ������̺��� �̸��� ù���ڰ� A�̰� ������ ���ڰ� N�� �ƴ� �����
-- �̸��� ����Ͻÿ�.
select ename as �̸�
from emp
where ename like 'A%' and not substr(ename,-1) ='N'; 

--25. ������ �̸�, �Ի� ��¥ �׸��� �⵵�� �������� �Ͽ� �ݿø��� ��¥��
--     ����Ͻÿ�.   
select ename as �̸�, hiredate as ��¥,
round(hiredate,'yyyy') as �ݿø���¥
from emp;