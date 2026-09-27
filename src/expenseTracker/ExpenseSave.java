package expenseTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExpenseSave {
	public static void expenseSave(Account account, ExpenseData expense) {
		File directory = new File("Expenses");
		directory.mkdirs();
		try(BufferedWriter write = new BufferedWriter(new FileWriter("Expenses/" + account.getAccountNumber() + ".txt", true))){
			write.write(expense.getDescription() + "|" + expense.getAmount() + "|" + expense.getCategory() + "|"
					+ expense.getDate() + "|" + expense.getBalance());
			write.newLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readExpenses(Account account) {
		File file = new File("Expenses/" + account.getAccountNumber() + ".txt");
		if (!file.exists()) {
			return;
		}
		
		try(BufferedReader read = new BufferedReader(new FileReader("Expenses/" + account.getAccountNumber()+ ".txt"))){
			String line;
			
			while((line = read.readLine()) != null) {
				String[] parts = line.split("\\|");
				String description = parts[0].trim();
				double amount = Double.parseDouble(parts[1].trim());
				String category = parts[2].trim();
				String date = parts[3].trim();
				double balance = Double.parseDouble(parts[4].trim());
				
				account.addExpenses(new ExpenseData(description, amount,category,date,balance));
					
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
