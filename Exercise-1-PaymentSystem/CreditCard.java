package lehmanCampusPaymentSystem;

public class CreditCard extends PaymentMethod {

	private double creditLimit;
	
	public CreditCard(String accountHolder, double balance, double creditLimit) {
		super(accountHolder, balance);
		this.creditLimit = creditLimit;
	}
	
	@Override 
	public void processPayment(double amount) {
		if (amount > (balance + creditLimit)) {
		System.out.println("Transaction Declined.");	
		} else {
			balance = balance - amount;
			totalTransactions++;
			System.out.println(accountHolder + ": Credit Card Payment of $" + amount + " processed.");
		}
	}

	@Override
	public String getPaymentStatus() {
		return "Credit Card Balance: $" + balance;
	}

	@Override
	public void validateAccount() {
	    if (balance < 0 && Math.abs(balance) > creditLimit) {
	        System.out.println("Account Alert: Credit limit exceeded");
	    } else {
	        System.out.println("Credit account for " + accountHolder + " is in good standing."); 
	    }
	}
	
	
	
	
	
	
}
