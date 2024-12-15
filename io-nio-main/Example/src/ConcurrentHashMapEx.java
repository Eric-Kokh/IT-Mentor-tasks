import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMapEx {

    public static volatile boolean ready = false;
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap
                = new ConcurrentHashMap<>();
        concurrentHashMap.put(0, 123);
        concurrentHashMap.put(1, 5236);
        concurrentHashMap.put(2, 3672);
        concurrentHashMap.put(3, 2847);
        concurrentHashMap.put(4, 9547);
        concurrentHashMap.put(5, 4573);
        concurrentHashMap.put(6, 427356);

        ReentrantLock reentrantLock = new ReentrantLock();
        Object o = reentrantLock.newCondition();



/*        new Thread(() -> {
            reentrantLock.lock();

            while (ready) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }

        }).start();*/
    }
}
