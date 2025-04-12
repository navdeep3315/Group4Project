package ca.sheridancollege.project;

import java.util.List;
import java.util.ArrayList;

public class ComputerPlayer extends Player {
    public ComputerPlayer(List<WarCard> deck) {
        super("Computer", new ArrayList<>(deck));
    }

    @Override
    public void play() {
        System.out.println("Computer is drawing a card...");
    }
}
