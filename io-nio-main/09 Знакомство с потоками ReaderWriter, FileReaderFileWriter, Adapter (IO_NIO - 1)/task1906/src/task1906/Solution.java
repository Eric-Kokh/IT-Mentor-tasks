package task1906;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Requirements:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.*/

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

            ByteBuffer evendBuffer = ByteBuffer.allocate(byteRead);
            for (int i = 1; i <= byteRead-1 ; i+=2) {
                evendBuffer.put(byteBuffer.get(i));
            }
            evendBuffer.flip();
            fileChannel2.write(evendBuffer);
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
