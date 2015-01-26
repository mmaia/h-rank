package mmaia.algorithm.isfibo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTests = scanner.nextInt();
		
		double maxFiboForThisTest = Math.pow(10, 10);
//		System.out.println("maxFibo => " + maxFiboForThisTest);
		List<Long> fiboList = fiboSeq(maxFiboForThisTest);
		
		for(int i = 0; i < numTests; i++){
			Long numberToTest = scanner.nextLong();
			System.out.println(isFibo(fiboList, numberToTest));
		}
		scanner.close();
	}
	
	/**
	 * Method that generates a list of fibo numbers and store them in a list with maximum value being the parameter passed
	 * @param maxValue - the maximum value of a fibo number to be stored on this list
	 * @return the list of fibo numbers
	 */
	private static List<Long> fiboSeq(double maxValue){
		List<Long> result = new ArrayList<Long>();
		result.add(new Long(0));//1st fibo number
		result.add(new Long(1));//2nd fibo number
		int j = 2; //index of next number on array
		while(true){
			Long fiboNumber = result.get(j-1) + (result.get(j-2));
//			System.out.println("next fibo=> " + fiboNumber);
			if(fiboNumber < maxValue){
				result.add(fiboNumber);
			}
			else{
				break;
			}
			j++;
		}
		return result;
	}
	
	/**
	 * Checks if value is present on the list of fibo passed
	 * @param fiboSeq - a list of fibo numbers
	 * @param value - a number to check if it's on the list
	 * @return a String IsFibo if the value is present on the fibo list of IsNotFibo if the value is not on the list.
	 */
	private static String isFibo(List<Long> fiboSeq, long value){
		String result;
		if(fiboSeq.contains(Math.abs(new Long(value)))){
			result = "IsFibo";
		}else{
			result = "IsNotFibo";
		}
		return result;
	}
	
	
	
	/**
	 * Fibo sequence calculator pure formula from math to java not used in this solution but here for record.
	 */
	public static double getFibonacci(int n) {
	    double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
	    double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);

	    return Math.floor((f1 - f2) / Math.sqrt(5));
	}
	
}
