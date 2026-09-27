package expenseTracker;
import java.util.*;
import java.util.function.Predicate;

public class AccountManager {
	
	final private static Map<String, Account> info = new HashMap<>();
	final private static Predicate<String> numberLenghtChecker = s -> s.length() == 11;
	final private static Predicate<String> passwordLengthChecker = s -> s.length() >= 5;
	final private static Predicate<String> pinLengthChecker = s -> s.length() == 4;
 	
	public static void createAccount() {
		String number;
		while(true) {
			number = Exceptions.StringException("Enter number: ");
			
			if(!numberLenghtChecker.test(number)) {
				System.out.println("Number must contain 11 char length! ");
				continue;
 			}
			
			if(info.containsKey(number)) {
				System.out.println("Account number already exists!");
			    continue;
			}
			break;
		}
		
		String name = Exceptions.StringException("Enter name: ");
		String password;
		while(true) {
			password = Exceptions.StringException("Enter password: ");
			if(!passwordLengthChecker.test(password)) {
				System.out.println("Password must be at least 5 characters long!");
				continue;
			}
			break;
		}
		
		String pin;
		while(true) {
			pin = Exceptions.StringException("Enter pin (must be only 4): ");
			if(!pinLengthChecker.test(pin)) {
				System.out.println("Pin must be only 4 number only! ");
				continue;
			}
			break;
		}
		
		info.put(number, new Account(number, name , password,pin,0.0));
		AccountData.saveAccount(info);
		System.out.println("Succesfully Created Account! ");
	}
	
	public static Account loginAccount() {
		String number = Exceptions.StringException("Enter number: ");
		if(!info.containsKey(number)) {
			System.out.println("Number has not been registered yet! ");
			return null;
		}
		
		int attempt = 5;	
		String password;
		while(attempt > 0) {
			password = Exceptions.StringException("Enter password: ");
			if(!password.equals(info.get(number).getPassword())) {
				System.out.println("Incorrect Password! ");
				--attempt;
				System.out.println("Attempt remaining: " + attempt);
				continue;
			}
			attempt = 5;
			break;
		}
		if(attempt == 0) {
			System.out.println("Please come back later! ");
			return null;
		}
		String pin;
		while(attempt > 0) {
			pin = Exceptions.StringException("Enter pin: ");
			
			if(!pin.equals(info.get(number).getPin())) {
				System.out.println("Incorrect Pin! ");
				--attempt;
				System.out.println("Attempt remaining: " + attempt);
				continue;
			}
			break;
		}
		
		if(attempt == 0) {
			System.out.println("Please come back later! ");
			return null;
		}
		
		System.out.println("Succesfully login! ");
		return info.get(number);
		
	}
	
	public static Map<String, Account> infos(){
		return info;
	}
}
