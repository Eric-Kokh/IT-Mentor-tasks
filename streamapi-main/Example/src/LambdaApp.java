import java.util.ArrayList;
import java.util.stream.BaseStream;

public class LambdaApp {

    public static void main(String[] args) {

        UserBuilder userBuilder = User1::new;
        User1 user = userBuilder.create("Tom");
        System.out.println(user.getName());
        ArrayList <Integer> arrayList = new ArrayList<>();
//        arrayList.stream()
    }
}
interface UserBuilder{
    User1 create(String name);
}


class User1{

    private String name;
    String getName(){
        return name;
    }

    User1(String n){
        this.name=n;
    }
}