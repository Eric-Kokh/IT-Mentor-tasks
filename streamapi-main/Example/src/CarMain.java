import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.*;
import java.util.stream.*;

public class CarMain {
    static ArrayList<Car> cars = new ArrayList<>();

    public static void createCar(int countCars, Supplier<Car> carSuplay) {
        for (int i = 0; i < countCars; i++) {
            cars.add(carSuplay.get());
        }
    }

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        createCar(10, () -> {
            return new Car("noname", "undefined", 0.0);
        });

        changeCar(cars.get(0), c -> {
            c.setModel("Toyota");
            c.setColour("Blue");
            c.setEngineCapacity(3.5);
        });

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Nokia 9", "HMD Global",150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(p->System.out.printf("%s (%s) - %d \n",
                        p.getName(), p.getCompany(), p.getPrice()));
//        Collector
//        Collectors
        try {
            Files.walk(Path.of("f:\\"),5).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream stream = Stream.of(new int[]{1, 2, 3, 4, 5});
        IntStream.range(1, 100);
        DoubleStream.iterate(0,d -> d < 100, d -> d + 2.3).forEach(System.out::println);
        cars.forEach(System.out::println);
        MobileInt nokia =  Mobile::zvonok;
        nokia.zvonok("Dzinn xyz");

    }
}
