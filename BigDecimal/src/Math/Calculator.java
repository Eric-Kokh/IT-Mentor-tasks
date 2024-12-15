package Math;

public interface Calculator {
    // Публичный метод по умолчанию
    default int add(int a, int b) {
        validate(a, b);
        return a + b;
    }

    // Еще один публичный метод по умолчанию
    default int subtract(int a, int b) {
        validate(a, b);
        return a - b;
    }

    // Приватный метод для проверки входных данных
    private void validate(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Arguments must be non-negative");
        }
    }

    // Статический метод с использованием приватного метода
    static int multiply(int a, int b) {
        validateStatic(a, b);
        return a * b;
    }

    // Приватный статический метод
    private static void validateStatic(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Arguments must be non-negative");
        }
    }
}