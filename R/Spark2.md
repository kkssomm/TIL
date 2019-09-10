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