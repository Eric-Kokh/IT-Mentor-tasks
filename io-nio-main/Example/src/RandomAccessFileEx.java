import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class RandomAccessFileEx {
    public static void main(String[] args) throws IOException {

        FilenameFilter txtFilter = (dir, name) -> name.endsWith(".txt");
//        System.out.println("FilenameFilter class: "+ FilenameFilter.class);

        File file = new File("test.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        byteBuffer.put("Hello world".getBytes());
        byteBuffer.flip();
        byte[] byteArray = new byte[11];
        byteBuffer.get(byteArray);
        for (byte b : byteArray) System.out.print((char) b);
        byteBuffer.flip();
        System.out.println();
        fileChannel.write(byteBuffer);
        fileChannel.position(7);
        System.out.println(fileChannel.position());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        System.out.println(fileChannel.position());
        randomAccessFile.close();
        fileChannel.close();
        Scanner scanner = new Scanner(System.in);
        Path

    }
    
}
