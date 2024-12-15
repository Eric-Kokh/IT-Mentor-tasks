//3. Ссылка на метод экземпляра произвольного объекта

import java.util.Arrays;

class Comp {
    public static int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class LambdaApp3 {
    public static void main(String[] args) {
        String[] words = {"cherry", "banana", "apple"};

        // Сортировка массива с использованием ссылки на метод compareToIgnoreCase
        Arrays.sort(words, String::compareToIgnoreCase);
        Arrays.sort(words, Comp::compare);

        // Вывод отсортированного массива
        for (String word : words) {
            System.out.println(word);
        }
    }
}
