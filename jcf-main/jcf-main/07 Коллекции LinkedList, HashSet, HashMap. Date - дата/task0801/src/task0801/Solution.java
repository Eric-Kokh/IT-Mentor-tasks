package task0801;

import java.util.*;

/* 
Создать коллекцию Set (реализация HashSet) с типом элементов String.
Добавить в неё следующие строки:
арбуз
банан
вишня
груша
дыня
ежевика
женьшень
земляника
ирис
картофель

Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.


Requirements:
1. Объяви переменную коллекции Set с типом элементов String и сразу проинициализируй ee.
2. Программа не должна считывать строки с клавиатуры.
3. Программа должна добавлять в коллекцию 10 строк, согласно условию.
4. Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<>();
        hashset.add("арбуз");
        hashset.add("банан");
        hashset.add("вишня");
        hashset.add("груша");
        hashset.add("дыня");
        hashset.add("ежевика");
        hashset.add("женьшень");
        hashset.add("земляника");
        hashset.add("ирис");
        hashset.add("картофель");

        Iterator iterator = hashset.iterator();
        iterator.forEachRemaining(s -> System.out.println(s));
        //напишите тут ваш код
    }
}
