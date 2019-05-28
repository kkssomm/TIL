package rjava;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab2 {
	public static void getHotel2R()throws RserveException,REXPMismatchException{
		RConnection rc = new RConnection();
		REXP x= rc.eval("imsi<-source('c:/RStudy/hotel2.R');imsi$value");
		RList list = x.asList();
		
//		int v_size=list.size();2
//		int d_length = list.at(0).length();10
//		System.out.println(d_length);
		String[][] s =new String[2][]; //데이터 프레임의 변수 갯수로 행의 크기
		for(int i=0;i<2;i++) {
			s[i] = list.at(i).asStrings();
		}	
		for(int i=0;i<2;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(s[i][j]+"\t");
			}
			System.out.println();
		}		
		rc.close();
	}
	public static void main(String[] args) throws RserveException, REXPMismatchException {
		System.out.println("R이 보내온 최빈 명사들");
		JavaRLab2.getHotel2R();
		
	}

}
