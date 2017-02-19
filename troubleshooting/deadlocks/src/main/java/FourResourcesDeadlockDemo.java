
public class FourResourcesDeadlockDemo {

    public static void main(String[] args){

        final Object resource1 = "resource 1";
        final Object resource2 = "resource 2";
        final Object resource3 = "resource 3";
        final Object resource4 = "resource 4";

        new Thread(() -> {
            synchronized(resource1) {
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                synchronized(resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }

                System.out.println("Thread 1 terminated");
            }
        }).start();

        new Thread(() -> {
            synchronized(resource2) {
                System.out.println("Thread 2: locked resource 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                synchronized(resource3) {
                    System.out.println("Thread 2: locked resource 3");
                }

                System.out.println("Thread 2 terminated");
            }
        }).start();

        new Thread(() -> {
            synchronized(resource3) {
                System.out.println("Thread 3: locked resource 3");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                synchronized(resource4) {
                    System.out.println("Thread 4: locked resource 4");
                }

                System.out.println("Thread 3 terminated");
            }
        }).start();

        new Thread(() -> {
            synchronized(resource4) {
                System.out.println("Thread 4: locked resource 4");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                synchronized(resource1) {
                    System.out.println("Thread 1: locked resource 1");
                }

                System.out.println("Thread 4 terminated");
            }
        }).start();
    }
}