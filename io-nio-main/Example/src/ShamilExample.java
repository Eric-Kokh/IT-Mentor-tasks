import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ShamilExample {
    public static void main(String[] args) {
        Cat marsik = new Cat("Marsik");
        File file = new File("C:\\IT-MENTOR\\multithreading-main\\test.txt");
        File fileCat = new File("C:\\IT-MENTOR\\multithreading-main\\cat.bin");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileCat));) {
            objectOutputStream.writeObject(marsik);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (RandomAccessFile test = new RandomAccessFile(file, "rw");
            FileChannel channel = test.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(50);
            StringBuilder stix = new StringBuilder();
            System.out.write("@ Привет @\n".getBytes());
            System.out.println("Привет");
//            ByteArrayInputStream
            int byteRead = channel.read(buffer);
            while (byteRead > 0){
//                System.out.println("Read " + byteRead);
                buffer.flip();

                while (buffer.hasRemaining()) {
//                    System.out.println(buffer.position());
                    stix.append((char) buffer.get());
                }

                buffer.clear();

                byteRead = channel.read(buffer);
            }
            System.out.println(stix);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Serializable{
    String name;
    int age;
    int colourship;

    public Cat(String name, int age, int colourship) {
        this.name = name;
        this.age = age;
        this.colourship = colourship;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.colourship = 0;
    }

    public Cat(String name) {
        this.name = name;
        this.age = 0;
        this.colourship = 0;
    }

    public boolean sret() {
        System.out.println(name + " sret");
        Random r = new Random();

        return r.nextBoolean();
    }

    public void meow() {
        System.out.println("Meouwwww");
    }

}