import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaforeExample {
    public static void main(String[] args) {
        // Семафор с 2 разрешениями
        Semaphore semaphore = new Semaphore(2);
        /*Object o = new Object();
        o.wait();*/

        // Создаём 5 потоков, которые будут пытаться получить доступ к ресурсу
        for (int i = 1; i <= 10; i++) {
            new Thread(new Worker(semaphore, "Поток " + i)).start();
        }


    }
}

class Worker implements Runnable {
    private Semaphore semaphore;
    private String name;

    public Worker(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " пытается получить доступ к ресурсу...");
            semaphore.acquire(); // Запрос разрешения
            System.out.println(name + " получил доступ к ресурсу!");

            // Работа с ресурсом
            Thread.sleep(2000);

            System.out.println(name + " освобождает ресурс.");
            semaphore.release(); // Освобождение ресурса
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}