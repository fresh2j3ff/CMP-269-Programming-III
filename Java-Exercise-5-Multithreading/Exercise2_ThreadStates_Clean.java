public class Exercise2_ThreadStates_Clean {

    public static void main(String[] args) {

        Thread sleepyThread = new Thread(() -> {
            try {
                System.out.println("[Child Thread] I'm awake, now going to sleep for 2 seconds...");
                Thread.sleep(2000);
                System.out.println("[Child Thread] I woke up! I'm done.");
            } catch (InterruptedException e) {
                System.out.println("[Child Thread] I was interrupted!");
            }
        });

        System.out.println("State after creation:      " + sleepyThread.getState());

        sleepyThread.start();
        System.out.println("State after start():       " + sleepyThread.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("[Main Thread] Interrupted!");
        }
        System.out.println("State while child sleeps:  " + sleepyThread.getState());

        try {
            sleepyThread.join();
        } catch (InterruptedException e) {
            System.out.println("[Main Thread] Interrupted while waiting!");
        }
        System.out.println("State after it finishes:   " + sleepyThread.getState());

        System.out.println("\nAll states observed!");
    }
}