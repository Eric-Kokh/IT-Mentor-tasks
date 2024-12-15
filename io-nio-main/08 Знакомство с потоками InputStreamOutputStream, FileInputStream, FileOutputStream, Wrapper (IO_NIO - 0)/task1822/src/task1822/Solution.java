package task1822;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Пример содержимого файла:
194 хлеб 12.6 25
195 масло сливочное 52.2 12
196 молоко 22.9 19

Пример вывода для id = 195:
195 масло сливочное 52.2 12


Requirements:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Element> base = new ArrayList<>();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        File file = getFileName("Введите имя файла: ", false, inputStreamReader);
        System.out.println(file.getName());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            base.add(new Element().getElementFromString(str));
        }
        for (Element element : base) {
            if (Integer.parseInt(args[0]) == element.id) {
                System.out.println(element);
            }
        }
        fileReader.close();
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
