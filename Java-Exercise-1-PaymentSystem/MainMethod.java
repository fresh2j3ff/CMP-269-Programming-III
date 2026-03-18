package lehmanCampusPaymentSystem;
import java.util.ArrayList;
public class MainMethod {

	public static void main(String[] args) {

		ArrayList<Payable> paymentQueue = new ArrayList<>();
		
		paymentQueue.add(new CreditCard("Richie Rich", 100.0, 1000.0));
		paymentQueue.add(new MealPlan("Joe Everyman", 100.0));
		
		for (Payable p : paymentQueue) {
			p.processPayment(50.0);
		}
System.out.println("Total transactions processed: " + PaymentMethod.totalTransactions);		
		
	}

}
