public class SyncBlock {
    static int counter1 = 0;
    static int counter2 = 0; 
    static Object lock1 = new Object();
    static Object lock2 = new Object();
   public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment2();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
        System.out.println("counter 1 " + counter1 + " counter 2 "+ counter2);
   }
   public static void increment1(){
        synchronized(lock1){
            counter1++;
        }    
   }
   public static void increment2(){
        synchronized(lock2){
            counter2++;
        }
   }
}
