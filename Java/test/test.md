 \1. 다음과 같은 결과를 출력하는 PrintAlpha 클래스를 구현하시오.(공유폴더에서 PrintAlpha.java 를 복사하여 구현하세요.)

A
BC
DEF
GHIJ
KLMNO 

\2. 입력 값에 따라 다음 기능을 처리하는 counter 메서드를 작성하시오. (공유폴더에서 WordTest.java 를 복사하여 구현하세요.)
package test;
public class WordTest {
public static void main(String[] args) {
WordCount a = new WordCount();
System.out.println("결과 1 : "+a.counter("java jdbc sql html5 css javascript", true));
System.out.println("결과 2 : "+a.counter("java jdbc sql html5 css javascript", false));
}
}
// - word = true 인 경우 => 단어의 개수를 리턴한다.
// - word = false 인 경우 => 문자열의 개수를 리턴한다.(공백도 포함)
class WordCount {	
int counter(String text, boolean word){
// 구현하세요.	
return 0; // 변경하세요.
}	
}

[ 실행 결과 ]
결과 1 : 6
결과 2 : 34

\3. 다음에 제시된 소스를 완성하여 요구되는 기능을 구현하세요.(공유폴더에서 GoodsTest.java와 Goods.java 를 복사하여 구현하세요.)
[ 객체 생성시 사용되는 데이터 ]
데이터 1 : "PRD-0001", "듀크컴퓨터", 10000, 'N'
데이터 2 : "PRD-0002", "턱시컴퓨터", 20000
package test;
public class GoodsTest {
public static void main(String[] args) {
// 위에서 제시된 데이터를 가지고 Goods 객체를 두 개 생성하고 
// 각각 getGoodsInfo()를 호출하고 리턴결과를 출력합니다.
}
}

package test;
public class Goods {
String prodId; // 상품 아이디 
String prodName; // 상품 이름 
int price; // 상품 가격 
char asYn; // AS 가능 여부 

// 생성자 두 개를 구현하시오. 

// getGoodsInfo() 메서드를 구현하시오.
}

[ 실행 결과 ]

상품ID : PRD-0001, 상품명 : 듀크컴퓨터, 가격 : 10,000원, AS가능여부 : 불가
상품ID : PRD-0002, 상품명 : 턱시컴퓨터, 가격 : 20,000원, AS가능여부 : 가능 