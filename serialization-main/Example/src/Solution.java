import java.io.*;

public class Solution {

        public static void main(String[] args) throws Exception {

            FileReader reader = new FileReader("file.txt");
            int charData;
            reader.
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
            reader.close();


            FileInputStream fis = new FileInputStream("file.txt");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            fis.close();
        }
    }
