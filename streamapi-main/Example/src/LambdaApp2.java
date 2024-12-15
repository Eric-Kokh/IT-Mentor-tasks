//2. Ссылка на метод экземпляра объекта
import java.util.function.Consumer;

    public class LambdaApp2 {
        public static void main(String[] args) {
            String message = "Hello, World!";

            // Ссылка на метод экземпляра
            Consumer<String> printer = message::concat;

            // Использование ссылки
//            System.out.println(printer.accept(" Have a great day!")); // "Hello, World! Have a great day!"
        }
    }