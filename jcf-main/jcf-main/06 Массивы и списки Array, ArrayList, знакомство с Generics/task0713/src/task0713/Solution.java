package task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Играем в Золушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.


Requirements:
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer> (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integerArrayList = new ArrayList<>(10);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            integerArrayList.add(Integer.parseInt(input.readLine()));
        }
        ArrayList<Integer> multipleOfTwo = new ArrayList<>(integerArrayList);
        ArrayList<Integer> multipleOfThree = new ArrayList<>(integerArrayList);

        Iterator iteratorOfTwo = multipleOfTwo.iterator();
        Iterator iteratorOfThree = multipleOfThree.iterator();

        while (iteratorOfTwo.hasNext()) {
            Integer i = (Integer) iteratorOfTwo.next();
            if ( i % 2 != 0) {
                iteratorOfTwo.remove();
            }
        }
        while (iteratorOfThree.hasNext()) {
            Integer i = (Integer) iteratorOfThree.next();
            if ( i % 3 != 0) {
                iteratorOfThree.remove();
            }
        }

        integerArrayList.removeAll(multipleOfThree);
        integerArrayList.removeAll(multipleOfTwo);

        printList(integerArrayList);
        System.out.println("================================");
        printList(multipleOfThree);
        System.out.println("================================");
        printList(multipleOfTwo);



        //напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        Iterator iterator = list.iterator();
        iterator.forEachRemaining(i -> System.out.println(i));
        //напишите тут ваш код
    }
}
