/*
 * Thread Priority
Let's say there are 10 threads in runnable state, however, there is only one available CPU, so only one thread can execute at a given time and others will have to wait. So who decides which thread gets to run on the CPU. This component is called as Thread Scheduler.
Each thread has certain priority and under normal circumstance the thread with higher priority gets to run on the CPU
Priority value from 1 to 10 can be assigned to any thread. 1 priority is represented as MIN_PRIORITY and 10 priority is represented as MAX_PRIORITY. By default, the priority of a thread is 5, it's represented as NORM_PRIORITY.
Threads of the same priority value are executed in FIFO manner. The thread scheduler stores the threads in a queue.
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("High Priority");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Low Priority");
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
