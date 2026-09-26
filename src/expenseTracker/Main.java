package expenseTracker;

public class Main {

	public static void main(String[] args) {
		AccountData.loadAccounts();
		Account isLogged = null;
		
		while(isLogged == null) {
			displayAccountMenu();
			String choice = Exceptions.StringException("Enter choice: ");
			
			switch(choice) {
				case "1" -> AccountManager.createAccount();
				case "2" -> isLogged = AccountManager.loginAccount();
				case "3" -> {
					System.out.println("Thank you! ");
					return;
				}
			}
		}

	}

	
	private static void displayAccountMenu() {
		System.out.println("===== FINANCE TRACKER =====");
		System.out.println("1. Create Account");
		System.out.println("2. Login");
		System.out.println("3. Exit ");
	}
}
