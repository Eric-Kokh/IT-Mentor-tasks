import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Employee("Гаджик", lock);
        new Employee("Нурик", lock);
        new Employee("Играмудин", lock);
        new Employee("Тагир", lock);

    }
}


class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        try {
            System.out.println(name + " ждет по освободится банкомат");
            lock.lock();
            System.out.println(name + " занял банкомат");
            Thread.sleep(2000);
            System.out.println(name + " закончил свои дела");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

