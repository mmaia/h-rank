package mmaia.algorithm.cutthesticks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int qtdSticks = scanner.nextInt();
		Integer[] sticks = new Integer[qtdSticks];
		for(int i = 0; i < qtdSticks; i++){
			sticks[i] = scanner.nextInt();
		}
		Arrays.sort(sticks);
		int sizeToCut = sticks[0];
//		System.out.println("Size to cut" + sizeToCut);
		List<Integer> listSticks = new ArrayList<Integer>();
		Collections.addAll(listSticks, sticks);
		computeStickCut(listSticks, sizeToCut);
		scanner.close();
	}
	
	public static void computeStickCut(List<Integer> sticks, int sizeToCut){
		//this is the number of sticks that will be cuted during this interaction.
		System.out.println(sticks.size());
		int result = 0;
		List<Integer> newStickList = new ArrayList<Integer>();
		for (Integer stick : sticks) {
			result = stick - sizeToCut;
			if(result > 0){
				//creates new one with new values and keep only the ones that need another interaction
				stick = new Integer(result);
				newStickList.add(stick);
			}
		}
		//need to get size to cut from the new list as the size might have decreased so let's sort it.
		Collections.sort(newStickList);
		
		//call recursive if there's still sticks to cut
		if(newStickList.size() > 0){
			int newSizeToCut = newStickList.get(0);
			computeStickCut(newStickList, newSizeToCut);
		}
	}

}
