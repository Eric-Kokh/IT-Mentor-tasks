package task1625;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Работаю...");
                    Thread.sleep(1000); // Поток может быть прерван здесь
                }
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время сна.");
            }
            System.out.println("Поток завершён.");
        });

        thread.start();

        try {
            Thread.sleep(3000); // Подождём 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // Прерываем поток
    }
}