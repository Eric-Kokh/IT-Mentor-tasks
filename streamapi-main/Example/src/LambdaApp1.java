//        1. Ссылка на статический метод
import java.util.function.Function;

    public class LambdaApp1 {
        public static void main(String[] args) {
            // Ссылка на статический метод
            Function<String, Integer> parseInt = Integer::parseInt;

            // Использование ссылки
            int number = parseInt.apply("123");
            System.out.println("Parsed number: " + number); // Output: Parsed number: 123
        }
    }