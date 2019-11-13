package day11;

import java.util.HashSet;

public class LottoSet {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		int i;
        for (i= 0; set.size()<10; i++) {
        	set.add((int)(Math.random()*21)+10);
        }
		
		
	System.out.println(set.size());

        System.out.println(set);
    }
	}


