package task1207;

/* 
Int и Integer
Реализуй два метода: print(int) и print(Integer).
Напиши такой код в методе main(), чтобы вызвались оба.


Requirements:
1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический void метод print() с параметром типа int.
3. Класс Solution должен содержать статический void метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.*/

public class Solution {
    public static String print(int num){
        return "Чило";
    }
    public static String print(String str){
        return "Строка";
    }
    public static void main(String[] args) {
        System.out.println(print(1));
        System.out.println(print("варпол"));
    }

    //Напишите тут ваши методы
}
