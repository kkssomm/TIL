# MySQL

### 인코딩

- 현재 인코딩 설정 확인

  ```
  SHOW VARIABLES LIKE 'c%';
  ```

- my.ini 수정

  - 경로 : `C:\Program Files\MariaDB 10.4\data\my.ini`

  - my.ini에 추가

    ```
    [client]
    default-character-set=utf8
    
    [mysqld]
    character-set-server=utf8
    collation-server=utf8_general_ci
    init_connect=SET collation_connection=utf8_general_ci
    init_connect=SET NAMES utf8
    
    [mysql]
    default-character-set=utf8
    ```

  - 서버 재시작

    ```
    net stop mariadb
    net start mariadb
    ```

