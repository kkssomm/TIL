library(ggplot2)
library(DBI)
library(RJDBC)
drv <-JDBC("oracle.jdbc.driver.OracleDriver","C:/Users/student/somi/ojdbc6.jar")
conn <- dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")

#1
iris_t <-iris
names(iris_t) <- c("SLENGTH","SWIDTH","PLENGTH","PWIDTH","SPECIES")
dbWriteTable(conn,"IRIS",iris_t)

#2
rs<-dbReadTable(conn,"IRIS")

#3
ggplot(rs, aes(x=SLENGTH,y=SWIDTH,colour=SPECIES))+
  geom_point()
ggsave("db1.jpg")

ggplot(rs, aes(x=PLENGTH,y=PWIDTH,colour=SPECIES))+
  geom_point()
ggsave("db2.jpg")
