/*
 * Daemon and User Threads
    On the basis of surface of execution, threads can be of two types
    Daemon Threads
    User Threads
    When a Java program starts the main thread (main() method thread) starts running immediately. 
    We can start child threads from the main thread. The main thread is the last thread
    to finish execution in normal circumstances, because it has to perform various shutdown operations.
    Daemon threads are intended to be helper threads which can run in background and are of low priority. Eg GC thread
    Daemon threads are terminated by the JVM when all other user threads are terminated (done with their execution)
    So, under normal circumstances, user threads are allowed to terminate once they are done with their execution, however, the daemon threads are shutdown by JVM once all the other threads are done executing.
 */
public class DaemonThreads {
    public static void main(String[] args) {
        Thread bgThread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    System.out.println("bg Thread Exec");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread userThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("User Thread Exec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        bgThread.setDaemon(true);
        bgThread.start();
        userThread.start();
    }
}
