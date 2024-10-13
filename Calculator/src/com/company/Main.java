package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner console = new Scanner(System.in);
        try {
            System.out.println(calc(console.nextLine()));
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
        console.close();
    }
    public static String calc(String input) throws Exception {

        int result;
        String[] elements = input.split(" ");

        int a = Integer.parseInt(elements[0]), b = Integer.parseInt(elements[2]);

        if ((elements.length != 3) || !(0 <= a && a <= 10) || !(0 <= b && b <= 10)){
            throw new Exception();
        }

        switch (elements[1]){
            case "+" :
                result = a + b;
                break;
            case "-" :
                result = a - b;
                break;
            case "*" :
                result = a * b;
                break;
            case "/" :
                result = a / b;
                break;
            default:
                throw new Exception();
        }
        return Integer.toString(result);
    }
}