package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deck of cards for the War game.
 */
public class Deck extends GroupOfCards {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public Deck() {
        super(52);
        setCards(new ArrayList<>());
        for (String suit : SUITS) {
            for (int rank = 2; rank <= 14; rank++) {
                getCards().add(new WarCard(suit, rank));
            }
        }
        shuffle();
    }

    public Card drawCard() {
        return getCards().isEmpty() ? null : getCards().remove(0);
    }

    public List<WarCard> drawCards(int count) {
        List<WarCard> drawnCards = new ArrayList<>();
        for (int i = 0; i < count && !getCards().isEmpty(); i++) {
            drawnCards.add((WarCard) drawCard());
        }
        return drawnCards;
    }
}
