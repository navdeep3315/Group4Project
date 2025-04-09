package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, List<WarCard> deck) {
        super(name, new ArrayList<>(deck));
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        System.out.println(getName() + ", press Enter to draw a card.");
        scanner.nextLine();