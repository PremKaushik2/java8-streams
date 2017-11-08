package com.java.streams.api;

import java.util.List;
import java.util.stream.Collectors;

import com.java.streams.model.Book;

public class FilterDemo {
	
	public static List<Book> filterAdultFiction(List<Book> books) {
		return books.stream().filter(b -> "adult fiction".equalsIgnoreCase(b.getGenre())).collect(Collectors.toList());
		
	}

	public static void main(String ... args){
		System.out.println(filterAdultFiction(Book.menu));
	}

}
