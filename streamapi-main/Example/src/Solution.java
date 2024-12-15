public class Solution {
    public static void main(String[] args) {
        Operationable<Integer> operationable = (x, y) -> x + y;

        System.out.println(operationable.calculate(2, 3));
        Operationable<String> operationable2 = (x, y) -> {
            return x + y;
        };
        System.out.println(operationable2.calculate("2", "3"));

        Expression func = (x) -> x % 2 == 0;
        int[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(arrayInt, func));


        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(sum(nums, ExpressionHelper::isEven));

        Expression expr = ExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));
    }
    private static int sum(int[] arrayInt, Expression func){
        int sum = 0;
        for (int i : arrayInt) {
            if (func.isEqual(i)) sum += i;
        }
        return sum;
    }
}

interface Operationable<T> {
    public T calculate(T x, T y);
}

interface Expression {
    public boolean isEqual(int i);
}
// класс, в котором определены методы
class ExpressionHelper{

    static boolean isEven(int n){

        return n%2 == 0;
    }

    static boolean isPositive(int n){

        return n > 0;
    }
}
