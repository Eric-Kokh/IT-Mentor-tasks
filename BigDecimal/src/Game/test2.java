package Game;

import Animals.Animal;
import Animals.Cat;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        ArrayList<? super Animal> array = new ArrayList<>();
        array.add(new Cat());





        System.out.println(array);

    }
}
