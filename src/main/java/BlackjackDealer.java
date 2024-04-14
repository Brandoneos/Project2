import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class BlackjackDealer {
    Stack<Card> stack = new Stack<Card>();
    public void generateDeck() {
        stack.clear();
        ArrayList<Card> cards = new ArrayList<>();
        for(int x = 1; x <= 13; x++) {
            //Hearts,Diamonds,Clubs,Spades
            Card c1 = new Card("hearts",x);
            cards.add(c1);
        }
        for(int x = 1; x <= 13; x++) {
            //Hearts,Diamonds,Clubs,Spades
            Card c1 = new Card("diamonds",x);
            cards.add(c1);
        }
        for(int x = 1; x <= 13; x++) {
            //Hearts,Diamonds,Clubs,Spades
            Card c1 = new Card("clubs",x);
            cards.add(c1);
        }
        for(int x = 1; x <= 13; x++) {
            //Hearts,Diamonds,Clubs,Spades
            Card c1 = new Card("spades",x);
            cards.add(c1);
        }
        for(int x = 0; x < 52; x++) {
            Random newRandomObject = new Random();
            int randomInt = newRandomObject.nextInt(cards.size());

            Card c2 = cards.get(randomInt);
            Card c3 = new Card(c2.suit,c2.value);
            cards.remove(randomInt);
            stack.push(c3);
        }
    }
    //            this should generate 52 cards, one for each of
//13 faces and 4 suits.
    public ArrayList<Card> dealHand() {
        Card c1 = stack.pop();
        Card c2 = stack.pop();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(c1);
        hand.add(c2);
        return hand;
    }
    //            this will return an Arraylist of two cards
//    and leave the remainder of the deck able to be drawn later.
    public Card drawOne() {
        Card c1 = stack.pop();
        return c1;
    }
    //    : this will return the next card on top of the deck
    public void shuffleDeck() {
        generateDeck();
    }
//            this will return all 52 cards to the deck and
//    shuffle their order
    public int deckSize() {
        return stack.size();
    }
//    : this will return the number of cards left in the deck.
//    After a call to shuffleDeck() this should be 52.

}
