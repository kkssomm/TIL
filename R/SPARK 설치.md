## SPARK 설치

- 파일 다운

  - wget  http://mirror.apache-kr.org/spark/spark-2.4.3/spark-2.4.3-bin-hadoop2.7.tgz

  - tar xvzf spark-2.4.3-bin-hadoop2.7.tgz

  - mv spark-2.4.3-bin-hadoop2.7.tgz spark-2.4.3

- PATH설정

  - vi .bashrc

  - 하둡과 하이브 중간에 추가

    export SPARK_HOME=/root/spark-2.4.3

    export PATH=$SPARK_HOME/bin:$SPARK_HOME/sbin:$PATH

  - source.bashrc
    
    - path 설정 중 실수 -> PATH=/usr/local/bin:/bin:/usr/bin-

- log4j 설정

  - cd $SPARK_HOME/conf
  - cp log4j.properties.template  log4j.properties
  - vi log4j.properties
  - 파일 수정 : 로그레벨 = INFO -> WARN

- spark-shell



## 워드 카운트 수행 : Java

**리눅스의 eclipse에서 수행**

- class 임포트
  - https://mvnrepository.com/ 에서 spark core 관련 dependency 태그 pom.xml에 추가
  - class 임포트

- jar file로 묶어서 실행

  - cd $SPARK_HOME
  - mkdir myspark
  - class export -> JAR file -> browse : /root/spark-2.4.3/myspark/wc7.jar
  - cd myspark
  - ls myspark
  - jar tvf wc7.jar
    - wc7 -> yarn을 사용해 파티션이 적용됨

  

  

## RDD





## Spart History Server

local vs application





stop-history-server.sh





# Spark2



m1복사 > 폴더명 single

m1.vmx > 메모장으로 열기 > displayName = "single"



hadoop-2.7.7/etc/hadoop

hdfs-site.xml 에 다음 내용을 편집핚다.

<value>1</value>

<value>master:50091</value>



slaves 파일을 다음 내용으로 편집한다.

master



 하둡 파일시스템 포맷핚다.

hdfs 

namenode 

-format



Hadoop의 HDFS 를 기동시킨다.

start-dfs.sh 

jps

hdfs dfs -ls /

hdfs dfs -mkdir /edudata

 cd ~/sampledata

hdfs dfs -put product_click.log /edudata
hdfs dfs -put president_moon.txt /edudata

hdfs dfs-put 2008.csv /edudata

hdfs dfs -cat /edudata/president_moon.txt



웹 페이지에서 저장된 블록 채크

http://master:50070/



## Scala

### eclipse에서 수행

- 마켓 플레이스에서 scala IDE 설치
- scala project 생성 
  - scalaexam
- scala에서 자동으로 설정된 library변경
  - JRE System Library -> Properties
- 패키지 생성 
  - edu.scala.exdam
- run as -> scalaApp



### Hello World

- 싱글톤 오브젝트 main 함수

  ```
  object S01_HelloWorldObject{
  	def main(args:Array[String]):Unit={
  		println("Hello World main")
  	}
  }
  ```

- App 트레잇 상속

  ```
  Object S01_HelloWorld extends App{
  	println("Hello World")
  }
  ```

  

### 객체

- 참조 자료형

  - Unit : 리턴값 없음
  - Nothing : 모든 객체의 서브 타입
  - Any : 모든 객체의 기본 타입

- 문자형

  ```ㄴ
  scala>var c1:char = 'a'
  c1:Char = a
  ```

- 문자열

  ```
  scala>val str1="aaa"
  ```

- 숫자형

- 데이터 형 선언

  - 암시적 선언

    : 컴파일러가 자동으로 타입 선택

    ```SA
    var X=10
    scala>var ii=10
    ```

  - 명시적 선언

    ```ㅇㅇ
    var b : Byte = 10
    var f = 10.0f //값에 약어를 추가
    ```



### 접두어 

- s

  ${변수명}을 이용해 문자열 안의 변수를 값으로 치환

  - 문자열 치환

  ```ㅇ
  val name ="David"
  ```

  - ${name}이 David로 변환

  ```
  scala  > println(s"Hello ${name}")
  ```

  > > Hello David

  - 계산 값 치환 안 됨

  ```
  scala > println(${1+1})
  ```

  > > ${1+1}

- f

- raw



### 변수

- 불변 변수(Value)

  재할당 시 오류 발생

  ```
  val value = 20
  //scala > value = 40
  ```

- 가변 변수(value)

  ```
  var variable = 10
  scala > variable =30
  ```



### 함수

