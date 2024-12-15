package task1405;

/* 
Пора покушать
Давай напишем программу, которая поможет тебе выбрать, что съесть на обед.
Для этого нужно:
Реализовать интерфейс Selectable в классе Food.
Метод onSelect() должен выводить на экран фразу "The food was selected".
Подумай, какие методы можно вызвать для переменной food, а какие для — selectable.
В методе callFoodMethods вызови методы onSelect, onEat, если это возможно.
В методе callSelectableMethods вызови методы onSelect, onEat, если это возможно.
Не используй явное приведение типов.

Requirements:
1. Интерфейс Selectable должен быть реализован в классе Food.
2. Метод onSelect() в классе Food должен выводить на экран фразу "The food was selected".
3. В методе callFoodMethods должны вызываться методы объекта типа Food.
4. В методе callSelectableMethods должны вызываться методы доступные у любого объекта реализующего интерфейс Selectable.
*/

public class Solution {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();

        callFoodMethods(food);
        callSelectableMethods(selectable);
    }

    public static void callFoodMethods(Food food) {
        //тут добавьте вызов методов для переменной food
    }

    public static void callSelectableMethods(Selectable selectable) {
        //тут добавьте вызов методов для переменной selectable
    }

    interface Selectable {
        void onSelect();
    }

    static class Food {
        public void onEat() {
            System.out.println("The food was eaten");
        }
    }
}
