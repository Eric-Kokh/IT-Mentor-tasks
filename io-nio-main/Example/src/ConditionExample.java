import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceWithCondition {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean ready = false;

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (ready) {
                condition.await(); // Ждём, пока данные не потреблены
            }
            System.out.println("Производим данные...");
            ready = true;
            condition.signal(); // Уведомляем потребителя
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (!ready) {
                condition.await(); // Ждём, пока данные не будут готовы
            }
            System.out.println("Потребляем данные...");
            ready = false;
            condition.signal(); // Уведомляем производителя
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionExample {
    public static void main(String[] args) {
        SharedResourceWithCondition resource = new SharedResourceWithCondition();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource.produce();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}