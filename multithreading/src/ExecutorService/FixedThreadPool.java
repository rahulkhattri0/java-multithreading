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

//cached pool service mein bhi kuch khaas nhi hai bas usme number of threads fixed nhi hoti ,
// basically ek fixed number hoti hai and agar 60 seconds(configurable)
// se zyada inactive hogi then that thread is killed
