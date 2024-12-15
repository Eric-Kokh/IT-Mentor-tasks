package Animals;

public class Dog extends Animal implements Voice{
    private String animalSound;

    public Dog(String name, int age, String animalSound) {
        super(name, age);
        this.animalSound = animalSound;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() + '\'' +
                ",animalSound='" + animalSound + '\'' +
                '}';
    }

    @Override
    public String getVoice() {

        return animalSound;
    }
}
