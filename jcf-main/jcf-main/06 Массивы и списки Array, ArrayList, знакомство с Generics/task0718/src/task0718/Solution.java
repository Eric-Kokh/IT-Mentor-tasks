package task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента, нарушающего такую упорядоченность.


Requirements:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Если список упорядочен по возрастанию длины строки, то ничего выводить не нужно.
4. Если список не упорядочен по возрастанию длины строки, то нужно вывести на экран индекс первого элемента, нарушающего такую упорядоченность.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int narushitel = -1;
        String str = input.readLine();
        arrayList.add(str);
        int prev = str.length();
        for (int i = 1; i < 9; i++) {
            String string = input.readLine();
            arrayList.add(string);
            if (string.length()<prev) {
                narushitel = i;
            } else prev = string.length();
        }

        if (prev != 9) System.out.println(prev);

        //напишите тут ваш код
    }
}

