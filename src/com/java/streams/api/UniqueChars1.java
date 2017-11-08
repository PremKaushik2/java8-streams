package com.java.streams.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueChars1 {
	
	public static List<String[]> uniqueCharacters(List<String> words){
		return words.stream().map(word -> word.split("")) .distinct().collect(Collectors.toList()); 
	}
	
	
	public static void main(String ... args){
		List<String[]> op = uniqueCharacters(Arrays.asList("Hello", "World"));
		
		for (String[]i:op){
			for(String j:i){
				System.out.println(j);
			}
		}
	}

}
