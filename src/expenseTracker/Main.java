package expenseTracker;

public class Main {

	public static void main(String[] args) {
		AccountData.loadAccounts();
		Account isLogged = null;

		while (isLogged == null) {
			displayAccountMenu();
			String choice = Exceptions.StringException("Enter choice: ");

			switch (choice) {
			case "1" -> AccountManager.createAccount();
			case "2" -> isLogged = AccountManager.loginAccount();
			case "3" -> {
				System.out.println("Thank you! ");
				return;
			}
			}

			if (isLogged != null) {
				ExpenseSave.readExpenses(isLogged);
				while (true) {
					displayMainMenu(isLogged.getAccountNumber());
					String choice1 = Exceptions.StringException("Enter Choice: ");

					if (choice1.equals("7")) {
						System.out.println("Logging out! ");
						isLogged = null;
						break;
					}

					switch (choice1) {
					case "1" -> ExpenseManager.deposit(isLogged.getAccountNumber());
					case "2" -> ExpenseManager.withdraw(isLogged.getAccountNumber());
					case "3" -> ExpenseManager.addExpense(isLogged);
					case "4" -> ExpenseManager.viewExpenseHistory(isLogged);
					case "5" -> ExpenseManager.checkBalance(isLogged.getAccountNumber());
					case "6" -> ExpenseManager.others(isLogged);
					}

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

	private static void displayMainMenu(String number) {
		System.out.println("=== Welcome ===");
		System.out.println("HI! " + AccountManager.infos().get(number).getName());
		System.out.println("1. Deposit ");
		System.out.println("2. Withdraw");
		System.out.println("3. Add expense");
		System.out.println("4. View expenses history");
		System.out.println("5. Check Balance");
		System.out.println("6. Other");
		System.out.println("7. Log out");
	}
}
