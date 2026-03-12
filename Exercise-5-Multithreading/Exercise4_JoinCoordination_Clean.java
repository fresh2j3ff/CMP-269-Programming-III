public class Exercise4_JoinCoordination_Clean {

    static long result = 0;

    public static void main(String[] args) {

        System.out.println("[Main] Starting the program...");

        Thread calculationThread = new Thread(() -> {
            System.out.println("[Calculator] Starting heavy calculation (counting to 1 billion)...");

            for (long i = 0; i <= 1_000_000_000L; i++) {
                result += i;
            }

            System.out.println("[Calculator] Heavy calculation complete! Result = " + result);
        });

        calculationThread.start();

        System.out.println("[Main] Waiting for the calculation to finish (join)...");

        try {
            calculationThread.join();
        } catch (InterruptedException e) {
            System.out.println("[Main] Was interrupted while waiting!");
        }

        System.out.println("[Main] Calculation Finished: " + result);
        System.out.println("[Main] Program complete.");
    }
}