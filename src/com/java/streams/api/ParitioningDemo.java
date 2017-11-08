package com.java.streams.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.collectingAndThen;
import com.java.streams.model.Book;

public class ParitioningDemo {

	public static void main(String... args) {
		//System.out.println("Books partitioned by price: " + partitionBooksByPrice());
		//System.out.println("Cheap Books by type: " + cheapBooksByType());
		System.out.println("Costliest books by price: " + costliestPartitionedByPrice());
	}

	private static Map<Boolean, List<Book>> partitionBooksByPrice() {
		return Book.menu.stream().collect(partitioningBy(b -> b.getPrice() < 400));
	}

	private static Map<Boolean, Map<Book.Type, List<Book>>> cheapBooksByType() {
		return Book.menu.stream().collect(partitioningBy((b -> b.getPrice() < 400), groupingBy(Book::getType)));
	}

	private static Object costliestPartitionedByPrice() {
		return Book.menu.stream().collect(partitioningBy((b -> b.getPrice() < 400),
				collectingAndThen(maxBy(comparingInt(Book::getPrice)), Optional::get)));
	}
}
