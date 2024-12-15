package task1809;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Requirements:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        File file1, file2;
        file1 = getFileName("Введите file1: ", false, inputStreamReader);
        file2 = getFileName("Введите file2: ", true, inputStreamReader);
        if (file1 == null) System.out.println("Файла file1 не существует");
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        FileChannel fileChannel1 = fileInputStream1.getChannel();
        FileChannel fileChannel2 = fileOutputStream2.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(500);
        int byteRead = fileChannel1.read(byteBuffer);
        while (byteRead > 0) {

            ByteBuffer reversedBuffer = ByteBuffer.allocate(byteRead);
            for (int i = byteRead-1; i >= 0 ; i--) {
                reversedBuffer.put(byteBuffer.get(i));
            }
            reversedBuffer.flip();
            fileChannel2.write(reversedBuffer);
            byteBuffer.clear();
            byteRead = fileChannel1.read(byteBuffer);

        }

        System.out.println();

        fileInputStream1.close();
        fileOutputStream2.flush();
        fileOutputStream2.close();

        inputStreamReader.close();

    }

    public static File getFileName(String msg, boolean createFile, InputStreamReader inputStreamReader) {

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String fileName = null;
            File file = null;
            System.out.print(msg);
            try {
                fileName = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file = new File(fileName);
            if (file.exists()) {
                return file;
            } else if (createFile) {
                try {
                    Files.createFile(Path.of(fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return file;
            } else return null;

    }
}
