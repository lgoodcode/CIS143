package com.olympic.cis143.m02.student.homework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/**
 * Note that you can think of the deck implementation as being an iterator in that its creates and used once. Meaning, when a card is
 * delt is  MUST be removed from the deck.
 */
public class DeckLinkedListImpl {

    /**
     * This will be the stack object for you to work with.
     */
    private Deque<Card> deck = new LinkedList<>();

    /**
     * Const.
     * @param jokers True if you want jokers in this deck.
     */
    public DeckLinkedListImpl(final boolean jokers) {
        this.createDeck(jokers);
    }

    /**
     * Private. THis is the place where you will need to create a deck of cards. You can iterate throug
     * ther enums in Card.
     *
     * Some rules:
     * ============
     * 1. Note the boolean jokers parameter. If true add the Jokers to the deck with a Card.Suite.NONE.
     * 2. Do not create cards, other than jokers, with a Card.Suite.NONE.
     *
     * Outcome
     * ========
     * if jokers == true, 54 cards will be created.
     * if jokers == false, 52 cards are created.
     *
     * @param jokers True if you want jokers added to the deck.
     */
    private void createDeck(final boolean jokers) {
        // Iterate through each suit
        for (Card.Suit suit : Card.Suit.values()) {
            // If on the last suit, check if we need to add jokers or not
            if (suit == Card.Suit.NONE) {
                if (jokers) {
                    deck.add(new Card(suit, Card.Value.JOKER));
                    deck.add(new Card(suit, Card.Value.JOKER));
                    break;
                }
            // Otherwise, iterate through each card and add it to deck
            } else {
                for (Card.Value val : Card.Value.values()) {
                    // Skip the joker
                    if (val == Card.Value.JOKER) {
                        continue;
                    }

                    deck.add(new Card(suit, val));
                }
            }
        }
    }

    /**
     * Gets the deck.
     * @return The deck.
     */
    public Deque<Card> getDeck() {
        return this.deck;
    }
    /**
     * Randomize and shuffle the deck of cards.
     * 
     * Create a copy of the LinkedList as an array and sort that, then clear
     * the deck and add the shuffled cards back in.
     */
    public void shuffle() {
        Object[] cards = deck.toArray();
        Random rand = new Random();
        Object temp;
        int i, j;
    
        for (i = deck.size(); i > 0; i--) {
          j = rand.nextInt(i);
          temp = cards[j];
          cards[j] = cards[i-1];
          cards[i-1] = temp;
        }

        deck.clear();
        
        for (var card : cards) {
            deck.add((Card) card);
        }
    }

    /**
     * True if the deck has cards remaining else false.
     * @return
     */
    public boolean hasNext() {
        return !deck.isEmpty();
    }

    /**
     * Always call the hasNext() method before calling this method.
     * This method should get the next card in the deck.
     *
     * Outcome
     * =======
     * The method will remove the next from the deck and return it in the method.
     *
     * If the deck is empty it should through a RuntimeException.
     * @return
     */
    public Card dealCard() {
        return deck.pop();
    }
}
