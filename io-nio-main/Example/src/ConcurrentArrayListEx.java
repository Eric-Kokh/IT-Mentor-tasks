import java.util.ArrayList;

public class ConcurrentArrayListEx {
    public static void main(String[] args) {
        ConcurrentArrayList<Integer> arrayList = new ConcurrentArrayList<>();

        new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    Thread.sleep(1000);
                    arrayList.add(++i);
                    System.out.println("Dobavlen element " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    Thread.sleep(1100);
//                    System.out.println("Poluchen element " + arrayList.get(i++));
                    System.out.println("Udalen Element " + arrayList.remove(0));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(12000);
                    System.out.println(arrayList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (arrayList) {
            while (true) {

            }
        }

    }
}

class ConcurrentArrayList<T> extends ArrayList<T> {
    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public synchronized int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public synchronized T get(int index) {
        return super.get(index);
    }

    @Override
    public synchronized T set(int index, T element) {
        return super.set(index, element);
    }

    @Override
    public synchronized boolean add(T t) {
        return super.add(t);
    }

    @Override
    public synchronized void add(int index, T element) {
        super.add(index, element);
    }

    @Override
    public synchronized T remove(int index) {
        return super.remove(index);
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }
}
