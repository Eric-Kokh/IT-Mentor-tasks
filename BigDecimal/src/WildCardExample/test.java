package WildCardExample;

public class test {
    public static void main(String[] args) {
        Bio n = new Animal();
        System.out.println(((Animal)n).name);
        n.abc();
    }
}

class Bio {
    String name = "Биомасса";
    public void abc() {
        System.out.println("Метод abc из класса Био");
    }
    public static void def() {
        System.out.println("Статический метод def из класса Био");
    }
}
class Animal extends Bio {
    String name = "Животный мир";
    public void abc() {
        System.out.println("Метод abc из класса Animal");
    }
    public static void def() {
        System.out.println("Статический метод def из класса Animal");
    }
}