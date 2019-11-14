package day11;

import java.util.*;

public class HashMapLab1 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner s = new Scanner(System.in);
		int count = 0;
		for(int i=0;map.size()<5;i++) {
			System.out.print("나라이름/인구수 입력:");
			String name = s.next();
			int num = s.nextInt();
			map.put(name,num);
		}
		//System.out.println(map);
		for(String key:map.keySet()) {
			Integer num = map.get(key);
			count++;
			if(count==5) {
				System.out.print(key+"("+num+")");
				break;
			}
			System.out.print(key+"("+num+")");
			System.out.print(",");
		}
s.close();       
	}

}
