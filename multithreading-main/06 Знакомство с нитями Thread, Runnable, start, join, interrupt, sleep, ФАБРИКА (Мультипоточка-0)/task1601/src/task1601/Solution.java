package task1601;

/* 
My first thread
Создать public static class TestThread - нить с интерфейсом Runnable.
TestThread должен выводить в консоль "My first thread".


Requirements:
1. Добавь в класс Solution публичный статический класс TestThread.
2. Класс TestThread должен реализовывать интерфейс Runnable.
3. Метод run класса TestThread должен выводить "My first thread".
4. Программа должна вывести "My first thread".
5. Метод main не изменять.*/

public class Solution {
    public static void main(String[] args) {
//        TestThread task = new TestThread("Задача1");
        Thread thread1 = new Thread(new TestThread("Задача1"));
        thread1.start();
        TestThread task1 = new TestThread("Задача2");
        new Thread(task1).start();
    }

    public static class TestThread implements Runnable{
        String text;
        public TestThread(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(text);
            }
        }
    }
}
