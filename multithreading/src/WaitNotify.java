public class WaitNotify {

    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread two = new Thread(() -> {
            try {
                two();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        one.start();
        two.start();
    }

    private static void one() throws InterruptedException{
        synchronized(LOCK){
            System.out.println("ONE STARTED");
            LOCK.wait(); /*
            difference between wait and sleep - 
            wait is used for inter-thread communication 
             while sleep is just for pausing execution
             */ 
            /*
             * What wait does is 
             * "I will RELEASE THE CURRENT LOCK so that others can use it, 
             * and now I will make the thread wait until I am notified."
             */
            System.out.println("ONE AFTER WAIT");
        }
        
    }

    private static void two() throws InterruptedException{
        synchronized(LOCK){
            System.out.println("TWO STARTED");
            LOCK.notify();
            System.out.println("TWO AFTER NOTIFY");
        }
    }
}
