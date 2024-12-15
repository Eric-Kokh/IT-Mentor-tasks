package task0707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* 
Что за список такой?
1. Создай список строк.
2. Добавь в него 5 различных строк.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.


Requirements:
1. Программа не должна ничего считывать с клавиатуры.
2. Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй ee.
3. Программа должна добавить 5 любых строк в список.
4. Программа должна вывести размер списка на экран.
5. Программа должна вывести содержимое списка на экран, каждое значение с новой строки.*/

public class Solution {

    public static void main(String[] args) {

        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Саша", "Паша", "Даша", "Глаша", "Иван"));
        System.out.println(strList.size());

        Iterator iterator = strList.iterator();

        iterator.forEachRemaining(e -> System.out.println(iterator.next()));

       //напишите тут ваш код
    }
}
