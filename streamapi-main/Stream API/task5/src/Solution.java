import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    /**
    *Подсчитайте количество задач имеющих тег books
    *Решить необходимо в 1 stream.
    */

    public static void main(String[] args) {
        Task task1 = new Task(1, "Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
        Task task2 = new Task(2, "Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
        Task task3 = new Task(3, "Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile").addTag("books");
        Task task4 = new Task(4, "Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
        Task task5 = new Task(5, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

        List<Task> tasks1 = Arrays.asList(task1, task2, task3, task4, task5);
        List<Task> tasks2 = Arrays.asList(task1, task2, task3, task4, task5);
        List<Task> tasks3 = Arrays.asList(task1, task2, task3, task4, task5);



        System.out.println(allReadingTasks(List.of(tasks1, tasks2, tasks3)));

        Map<TaskType, Long> adsfgsdf = List.of(tasks1, tasks2, tasks3).stream()
                .flatMap(List::stream).collect(Collectors.groupingBy(Task::getType, Collectors.counting()));
        System.out.println(adsfgsdf);

        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.toList());


//        BinaryOperator<Integer> sum = Integer::sum;
//        System.out.println(sum.apply(10, 20)); // Вывод: 30
//        tasks1.removeIf(task -> true);
//
////        Collections.addAll()
//        Stream<Task> tasksStream = tasks1.stream();
//        tasksStream.filter(task -> task.getType() == TaskType.READING).flatMap(task -> task.getTags().stream()).distinct().forEach(System.out::println);


//        BiFunction<Integer, Integer, Integer> sumBiF = Integer::sum;
//        System.out.println(sum.apply(10, 20));

//        UnaryOperator<Integer> incInt = integer -> integer += 10;
//        System.out.println(incInt.apply(5));
//
//        Function<Integer, Integer> incIntFun = integer -> integer += 10;
//        System.out.println(incIntFun.apply(5));

    }

    private static Long allReadingTasks(List<List<Task>> tasks) {

        return tasks.stream()
                .flatMap(List::stream)
//                .flatMap(el -> el.stream()) // можно написать и так, компилятор сам понимает что List.stream()
//                т.е. мы подаем List а получаем поток, так же и здесь el/это List/ -> el.stream()/а это поток Stream/
                .filter(el -> el.getTags().contains("books"))
                .count();
        // Ваш код здесь
    }
}