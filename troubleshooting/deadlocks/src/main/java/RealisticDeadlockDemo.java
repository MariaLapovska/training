
public class RealisticDeadlockDemo {

    public static void main(String[] args) {
        final Object resource1 = "resource 1";
        final Object resource2 = "resource 2";

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 3: locked resource 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 4: locked resource 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
