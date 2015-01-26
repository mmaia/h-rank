package mmaia.algorithm.halloweenparty;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTests = scanner.nextInt();
		for(int i = 0; i < numberOfTests; i++){
			int numberOfLines = scanner.nextInt();
			long result = calcNumberOfChocolates(numberOfLines);
			System.out.println(result);
		}
		scanner.close();
	}
	
	public static long calcNumberOfChocolates(int numberOfCuts){
		long result = 0;
		if(numberOfCuts % 2 == 0){
			result = (long) Math.pow(numberOfCuts / 2, 2);
		}
		else{
			result = (long)(calcNumberOfChocolates(numberOfCuts - 1) + (numberOfCuts / 2)); 
		}
		return result;
	}

}
