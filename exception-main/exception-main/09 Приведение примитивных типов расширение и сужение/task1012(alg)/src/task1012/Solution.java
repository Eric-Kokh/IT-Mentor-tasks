package task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
Введи с клавиатуры 10 строчек и посчитай в них количество различных букв без учета регистра. Результат выведи на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Requirements:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и количество раз, которое буква встречалась в введенных строках.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine().toLowerCase();
            str.append(line);
        }

        TreeMap<Character, Integer> tm = new TreeMap<>();

        for (int i = 0; i < alphabet.size(); i++) {
            int count = 0;
            /*boolean isFind=true;*/
            int ind = 0;
            while (true) {
                ind = str.indexOf(String.valueOf(alphabet.get(i)), ind);
                if (ind>=0) {
                    ind++;
                    count++;
                } else break;
            }
            tm.put(alphabet.get(i),count);
        }

        Iterator iterator = tm.keySet().iterator();
        for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }

        // напишите тут ваш код
    }
}
