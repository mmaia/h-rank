package mmaia.algorithm.servicelane;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("processing entries");
	    int segments = scanner.nextInt();
	    int numberOfTestCases = scanner.nextInt();
	    int[] widthOfLane = new int[segments];
	    for(int i=0; i<widthOfLane.length; i++){
//	    	System.out.println("loop 1");
	        widthOfLane[i] = scanner.nextInt();
	    }
//	    System.out.println("finished loading lane ");
	    for(int j=0; j<numberOfTestCases; j++){
	        int segmentEntry = scanner.nextInt();
	        int segmentExit = scanner.nextInt();
	        int minWidth = 3;
	        while(segmentEntry <= segmentExit){
	            if(widthOfLane[segmentEntry]<minWidth){
	                minWidth = widthOfLane[segmentEntry];
	            }
	            segmentEntry++;
	        }
	        System.out.println(minWidth);
	    }
	    
	    scanner.close();
	}
}
