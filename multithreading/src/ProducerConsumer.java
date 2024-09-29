import java.util.*;
public class ProducerConsumer {
    public static void main(String[] args) {
        Worker worker = new Worker(3);
        Thread producer = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.start();
        producer.start();
        
    }
}

class Worker{
    public ArrayList<Double> sharedList;
    public int capacity;
    public Object LOCK = new Object();
    public Worker(int capactiy){
        this.sharedList = new ArrayList<>();
        this.capacity = capactiy;
    }

    public void produce() throws InterruptedException{
        synchronized(LOCK){
            while (true) {
                if(sharedList.size() == capacity){
                    System.out.println("Shared list is full please consume something");
                    LOCK.wait();
                }
                else {
                    Double value = Math.random();
                    System.out.println("Produced this " + value);
                    sharedList.add(value);
                    LOCK.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        synchronized(LOCK){
            while (true) {
                if(sharedList.size() == 0){
                    System.out.println("Shared list is empty please produce something");
                    LOCK.wait();
                }
                else {
                    System.out.println("Consumed this " + sharedList.removeFirst());
                    LOCK.notify();
                }

                Thread.sleep(1000);
            }
        }
    }
}
