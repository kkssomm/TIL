#nevigate
library(RSelenium)
remDr<-remoteDriver(remoteServerAddr="localhost",port=4445L,browserName="chrome")
remDr$open()
site <- paste("http://www.jobkorea.co.kr/")
remDr$navigate(site)

#sendKeysToElement
webElem <- remDr$findElement("css", "[name='stext']")
webElem$sendKeysToElement(list("자바",key="enter"))



# 태그 추출하기
page<-1
flag<-1
tag_v = NULL
repeat {
  for(index in 1:30) {
    # 한 페이지 내 컨텐츠 추출 -> li:nth-child(1:30)
    fullContentCSS <- paste0('#smGiList > div.list > ul > li:nth-child(',index,') > span.detailInfo > p.gibInfo > a',sep='')
    #fullContentCSS <- paste0('#smGiList > div.list > ul > li:nth-child(1) > span.detailInfo > p.gibInfo > a',sep='')
    fullContent<-remDr$findElements(using='css', fullContentCSS)
    tag <-sapply(fullContent,function(x){x$getElementText()})  
    #print(tag)
    tag_v <- c(tag_v, unlist(tag))
  }
  
  page <- page+1;
  flag <-flag+1;
  # 다음 페이지 버튼
  if(flag==20){
    break
  }
  else if(page>10){
    nextLink<-remDr$findElements(using='css',  "#smGiList > div.tplPagination > p > a")
    sapply(nextLink,function(x){x$clickElement()})
    Sys.sleep(1)
    page<-1
  }
  # 10 페이지 추출 -> li:nth-child(1:10)
  else{
    nextPageCSS <- paste0("#smGiList > div.tplPagination > ul > li:nth-child(",page,") > a",sep="")
    nextPageLink<-remDr$findElements(using='css',nextPageCSS)  
    sapply(nextPageLink,function(x){x$clickElement()})  
    Sys.sleep(1)
    #print(page)
  }
}
write(tag_v, "jobwithjava.txt")



# 상위 15개 태그의 빈도수 추출
(job <- readLines("jobwithjava.txt"));
job <- strsplit(unlist(job),',')
job <- unlist(job)
freq <- table(job)
freq <- as.data.frame(freq)

job_t <- freq[order(freq$Freq,decreasing=T),]
colnames(job_t)<-c("키워드","빈도수")
job_f<-job_t[c(1:15),]
#job_t<-as.data.frame(job_t$키워드,job_t$빈도수)
write.csv(job_f, "jobwithjava.csv",row.names=F)



# wordcloud2 로 시각화
library(wordcloud2)
wordcloud2(job_t)
