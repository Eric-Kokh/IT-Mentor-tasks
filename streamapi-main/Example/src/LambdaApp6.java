//6. Ссылка на метод, встроенный в Stream API
import java.util.Arrays;
import java.util.List;

    public class LambdaApp6 {
        public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

            // Использование ссылки на метод System.out::println
            names.forEach(System.out::println);
        }
    }
