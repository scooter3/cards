package com.pslin.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author plin
 */
public class HandCompareUtils {

    public static void main(String[] args) {
//        Hand straight = CardGenerator.getStraight(3, 7);
//        System.out.println(straight.toString());
//        System.out.println(isStraight(straight));
//
//        Hand flush = CardGenerator.getFlush(Card.Suit.SPADE);
//        System.out.println(flush.toString());
//        System.out.println(isFlush(flush));
//
//        Hand random = CardGenerator.getFiveRandom();
//        System.out.println(random.toString());
//        System.out.println(isFlush(random));

        Hand fullHouse = CardGenerator.getFullHouse(14, 3);
        System.out.println(fullHouse.toString());
        System.out.println(isFullHouse(fullHouse));


    }

//    public boolean compareHands(Hand hand1, Hand hand2) {
//        if(hand1.getCards().size() != hand2.getCards().size()) {
//            throw new RuntimeException("Cannot compare hands: different sizes.");
//        }
//
//
//    }

    /**
     * Determines if a hand is a straight.
     *
     * @param hand
     * @return true if hand is a straight
     */
    public static boolean isStraight(Hand hand) {
        List<Card> cards = hand.getCards();

        if(cards.size() < 5) {
            return false;
        }

        Collections.sort(cards);
        Card previousCard = null;

        for(Card card : cards) {
            if(previousCard == null) {
                previousCard = card;
                continue;
            }
            // check difference between current and previous is not 1, it is not a straight
            if(card.getValue() - previousCard.getValue() != 1) {
                return false;
            }

            previousCard = card;
        }

        return true;
    }

    /**
     * Determines if a hand is a flush.
     *
     * @param hand
     * @return true if hand is a flush
     */
    public static boolean isFlush(Hand hand) {
        List<Card> cards = hand.getCards();

        if(cards.size() < 5) {
            return false;
        }

        Card.Suit suit = null;

        for(Card card : cards) {
            if(suit == null) {
                suit = card.getSuit();
                continue;
            }
            if(suit != card.getSuit()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isFullHouse(Hand hand) {
        Map<Integer, List<Card>> cardMap = new HashMap<>();
        List<Card> cards = hand.getCards();

        if(cards.size() < 5) {
            return false;
        }

        for(Card card : cards) {
            List<Card> list = cardMap.get(card.getValue());

            // if list is null, then create a new one and add it to the map
            if(list == null) {
                list = new ArrayList<>();
                cardMap.put(card.getValue(), list);
            }

            list.add(card);
        }

        // if there are more than 2 distinct card values, it is not a full house
        if(cardMap.size() != 2) {
            return false;
        }

        int previousSet = 0;
        for(Map.Entry<Integer, List<Card>> entry : cardMap.entrySet()) {
            if(previousSet == 0) {
                previousSet = entry.getValue().size();
            } else {
                if(previousSet == 2) {
                    return entry.getValue().size() == 3;
                }
            }

        }

        return false;
    }

    public static boolean isStraightFlush(Hand hand) {
        return isStraight(hand) && isFlush(hand);
    }


}
