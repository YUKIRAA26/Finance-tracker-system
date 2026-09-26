package expenseTracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AccountData {
	
	public static void loadAccounts() {
		
		File file = new File("accounts/account.txt");
        if (!file.exists()) return;
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] parts = line.split("\\|");
				
				String number = parts[0];
				String name = parts[1];
				String password = parts[2];
				String pin = parts[3];
				double balance = Double.parseDouble(parts[4]);
				
				Account account = new Account(
						number,name,password,pin,balance);
				
				AccountManager.infos().put(number, account);
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveAccount(Map<String, Account> info) {
		File file = new File("accounts");
		file.mkdirs();
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("accounts/account.txt",false))){
			
			for(Account account: info.values()) {
				writer.write(account.getAccountNumber() + "|" + account.getName() + "|"
						+ account.getPassword() + "|" + account.getPin() + "|" + account.getBalance());
				writer.newLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
