package task0809;

import java.util.*;

/* 
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getInsertTimeInMs должен вернуть время своего исполнения в миллисекундах.


Requirements:
1. Программа должна выводить числа на экран.
2. Метод main должен вызывать метод getInsertTimeInMs только два раза.
3. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
4. Метод getInsertTimeInMs должен вызывать метод insert10000 только один раз.
5. Метод getInsertTimeInMs должен вернуть время в миллисекундах, которое занимает 10 тысяч вставок в список.*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getInsertTimeInMs(new ArrayList()));
        System.out.println(getInsertTimeInMs(new LinkedList()));
        new LinkedHashSet<>();
    }

    public static long getInsertTimeInMs(List list) {
        // напишите тут ваш код
        long startTime = System.nanoTime();
        insert10000(list);
        long endTime = System.nanoTime();
        // напишите тут ваш код
        return endTime - startTime;

    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
