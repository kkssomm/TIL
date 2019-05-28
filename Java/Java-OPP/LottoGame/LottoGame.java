package day10;

import java.util.Random;

class LottoMachine {
	private int[] nums = new int[6];

	LottoMachine() {
	}

	void createLottoNums() {
		Random r = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(20);
		}
	}

	void checkLottoNums() throws Exception {
		try {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] == nums[j])
						throw new DuplicateException();
				}
			}
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public int[] getNums() {
		return nums;
	}
}

class DuplicateException extends Exception {
	DuplicateException() {
		super("중복된 로또 번호가 발생했습니다.");
	}
}

public class LottoGame {

	public static void main(String[] args) throws Exception {
		int i;
		LottoMachine l = new LottoMachine();
		l.createLottoNums();
		l.checkLottoNums();
		for (i = 0; i < 5; i++) {
			System.out.print(l.getNums()[i]+",");
		}
System.out.println(l.getNums()[5]);
	}

}
