/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ishantluna
 */
/**
 * Represents a single card in the War card game.
 */
public class WarCard extends Card {
    private String suit;
    private int rank;

    public WarCard(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rankToString(rank) + " of " + suit;
    }

    private String rankToString(int rank) {
        switch (rank) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return String.valueOf(rank);
        }
    }
}
