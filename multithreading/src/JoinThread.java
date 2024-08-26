public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread t1 :" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread t2 :" + i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main Thread Exec");
    }
}
