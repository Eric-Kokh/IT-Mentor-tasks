package task1505;

/* 
ООП - исправь ошибки в наследовании
У каждого человека есть рост и вес. Класс Human реализует соответствующие интерфейсы. Но, похоже, в такой реализации закралась ошибка. Обрати внимание на вывод программы. Исправь ошибки в интерфейсах (подсказка: переименуй методы, согласно требований к задаче) и, соответственно, в остальном коде. На экран должны быть выведены рост и вес человека (любые положительные целые числа).


Requirements:
1. Метод int getValue() интерфейса HasWeight должен быть переименован в getWeight.
2. Метод int getValue() интерфейса HasHeight должен быть переименован в getHeight.
3. В классе Human должны быть переопределены методы getWeight и getHeight. Каждый из них должен возвращать любое целое число больше 0.
4. В классе Human не должно быть метода getValue.
5. В методе main у объекта класса human должны вызываться методы getWeight и getHeight.*/

public class Solution {
    public interface HasWeight {
        int getValue();
    }

    public interface HasHeight {
        int getValue();
    }

    public static class Human implements HasWeight, HasHeight {
        @Override
        public int getValue() {
            return 0;
        }
    }

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getValue());
        System.out.println(human.getValue());
    }
}