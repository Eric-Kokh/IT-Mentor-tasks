public class NotifyExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Создаем несколько потоков
        Thread thread1 = new Thread(sharedResource::waitForNotification, "Thread-1");
        Thread thread2 = new Thread(sharedResource::waitForNotification, "Thread-2");
        Thread thread3 = new Thread(sharedResource::notifyThread, "Notifier");

        thread1.start();
        thread2.start();

        // Даем потокам время перейти в состояние ожидания
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.setPriority();
        thread3.start();
        System.out.println("Поток main завершился");
        System.out.println(thread2.getState());
    }
}

class SharedResource {
    public synchronized void waitForNotification() {
        System.out.println(Thread.currentThread().getName() + " ждёт уведомления...");
        try {
            wait(); // Переход в ожидание
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " получил уведомление!");
    }

    public synchronized void notifyThread() {
        System.out.println(Thread.currentThread().getName() + " отправляет уведомление.");
        notify(); // Пробуждает один поток
    }
}