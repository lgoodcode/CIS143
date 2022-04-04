package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.List;

public class DeckIteratorImpl implements Deck {
   private ArrayList<Card> deck;

   public DeckIteratorImpl(final boolean jokers) {
      deck = new ArrayList<>();
      createDeck(jokers);
   }

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
   public List<Card> getDeck() {
      return deck;
   }

   /**
    * Randomize and shuffle the deck of cards.
    */
   public void shuffle() {

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
      return deck.remove(0);
   }
}
