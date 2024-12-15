//5. Ссылка на конструктор с параметрами
import java.util.function.BiFunction;

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + " years old)";
        }
    }

    public class LambdaApp5 {
        public static void main(String[] args) {
            // Ссылка на конструктор с двумя параметрами
            BiFunction<String, Integer, Person> personBuilder = Person::new;

            // Создание объекта
            Person person = personBuilder.apply("Alice", 30);
            System.out.println(person); // Output: Alice (30 years old)
        }
    }