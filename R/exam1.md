- Q1. mpg 데이터의 cty(도시 연비)와 hwy(고속도로 연비) 간에 어떤 관계가 있는지 알아보려고 합니다. x축은 cty, y축은 hwy로 된 산점도를 만들어 보세요.



Q2. 자동차 중에서 어떤 class(자동차 종류)가 가장 많은지 알아보려고 합니다. 자동차 종류별 빈도를 표현한 막대 그래프를 만들어 보세요.

Q3. 미국 지역별 인구통계 정보를 담은 ggplot2 패키지의 midwest 데이터를 이용해서 전체 인구와 아시아인 인구 간에 어떤 관계가 있는지 알아보려고 합니다. x축은 poptotal(전체 인구), y축은 popasian(아시아인 인구)으로 된 산점도를 만들어 보세요. 전체 인구는 50만 명 이하, 아시아인 인구는 1만 명 이하인 지역만 산점도에 표시되게 설정하세요.

Q4. class(자동차 종류)가 "compact", "subcompact", "suv"인 자동차의 cty(도시 연비)가 어떻게 다른지 비교해보려고 합니다. 세 차종의 cty를 나타낸 상자 그림을 만들어보세요.

Q5. product_click.log 파일을 가지고 클릭된 상품의 갯수를 가지고 바 그래프로 출력합니다.

Q6. product_click.log 파일을 가지고 요일별 상품 클릭 횟수를 계산하여 바 그래프로 출력합니다.(x축은 요일명)



[ 참고 ]
? 10만 단위가 넘는 숫자는 지수 표기법(Exponential Notation)에 따라 표현됨
? 1e+05 = 10만(1 × 10의 5승)
? 정수로 표현하기 : options(scipen = 99) 실행 후 그래프 생성
? 지수로 표현하기 : options(scipen = 0) 실행 후 그래프 생성
? R 스튜디오 재실행시 옵션 원상 복구됨



```
data(mpg)
data(midwest)
library(ggplot2)
#1
ggplot(mpg, aes(x=cty,y=hwy))+geom_point()

#2
ggplot(mpg,aes(x=class))+geom_bar(width=0.5,aes(fill=class))

#3
options(scipen = 99)
ggplot(midwest, aes(x=poptotal,y=popasian))+geom_point()+
  xlim(0,500000)+ylim(0,10000)

#4
ggplot(data=subset(mpg,class %in% c("compact","subcompact","suv")), aes(x=class, y=cty)) + 
  geom_boxplot()

#5
click <- read.table("product_click.log")
pid <- click[2]
ggplot(pid,aes(x=V2))+geom_bar(width=0.5,aes(fill=V2))

#6
요일명<-weekdays(as.Date(substr(click$V1, 1,8),format='%Y%m%d'))
ggplot(pid,aes(x=요일명))+geom_bar(width=0.5,aes(fill=요일명))+
  scale_x_discrete(limits=c("월요일","화요일","수요일","목요일","금요일","토요일","일요일"))

ggsave("result1.png")
ggsave("result2.png")
ggsave("result3.png")
ggsave("result4.png")
ggsave("result5.png")
ggsave("result6.png")

```