package task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Requirements:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> stringArray = new ArrayList<>(10);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            stringArray.add(input.readLine());
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len;
        for (String s : stringArray) {
            len = s.length();
            if (len > max) {
                max = s.length();
            }
            if (len < min) {
                min = len;
            }
        }
        for (String s : stringArray) {
            if (s.length() == min || s.length() == max) {
                System.out.println(s);
                break;
            }
        }
        //напишите тут ваш код
    }
}
