## Web-Client 실습



### exam_all.html

날짜 : 2019/06/11

나와 우리동네 자랑할만한 곳을 소개하는 HTML 문서 homework_css.html 을 exam_all.html로 복사하여 여기에 weather.jsp를 Ajax 요청하여 날씨정보를 이미지로 추가하고
mycard.html 에서 구현한 카드만들기 기능을 추가합니다. 


테스트는 http://IP주소:8000/edu/exam_all.html 로 하여 다른 시스템에서 요청하더라도 모든 기능이 잘 처리되도록 구현하기 바랍니다.

태그의 제목 옆에 적당한 크기로 출력하고

태그의 바로 위에 추가합니다.

모든 기능이 구현된 exam_all.html 만 제출합니다.



### mycard.html

날짜 : 2019/06/05

카드 꾸미기 앱을 HTML5의 Canvas, Web storage, Drag and Drop 기술을 이용하여 구현해 봅니다. 어떤 카드를 테마로 할 것인지 결정하여 이미지들을 모우고 다음과 비슷하게 구성하여  구현합니다.(아래에 제시한 것은 예입니다.)

다음은 첫 화면입니다. 

![설명선 3: change 이벤트](/images/mycard1.png)![설명선 3: click 이벤트](/images/mycard2.png)![img](/images/mycard3.jpg)

1. 저장하기 버튼을 클릭하면 왼쪽 박스 즉 캔바스 태그의 내용을 DataURL 형식으로 변환하여 로컬 스토리지에 저장합니다.

2. 읽어오기 버튼을 클릭하면 DataURL 형식으로 변환하여 로컬 스토리지에 저장한 내용을 읽어와서 캔바스 태그 영역에 그리기 합니다.

3. 지우기 버튼을 클릭하면 Canvas 태그 영역을 clearRect() 합니다.

4. 배경 칼라설정에서 칼라를 선택하면 캔바스 태그 영역에 설정된 칼라로 fillRect() 합니다.

5. 테두리 칼라설정에서 칼라를 선택하면 캔바스 태그 영역에 설정된 칼라로 strokeRect() 합니다.

6. 메시지 칼라를 선택하고, 메시지를 입력한 후에 Canvas 태그 영역에서 클릭하면 그 위치에 설정된 칼라로 메시지가 출력됩니다.

7. 오른쪽 이미지를 드래그하여 왼쪽 박스 영역에 드롭하면 그 위치에 미미지의 원래 크기의 

1/2~1/3 정도의 크기로 그려지게 합니다. 그냥 그리면 너무 큽니다.





### 실습 결과

- ajax를 활용한 오늘의 날씨 아이콘

![test1](/images/test1.png)



- Canvas, Web storage, Drag and Drop을 활용한 크리스마스 카드 만들기

  ![test2](/images/test2.png)

  ![test3](/images/test3.png)