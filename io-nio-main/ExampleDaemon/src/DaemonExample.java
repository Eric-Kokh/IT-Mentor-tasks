public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        UserThread userThread = new UserThread();
        userThread.setName("user thread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon thread");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
        System.out.println("Main thread ends");

    }
}

class UserThread extends Thread{
    public void run() {
        System.out.println(Thread.currentThread().getName() + (this.isDaemon() ? " is Daemon": " no Daemon"));
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                Thread.sleep(3000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class DaemonThread extends Thread{
    public void run() {
        System.out.println(Thread.currentThread().getName() + (this.isDaemon() ? " is Daemon": " no Daemon"));
        for (int i = 1; i <= 1000; i++) {
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}