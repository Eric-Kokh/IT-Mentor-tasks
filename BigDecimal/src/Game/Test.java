package Game;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Тагир", 36);
        Employee employee2 = new Employee("Играмудин", 43);
        Employee employee3 = new Employee("Гаджихан", 44);
        Employee employee4 = new Employee("Руслан", 41);
        Employee employee5 = new Employee("Тимур", 35);
        Team<Employee> teamEmployee1 = new Team<>("Кабаны");
        Team<Employee> teamEmployee2 = new Team<>("Львы");
        teamEmployee1.addNewParticipant(employee1);
        teamEmployee1.addNewParticipant(employee2);
        teamEmployee1.addNewParticipant(employee3);
        teamEmployee2.addNewParticipant(employee4);
        teamEmployee2.addNewParticipant(employee5);

        Student student1 = new Student("Шамиль", 18);
        Student student2 = new Student("Магомедхан", 18);
        Student student3 = new Student("Магомед", 17);
        Student student4 = new Student("Толик", 20);
        Team<Student> teamStudent1 = new Team<>("Хакеры");
        Team<Student> teamStudent2 = new Team<>("Кодеры");
        teamStudent1.addNewParticipant(student1);
        teamStudent1.addNewParticipant(student2);
        teamStudent2.addNewParticipant(student3);
        teamStudent2.addNewParticipant(student4);

        Schoolboy schoolboy1 = new Schoolboy("Аминка", 14);
        Schoolboy schoolboy2 = new Schoolboy("Алия", 14);
        Schoolboy schoolboy3 = new Schoolboy("Шуана", 14);
        Schoolboy schoolboy4 = new Schoolboy("Патя", 14);
        Team<Schoolboy> teamSchoolboy1 = new Team<>("Умницы");
        Team<Schoolboy> teamSchoolboy2 = new Team<>("Дурнушки");
        teamSchoolboy1.addNewParticipant(schoolboy1);
        teamSchoolboy1.addNewParticipant(schoolboy2);
        teamSchoolboy2.addNewParticipant(schoolboy3);
        teamSchoolboy2.addNewParticipant(schoolboy4);

        teamEmployee1.playWith(teamEmployee2);

        teamSchoolboy1.playWith(teamSchoolboy2);

        teamStudent1.playWith(teamStudent2);

        

    }
}
