package task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/* 
Перестановочка подоспела
Ввести с клавиатуры 2 числа N и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.

Примечание: запрещено создавать больше одного списка.


Requirements:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
3. Переставить M первых строк в конец списка.
4. Выведи список на экран, каждое значение с новой строки.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Вееди число N:");
        n = Integer.parseInt(reader.readLine());
        System.out.printf("Вееди число M:");
        m = Integer.parseInt(reader.readLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(reader.readLine());
        }

        breakPoint:
        {
            if (m >= n) break breakPoint;
            for (int i = 0; i < m; i++) {
                arrayList.add(arrayList.remove(0));
            }
        }
        ListIterator listIterator = arrayList.listIterator();
        listIterator.forEachRemaining(s -> System.out.println(s));
        NavigableSet<Integer> sdf = new TreeSet<>();

        //напишите тут ваш код
    }
}
