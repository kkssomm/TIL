# Spring과 MariaDB 연동 및 Mybatis

## 설정

1. pom.xml 관련 라이브러리 추가

   - Maria DB, DBCP 데이터 베이스 풀 커넥션, Spring JDBC, MyBatis

   ```
   <!-- Maria DB -->
   <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>2.0.3</version>
   </dependency>
    
   <!-- DBCP 데이터베이스 풀 커넥션 -->
   <dependency>
        <groupId>commons-dbcp</groupId>
        <artifactId>commons-dbcp</artifactId>
        <version>1.4</version>
   </dependency>
   
   <!-- Spring JDBC -->
   <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>4.3.9.RELEASE</version>
   </dependency>
   
   <!-- Mybatis -->
   <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.4</version>
   </dependency>
   <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.1</version>
   </dependency>
   ```

2. root-context.xml 에 bean 설정

   - sqlSessionFactory

   `configLocation`:Mybatis의 config 파일의 위치를 지정

   `mapperLocation` 매핑할(쿼리가 작성될)파일의 위치를 지정 (/mybatis/sql/*.xml -> 하위 모든 xml파일을 매핑)

   - dataSource

     `url` =   "jdbc:mariadb://localhost:3306/데이터베이스명"

     `username` = "아이디"

     `password`="비밀번호"

   - namespace의 context,jdbc, mybastis에 체크하고 source에 아래 코드 입력

   ```
   <!-- DB -->
       <bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
           <property name="driverClass" value="org.mariadb.jdbc.Driver"></property>
           <property name="url" value="jdbc:mariadb://localhost:3306/lostfind"></property>
           <property name="username" value="mulcam"></property>
           <property name="password" value="mulcam"></property>
       </bean>
   
       <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           <property name="dataSource" ref="dataSource"></property>
           <property name="configLocation" value="classpath:/mybatis/mybatis-config.xml"></property>
           <property name="mapperLocations" value="classpath*:/mybatis/sql/*.xml"></property>
       </bean>
    
       <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
           <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
       </bean>
   ```

3. mybatis 관련 config 파일 & 쿼리 작성 파일 생성

4. test

