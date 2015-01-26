package mmaia.algorithm.gameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String testPalindrome = scanner.next();
		String result = checkPalindrome(testPalindrome);
		System.out.println(result);
		scanner.close();
	}
	
	private static String checkPalindrome(String toBeTested){
		String result;
		char[] allChars = toBeTested.toCharArray();
		Map<String, List<Character>> hashMap = new HashMap<String, List<Character>>();
		List<Character> listOfSpecificChar;
		for (int i = 0; i < allChars.length; i++) {
			char x = allChars[i];
			String key = String.valueOf(x);
			if(hashMap.containsKey(key)){
				listOfSpecificChar = (List<Character>) hashMap.get(key);
				listOfSpecificChar.add(x);
			}else{
				listOfSpecificChar = new ArrayList<Character>();
				listOfSpecificChar.add(x);
				hashMap.put(key, listOfSpecificChar);
			}
				
		}
		//now just need to check map entries if unpaired > 1 than can't be a palindrome
		int numOfUnpairedChars = 0;
		
		for (Map.Entry<String, List<Character>> hm: hashMap.entrySet()) {
			listOfSpecificChar = hm.getValue();
			if(listOfSpecificChar.size() % 2 > 0 || listOfSpecificChar.size() < 2){
				numOfUnpairedChars++;
			}
		}
		
		if(numOfUnpairedChars > 1){
			result = "NO";
		}else{
			result = "YES";
		}
		return result;
	}

}
