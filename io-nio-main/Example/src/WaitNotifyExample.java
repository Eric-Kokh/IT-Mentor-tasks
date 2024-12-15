public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Thread producer = new Thread(new Producer(market));
        Thread consumer = new Thread(new Consumer(market));
        producer.start();
        consumer.start();
        consumer.getState();
    }
}

class Market {
    int breadCount = 0;

    public void getBread() {
        synchronized (this) {
            while (breadCount < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;

            System.out.println("Потребитель купил 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + breadCount);
            notify();
        }
    }

    public void putBread() {
        synchronized (this) {
            while (breadCount >= 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount++;
            System.out.println("Производитель добавил на витрину 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + breadCount);
            notify();
        }
    }

}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}