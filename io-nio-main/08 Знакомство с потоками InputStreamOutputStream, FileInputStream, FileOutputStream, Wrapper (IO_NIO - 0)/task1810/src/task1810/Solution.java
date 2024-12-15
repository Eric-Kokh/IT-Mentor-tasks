package task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Requirements:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.*/

public class Solution {

//    private static Object DownloadException;

    public static void main(String[] args) throws DownloadException, IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
        String strFileName;
        while (true) {
            System.out.print("ВВеди имя файла: ");
            strFileName = bufferedReader.readLine();

            try (FileInputStream fileInputStream = new FileInputStream(strFileName);
                 FileChannel fileChannel = fileInputStream.getChannel()) {
                int readBytes = fileChannel.read(byteBuffer);
                if (readBytes < 1000) {
                    throw new DownloadException();
                }
                byteBuffer.clear();
            }
        }
    }

    public static class DownloadException extends Exception {
        public DownloadException() {
            super("Файл размером меньше 1000 байт");
        }

    }
}
