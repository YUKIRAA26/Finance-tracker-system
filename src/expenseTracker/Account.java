package expenseTracker;


import java.util.*;

public class Account {
	private String accountNumber;
	private String name;
	private String password;
	private String pin;
	private double balance;
	
	Account(String accountNumber,String name,String password,String pin, double balance){
		this.setAccountNumber(accountNumber);
		this.setName(name);
		this.setPassword(password);
		this.setBalance(balance);
		this.setPin(pin);
	}
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
