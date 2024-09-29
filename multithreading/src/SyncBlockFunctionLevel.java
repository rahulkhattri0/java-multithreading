public class SyncBlockFunctionLevel {

    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("final val: " + counter);
    }
    //coarse grained locking 
    //- does not make sense to block the entire method 
    //- just lock the critical section only 
    //- also this is class level lock
    // so if we put synchronized on function level
    // and suppose two threads are working on two different critical sections(see SyncBlock.java)
    // even tho the other thread is operating on other critical section, it will be blocked
    // because we have acquired a CLASS LEVEL LOCK.
    private static synchronized void increment(){
        counter++;
    }
}
