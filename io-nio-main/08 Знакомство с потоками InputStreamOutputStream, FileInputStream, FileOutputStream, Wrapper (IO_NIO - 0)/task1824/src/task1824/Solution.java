package task1824;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используй System.exit();


Requirements:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        if (getFileName("Введите имя файла: ", false, inputStreamReader) == null) {
            System.out.println("переданное неправильное имя файла");
        }
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
