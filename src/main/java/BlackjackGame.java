import java.util.ArrayList;

public class BlackjackGame {
    ArrayList<Card> playerHand;
    ArrayList<Card> bankerHand;
    BlackjackDealer theDealer;
    BlackjackGameLogic gameLogic;
    double currentBet;
    //        : the amount currently bet from the user
    double totalWinnings;
    //    the total amount of value that the user has.
    public double evaluateWinnings() {
        //should only calculate bets and winnings
        double amountWonOrLost = 0.0;
        String winner = gameLogic.whoWon(playerHand,bankerHand);
        //has blackjack?
        boolean playerHasBlackJack = false;
        boolean dealerHasBlackJack = false;
        Card c1 = playerHand.get(0);
        Card c2 = playerHand.get(1);
        int count1 = playerHand.size();
        if(((c1.value == 1 && c2.value >= 10) || (c2.value == 1 && c1.value >= 10)) && count1 == 2) {
            playerHasBlackJack = true;
        }
        Card c3 = bankerHand.get(0);
        Card c4 = bankerHand.get(1);
        int count2 = bankerHand.size();
        if(((c3.value == 1 && c4.value >= 10) || (c4.value == 1 && c3.value >= 10)) && count2 == 2) {
            dealerHasBlackJack = true;
        }

        //
        if(winner.equals("player")) {
            if(playerHasBlackJack) {
                amountWonOrLost = (currentBet * 1.5) + (currentBet);
            } else {
                amountWonOrLost = currentBet + currentBet;
            }

        } else if(winner.equals("dealer")) {
            amountWonOrLost = 0;
        } else if(winner.equals("push")) {
            amountWonOrLost = currentBet;
        } else {
            System.out.println("Error");
        }


        return amountWonOrLost;

    }
//    : This method will determine if the user
//    won or lost their bet and return the amount won or lost based on the value in
//    currentBet.
}
