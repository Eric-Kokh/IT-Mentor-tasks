import java.util.Optional;
import java.util.OptionalInt;

public class TregLambda {
    public static void def(I i) {
        System.out.println(i.abc("Nurik"));

    }

    public static void main(String[] args) {
        I tr = (String str) -> str.length();

        def((String str) -> str.length());

    }

}

interface I {
    int abc(String s);
}
