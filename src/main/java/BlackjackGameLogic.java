import java.util.ArrayList;

public class BlackjackGameLogic {
    public String whoWon(ArrayList<Card> playerHand1, ArrayList<Card> dealerHand) {
        //fix  whoWon() based on Ace = 1,11 and face cards not having their value = value, but = 10;
        //
        String player = "player";
        String dealer = "dealer";
        String push = "push";//Represents tie
        int h1 = handTotal(playerHand1);
        int h2 = handTotal(dealerHand);
        //checking bust
        if(h1 > 21) {
            return dealer;
        }
        if(h2 > 21) {
            return player;
        }
        //checking blackjack
        boolean playerHasBlackJack = false;
        boolean dealerHasBlackJack = false;
        Card c1 = playerHand1.get(0);
        Card c2 = playerHand1.get(1);
        int count1 = playerHand1.size();
        if(((c1.value == 1 && c2.value >= 10) || (c2.value == 1 && c1.value >= 10)) && count1 == 2) {
            playerHasBlackJack = true;
        }
        Card c3 = dealerHand.get(0);
        Card c4 = dealerHand.get(1);
        int count2 = dealerHand.size();
        if(((c3.value == 1 && c4.value >= 10) || (c4.value == 1 && c3.value >= 10)) && count2 == 2) {
            dealerHasBlackJack = true;
        }


        //whoever is higher


        if(playerHasBlackJack && dealerHasBlackJack) {
            return push;
        } else if(playerHasBlackJack) {
            return player;
        } else if(dealerHasBlackJack) {
            return dealer;
        } else {

            //Accounting for Ace
            boolean playerHasAce = false;
            boolean dealerHasAce = false;

            for(Card c : playerHand1) {
                if(c.value == 1) {
                    playerHasAce = true;
                }
            }
            for(Card c : dealerHand) {
                if(c.value == 1) {
                    dealerHasAce = true;
                }
            }
            if(playerHasAce && dealerHasAce) {
                if(h1 + 10 <= 21) {//checking player's hand
                    h1 = h1 + 10;
                }
                if(h2 + 10 <= 21) {//checking dealer's hand
                    h2 = h2 + 10;
                }

            } else if(dealerHasAce) {
                if(h2 + 10 <= 21) {
                    h2 = h2 + 10;
                }
            } else if(playerHasAce) {
                if(h1 + 10 <= 21) {
                    h1 = h1 + 10;
                }

            }

            //evaluate with best values

            if(h1 > h2) {
                return player;
            } else if(h1 < h2) {
                return dealer;
            } else {
                return push;
            }
        }

    }
    //: given two hands this should return either player or dealer or push depending on who wins.
    public int handTotal(ArrayList<Card> hand) {
        int total = 0;
        for(Card card : hand) {
            if(card.value >= 10) {
                total+=10;
            } else {
                total+=card.value;
            }

        }
        return total;
    }
    //            this should return the total value of all cards in the hand.
    public boolean evaluateBankerDraw(ArrayList<Card> hand) {
        int firstHand = 0;
        int secondHand = 0;
        firstHand = handTotal(hand);
        secondHand = firstHand;
        int numberOfAces = 0;
        for(Card c : hand) {
            if(c.value == 1) {
                numberOfAces+=1;
            }
        }
        for(int x = 0; x < numberOfAces;x++) {
            if(secondHand+10 <= 21) {
                secondHand+=10;
            }
            if(secondHand >= 17) {
                return false;
            }
        }


        if(firstHand >= 17 || secondHand >= 17) {
            return false;
        } else {
            return true;
        }


    }
//            this method
//    should return true if the dealer should draw another card, i.e. if the value is 16
//    or less
}
