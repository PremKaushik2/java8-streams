package com.java.streams.api;

import java.util.List;
import java.util.stream.Collectors;

import com.java.streams.model.Book;

public class MapDemo {

	public static List<String> mapDemo(List<Book> books) {

		return books.stream().map(b -> b.getTitle().toUpperCase()).collect(Collectors.toList());

	}

	public static void main(String... args) {
		System.out.println(mapDemo(Book.menu));
	}

}
