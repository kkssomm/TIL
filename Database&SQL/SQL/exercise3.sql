--�������ϸ� : exercise3.sql
-- scott_db.sql �� �����Ͽ� scott ����� �������� �����Ű�� 
-- course1 �� couse2 ���̺��� ������ �Ŀ� �����Ѵ�.
@C:\Users\student\somi\sql\scott_db.sql

-- 1. ���տ����� �ǽ�

-- 1.1 course1 �� course2 �� ��� �����ϴ� �л����� �̸�, ��ȭ ��ȣ �׸��� 
--    ���̸� ����Ͻÿ�.
select name, phone, age
from course1
intersect
select name, phone, age
from course2;
  
-- 1.2 course1 �̵� course2 �� �����ϴ� �л����� �̸�, ��ȭ ��ȣ �׸��� 
--    ���̸� ����ϴµ� ���̰� ���� ������ ����Ͻÿ�.
select name, phone, age
from course1
union
select name, phone, age
from course2
order by age desc;

-- 1.3 course1�� ���������� course2 �� �������� �ʴ� �л����� �̸��� ����Ͻÿ�.
select name, phone, age
from course1
minus
select name, phone, age
from course2;

-- 1.4 course2�� ���������� course1 �� �������� �ʴ� �л����� �̸��� ��ȭ��ȣ�� 
--    �̸� ������ ����Ͻÿ�.
select name, phone, age
from course2
minus
select name, phone, age
from course1
order by name;

--2. ��� ������ ������ ����� ���Ͻÿ�. 
select trunc(avg(sal),2) as �������
from emp;

--3. ��� �������� �޴� Ŀ�̼��� ���� ���Ͻÿ�.
select sum(comm) as "Ŀ�̼� ��"
from emp;

--4. 'DALLAS'���� �ٹ����� ������ ����� ������ ���� ������ ���� �������� �����Ͻÿ�.
	ó�����
	----------------------------
                �������� X���̰� ������ ���� X�Դϴ�.


--5. �μ��� �ִ� ������ "�μ���", "�ִ����" ���� ����Ͻÿ�.(�ִ������ ū ��)
	
	�μ���	�ִ����
	----------------------------
	xxxx          xxx
	 :	   :

--6. ���޺� �ּ� ������ 3000 �̻��� �Ǵ� ������ ���޸�� �ּ� ������  ����Ͻÿ�. 

	���޸�	�ּҿ���
	----------------------------
	xxxx          xxx
	 :	   :


--7. �μ��� ��տ����� ����ϵ�, ��տ��ް� 2000����
-- ū �μ��� �μ� �̸��� ��տ����� ����Ͻÿ�.

	�μ���     ��տ���
           	------------------------
	xxxx          xxx
	 :	   :



--8. �� ���޺��� �ѿ����� ����ϵ� �ѿ����� ���� ������ ����Ͻÿ�.
select job as ���޸�, sum(sal) as �ѿ���
from emp
group by job
order by sum(sal);

--9. ���޺� �ѿ����� ����ϵ�, ������ 'MANAGER'�� �������� �����Ͻÿ�. 
--   �׸��� �� �ѿ����� 5000���� ū ���ް� �ѿ��޸� ����Ͻÿ�.
select job as ���޸�, sum(sal) as �ѿ���
from emp
where not job = 'MANAGER'
group by job
having sum(sal) >5000;

--10. Ŀ�̼��� ������ ������ �߿��� �μ��� �ִ������ ����Ͻÿ�. 
--�ִ� ������ ���� ������ �����Ͽ� ����Ͻÿ�.

	�μ���     �ִ����
           	------------------------
	xxxx          xxx
	 :	   :

--11. 30�� �μ��� ������ ����� ����� �˻��Ѵ�.
-- ��������� ����+Ŀ�̼�(null�̸� 0���� ���)�̸� 
-- ��� ����� �Ҽ��� ���� �� �ڸ�(�ݿø�)���� ���ϵ� ������� ����Ѵ�.
select job as "���� ��", round(avg(sal+nvl(comm,0)),2) as "��տ���"
from emp
where deptno = 30
group by job;


--12. �μ��� �ٹ� ������ 5�� �̻��� �μ��� �μ���� �������� ����Ѵ�.

	�μ���       �ٹ��ο� ��
              ---------------------------
              xxxx            x
	 :	    :



  