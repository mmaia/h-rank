package mmaia.algorithm.maximizingxor;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int maxXor(int lower, int higher) {
		int result = Integer.MIN_VALUE;
		int[] numbersToTest = new int[higher - lower + 1];
		for (int i = 0; i < numbersToTest.length; i++) {
			numbersToTest[i] = lower;
			lower ++;
		}
		int[] duplicatedNumbers = Arrays.copyOf(numbersToTest, numbersToTest.length);
		for (int i = 0; i < numbersToTest.length; i++) {
			int number = numbersToTest[i];
			for (int j = 0; j < duplicatedNumbers.length; j++) {
				int numberToCompare = duplicatedNumbers[j];
				int xor = number ^ numberToCompare;
				if(xor > result){
					result = xor;
				}
			}
		}
		return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        int lower;
        lower = Integer.parseInt(scanner.nextLine());
        
        int higher;
        higher = Integer.parseInt(scanner.nextLine());
        
        result = maxXor(lower, higher);
        System.out.println(result);
        scanner.close();
    }
}
