import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class MyTest {


	//test a blackjack case, for both dealer and player and both

	@Test
	void blackjackTestPlayer() {

		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c2 = new Card("clubs",11);
		Card c3 = new Card("spades",2);
		Card c4 = new Card("spades",11);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1250.0);//currentBet + (currentBet * 1.5)


	}
	@Test
	void blackjackTestDealer() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c2 = new Card("clubs",11);
		Card c3 = new Card("spades",2);
		Card c4 = new Card("spades",11);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c1);
		theGame.bankerHand.add(c2);

		theGame.playerHand.add(c3);
		theGame.playerHand.add(c4);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"dealer");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,0);//0
	}
	@Test
	void blackjackTestBoth() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c2 = new Card("clubs",11);
		Card c3 = new Card("spades",1);
		Card c4 = new Card("spades",11);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"push");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,500.0);//currentBet
	}
	//Test a regular win for player, regular win for dealer, regular tie(no busts)
	@Test
	void regularPlayer() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",10);
		Card c2 = new Card("clubs",11);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);//currentBet + (currentBet * 1)
	}
	@Test
	void regularDealer() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",10);
		Card c2 = new Card("clubs",11);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c1);
		theGame.bankerHand.add(c2);

		theGame.playerHand.add(c3);
		theGame.playerHand.add(c4);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"dealer");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,0.0);//0
	}
	@Test
	void regularPush() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",8);
		Card c2 = new Card("clubs",9);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"push");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,500.0);//currentBet
	}
	//Test a bust for player, and bust for dealer.
	@Test
	void bustPlayer() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",10);
		Card c2 = new Card("clubs",11);
		Card c5 = new Card("clubs",5);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"dealer");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,0);//0
	}
	@Test
	void bustDealer() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",10);
		Card c2 = new Card("clubs",11);
		Card c5 = new Card("clubs",5);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();

		theGame.playerHand.add(c3);
		theGame.playerHand.add(c4);

		theGame.bankerHand.add(c1);
		theGame.bankerHand.add(c2);
		theGame.bankerHand.add(c5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);//currentBet + (currentBet * 1)
	}


	//Test Aces Player win with value of 1, Test Aces Player win with value of 11,


	@Test
	void aceTest1() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c2 = new Card("clubs",9);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);//currentBet
	}
	@Test
	void aceTest2() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c2 = new Card("clubs",10);
		Card c2_5 = new Card("clubs",11);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c2_5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}
	// Test 2 Aces Player win with value of 1 and 1, 1 and 11,
	@Test
	void aceTest3() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("clubs",10);
		Card c2_5 = new Card("clubs",8);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c1_5);
		theGame.playerHand.add(c2_5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}
	@Test
	void aceTest4() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2_5 = new Card("clubs",8);
		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c1_5);
		theGame.playerHand.add(c2_5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}
	//Test 3 and 4 aces, make sure only 1 can have value of 11
	@Test
	void aceTest5() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",8);
//		Card c5 = new Card("spades",1);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c1_5);
		theGame.playerHand.add(c2_5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}
	@Test
	void aceTest6() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",7);
		Card c5 = new Card("spades",1);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c1_5);
		theGame.playerHand.add(c2_5);
		theGame.playerHand.add(c5);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}
	//3 aces, no 11 values
	@Test
	void aceTest7() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);
		theGame.bankerHand = new ArrayList<Card>();
		theGame.playerHand = new ArrayList<Card>();
		theGame.bankerHand.add(c3);
		theGame.bankerHand.add(c4);

		theGame.playerHand.add(c1);
		theGame.playerHand.add(c2);
		theGame.playerHand.add(c1_5);
		theGame.playerHand.add(c2_5);
		theGame.playerHand.add(c5);
		theGame.playerHand.add(c6);
		String whoWon1 = theGame.gameLogic.whoWon(theGame.playerHand,theGame.bankerHand);
		assertEquals(whoWon1,"player");
		theGame.currentBet = 500.0;
		double earnings = theGame.evaluateWinnings();
		assertEquals(earnings,1000.0);
	}

	//Test all other methods

	// Test generateDeck()
	@Test
	void generateDeckTest() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();

		theGame.theDealer.generateDeck();
		Card c = theGame.theDealer.drawOne();
		//Should be no error when drawing a card as there is a deck.
		assertEquals(1,2-1);

	}
	// Test dealHand()
	@Test
	void dealHandAndDeckSize() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();

		theGame.theDealer.generateDeck();
		assertEquals(52,theGame.theDealer.deckSize());
		theGame.bankerHand = theGame.theDealer.dealHand();
		theGame.playerHand = theGame.theDealer.dealHand();

		assertEquals(48,theGame.theDealer.deckSize());
		assertNotNull(theGame.bankerHand);
		assertNotNull(theGame.bankerHand.get(0));
		assertNotNull(theGame.bankerHand.get(1));
		assertNotNull(theGame.playerHand);
		assertNotNull(theGame.playerHand.get(0));
		assertNotNull(theGame.playerHand.get(1));




	}
	// Test drawOne()
	@Test
	void drawOneTest() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();

		theGame.theDealer.generateDeck();
		assertEquals(52,theGame.theDealer.deckSize());
		theGame.bankerHand = theGame.theDealer.dealHand();
		theGame.playerHand = theGame.theDealer.dealHand();

		assertEquals(48,theGame.theDealer.deckSize());
		theGame.playerHand.add(theGame.theDealer.drawOne());
		assertEquals(47,theGame.theDealer.deckSize());
		assertNotNull(theGame.playerHand.get(2));

		theGame.playerHand.add(theGame.theDealer.drawOne());
		assertEquals(46,theGame.theDealer.deckSize());
		assertNotNull(theGame.playerHand.get(3));


	}

	// Test shuffleDeck();
	@Test
	void shuffleDeckTest() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();
		theGame.theDealer.generateDeck();
		assertEquals(52,theGame.theDealer.deckSize());
		theGame.bankerHand = theGame.theDealer.dealHand();
		Card c1 = theGame.bankerHand.get(0);
		theGame.playerHand = theGame.theDealer.dealHand();

		assertEquals(48,theGame.theDealer.deckSize());
		theGame.theDealer.shuffleDeck();
		assertEquals(52,theGame.theDealer.deckSize());
		theGame.bankerHand.clear();
		theGame.bankerHand = theGame.theDealer.dealHand();
		Card c2 = theGame.bankerHand.get(0);
		assertNotEquals(c1,c2);//assert order is not the same after shuffle


	}
	// Test handTotal(), test regular, with aces, with face cards
	@Test
	void handTotalTest1() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);

		theGame.playerHand = new ArrayList<Card>();


		theGame.playerHand.add(c3);
		theGame.playerHand.add(c4);
