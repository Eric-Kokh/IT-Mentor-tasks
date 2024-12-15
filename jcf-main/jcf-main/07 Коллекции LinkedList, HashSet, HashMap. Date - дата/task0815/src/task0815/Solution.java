package task0815;

import org.w3c.dom.Node;

import java.util.*;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Requirements:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> perep = new HashMap<>();
        perep.put("Магомедов","Магомед");
        perep.put("Магомедов1","Магомед1");
        perep.put("Магомедов2","Магомед2");
        perep.put("Магомедов3","Магомед3");
        perep.put("Магомедов4","Магомед4");
        perep.put("Магомедов5","Магомед5");
        perep.put("Магомедов6","Магомед");
        perep.put("Магомедов7","Магомед");
        perep.put("Магомедов9","Магомед7");
        perep.put("Магомедов8","Магомед8");
        return perep;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int i = 0;
        for (String value : map.values()) {
            if (value.equals(name)) {
                i++;
            }
        }
        //напишите тут ваш код
        return i;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        return 0;
    }

    public static void main(String[] args) {
        Map<String, String> perep = createMap();
        System.out.println(createMap());
        System.out.println("в Реализациях интерфейса Map не может быть повторяющихся ключей");
        System.out.println(getCountTheSameLastName(perep,"Магомедов"));
        System.out.println("Повторяющиеся Имена");
        System.out.println(getCountTheSameFirstName(perep, "Магомед"));
        ArrayList<?> dsfg = new ArrayList<>();

    }
}