- `def` 함수 선언

  ```d
  def add(x: Int ,y: Int):Int ={
      return x+y
  }
  ```

- 함수의 매개변수는 불변변수(val) 이기 때문에 재할당 불가

```
def add(x:Int): Int = {
	x=10
}
```

- 리턴 타입 생략 가능

```
def add(x: Int, y: Int)={
	println(x+y)
}
```

- 리턴 데이터 없는 경우 Unit 선언

```ㅇㅇ
def add(x:Int, y: Int): Unit={
	println(x+y)
}
```





## Spark 프로그래밍

### 기초 문법

: 터미널에서 수행

`parallelize()`

- 1

  ```
  val x= sc.
  ```

  Long = 5

  String = spark

  Array[(String, Int)] = Array((spark,1), (rdd,1), (example,1), (sample,1), (example,1))

  (spark,1)
  (rdd,1)
  (example,1)
  (sample,1)
  (example,1)

  Array[(String, Int)] = Array((spark rdd example,17), (sample example,14))

  (spark rdd example,17)
  (sample example,14)

- 



y.collect

Array[Array[String]] = Array(Array(spark, rdd, example), Array(sample, example))



### 기본 API를 이용한 프로그래밍

- 스파크 애플리케이션

  **spark에서 실행**

  - collect 액션

    : RDD에 collect 액션을 적용하면 클러스터에서 분산처리된 해당 RDD의 파티션이 드라이버 프로그램으로 반환

    ```
    scala > val Array = RDD.collect
    ```
  - 텍스트 파일로부터 RDD 생성

    `textFile(path)`

  ```
  scala > val textRDD = sc.textFile("file///root/sampledata/simple-words.txt")   
  ```
  > cat
  >   dog
  > .org
  >   cat
  >   cat
  >   &&
  >   tiger
  >   dog
  >   100
  >   tiger
  >   cat

  - RDD요소 필터링

    `filter(T => Booelan)` : RDD의 각 요소를 매개변수로 filter 메소드의 내부에서 호출되며, 매개변수로 받은 요소를 남길 경우에는 true, 삭제할 경우에는 false를 결과 값으로 함

    ```
   scala > val isWord: String => Boolean = word => word.matches("""\p{Alnum}+""")
    scala > val wordRDD = textRDD.filter(isWord)
    ```
  > cat
  >   dog
  >   cat
  >   cat
  >   tiger
  >   dog
  >   100
  >   tiger
  >   cat

  - RDD요소 가공

    ```
  scala > val wordAndOnePairRDD = wordRDD.amp(word => (word, 1))
    ```
  >   (cat,1)
  >   (dog,1)
  >   (cat,1)
  >   (cat,1)
  >   (tiger,1)
  >   (dog,1)
  >   (100,1)
  >   (tiger,1)
  >   (cat,1)

  - RDD 요소를 키 단위로 집약처리

  ```
  scala> val wordAncCountRDD = wordAndOnePairRDD.reduceByKey((result,elem)=>result+elem)
  ```

  >  (dog,2)
  >
  > (cat,4)
  >
  > (tiger,2)
  >
  > (100,1)

- 드라이버 프로그램 작성하기 

  **linux-eclipse 에서 실행**

  1) Hadoop DFS 와 Hadoop YARN을 기동

  2) scalaexam을 maven 프로젝트로 변환

  - 프로젝트>Configure>Convert to Maven

  3) pom.xml에 spark core 라이브러리에 대한  <dependecy> 태그를 추가

  - [mvnrepository](https://mvnrepository.com/)

  4) jar 파일을 저장할 폴더를 SPARK_HOME 디렉토리에 생성

  ```
mkdir myspark
  ```
  
  - 로컬파일시스템

    ```
  spark-submit --master local --class com.example.chapter5.WordCount --name WordCount wc111.jar file:///root/sampledata/simple-words.txt
    ```
  
  - 하둡파일시스템
  
    ```
    spark-submit --master local --class com.example.chapter5.WordCount --name WordCount wc111.jar file:///root/sampledata/simple-words.txt
    ```



