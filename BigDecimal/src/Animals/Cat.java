package Animals;

public class Cat extends Animal implements  Voice{
    private String animalSound;

    public Cat(String name, int age, String animalSound) {
        super(name, age);
        this.animalSound = animalSound;
    }

    public Cat() {
        super("dsfasdf", 3);
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    @Override
    public String toString() {
        return "Cat{" +
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