//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertEquals(17,theGame.gameLogic.handTotal(theGame.playerHand));


	}
	//Test with Ace
	@Test
	void handTotalTest2() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);

		theGame.playerHand = new ArrayList<Card>();


		theGame.playerHand.add(c3);//9
		theGame.playerHand.add(c1);//1
//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertEquals(10,theGame.gameLogic.handTotal(theGame.playerHand));


	}
	//Test with 2 aces
	@Test
	void handTotalTest3() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",9);
		Card c4 = new Card("spades",8);

		theGame.playerHand = new ArrayList<Card>();


		theGame.playerHand.add(c2);//1
		theGame.playerHand.add(c4);//8
		theGame.playerHand.add(c1);//1

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertEquals(10,theGame.gameLogic.handTotal(theGame.playerHand));


	}
	//Test With Face Cards
	@Test
	void handTotalTest4() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);

		theGame.playerHand = new ArrayList<Card>();


		theGame.playerHand.add(c3);//10
		theGame.playerHand.add(c4);//10
//		theGame.playerHand.add(c1);//1

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertEquals(20,theGame.gameLogic.handTotal(theGame.playerHand));


	}
	//Test With Bust
	@Test
	void handTotalTest5() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.playerHand = new ArrayList<Card>();


		theGame.playerHand.add(c3);//10
		theGame.playerHand.add(c4);//10
		theGame.playerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertEquals(30,theGame.gameLogic.handTotal(theGame.playerHand));


	}

	// Test evaluateBankerDraw()
	//16 or under
	@Test
	void evaluateBankerDrawTest1() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",6);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.bankerHand = new ArrayList<Card>();


		theGame.bankerHand.add(c6);//6
		theGame.bankerHand.add(c3);//10
//		theGame.bankerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertTrue(theGame.gameLogic.evaluateBankerDraw(theGame.bankerHand));

	}
	//15
	@Test
	void evaluateBankerDrawTest2() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",5);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.bankerHand = new ArrayList<Card>();


		theGame.bankerHand.add(c6);//5
		theGame.bankerHand.add(c3);//10
//		theGame.bankerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertTrue(theGame.gameLogic.evaluateBankerDraw(theGame.bankerHand));

	}
	//Tests 17 and up
	@Test
	void evaluateBankerDrawTest3() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",7);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.bankerHand = new ArrayList<Card>();


		theGame.bankerHand.add(c6);//7
		theGame.bankerHand.add(c3);//10
//		theGame.bankerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertFalse(theGame.gameLogic.evaluateBankerDraw(theGame.bankerHand));

	}
	//Soft 16
	@Test
	void evaluateBankerDrawTest4() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",5);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.bankerHand = new ArrayList<Card>();


		theGame.bankerHand.add(c1);//11
		theGame.bankerHand.add(c6);//5
//		theGame.bankerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertTrue(theGame.gameLogic.evaluateBankerDraw(theGame.bankerHand));

	}
	//Third Card Ace
	@Test
	void evaluateBankerDrawTest5() {
		BlackjackGame theGame = new BlackjackGame();
		theGame.theDealer = new BlackjackDealer();
		theGame.gameLogic = new BlackjackGameLogic();


		theGame.theDealer.generateDeck();

		Card c1 = new Card("clubs",1);
		Card c1_5 = new Card("hearts",1);
		Card c2 = new Card("spades",1);
		Card c2_5 = new Card("diamonds",10);
		Card c5 = new Card("spades",1);
		Card c6 = new Card("spades",4);

		Card c3 = new Card("spades",11);
		Card c4 = new Card("spades",12);
		Card c7 = new Card("spades",13);

		theGame.bankerHand = new ArrayList<Card>();


		theGame.bankerHand.add(c6);//4
		theGame.bankerHand.add(c4);//10
		theGame.bankerHand.add(c1);//1

//		theGame.bankerHand.add(c7);//10

//		theGame.playerHand.add(c1_5);
//		theGame.playerHand.add(c2_5);
//		theGame.playerHand.add(c5);
//		theGame.playerHand.add(c6);
		assertTrue(theGame.gameLogic.evaluateBankerDraw(theGame.bankerHand));

	}
	//


}
