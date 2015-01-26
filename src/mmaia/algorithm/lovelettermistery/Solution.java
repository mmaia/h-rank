package mmaia.algorithm.lovelettermistery;

import java.util.Scanner;
import java.util.logging.Logger;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTests = scanner.nextInt();
		for(int i = 0; i < numberOfTests; i++){
			String stringToTest = scanner.next();
			int palindrome = calcPalindrome(stringToTest);
			System.out.println(palindrome);
		}
		scanner.close();
	}

	/**
	 * calculates the number of operations necessary to make a string a palindrome. 
	 * To be a palindrome a String should have the first half of it equals the second half of it.
	 * Because chars can be translated to int and mapped to ascii table what we need to do is to implement a routine
	 * where the first char from the string is compared with the last and see the difference between them. After that 
	 * take the second and the before last one and do the same, repeat until reach the middle of the string(if the size is even 
	 * the middle character can be ignored). Some assumptions based on that: 
	 * 1) the maximum number of tests that should be made is equal the half size of the string length.
	 * 2) Each test will give the difference necessary(which is equal the number of changes) to make the pair o chars equal to each other.
	 * 3) Store the difference for each pair and sum up until reaches the half size of the string.
	 * @param word
	 * @return
	 */
	public static int calcPalindrome(String word){
		int result = 0;
		//first test if it's already a palindrome
		String wordReversed = new StringBuilder(word).reverse().toString();
		if(word.equals(wordReversed)){
			return result;
		}
		char[] wordAsCharArray = word.toCharArray();
		//this is the maximum number of loops that should be needed.
//		int maxOperations = wordAsCharArray.length/2;
		
		//counter to the beggining of the char
		int fromStartToFinish = 0;
		int fromFinishToStart = wordAsCharArray.length - 1;
		while(fromFinishToStart > fromStartToFinish){
			//check if char is equal befor processing.
			if(wordAsCharArray[fromStartToFinish] != wordAsCharArray[fromFinishToStart]){
				int diff = Math.abs(wordAsCharArray[fromFinishToStart] - wordAsCharArray[fromStartToFinish]);
				result = result + diff;
			}
			//walks one char.
			fromStartToFinish++;
			//goes back one char.
			fromFinishToStart--;
		}
		return result;
	}
}
