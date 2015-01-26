package mmaia.algorithm.alternatingcharacters;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			String stringToTest = scanner.next();
			int result = removeSequencialDuplicates(stringToTest);
			System.out.println(result);
		}
		scanner.close();
	}
	
	
	private static int removeSequencialDuplicates(String stringToTest){
		int result = 0;
		char[] asCharArray = stringToTest.toCharArray();
		char lastChar = '1';//initializes to an invalid char in this context as this problem only accpets letters.
		char currentChar;
		for (int i = 0; i < asCharArray.length; i++) {
			currentChar = asCharArray[i];
			if(currentChar == lastChar){
				result++;
			}
			lastChar = currentChar;
		}
		return result;
	}

}
