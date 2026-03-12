public class BankAccount {

    private int balance = 1000;

    public void withdrawUnsafe(int amount, String person) {
        if (balance >= amount) {
            System.out.println(person + " is about to withdraw $" + amount + " | Balance before: $" + balance);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;
            System.out.println(person + " withdrew $" + amount + " | Balance after: $" + balance);

        } else {
            System.out.println(person + " tried to withdraw $" + amount + " but only $" + balance + " available. DENIED.");
        }
    }

    public synchronized void withdrawSafe(int amount, String person) {
        if (balance >= amount) {
            System.out.println(person + " is about to withdraw $" + amount + " | Balance before: $" + balance);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;
            System.out.println(person + " withdrew $" + amount + " | Balance after: $" + balance);

        } else {
            System.out.println(person + " tried to withdraw $" + amount + " but only $" + balance + " available. DENIED.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void resetBalance() {
        this.balance = 1000;
    }

    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        System.out.println("===== BROKEN VERSION (no synchronized) =====");
        System.out.println("Starting balance: $" + account.getBalance());

        Thread husband = new Thread(() -> account.withdrawUnsafe(700, "Husband"));
        Thread wife = new Thread(() -> account.withdrawUnsafe(700, "Wife"));

        husband.start();
        wife.start();
        husband.join();
        wife.join();

        System.out.println("\nFinal balance (BROKEN): $" + account.getBalance() + "\n");

        account.resetBalance();

        System.out.println("===== FIXED VERSION (with synchronized) =====");
        System.out.println("Starting balance: $" + account.getBalance());

        Thread husband2 = new Thread(() -> account.withdrawSafe(700, "Husband"));
        Thread wife2 = new Thread(() -> account.withdrawSafe(700, "Wife"));

        husband2.start();
        wife2.start();
        husband2.join();
        wife2.join();

        System.out.println("\nFinal balance (FIXED): $" + account.getBalance());
    }
}