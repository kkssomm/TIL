package day12;
import java.util.*;

class CreateList {
	public ArrayList<Integer> convertList(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = array.length - 1; i >= 0; i--) {
			list.add(array[i]);
		}
		return list;
	}
}

public class ListTest {

	public static void main(String[] args) {
		int array[] = { 3, 4, 2, 5, 2, 3, 6, 7, 5, 7, 9 };
		CreateList list = new CreateList();

		for (int i = 0; i < array.length; i++) {
			Integer data = list.convertList(array).get(i);
			System.out.println(data);
		}

	}

}
