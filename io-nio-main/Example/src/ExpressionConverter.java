import java.util.*;

public class ExpressionConverter {
    public static void main(String[] args) {
        String infixExpression = "3.14 + x * cos(2.5 - y) / z ^ 2";

        try {
            String rpn = toRPN(infixExpression);
            System.out.println("Обратная польская нотация: " + rpn);
            String infix = fromRPN(rpn);
            System.out.println("Восстановленное выражение: " + infix);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Преобразование инфиксного выражения в обратную польскую нотацию
//    Код не работает, надо дорабатывать
    public static String toRPN(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<String> operators = new Stack<>();
        String[] tokens = tokenize(expression);

        for (String token : tokens) {
            if (isNumber(token) || isVariable(token)) {
                output.append(token).append(" ");
            } else if (isFunction(token)) {
                operators.push(token);
            } else if ("(".equals(token)) {
                operators.push(token);
            } else if (")".equals(token)) {
                while (!operators.isEmpty() && !"(".equals(operators.peek())) {
                    output.append(operators.pop()).append(" ");
                }
                if (operators.isEmpty() || !"(".equals(operators.pop())) {
                    throw new IllegalArgumentException("Несогласованные скобки");
                }
                if (!operators.isEmpty() && isFunction(operators.peek())) {
                    output.append(operators.pop()).append(" ");
                }
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.append(operators.pop()).append(" ");
                }
                operators.push(token);
            } else {
                throw new IllegalArgumentException("Неподдерживаемый токен: " + token);
            }
        }

        while (!operators.isEmpty()) {
            String op = operators.pop();
            if ("(".equals(op) || ")".equals(op)) {
                throw new IllegalArgumentException("Несогласованные скобки");
            }
            output.append(op).append(" ");
        }

        return output.toString().trim();
    }

    // Преобразование из обратной польской нотации в инфиксное выражение
    public static String fromRPN(String rpn) {
        Stack<String> stack = new Stack<>();
        String[] tokens = rpn.split(" ");

        for (String token : tokens) {
            if (isNumber(token) || isVariable(token)) {
                stack.push(token);
            } else if (isFunction(token)) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Недостаточно операндов для функции: " + token);
                }
                String a = stack.pop();
                String subExpression = token + "(" + a + ")";
                stack.push(subExpression);
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Недостаточно операндов для операции: " + token);
                }
                String b = stack.pop();
                String a = stack.pop();
                String subExpression = "(" + a + " " + token + " " + b + ")";
                stack.push(subExpression);
            } else {
                throw new IllegalArgumentException("Неподдерживаемый токен: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        return stack.pop();
    }

    // Разбиение строки на токены
    private static String[] tokenize(String expression) {
        return expression.split("(?<=[-+*/^(),])|(?=[-+*/^(),])|\\s+");
    }

    // Проверка, является ли строка числом
    private static boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    // Проверка, является ли строка переменной
    private static boolean isVariable(String token) {
        return token.matches("[a-zA-Z]+") && !isFunction(token);
    }

    // Проверка, является ли строка оператором
    private static boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }

    // Проверка, является ли строка функцией
    private static boolean isFunction(String token) {
        return Arrays.asList("cos", "sin", "tg", "ctg", "ln", "log", "exp").contains(token.toLowerCase());
    }

    // Приоритет операторов
    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }
}
