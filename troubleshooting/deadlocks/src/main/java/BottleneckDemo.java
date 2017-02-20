
public class BottleneckDemo {

    public static void main(String[] args) {
        final Object resource1 = "resource 1";

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 1 terminated");
        }).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 2: locked resource 1");
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 2 terminated");
        }).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 3: locked resource 1");
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 3 terminated");
        }).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 4: locked resource 1");
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 4 terminated");
        }).start();
    }
}