package task1805;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.print("Введите имя файла: ");
        String fileName = null;
        TreeSet<Byte> byteTreeSet = new TreeSet<>();

        try {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file;
        if (fileName != null) {
            file = new File(fileName);
        } else return;
        if (!file.exists()) return;


        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
             FileChannel fileChannel = randomAccessFile.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);
            int byteRead = fileChannel.read(byteBuffer);


            while (byteRead > 0){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byteTreeSet.add(byteBuffer.get());
                }
                byteBuffer.clear();
                byteRead = fileChannel.read(byteBuffer);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Byte b : byteTreeSet) {
            System.out.print(b + " ");
        }
    }
}
