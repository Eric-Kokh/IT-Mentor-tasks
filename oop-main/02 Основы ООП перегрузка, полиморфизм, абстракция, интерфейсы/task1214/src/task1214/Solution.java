package task1214;

/* 
Корова — тоже животное
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.


Requirements:
1. Класс Animal должен быть абстрактным.
2. Класс Cow не должен быть абстрактным.
3. Класс Cow должен наследоваться от класса Animal.
4. Класс Cow должен реализовать абстрактный метод из класса Animal.
5. Метод getName() класса Cow должен возвращать любое имя коровы.*/

public class Solution {
    public static void main(String[] args) {
        Cow cow = new Cow();
        System.out.println(cow.getName());

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal{
        @Override
        public String getName() {
            return "Буренка";
        }
    }

}
