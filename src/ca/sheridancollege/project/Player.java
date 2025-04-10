package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> deck;
    private List<Card> wonPile;

    public Player(String name, List<Card> deck) {
        this.name = name;
        this.deck = (deck != null) ? new ArrayList<>(deck) : new ArrayList<>();
        this.wonPile = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean hasCards() {
        return !deck.isEmpty() || !wonPile.isEmpty();
    }

    public Card drawCard() {
        if (deck.isEmpty() && !wonPile.isEmpty()) {
            reshuffleWonPile();
        }
        return deck.isEmpty() ? null : deck.remove(0);
    }

    public void collectCards(List<WarCard> cards) {
        if (cards != null && !cards.isEmpty()) {
            wonPile.addAll(cards);
        }
    }

    public void checkAndReshuffle() {
        if (deck.isEmpty() && !wonPile.isEmpty()) {
            reshuffleWonPile();
        }
    }

    private void reshuffleWonPile() {
        if (!wonPile.isEmpty()) {
            System.out.println(name + " is reshuffling their won pile into the deck!");
            Collections.shuffle(wonPile);
            deck.addAll(wonPile);
            wonPile.clear();
        }
    }

    public int getTotalCardCount() {
        return deck.size() + wonPile.size();
    }



    public abstract void play();
}
