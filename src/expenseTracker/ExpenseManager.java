package expenseTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExpenseManager {
	private final static List<ExpenseData> expenses = new ArrayList<>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private static String getCurrentDateTime() {
		return LocalDateTime.now().format(formatter);
	}
	
	public static void addExpense() {
		System.out.println("=== Add Expenses ===");
		double balance = Exceptions.DoubleException("Enter balance: ");
		String description = Exceptions.StringException("description: ");
		double amount = Exceptions.DoubleException("Enter amount: ");
		String category = Exceptions.StringException("catergory (food,transportation,books,clothes etc.): ");
		
		expenses.add(new ExpenseData(description, amount, category, getCurrentDateTime(),balance));
		System.out.println("Expenses added! ");
		
	}
}
