 [ SQL ]
hr 계정으로 접속하여 다음의 문제들을 해결하고 각 문제 아래에 SQL 문을 
작성한 후 업로드하여 제출합니다. 파일명은 sqltest.sql 입니다.

\1. employees 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.

\2. departments 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.

\3. 오늘의 날짜를 작성하는 SQL 명령을 작성하시오.
날짜의 작성 형식 : 2019년 5월 24일 

\4. 직원들이 총 몇명인지 출력합니다.

\5. 올해의 크리스마스가 무슨 요일인지 출력하시오.

\6. 부서 배치가 아직 되지 않은 직원의 id(employee_id), 이름(first_name), 해당 직원을 담당하는 매니저 ID, 매니저의 이름을 조회하여 출력하시오. 

사번 사원 이름 매니저 사번 매니저 이름
\---------------------------------------------------------------------
178 Kimberely 149 Eleni 

\7. 입사월 별로 직원의 최고급여를 조회하여 출력하시오. 단, 출력시 최고급여 내림차순으로 정렬되어 출력하며 최고급여가 10000 이상인 직원만 출력합니다. 

입사월	최고급여
\--------------------------
6월 24,000원
1월	17,000원
9월	17,000원
10월	14,000원
:
11월 10,500원

\8. 입사년도별 직원 수를 구하여 출력하시오. 단, 급여가 5000에서 10000 사이만 직원만 그리고 직원수가 7명 이상인 경우만 출력하시오. 또한 출력은 입사년도 순으로 정렬하시오.
입사년도 조건에 맞는 직원수
\-----------------------------------------------
05	11
06	9
07	8

\9. 입사일이 6월인 직원의 이름(first_name), 부서이름(department_name) 및 ‘축-입사기념달’을 출력하시오. 
직원이름 오름차순으로 정렬하여 출력 합니다.

이름 부서이름 축하메시지
\--------------------------------------------------------------
David IT 축-입사기념달
Donald Shipping 축-입사기념달

:

William Accounting 축-입사기념달 


\10. 'Den'과 동일 부서에서 근무하는 직원들의 최대월급, 최소월급 그리고 월급의 평균을 구하시오.
단, 평균값을 출력할때 백단위까지만 출력하시오.

최대월급 최소월급 월급평균
\---------------------------------------------------
11000 2500 4150

[ JDBC ]

제시된 소스를 가지고 다음 기능을 구현합니다.(시험용 오라클 계정은 hr 이며 테이블은 employees 입니다.)
직원이름의 첫 글자를 인자로 전달하면 해당 글자로 이름(first_name)이 시작되는 직원의 
이름(first_name),성(last_name), 급여(salary) 출력하는 kaja() 메소드를 구현하십시오.
SQLException 발생시 "DB연동 오류 발생 : XXX" 이라는 메시지를 출력하시오. 여기에서 XXX는 오류메시지입니다.

<< 실행 결과 >>

Elizabeth(Bates)	7,300원
Eleni(Zlotkey)	10,500원
Ellen( Abel)	11,000원


import java.sql.*;
public class Prob {	 
public static void main(String[] args) throws SQLException, ClassNotFoundException {
Class.forName("oracle.jdbc.driver.OracleDriver");	
kaja("E");	
}

public static void kaja(String fn) {
//여기에 구현하시오

}
} 