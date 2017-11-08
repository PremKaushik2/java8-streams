package com.java.streams.api;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.streams.model.Transaction;

public class GroupingTransactionFunctionally {

	public static List<Transaction> transactions = Arrays.asList(new Transaction(Currency.getInstance("EUR"), 1500.0),
			new Transaction(Currency.getInstance("USD"), 2300.0), new Transaction(Currency.getInstance("GBP"), 9900.0),
			new Transaction(Currency.getInstance("EUR"), 1100.0), new Transaction(Currency.getInstance("JPY"), 7800.0),
			new Transaction(Currency.getInstance("CHF"), 6700.0), new Transaction(Currency.getInstance("EUR"), 5600.0),
			new Transaction(Currency.getInstance("USD"), 4500.0), new Transaction(Currency.getInstance("CHF"), 3400.0),
			new Transaction(Currency.getInstance("GBP"), 3200.0), new Transaction(Currency.getInstance("USD"), 4600.0),
			new Transaction(Currency.getInstance("JPY"), 5700.0), new Transaction(Currency.getInstance("EUR"), 6800.0));

	 private static void groupFunctionally() {
	        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
	        System.out.println(transactionsByCurrencies);
	    }

	public static void main(String... args) {
		groupFunctionally();

	}

}
