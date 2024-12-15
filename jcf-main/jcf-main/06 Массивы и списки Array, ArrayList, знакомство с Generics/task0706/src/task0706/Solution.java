package task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formattable;
import java.util.Scanner;

/* 
1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение - числом жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными - на другой. Выяснить, на какой стороне улицы проживает больше жителей.
4. Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей." или "В домах с четными номерами проживает больше жителей."

Примечание:
дом с порядковым номером 0 считать четным.


Requirements:
1. Программа должна создавать массив на 15 целых чисел.
2. Программа должна считывать числа для массива с клавиатуры.
3. Программа должна вывести сообщение "В домах с нечетными номерами проживает больше жителей.", если сумма нечетных элементов массива больше суммы четных.
4. Программа должна вывести сообщение "В домах с четными номерами проживает больше жителей.", если сумма четных элементов массива больше суммы нечетных.
5. Программа не должна выводить текст в консоль, если количество жителей на каждой стороне - одинаковое.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int houseCount = 15; // количество домов
        int honestPeopleCount = 0; //количество людей в четных домах
        int oddPeopleCount = 0; //количество людей в нечетных домах
        int[] peopleCount = new int[houseCount]; // массив количество людей в доме с индексом дома совпадающего с индексом массива
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < houseCount; i++) {
            if (input.hasNextInt()) {
                peopleCount[i] = input.nextInt();
            } else {
                peopleCount[i] = 0;
            }
        }

        for (int i = 0; i < houseCount; i++) {
            if (i % 2 == 0) {
                honestPeopleCount += peopleCount[i];
            } else {
                oddPeopleCount += peopleCount[i];
            }
        }
        if (honestPeopleCount > oddPeopleCount) {
            System.out.printf("В дома с четными номерами проживает больше жителей");
        } else if (honestPeopleCount < oddPeopleCount) {
            System.out.printf("В дома с нечетными номерами проживает больше жителей");
        }

        //напишите тут ваш код
    }
}
