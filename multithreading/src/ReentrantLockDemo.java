import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 
public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("outer method called" + "for " + Thread.currentThread().getName());
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        /*
            deadlock would have occurred but 
            ReentrantLock is smart enough to see if the current thread owns the lock already it allows this to execute 
            and increases its internal lock count acquired by 1
         */ 
        lock.lock(); 
        try{
            System.out.println("inner method called" + "for " + Thread.currentThread().getName());
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo ob = new ReentrantLockDemo();
        Thread t1 = new Thread(() -> {
            ob.outerMethod();
        });
        Thread t2 = new Thread(() -> {
            ob.outerMethod();
        });
        t1.start();
        t2.start();
    }
}
