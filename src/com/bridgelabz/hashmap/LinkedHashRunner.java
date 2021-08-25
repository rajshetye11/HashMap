package com.bridgelabz.hashmap;

public class LinkedHashRunner {

	public static void main(String[] args) {
		
		String sentence = "Paranoids are not paranoid because they are paranoid "
				+ "but because they keep putting themselves deliberately into paranoid avoidable situations";
		
		LinkedHashMap<String, Integer> LinkedHashMap = new LinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for(String word: words) {
			Integer value = LinkedHashMap.get(word);
			if(value == null)
				value = 1;
			else
				value += 1;
			LinkedHashMap.add(word, value);
		}
		System.out.println(LinkedHashMap);
		System.out.println(LinkedHashMap.get("paranoid"));
	}
}
