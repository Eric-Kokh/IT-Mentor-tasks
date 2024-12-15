package task0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Massiv {

    public static int[] initializeIntArray(int count, int initCount) throws IOException {
        int[] intArray= new int[count];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<initCount; i++) {
            intArray[i] = Integer.parseInt(input.readLine());
        }
        return intArray;
    }

    public static StringBuilder[] initializeStrArray(int count, int initCount) throws IOException {
        StringBuilder[] strArray = new StringBuilder[count];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<initCount; i++) {
            strArray[i] = new StringBuilder(input.readLine());
        }
        for (int i = initCount; i <count ; i++) {
            strArray[i] = new StringBuilder("");
        }
        return strArray;
    }
}
