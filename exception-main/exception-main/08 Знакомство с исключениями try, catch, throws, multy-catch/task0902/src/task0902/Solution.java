package task0902;

/* 
И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.


Requirements:
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать имя метода, вызвавшего его.
4. Для получения имени вызвавшего метода, используй метод getMethodName.*/

import jdk.jfr.StackTrace;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        String str = method1();


//        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
//        try {
//            System.out.println(getFactorial(0));
//        } catch (Exception e) {
//            System.out.println("Основание меньше 1");
//        }



    }

    public static String method1() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            throw new Exception();
        } catch ( Exception e ) {
            System.out.println(e.getStackTrace()[0].getMethodName());
        }
        method2();
        return "";
        //напишите тут ваш код
    }

    public static String method2() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            throw new Exception();
        } catch ( Exception e ) {
            System.out.println(e.getStackTrace()[0].getMethodName());
        }
        method3();
        return "";
        //напишите тут ваш код
    }

    public static String method3() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            throw new Exception();
        } catch ( Exception e ) {
            System.out.println(e.getStackTrace()[0].getMethodName());
        }
        method4();
        return "";
        //напишите тут ваш код
    }

    public static String method4() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            throw new Exception();
        } catch ( Exception e ) {
            System.out.println(e.getStackTrace()[0].getMethodName());
        }
        method5();
        return "";
        //напишите тут ваш код
    }

    public static String method5() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            throw new Exception();
        } catch ( Exception e ) {
            System.out.println(e.getStackTrace()[0].getMethodName());
        }
        return "";
        //напишите тут ваш код
    }
    public static int getFactorial(int num) throws Exception{

        if(num<1) throw new Exception("The number is less than 1");
        int result=1;
        for(int i=1; i<=num;i++){

            result*=i;
        }
        return result;
    }

}
