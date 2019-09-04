# R과 서버 연동





## R과 Oracle



### 구현과정



- 패키지 설치

```
install.packages("DBI")
install.packages("RJDBC")
```

- DB 서버 접속

`JDBC()` : 드라이버 프로그램 로딩

드라이버 압축 파일은 ojdbc6.jar 사용

```
drv <-JDBC("oracle.jdbc.driver.OracleDriver","드라이버 압축 파일 Path")
```

`dbConnect()`: DBMS 서버 접속

```
conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")
```

- DB 접속 해제

  ```
  dbDisconncet(conn)
  ```

- 테이블 리스트추출

  ```
  dbListTables(conn)
  ```

- 테이블에 저장된 데이터 읽기

  - `dbReadTable(conn,테이블명)`

  ```
  result1 <- dbReadTable(conn,"VISITOR")
  ```

  - ` dbGetQuery(conn,"SELECT * FROM 테이블명")`

  ```
  result2 <- dbGetQuery(conn,"SELECT * FROM VISITOR")
  ```

  - `dbFetch(테이블 데이터,행)` 행 인자 생략하면 모든 행 추출

  ```
  rs <- dbSendQuery(conn,"SELECT * FROM VISITOR")
  ret1 <- dbFetch(rs,1)
  ret2 <- dbFetch(rs,)
  ```

- 테이블에 데이터 저장

  - `dbWriteTable(conn,"테이블명",데이터프레임)`

  ```
  dbWriteTable(conn,"book",
               data.frame(bookname=c("자바의 정석","하둡 완벽 입문","이것이 리눅스다"),
                          price=c(30000,25000,32000))
               )
               
  dbWriteTable(conn,"cars",head(cars,3))
  ```

  - `dbSendUpdate(conn,"INSERT INTO 테이블명",데이터프레임)`

  ```
  dbSendUpdate(conn,"INSERT INTO VISITOR VALUES('R언어',sysdate,'R언어로 데이터를 입력해요',visitor_seq.nextval)")
  ```

- 데이터 수정

  ```
  dbSendUpdate(conn,"INSERT INTO cars(speed,dist) VALUES(1,1)")
  
  dbSendUpdate(conn,"UPDATE CARS SET DIST =DIST*100 WHERE SPEED=1")
  ```

- 테이블 삭제

  ```
  dbRemoveTable(conn,"CARS")
  ```



### 연동 예제

- product_click.log 파일을 데이터 프레임 형식으로 불러와 "PODUCTLOG"테이블로 저장한다.

```setwd(&quot;C:/Rstudy&quot;)
![20190904_103702](C:\Users\student\Desktop\20190904_103702.png)df<-read.table("product_click.log",stringsAsFactors = F)
names(df)<-c("click_time","pid")
df$click_time <-as.character(df$click_time)
dbWriteTable(conn,"productlog",df)
result4<-dbReadTable(conn,"PRODUCTLOG")
result4
```

![](C:\Users\student\Desktop\20190904_103702.png)





## R과 Spring FW



### RServe

:  Java 등 언어에서 R 코드를 연동할 때 필요한 기능을 서포트 하는 서버

- 패키지 설치 - Rstudio

  ```
  install.packages("Rserve")
  ```

- Rserve 기동 - cmd

  - C:\Program Files\R\R-3.6.1\library\Rserve\libs\x64의 모든 파일을 C:\Program Files\R\R-3.6.1\bin\x64에 복사

  - 이 디렉토리의 cmd 창에서 Rserve 기동 명령 수행

    ```
    Rserve --RS-encoding utf8
    ```

- Rserve 사용을 위한 pom.xml 설정 - eclipse
  - Spring MVC 프로젝트 생성
  - pom.xml에 net.rforge, com.github.lucarosellini.rJava 에 해당하는 dependency 태그 추가
  - pom.xml java 버전>1.8 과 spring 버전>5.0.2로 수정
  - 텍스트 파일 인코딩 : project > Properties > Resources > Utf8 
  - 버전 호환 : project > Properties > project Facets > Java > 1.8



### Java와 R 연동 예제

`RConnection`: R에 접속하여 역할 수행

`eval()` : REXP 타입으로 데이터를 반환 받음

`assign()` : R의 변수에 REXP 또는 String 형태로 데이터를 지정하여 설정

- R에서 주입 연산 후 가져오기

  ```
  public static void getIntegers()throws REXPMismatchException, REngineException{
  		RConnection rc = new RConnection(); 
  		double[] dataX = {1,2,3,4,5,6,7,8,9,10};
  		rc.assign("x",dataX);
  		rc.eval("y<-x+10");
  		int[] resultX = rc.eval("y").asIntegers();
  		for(int i=0;i<resultX.length;i++) {
  			System.out.println(resultX[i]);
  		}
  		rc.close();
  	}
  ```

  11
  12
  13
  14
  15
  16
  17
  18
  19
  20

- R에서 생성 연산 후 가져오기

  ```
  public static void getDataFrame1()throws REXPMismatchException, RserveException{
  		RConnection rc = new RConnection();
  		REXP x= rc.eval("d<-data.frame(LETTERS[11:20],c(11:20),stringsAsFactors=F)");
  		RList list = x.asList();
  		int v_size=list.size();
  		int d_length = list.at(0).length();
  		System.out.println("데이터(관측치)의 갯수 :"+d_length);
  		System.out.println("변수의 갯수 :"+ v_size);
  		int arrayRows = v_size;
  		int arrayCols = d_length;
  		String[][] s =new String[arrayRows][]; //데이터 프레임의 변수 갯수로 행의 크기
  		for(int i=0;i<arrayRows;i++) {
  			s[i] = list.at(i).asStrings();
  		}
  		for(int i=0;i<arrayRows;i++) {
  			for(int j=0;j<arrayCols;j++) {
  				System.out.println(s[i][j]+"\t");
  			}
  			System.out.println();
  		}
  		rc.close();
  	}
  ```

  데이터(관측치)의 갯수 :10
  변수의 갯수 :2
  K	
  L	
  M	
  N	
  O	
  P	
  Q	
  R	
  S	
  T	

  11	
  12	
  13	
  14	
  15	
  16	
  17	
  18	
  19	
  20	



### R Java Oracle 예제

필요한 경우 servlet-context.xml에 context:component 를 추가한다.

테이블명은 대문자임에 유의한다.

- RDBC

  - 테이블의 전체 행 추출

    ```
    if( type == 1)
    				r.eval("query = 'SELECT * FROM VISITOR'");
    			else if (type == 2)
    				r.eval("query = 'SELECT * FROM VISITOR order by name'");
    			RList list = r.eval("dbGetQuery(conn,query)").asList();
    ```

  - 추출 행 검색

    ```
    r.eval("query <- 'SELECT * FROM VISITOR WHERE NAME = "+name+"'"); 
    RList list = r.eval("dbGetQuery(conn,query)").asList();
    ```

  - 테이블 생성

    ```
    r.eval("insertSQL <- 'INSERT INTO visitor VALUES ("+name+",sysdate,"+content+", visitor_seq.nextval)'");
    			r.eval("dbSendUpdate (conn, insertSQL)");
    ```

- RGraph