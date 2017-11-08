package com.java.streams.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Uniquechars2 {
	public static List<String> uniqueCharacters(List<String> words){
		return words.stream().map(word -> word.split("")) .flatMap(Arrays::stream)
.distinct().collect(Collectors.toList()); 
	}
	
	
	public static void main(String ... args){
		List<String> op = uniqueCharacters(Arrays.asList("Hello", "World"));		
		for (String i:op){	
				System.out.println(i);
		}
	}

}
