package task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* 
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.


Requirements:
1. В методе main инициализируй существующее поле strings класса Solution новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings класса Solution.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lengthStrArrayElements = new ArrayList<>(5);
        strings = new ArrayList<>(5);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        for (int i = 0; i < 5; i++) {
            strings.add(input.readLine());
            int j = strings.get(i).length();
            lengthStrArrayElements.add(j);
            if (i == 0) {
                max = strings.get(i).length();
            }
            if (j > max) {
                max = j;
            }
        }


        for (int i = 0; i < 5; i++) {
            if (max == lengthStrArrayElements.get(i)) {
                System.out.println(strings.get(i));
            }
        }





        //напишите тут ваш код
    }
}
