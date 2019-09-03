library(tm)
library(proxy)
library(dplyr)

듀크 <- c("사과 포도 망고")
둘리 <- c("포도 자몽 자두")
또치 <- c("복숭아 사과 포도")
도우너 <- c("오렌지 바나나 복숭아")
길동 <- c("포도 바나나 망고")
희동 <- c("포도 귤 오렌지")
lunch <- c(듀크,둘리,또치,도우너,길동,희동)

cps <- VCorpus(VectorSource(lunch))
dtm <- DocumentTermMatrix(cps,control = list(wordLengths=c(1,Inf)))
as.matrix(dtm)
m <- as.matrix(dtm)
com <- m %*% t(m)
#prob1
dist(com, method = "cosine")
#prob2
sort(colSums(m),decreasing=T) %>% head(1)
#porb3
sort(colSums(m)) %>% head(1)