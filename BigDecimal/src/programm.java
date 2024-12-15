import Animals.*;
import Game.Box;
import Game.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class programm {

    public enum Day {
        MONDAY("Start of the workweek"),
        TUESDAY("Second day"),
        WEDNESDAY("Midweek"),
        THURSDAY("Almost there"),
        FRIDAY("End of the workweek"),
        SATURDAY("Weekend"),
        SUNDAY("Weekend");

        private String description;

        // Конструктор для enum
        Day(String description) {
            this.description = description;
        }

        // Метод для получения описания
        public String getDescription() {
            return description;
        }
    }

    public enum Season {
        WINTER("Cold"),
        SPRING("Mild"),
        SUMMER("Hot"),
        FALL("Cool");

        private String temperature;

        // Конструктор enum, который принимает температуру
        Season(String temperature) {
            this.temperature = temperature;
        }

        // Метод для получения значения переменной
        public String getTemperature() {
            return temperature;
        }
    }



    public class Test {
        public static void prnTest(Predicate<String> par) {
            System.out.println(par.test("Салам"));
        }
    }


    public static int Func(int x, int y) {
        return x + y;
    }

    public static int Func(int x, int y, int c) {
        return x + y + c;
    }

    public static void main(String[] args) {

        Test.prnTest(x -> {
            if (x.length() > 4) {
                return true;
            } else {
                return false;
            }
        });

        Integer cell = 123;

        //Box<Cat> stringBox = new Box<>(new Cat("Марсик", 15, "Maooooo"));
        //System.out.println(stringBox.getItem().getVoice());
        List<Integer> rows = new ArrayList<>();
        System.out.println(rows.getClass());

        Student stud1 = new Student("Нурик", 46);
        Box<Student> stud = new Box<>(stud1);
        stud.getItem();





/*        System.out.println("Hello world");
        Dog bob = new Dog("Бобик", 3, "Гав гав");
        System.out.println(bob);
        Cat mar = new Cat("Марсик", 7, "Мауууу");
        System.out.println(mar.hashCode());
        System.out.println(Func(1, 2, 3));


        Class<?> stringClass = mar.getClass();



        // Выводим полное имя класса
        System.out.println("Имя класса: " + stringClass.getName());
        // Выводим методы класса
        System.out.println("Методы класса:");
        for (Method method : stringClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // Выводим суперкласс
        System.out.println("Суперкласс: " + stringClass.getSuperclass().getName());
        System.out.printf("Кот %s издет звук %s\n",mar.getName(), ((Voice) mar).getVoice());
            mar.setAnimalSound("Мияуууууууууу");
            System.out.printf("Кот %s издет звук %s\n",mar.getName(), ((Voice) mar).getVoice());

            Calculator probD = new Plus();
            System.out.println(probD.add(1, 2));

            Season temp = Season.valueOf("Cold");


        new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class!");
            }
        };*/

    }
}

