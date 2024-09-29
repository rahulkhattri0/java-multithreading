package ExecutorService;


import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args) {
        try (ExecutorService exService = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 5; i++) {
                exService.execute(new Work(i));
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}

class Work implements Runnable{
    public int id;
    public Work(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Work " + id + " is being executed by " + Thread.currentThread().getName());
    }
    
}
