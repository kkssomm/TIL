package rjava;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab1 {
	public static void getHotel2()throws REXPMismatchException, RserveException{
		RConnection rc = new RConnection();
		
		rc.eval("library(KoNLP)");
		rc.eval("word_data <- readLines('result/hotel2.txt')");
		rc.eval("word_data2 <- sapply(word_data,extractNoun,USE.NAMES=F)");
		rc.eval("undata<-unlist(word_data2)");
		rc.eval("undata2<-Filter(function(x){nchar(x)>=2},undata)");
		rc.eval("word_table <- table(undata2)");
		rc.eval("word_table2<-sort(word_table,decreasing=T)");
		rc.eval("word_table2<-head(word_table2,n=10)");
		String[] result= rc.eval("names(word_table2)").asStrings();
		
		for(int i=0;i<10;i++) {
			System.out.print(" "+result[i]);
		}
		rc.close();
	}
	
	public static void main(String[] args) throws REngineException, REXPMismatchException {
		System.out.print("R이 보내온 최빈 명사들 :");
		JavaRLab1.getHotel2();
	}
	
}
