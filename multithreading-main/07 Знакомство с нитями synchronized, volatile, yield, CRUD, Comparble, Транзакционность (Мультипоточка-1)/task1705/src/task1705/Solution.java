package task1705;

import com.sun.tools.javac.Main;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/* 
Сад-огород
1. Создай метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index.
2. Создай метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index.
3. Создай метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index.
4. Создай метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index.
5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мьютекс this.
6. Реализуй это минимальным количеством кода.


Requirements:
1. Класс Garden должен содержать метод public void addFruit(int index, String fruit).
2. Класс Garden должен содержать метод public void removeFruit(int index).
3. Класс Garden должен содержать метод public void addVegetable(int index, String vegetable).
4. Класс Garden должен содержать метод public void removeVegetable(int index).
5. Метод addFruit(int index, String fruit) должен добавлять параметр fruit в лист fruits на позицию index.
6. Метод removeFruit(int index) должен удалять из fruits элемент с индексом index.
7. Метод addVegetable(int index, String vegetable) должен добавлять параметр vegetable в лист vegetables на позицию index.
8. Метод removeVegetable(int index) должен удалять из vegetables элемент с индексом index.
9. Все методы класса Garden должны блокировать мьютекс this (быть синхронизированы).*/

public class Solution {

    public static void main(String[] args) {

        Thread garden = new Thread(new Garden(5, 5));
        garden.start();
        System.out.println("Программа завершилась");
    }

    public static class Garden implements Runnable{
        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();
        private int count_Fruits;
        private int count_Vegetables;


        public Garden(int count_Fruits, int count_Vegetables) {
            this.count_Fruits = count_Fruits;
            this.count_Vegetables = count_Vegetables;
        }

        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Сначала фрукты");
                for (int i = 0; i < count_Fruits; i++) {
                    fruits.add(reader.readLine());
                }
                System.out.println("Теперь овощи");
                for (int i = 0; i < count_Vegetables; i++) {
                    vegetables.add(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(fruits);
            System.out.println(vegetables);
        }

        public synchronized void addFruit(int index, String fruit) {
            fruits.add(index, fruit);
        }

        public synchronized void removeFruit(int index) {
            fruits.remove(index);
        }

        public synchronized void addVegetable(int index, String vegetable) {
            vegetables.add(index, vegetable);
        }

        public synchronized void removeVegetable(int index) {
            vegetables.remove(index);
        }
    }
}
