package expenseTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExpenseManager {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private static String getCurrentDateTime() {
		return LocalDateTime.now().format(formatter);
	}
	
	public static void addExpense(Account account) {
		System.out.println("=== Add Expenses ===");
		String description = Exceptions.StringException("description: ");
		double amount = Exceptions.DoubleException("Enter amount: ");
		String category = Exceptions.StringException("catergory (food,transportation,books,clothes etc.): ");
		

	    if (amount > account.getBalance()) {
	        System.out.println("Insufficient balance!");
	        return;
	    }
		account.setBalance(account.getBalance() - amount);
		ExpenseData expense = new ExpenseData(description, amount, category, getCurrentDateTime(), account.getBalance());
		account.addExpenses(expense);
		ExpenseSave.expenseSave(account,expense);
		AccountData.saveAccount(AccountManager.infos());
		System.out.println("Expenses added! ");
		System.out.println("New Balance: " + account.getBalance());
	}
	
	public static void deposit(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== DEPOSIT =====");
		double amount = Exceptions.DoubleException("Enter amount: ");

		info.setBalance(info.getBalance() + amount);
		AccountData.saveAccount(AccountManager.infos());
		System.out.println("Succesfullt deposited " + "$" + amount);
	}
	
	public static void withdraw(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== WITHDRAW =====");
		double amount = Exceptions.DoubleException("Enter amount: ");

		if (amount > info.getBalance()) {
			System.out.println("Not enough balance! ");
			return;
		}

		info.setBalance(info.getBalance() - amount);
		AccountData.saveAccount(AccountManager.infos());
		System.out.println("Succesfullt Withdraw " + "$" + amount);
		System.out.println("Remaining balance: " + info.getBalance());
	}
	
	public static void viewExpenseHistory(Account account) {
		if(account.getExpenses().size() == 0) {
			System.out.println("Expenses history is empty! ");
			return;
		}
		
		System.out.println("=== Expenses History ===");
		for(int i = 0; i < account.getExpenses().size();i++) {
			ExpenseData history = account.getExpenses().get(i);
			System.out.println(i + 1 + ".");
			System.out.println("Description: " + history.getDescription());
			System.out.println("Amount: " + history.getAmount());
			System.out.println("Category: " + history.getCategory());
			System.out.println("New Balance: " + history.getBalance());
			System.out.println("Date: " + history.getDate());
			System.out.println();
		}
	}
	
	public static void others() {
		System.out.println("=== Others ===");
		System.out.println("1. Total Spent");
		System.out.println("2. Spending by Categery");
		System.out.println("3. Filter by Date range");
		System.out.println("4. Back");
		
		String choice = Exceptions.StringException("Enter choice: ");
		
		if(choice.equals("4")) {
			return;
		}
	}
	
	public static void checkBalance(String number) {
		System.out.println("=== Balance ===");
		System.out.println("Balance: " + AccountManager.infos().get(number).getBalance());
	}
	
	
}
