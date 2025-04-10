package ca.sheridancollege.project;

public class WarGame extends Game {
    private Player player1;
    private Player player2;
    private WarRound warRound;
    private boolean gameOver = false; 
    private int player1RoundsWon = 0;
    private int player2RoundsWon = 0;
    

    public WarGame(Player player1, Player player2) {
        super("War Card Game");
        this.player1 = player1;
        this.player2 = player2;
        this.warRound = new WarRound(player1, player2, this);
    }

    @Override
    public void play() {
        System.out.println("Starting War Game!\n");

        while (player1.hasCards() && player2.hasCards()) {
            warRound.playRound();
            showScore();
            if (gameOver) break; 
        }

        declareWinner(); 
    }

@Override
public void declareWinner() {
    int player1Cards = player1.getTotalCardCount();
    int player2Cards = player2.getTotalCardCount();

    System.out.println("\n===== Final Result =====");

    if (player1Cards > player2Cards) {
        System.out.println(player1.getName() + " wins the game!");
    } else if (player2Cards > player1Cards) {
        System.out.println(player2.getName() + " wins the game!");
    } else {
        System.out.println("It's a tie!");
    }

    System.out.println(player1.getName() + "'s final score: " + player1Cards + " cards");
    System.out.println(player2.getName() + "'s final score: " + player2Cards + " cards");

    System.out.println();
    System.out.println(player1.getName() + " won " + player1RoundsWon + " rounds.");
    System.out.println(player2.getName() + " won " + player2RoundsWon + " rounds.");
    System.out.println("========================\n");
}
public void incrementPlayer1RoundsWon() {
    player1RoundsWon++;
}

public void incrementPlayer2RoundsWon() {
    player2RoundsWon++;
}




    public void showScore() {
    System.out.println("\n=== Current Score ===");
    System.out.println(player1.getName() + ": " + player1.getTotalCardCount() + " cards | Rounds Won: " + player1RoundsWon);
    System.out.println(player2.getName() + ": " + player2.getTotalCardCount() + " cards | Rounds Won: " + player2RoundsWon);
    System.out.println("Total Round: "+(player1RoundsWon+player2RoundsWon));

    System.out.println("=======================");
}

    

    public void setGameOver(boolean gameOver) { 
        this.gameOver = gameOver;
    }
}
