import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        List<AtomicInteger> atomicIntegerList= new ArrayList<>();
        AtomicInteger aI = new AtomicInteger(0);
        aI.set(56);
        atomicIntegerList.add(aI);
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        FutureTask<Integer> futureTask = new FutureTask<>();
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new RunnableImp100());
        }
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Main ends");
    }
}

class RunnableImp100 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}