package mmaia.algorithm.utopiantree;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		int[] cycle = new int[numberOfTestCases];
		
		//just loads the cycles to process later.
		for (int i= 0; i < cycle.length; i++) {
			cycle[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < cycle.length; i++) {
			
			int numberOfCycles = cycle[i];
			//treeHeigh starts 1
			int result = 1;
			boolean doubleGrowth = true;
			
			for(int j = 0; j < numberOfCycles; j++){
				if(doubleGrowth){
					result += result;
					doubleGrowth = false;
				}
				else{//growth only 1
					result = result + 1;
					doubleGrowth = true;
				}
			}
			System.out.println(result);
		}
		scanner.close();
	}

}
