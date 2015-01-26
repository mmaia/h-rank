package mmaia.algorithm.lonelyinteger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int lonelyinteger(int[] a) {
		int result = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			int number = a[i];
			boolean containsNumber = hs.add(number);
			if(!containsNumber)
				hs.remove(number);
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.addAll(hs);
		result = al.get(0);
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(scanner.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = scanner.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a);
		System.out.println(res);
		scanner.close();
	}
}
