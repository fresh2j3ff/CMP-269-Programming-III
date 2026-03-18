public class GreeterTask implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from " + threadName + " (print #" + i + ")");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted!");
            }
        }

        System.out.println(threadName + " is done!");
    }

    public static void main(String[] args) {
        GreeterTask task = new GreeterTask();

        Thread thread1 = new Thread(task, "Lehman-Thread-1");
        Thread thread2 = new Thread(task, "Lehman-Thread-2");

        System.out.println("Starting both threads...\n");

        thread1.start();
        thread2.start();

        System.out.println("Both threads have been started from main!\n");
    }
}