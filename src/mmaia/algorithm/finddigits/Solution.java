package mmaia.algorithm.finddigits;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		int[] numbersToProcess = new int[numberOfTestCases];
		// loads the test case from stdin.
		for (int i = 0; i < numbersToProcess.length; i++) {
			numbersToProcess[i] = scanner.nextInt();
		}

		for (int i = 0; i < numbersToProcess.length; i++) {
			int number = numbersToProcess[i];
			// start processing the numbers
			char[] digitsCh = ("" + number).toCharArray();
			int[] digitsInt = new int[digitsCh.length];
			
			//load any digit in number to a position in digitsInt array.
			for (int j = 0; j < digitsCh.length; j++) {
				digitsInt[j] = Character.getNumericValue(digitsCh[j]);
			}

			int result = 0;
			int module = 0;
			for (int k = 0; k < digitsInt.length; k++) {
				if(digitsInt[k] != 0){
					module = number % digitsInt[k];
					if (module == 0)
						result++;
				}
				
			}
			System.out.println(result);
		}
		// closing scanner could be omitted in this case but good practice.
		scanner.close();
	}
}
