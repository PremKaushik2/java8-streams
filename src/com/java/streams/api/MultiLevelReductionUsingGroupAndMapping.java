package com.java.streams.api;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import com.java.streams.model.Instruction;
import com.java.streams.model.TradeAction;
import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.time.LocalDate;
public class MultiLevelReductionUsingGroupAndMapping {

	// Create a predicate for outgoing
		private final static Predicate<Instruction> outgoingInstructionPredicate=instruction -> instruction.getAction().equals(TradeAction.BUY);

		// Create a predicate for incoming
		private final static Predicate<Instruction> incomingInstructionsPredicate = instruction -> instruction.getAction()
				.equals(TradeAction.SELL);
		

	public static void main(String... args) {
		//System.out.println("Books grouped by type: " + groupBooksByType());
		//System.out.println("Books grouped by price level: " + groupBooksByPriceLevel());
		//System.out.println("Books grouped by type and price level: " + groupBooksByTypeAndPriceLevel());
		//System.out.println("Costliest books by type: " + costliestBooksByTypeWithoutOptionals());
		Set<Instruction> instructions=InstructionsGenerator.getFakeInstructions();
		Map<LocalDate, BigDecimal> stats=calculateDailyAmount(instructions, outgoingInstructionPredicate);
		System.out.println(stats);
	}

	private static  Map<LocalDate, BigDecimal> calculateDailyAmount(Set<Instruction> instructions,
			Predicate<Instruction> outgoinginstructionpredicate2) {
		return instructions.stream().filter(outgoinginstructionpredicate2)
			.collect(groupingBy(Instruction::getSettlementDate,
					mapping(Instruction::getTradeAmount, 
					reducing(BigDecimal.ZERO,BigDecimal::add))));
		
	}

	
}
