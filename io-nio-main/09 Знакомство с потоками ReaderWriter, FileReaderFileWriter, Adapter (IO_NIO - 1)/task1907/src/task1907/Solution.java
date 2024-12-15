package task1907;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        File file = getFileName("Введите имя файла: ", false, inputStreamReader);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int cnt = 0;
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("[,.!?:;'\"\\s]+");
            for (String arg : words) {
                if (arg.equals("world")) cnt++;
            }

        }

        System.out.println(cnt);

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
