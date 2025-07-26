public class VirtualThreadsDemo {
    public static int counter = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for(int i = 0; i < 100000; i++) {
                synchronized (VirtualThreadsDemo.class) {
                    counter++;
                }
            }
        };

        Runnable sleepTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName() +  " going to sleep");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " out of slumber");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = Thread.startVirtualThread(task);
        Thread thread2 = Thread.startVirtualThread(task);
        Thread thread3 = Thread.startVirtualThread(task);
        Thread thread4 = Thread.startVirtualThread(task);
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.Builder builder = Thread.ofVirtual().name("Thread5");
        Thread t = builder.start(task);
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.Builder sleeper = Thread.ofVirtual().name("Sleeper thread");

        Thread sleeptThread = sleeper.start(sleepTask);

        try {
            sleeptThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter - " + counter);
    }
}
