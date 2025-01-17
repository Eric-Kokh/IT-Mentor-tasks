package task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.


Requirements:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа List с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int maxRepeat1 = 1;
        int maxRepeat = 0;

        List<Integer> arraylist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arraylist.add(Integer.parseInt(input.readLine()));
        }
        Integer el = arraylist.get(0);
        for (int i = 1; i < 10; i++) {
            if (el.equals(arraylist.get(i))){
                maxRepeat1++;
            } else
            {
                el = arraylist.get(i);
                if (maxRepeat< maxRepeat1) {
                    maxRepeat = maxRepeat1;
                    maxRepeat1 = 1;
                }
            }
        }
        System.out.println(maxRepeat);
        //напишите тут ваш код

    }
}
