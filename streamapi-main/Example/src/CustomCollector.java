import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.stream.Stream;

public class CustomCollector {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D");

        String result = stream.collect(joiningWithDelimiter(", "));
        System.out.println(result); // A, B, C, D
    }

    public static Collector<String, StringBuilder, String> joiningWithDelimiter(String delimiter) {
        return Collector.of(
                StringBuilder::new, // supplier
                (sb, str) -> { // accumulator
                    if (sb.length() > 0) sb.append(delimiter);
                    sb.append(str);
                },
                (sb1, sb2) -> { // combiner
                    if (sb1.length() > 0 && sb2.length() > 0) sb1.append(delimiter);
                    sb1.append(sb2);
                    return sb1;
                },
                StringBuilder::toString, // finisher
                Collector.Characteristics.UNORDERED // characteristics
        );
    }
}