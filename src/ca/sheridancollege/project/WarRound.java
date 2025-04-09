package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class WarRound {
    private Player player1;
    private Player player2;
    private WarGame game;

    public WarRound(Player player1, Player player2, WarGame game) {
        this.player1 = player1;
        this.player2 = player2;
        this.game = game;
    }

    public void playRound() {
        player1.play();
        player2.play();

        WarCard card1 = (WarCard) player1.drawCard();
        WarCard card2 = (WarCard) player2.drawCard();

        if (card1 == null || card2 == null) {
            return;
        }

        System.out.println("\n" + player1.getName() + " plays: " + card1);
        System.out.println(player2.getName() + " plays: " + card2);

        List<WarCard> warPile = new ArrayList<>();
        warPile.add(card1);
        warPile.add(card2);

        if (card1.getRank() > card2.getRank()) {
            System.out.println(player1.getName() + " wins this round and takes all cards!\n");
            player1.collectCards(warPile);
        } else if (card2.getRank() > card1.getRank()) {
            System.out.println(player2.getName() + " wins this round and takes all cards!\n");
            player2.collectCards(warPile);
        } else {
            System.out.println(" WAR! Players place three face-down cards...\n");
            handleWar(warPile);
        }

        player1.checkAndReshuffle();
        player2.checkAndReshuffle();
        checkForElimination();
    }

    private void handleWar(List<WarCard> warPile) {
        for (int i = 0; i < 3; i++) {
            if (!player1.hasCards() || !player2.hasCards()) {
                return;
            }
            warPile.add((WarCard) player1.drawCard());
            warPile.add((WarCard) player2.drawCard());
        }

        System.out.println("WAR CONTINUES! Players reveal their next card...");

        WarCard warCard1 = (WarCard) player1.drawCard();
        WarCard warCard2 = (WarCard) player2.drawCard();

        if (warCard1 == null || warCard2 == null) {
            return;
        }

        System.out.println("\n" + player1.getName() + " plays: " + warCard1);
        System.out.println(player2.getName() + " plays: " + warCard2);

        warPile.add(warCard1);
        warPile.add(warCard2);

        if (warCard1.getRank() > warCard2.getRank()) {
            System.out.println(player1.getName() + " wins the war and takes ALL the cards!\n");
            player1.collectCards(warPile);
        } else if (warCard2.getRank() > warCard1.getRank()) {
            System.out.println(player2.getName() + " wins the war and takes ALL the cards!\n");
            player2.collectCards(warPile);
        } else {
            System.out.println(" ANOTHER WAR! Players place three more face-down cards...\n");
            handleWar(warPile);
        }
    }

    private void checkForElimination() {
        if (!player1.hasCards()) {
            System.out.println("\n" + player1.getName() + " has run out of cards and loses the game!");
            game.setGameOver(true);  
        } else if (!player2.hasCards()) {
            System.out.println("\n" + player2.getName() + " has run out of cards and loses the game!");
            game.setGameOver(true);  
        }
    }
}
