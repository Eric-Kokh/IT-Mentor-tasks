package Game;

import java.util.ArrayList;

public class Box<T extends Participant> {
    private T item;
    private Class<T> typeT;

    public void setItem(T item) {
        this.item = item;

    }

    public Box(T item) {
        this.item = item;
        this.typeT = (Class<T>) item.getClass();
    }

    public T getItem() {
        System.out.println(typeT);
        return item;
    }

}