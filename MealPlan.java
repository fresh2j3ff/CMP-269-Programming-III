package lehmanCampusPaymentSystem;

public class MealPlan extends PaymentMethod {

	public MealPlan(String accountHolder, double balance) {
		super(accountHolder, balance);
	}
	
	
	@Override
	public void processPayment(double amount) {
		if (amount <= balance) {
            balance = balance - amount;
            totalTransactions++;
            System.out.println(accountHolder + ": Meal purchased for $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
		
	}

	@Override
	public String getPaymentStatus() {
		return "Meal Plan Balance: $" + balance;
	}

	@Override
	void validateAccount() {
		if (balance < 0) {
            System.out.println("Account is negative.");
        } else {
            System.out.println("Meal Plan valid for " + accountHolder);
        }
		
	}

	
	
	
	
	
	
	
	
}
