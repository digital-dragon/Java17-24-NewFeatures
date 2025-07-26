public class ThreadInterrupted {
    public static void main(String[] args) {
        Runnable sleepyTask = () -> {
            for (int i = 1; i < 101; i++ ) {

                System.out.println(Thread.currentThread().getName() + " count is " + i);

                if (Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName() + " has been interrupted, exiting");
                    System.out.println(Thread.currentThread().getName() + " count is " + i);
                    break;
                }
            }
        };

        Thread sleepyThread = new Thread(sleepyTask, "Sleepy platform thread");
        sleepyThread.start();
        Thread.Builder builder = Thread.ofVirtual().name("Sleepy virtual thread");
        Thread sleepyThreadTwo = builder.start(sleepyTask);



        try {
            Thread.sleep(5);
            sleepyThread.interrupt();
            sleepyThreadTwo.interrupt();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sleepyThread.getName() + "'s isInterrupted flag is : " + sleepyThread.isInterrupted());
        System.out.println(sleepyThreadTwo.getName() +  "'s isInterrupted flag is : " + sleepyThreadTwo.isInterrupted());

    }
}
