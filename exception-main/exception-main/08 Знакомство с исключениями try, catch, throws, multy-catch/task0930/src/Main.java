import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.*;

/**
 *  Логирование состояний и ошибок в работе программы.
 *  Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 *  Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 */

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("f:\\app.log");
            fileHandler.setLevel(Level.FINEST);
            logger.setLevel(Level.FINEST);
        } catch (IOException e) {
            logger.log(Level.WARNING,"Ошибка создания файла app.log");
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        try {
            logger.log(Level.INFO, "Вызов метода dangerousMethod начался");
            dangerousMethod();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка при вызове dangerousMethod", e);
            logger.fine("Fine");
            logger.finer("Finer");
            logger.finest("Finest");
            logger.severe("Предупреждение: Ошибка в процессе выполнения задачи: " + e.getMessage());
            Throwable
        }
    }

    public static void dangerousMethod() throws IOException {
         throw new IOException("Ошибка: что-то пошло не так!");
     }
}