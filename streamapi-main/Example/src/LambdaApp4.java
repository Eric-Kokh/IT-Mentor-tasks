//4. Ссылка на конструктор
import java.util.function.Supplier;

    class User {
        private String name;

        public User() {
            this.name = "Default User";
        }

        public String getName() {
            return name;
        }
    }

    public class LambdaApp4 {
        public static void main(String[] args) {
            // Ссылка на конструктор
            Supplier<User> userSupplier = User::new;

            // Создание объекта
            User user = userSupplier.get();
            System.out.println(user.getName()); // Output: Default User
        }
    }