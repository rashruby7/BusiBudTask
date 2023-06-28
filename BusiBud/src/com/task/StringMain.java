package com.task;

//	String Challenge Have the function string challenge (str) take the str parameter being passed and determine the largest number of 

//	unique characters that exists between a pair of matching letters anywhere in the string. For example: if str is "ahyjakh"
//	then there are only two pairs of matching letters, the two a's and the two h's. Between the pair of a's there are 3 unique characters: h, y,
//	and j. Between the h's there are 4 unique characters: y, j, a, and k. So for this example your program should return 4. 1 import jav 
//	Another example: if str is "ghececgkaem" then your program should return 5 because the most unique characters exists within the farthest pair
//	of e characters. The input string may not contain any character pairs,
//	and in that case your program should just return 0. The input will only consist of lowercase alphabetic characters.

import java.util.*;

class StringMain {
	public static int StringChallenge(String str) {
		int maxUnique = 0; // Variable to store the maximum number of unique characters

		// Map to keep track of the last occurrence index of each character
		Map<Character, Integer> lastOccurrenceMap = new HashMap<>();

		// Iterate through each character in the string
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// If the character is already seen, calculate the number of unique characters
			// between the pair
			if (lastOccurrenceMap.containsKey(c)) {
				int start = lastOccurrenceMap.get(c) + 1; // Starting index of the pair of matching letters
				int end = i - 1; // Last index of the matching letter

				// Check the number of unique characters between the pair
				int uniqueCount = countUniqueCharacters(str.substring(start, end + 1));

				// Update the maximum unique count if necessary
				maxUnique = Math.max(maxUnique, uniqueCount);
			}

			// Update the last occurrence index of the character
			lastOccurrenceMap.put(c, i);
		}

		// Check the number of unique characters after the last pair
		if (lastOccurrenceMap.size() > 1) {
			int start = lastOccurrenceMap.get(str.charAt(str.length() - 1)) + 1;
			int end = str.length() - 1;
			int uniqueCount = countUniqueCharacters(str.substring(start, end + 1));
			maxUnique = Math.max(maxUnique, uniqueCount);
		}

		return maxUnique;
	}

	// Helper method to count the number of unique characters in a string
	private static int countUniqueCharacters(String str) {
		boolean[] visited = new boolean[26]; // Assuming lowercase alphabetic characters only
		int count = 0;

		for (char c : str.toCharArray()) {
			if (!visited[c - 'a']) {
				visited[c - 'a'] = true;
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge(s.nextLine()));
	}
}
