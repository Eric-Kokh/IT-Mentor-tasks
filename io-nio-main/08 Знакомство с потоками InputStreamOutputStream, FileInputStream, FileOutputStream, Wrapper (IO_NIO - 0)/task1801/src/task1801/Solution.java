package task1801;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) {
        int max = 0;
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.print("Введите имя файла: ");
        File file = null;
        try {
            file = new File(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            FileChannel channel = randomAccessFile.getChannel())
        {
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);
            int byteRead = channel.read(byteBuffer);

            while (byteRead > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    int cur = byteBuffer.get();
                    if (cur > max) max = cur;
                }
                byteBuffer.clear();
                byteRead = channel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(max);


    }
}
