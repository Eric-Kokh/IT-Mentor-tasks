package task0724;

/* 
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
...


Requirements:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.*/

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        Human patah = new Human("Патах",true, 95,null,null);
        Human may = new Human("Майсабаба",false, 94,null,null);
        Human patah1 = new Human("Магомед",true, 95,null,null);
        Human may1 = new Human("Парсихат",false, 94,null,null);
        Human otec = new Human("Магомед",true, 95,patah,may);
        Human mat = new Human("Загра",false, 95,patah1,may1);
        Human sh = new Human("Шамиль",true, 33,otec,mat);
        Human gad = new Human("Гаджимурад",true, 25,otec,mat);
        Human mag = new Human("Магомедхан",true, 18,otec,mat);

        ArrayList<Human> family = new ArrayList<>();
        family.add(patah);
        family.add(may);
        family.add(patah1);
        family.add(may1);
        family.add(otec);
        family.add(mat);
        family.add(sh);
        family.add(gad);
        family.add(mag);

        Iterator iterator = family.iterator();
        iterator.forEachRemaining(s -> System.out.println(s));

        // напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        Human father;
        Human mother;
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}