- Sort

  - RDD 요소 정렬

    ```
    val textRDD = sc.textFile("file:///root/spark-2.4.3/README.md")
    val wordCandidateRDD = textRDD.flatMap(_.split("[ ,.]"))
    val wordRDD = wordCandidateRDD.filter(_.matches("""\p{Alnum}+"""))
    val wordAndOnePairRDD = wordRDD.map((_,1))
    val wordAndCountRDD = wordAndOnePairRDD.reduceByKey(_+_)
    
    val countAndWordRDD = wordAndCountRDD.map{wordAndCount =>
         | (wordAndCount._2,wordAndCount._1)
         | }
         
    val sortedCWRDD = countAndWordRDD.sortByKey(false)
    val sortedWCRDD = sortedCWRDD.map{countAndWord=>
         | (countAndWord._2,countAndWord._1)
         | }
    ```

    - 다른방법

      ```
       val sortedWCRDD = sortedCWRDD.map{
           | case(count,word)=>
           | (word,count)
           | }
      ```

  - RDD 선두로부터 요소 꺼내기

    ```
    scala> val top3WordArray=sortedWCRDD.take(3)
    scala> top3WordArray.foreach(println)
    ```

    > (the,24)
    > (Spark,17)
    > (to,17)



### Spark SQL

- 준비

  - hive-site.xml

    hive-site.xml을 $SPARK_HOME/conf에 배치

  - 샘플 데이터 파일

    /edudata/data/dessert-menu.csv





scala> case class Dessert(menuId: String, name: String, price: Int, kcal:Int)
defined class Dessert

scala> val dessertRDD = sc.textFile("/edudata/data/dessert-menu.csv")
dessertRDD: org.apache.spark.rdd.RDD[String] = /edudata/data/dessert-menu.csv MapPartitionsRDD[1] at textFile at <console>:24

scala> val IdAndCountArray = dessertRDD.collect
IdAndCountArray: Array[String] = Array(D-0,초콜릿 파르페,4900,420, D-1,푸딩 파르페,5300,380, D-2,딸기 파르페,5200,320, D-3,판나코타,4200,283, D-4,치즈 무스,5800,288, D-5,아포가토,3000,248, D-6,티라미스,6000,251, D-7,녹차 파르페,4500,380, D-8,바닐라 젤라또,3600,131, D-9,카라멜 팬케익,3900,440, D-10,크림 안미츠,5000,250, D-11,고구마 파르페,6500,650, D-12,녹차 빙수,3800,320, D-13,초코 크레이프,3700,300, D-14,바나나 크레이프,3300,220, D-15,커스터드 푸딩,2000,120, D-16,초코 토르테,3300,220, D-17,치즈 수플레,2200,160, D-18,호박 타르트,3400,230, D-19,캬라멜 롤,3700,230, D-20,치즈 케익,4000,230, D-21,애플 파이,4400,350, D-22,몽블랑,4700,290)

scala> val dessertDF = dessertRDD.map{ record =>
     | val splitRecord = record.split(",")
     | val menuId = splitRecord(0)
     | val name = splitRecord(1)
     | price = splitRecord(2).toInt
     | kcal = splitRecord(3).toInt
     | Dessert(menuId, name, price, kcal)
     | }.toDF

scala> val dessertDF = dessertRDD.map{ record =>
     | val splitRecord = record.split(",")
     | val menuId = splitRecord(0)
     | val name = splitRecord(1)
     | val price = splitRecord(2).toInt
     | val kcal = splitRecord(3).toInt
     | Dessert(menuId,name,price,kcal)
     | }.toDF
dessertDF: org.apache.spark.sql.DataFrame = [menuId: string, name: string ... 2 more fields]

scala> dessertDF.printSchema
root
 |-- menuId: string (nullable = true)
 |-- name: string (nullable = true)
 |-- price: integer (nullable = false)
 |-- kcal: integer (nullable = false)


scala> val rowRDD = dessertDF.rdd
rowRDD: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = MapPartitionsRDD[6] at rdd at <console>:25

scala> val nameAndPriceRDD = rowRDD.map{row=>
     | val name = row.getString(1)
     | val price = row.getInt(2)
     | (name,price)
     | }
nameAndPriceRDD: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[7] at map at <console>:25

scala> nameAndPriceRDD.collect.foreach(pritnln)
<console>:26: error: not found: value pritnln
       nameAndPriceRDD.collect.foreach(pritnln)
                                       ^

scala> nameAndPriceRDD.collect.foreach(println)
(초콜릿 파르페,4900)
(푸딩 파르페,5300)
(딸기 파르페,5200)
(판나코타,4200)
(치즈 무스,5800)
(아포가토,3000)
(티라미스,6000)
(녹차 파르페,4500)
(바닐라 젤라또,3600)
(카라멜 팬케익,3900)
(크림 안미츠,5000)
(고구마 파르페,6500)
(녹차 빙수,3800)
(초코 크레이프,3700)
(바나나 크레이프,3300)
(커스터드 푸딩,2000)
(초코 토르테,3300)
(치즈 수플레,2200)
(호박 타르트,3400)
(캬라멜 롤,3700)
(치즈 케익,4000)
(애플 파이,4400)
(몽블랑,4700)