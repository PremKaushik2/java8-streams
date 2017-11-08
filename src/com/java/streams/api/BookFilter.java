package com.java.streams.api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java.streams.model.Book;

public class BookFilter {

	/*
	 * public static List<String> findLowPriceBooksJava8(List<Book> books) { return
	 * books.stream().filter(d -> d.getPrice() <
	 * 400).sorted(Comparator.comparing(Book::getPrice))
	 * .map(Book::getTitle).collect(Collectors.toList()); }
	 */

	public static void main(String... args) {
		System.out.println(findLowPriceBooksJava8(Book.menu));
	}

	private static List<String> findLowPriceBooksJava8(List<Book> books) {

		return books.stream().filter(d -> d.getPrice() < 400).
				sorted(Comparator.comparing(Book::getPrice))
				.map(Book::getTitle).
				 collect(Collectors.toList());
	}

}
