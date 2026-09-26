package expenseTracker;

public class ExpenseData {
	private String description;
	private double amount;
	private String category;
	private double balance;
	private String date;
	
	
	public ExpenseData(String description, double amount, String category, String date, double balance) {
		this.setDescription(description);
		this.setAmount(amount);
		this.setCategory(category);
		this.date = date;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
