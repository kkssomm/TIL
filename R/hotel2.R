library(KoNLP)
library(dplyr)
word_data <- readLines("result/hotel2.txt");

word_data2 <- sapply(word_data,extractNoun,USE.NAMES=F)

undata<-unlist(word_data2)

undata2<-Filter(function(x){nchar(x)>=2},undata)

word_table<-undata2 %>% table() %>% data.frame()

word_table2<-arrange(word_table,desc(Freq))
word_table2<-head(word_table2,n=10)

