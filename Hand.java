package com.pslin.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author plin
 */
public class Hand {

    private List<Card> cards;

    private int fullHouseTripleValue;

    private int fullHousePairValue;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getFullHouseTripleValue() {
        return fullHouseTripleValue;
    }

    public void setFullHouseTripleValue(int fullHouseTripleValue) {
        this.fullHouseTripleValue = fullHouseTripleValue;
    }

    public int getFullHousePairValue() {
        return fullHousePairValue;
    }

    public void setFullHousePairValue(int fullHousePairValue) {
        this.fullHousePairValue = fullHousePairValue;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Hand{ ");
        for(Card c : cards) {
            string.append(c.getDisplayValue()).append(c.getSuit().getUnicode()).append(" ");
        }
        string.append('}');
        return string.toString();
    }
}
