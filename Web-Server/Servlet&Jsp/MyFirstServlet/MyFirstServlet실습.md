## Servlet&Jsp - Move 실습



## MoveServlet

날짜 : 2019 / 06 / 14



다음 기능의 서블릿클래스를 생성한다.

(1) 클래스명 : core.MoveServlet
(2) 매핑명 : /move
(3) GET 방식지원 서블릿
(4) 기능 : action이라는 이름으로 전달되는 Query 문자열을 추출하고

              추출된 값이
              naver 이면 네이버 페이지로
              daum 이면 다음 페이지로
              google 이면 구글 페이지로
              추출되지 않으면 직접 다음 내용을 응답한다.
    
              <h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니당..</h2>  
    
    http://localhost:8000/sedu/move?action=naver
    http://localhost:8000/sedu/move?action=daum
    http://localhost:8000/sedu/move?action=google
            http://localhost:8000/sedu/move

(5) 제출 : MoveServlet.java

