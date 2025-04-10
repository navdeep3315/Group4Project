/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author navde
 */
    import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {  // ✅ Loop to allow replay
                System.out.print("Enter Player 1 name: ");
                String player1Name = scanner.nextLine();
                
                System.out.print("Enter Player 2 name (or press Enter for Computer): ");
                String player2Name = scanner.nextLine();
                
                boolean isComputer = player2Name.isEmpty();
                Deck deck = new Deck();
                
                Player player1 = new HumanPlayer(player1Name, deck.drawCards(26));
                Player player2 = isComputer ? new ComputerPlayer(deck.drawCards(26)) : new HumanPlayer(player2Name, deck.drawCards(26));
                
                WarGame game = new WarGame(player1, player2);
                game.play();
                
                // ✅ Ask if the user wants to play again AFTER the game ends
                System.out.print("\nDo you want to play again? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                
                if (!response.equals("yes")) {
                    System.out.println("Thank you for playing! Goodbye.");
                    break;  // ✅ Exit loop if user says "no"
                }
            }
        }
    }
}

