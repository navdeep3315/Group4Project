/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author navde
 */

public class WarGame extends Game {
    private Player player1;
    private Player player2;
    private WarRound warRound;
    private boolean gameOver = false; 

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
        System.out.println(player1.getName() + " wins the game! ");
        System.out.println(player1.getName() + "'s final score: " + player1Cards + " cards");
        System.out.println(player2.getName() + "'s final score: " + player2Cards + " cards");
    } else if (player2Cards > player1Cards) {
        System.out.println(player2.getName() + " wins the game! ");
        System.out.println(player2.getName() + "'s final score: " + player2Cards + " cards");
        System.out.println(player1.getName() + "'s final score: " + player1Cards + " cards");
    } else {
        System.out.println("It's a tie!");
        System.out.println(player1.getName() + " and " + player2.getName() + " both have " + player1Cards + " cards");
    }

    System.out.println("========================\n");
}






    private void showScore() {
        System.out.println("\n=== Current Score ===");
        System.out.println(player1.getName() + ": " + player1.getTotalCardCount() + " cards");
        System.out.println(player2.getName() + ": " + player2.getTotalCardCount() + " cards");
        System.out.println("======================\n");
    }

    public void setGameOver(boolean gameOver) { 
        this.gameOver = gameOver;
    }
}


