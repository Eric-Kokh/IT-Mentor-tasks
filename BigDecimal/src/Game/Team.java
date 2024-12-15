package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();
    public static final String ANSI_BLUE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T partisipant){
        participants.add(partisipant);
        System.out.printf("В нашу команду %s%s%s вступил новый член %s\n",ANSI_BLUE,name,ANSI_RESET,partisipant.name);
    }
    void playWith (Team<T> team){
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = name;
        } else {
            winnerName = team.name;
        }
        System.out.printf("Выиграла команда %s%s%s\n",ANSI_BLUE,winnerName,ANSI_RESET);
    }

}
