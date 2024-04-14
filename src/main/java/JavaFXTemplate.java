import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaFXTemplate extends Application {

	private Button b1,b2;
	private HashMap<Integer, String> mapOfValues;
	private TextField t1,t2;
	private VBox v1;
	private HBox h1;
	// Defined for BlackJack
	private Image backside;
	private Image Card1Dealer;
	private Image Card2Dealer;
	private Image Card1Player;
	private Image Card2Player;
	private ImageView Card1DealerIV;
	private ImageView Card2DealerIV;
	private ImageView Card1PlayerIV;
	private ImageView Card2PlayerIV;
	private TextField setStartBalance,betField;
	private Label winnerLabel;
	private Button betButton,startButton, hitButton, stayButton, playAnotherRoundButton;
	private HBox dealerHBox,playerHBox;
	private VBox wholeBox,bottomBox;
	private double startBalance1;
	private double betAmount;
	private boolean isStarted;
	private boolean roundStarted;
	private BlackjackGame game1;







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public boolean isNotZero(double number) {
		return Math.abs(number - 0.0) > 0.0000000001;
	}
	public void startRound() {
		betField.setDisable(false);
		betButton.setDisable(false);
		hitButton.setDisable(false);
		stayButton.setDisable(false);
		winnerLabel.setText("");

		game1.theDealer.shuffleDeck();
		playerHBox.getChildren().clear();
		dealerHBox.getChildren().clear();


		Card1DealerIV.setImage(backside);
		Card2DealerIV.setImage(backside);
		Card1PlayerIV.setImage(backside);
		Card2PlayerIV.setImage(backside);

		playerHBox.getChildren().add(Card1PlayerIV);
		playerHBox.getChildren().add(Card2PlayerIV);
		dealerHBox.getChildren().add(Card1DealerIV);
		dealerHBox.getChildren().add(Card2DealerIV);

		game1.playerHand.clear();
		game1.bankerHand.clear();


	}
	public void endRound(String winner, boolean didBust) {
		playAnotherRoundButton.setDisable(false);
		roundStarted = false;
		game1.totalWinnings += game1.evaluateWinnings();
		setStartBalance.setText("Balance: " + game1.totalWinnings);
		if(didBust) {
			winnerLabel.setText("BUST; Winner: " + winner + "; You win " + game1.evaluateWinnings());
		} else {
			winnerLabel.setText("WIN BY VALUE; Winner: " + winner + "; You win " + game1.evaluateWinnings());
		}
		hitButton.setDisable(true);
		stayButton.setDisable(true);




	}
	public boolean isOver21(ArrayList<Card> hand) {
		if(game1.gameLogic.handTotal(hand) > 21) {
			return true;
		} else {
			return false;
		}
	}
	public void endGame() {

		startButton.setText("START");
		betField.setDisable(true);
		betButton.setDisable(true);
		hitButton.setDisable(true);
		stayButton.setDisable(true);
		playAnotherRoundButton.setDisable(true);
		setStartBalance.setDisable(false);
		setStartBalance.clear();
		setStartBalance.setPromptText("Set Balance: ");
		startBalance1 = 0.0;

		playerHBox.getChildren().clear();
		dealerHBox.getChildren().clear();


		Card1DealerIV.setImage(backside);
		Card2DealerIV.setImage(backside);
		Card1PlayerIV.setImage(backside);
		Card2PlayerIV.setImage(backside);

		playerHBox.getChildren().add(Card1PlayerIV);
		playerHBox.getChildren().add(Card2PlayerIV);
		dealerHBox.getChildren().add(Card1DealerIV);
		dealerHBox.getChildren().add(Card2DealerIV);

		game1.playerHand.clear();
		game1.bankerHand.clear();


		isStarted = false;
		roundStarted = false;
		betField.clear();

	}
	public void addCard(Card c1,String toWho) {
		String card1file = mapOfValues.get(c1.value) + "_of_" + c1.suit + ".png";
		Image ii = new Image(card1file);
		ImageView ii2 = new ImageView(ii);
		ii2.setFitWidth(100);
		ii2.setPreserveRatio(true);
		if(toWho.equals("player")) {
			playerHBox.getChildren().add(ii2);
		} else if(toWho.equals("dealer")) {
			dealerHBox.getChildren().add(ii2);
		}


	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {

		// TODO Auto-generated method stub
		primaryStage.setTitle("Brandon Kim Project 2: BlackJack");
		BorderPane borderPane = new BorderPane();
		startBalance1 = 0.0;

		isStarted = false;
		roundStarted = false;
		mapOfValues = new HashMap<Integer, String>();
		for(int x = 2; x <= 10; x++) {
			String s1 = "" + x;
			mapOfValues.put(x,s1);
		}
		mapOfValues.put(1,"ace");
		mapOfValues.put(11,"jack");
		mapOfValues.put(12,"queen");
		mapOfValues.put(13,"king");


		//Assign the variables/Objects


		b1 = new Button("button 1");
		backside = new Image("backsideCard.jpg");
		b2 = new Button("button 2");

		startButton = new Button("START");
		//Card1Dealer = new Image("2_of_clubs.png");

		Card1Dealer = backside;
		Card2Dealer = backside;
		Card1Player = backside;
		Card2Player = backside;
		Card1DealerIV = new ImageView(Card1Dealer);
		Card2DealerIV = new ImageView(Card2Dealer);
		Card1PlayerIV = new ImageView(Card1Player);
		Card2PlayerIV = new ImageView(Card2Player);
		Card1PlayerIV.setPreserveRatio(true);
		Card2PlayerIV.setPreserveRatio(true);
		Card1DealerIV.setPreserveRatio(true);
		Card2DealerIV.setPreserveRatio(true);
		Card1DealerIV.setFitWidth(100);
		Card2DealerIV.setFitWidth(100);
		Card1PlayerIV.setFitWidth(100);
		Card2PlayerIV.setFitWidth(100);

		setStartBalance = new TextField();
		setStartBalance.setPromptText("Set Balance: ");
		setStartBalance.setMaxWidth(100);
		betField = new TextField();
		betField.setPromptText("Bet Amount: ");
		betField.setMaxWidth(100);
		betField.setDisable(true);
		betButton = new Button("Confirm Bet");
		betButton.setDisable(true);
		hitButton = new Button("HIT");
		hitButton.setDisable(true);
		stayButton = new Button("STAY");
		stayButton.setDisable(true);
		winnerLabel = new Label("");
		playAnotherRoundButton = new Button("Play Another Round");
		playAnotherRoundButton.setDisable(true);

		playerHBox = new HBox(6,Card1PlayerIV,Card2PlayerIV);
		dealerHBox = new HBox(6,Card1DealerIV,Card2DealerIV);

		bottomBox = new VBox(4,betField,betButton,hitButton,stayButton,playAnotherRoundButton);
		bottomBox.setAlignment(Pos.CENTER);

//		System.out.println(Card1DealerIV.get + " , " + Card1DealerIV.getHeight());

		//500 x 726 images
		//if Y x 100(setHeight 100) then Y = 500*100/726 -> ~68.87


		//Setup BlackJack here



		//Set the button actions here
		startButton.setOnAction(actionEvent -> {
			if(!isStarted) {

				try {
					startBalance1 = Double.parseDouble(setStartBalance.getText());
				} catch (Exception e) {
					startBalance1 = 0.0;
					return;
				}

				if(isNotZero(startBalance1)) {
					isStarted = !isStarted;
				} else {
					return;
				}
				winnerLabel.setText("");
				startButton.setText("EXIT");
				betField.setDisable(false);
				betButton.setDisable(!betButton.isDisabled());
				hitButton.setDisable(!hitButton.isDisabled());
				stayButton.setDisable(!stayButton.isDisabled());
//				playAnotherRoundButton.setDisable(!playAnotherRoundButton.isDisabled());

				setStartBalance.setDisable(!setStartBalance.isDisabled());

				setStartBalance.setText("Balance: " + startBalance1);

				//Start the game in the backend too

				game1 = new BlackjackGame();
				game1.theDealer = new BlackjackDealer();
				game1.gameLogic = new BlackjackGameLogic();
				game1.theDealer.generateDeck();
				game1.totalWinnings = startBalance1;

				//





			} else {
				winnerLabel.setText("");
				endGame();
			}

		}
		);

		betButton.setOnAction(actionEvent -> {
			if(roundStarted) {
//				System.out.println("Print this");
				return;
			}

			try {
				betAmount = Double.parseDouble(betField.getText());
			} catch (Exception e) {
				betAmount = 0.0;
				return;
			}
			if(betAmount > game1.totalWinnings) {
				return;
			}

			game1.playerHand = game1.theDealer.dealHand();
			game1.bankerHand = game1.theDealer.dealHand();
			Card c1 = game1.playerHand.get(0);
			Card c2 = game1.playerHand.get(1);

			Card dc1 = game1.bankerHand.get(0);//hidden one

			Card dc2 = game1.bankerHand.get(1);

			String card1file = mapOfValues.get(c1.value) + "_of_" + c1.suit + ".png";
			String card2file = mapOfValues.get(c2.value) + "_of_" + c2.suit + ".png";

			String dc2file = mapOfValues.get(dc2.value) + "_of_" + dc2.suit + ".png";

			Image i1 = new Image(card1file);
			Image i2 = new Image(card2file);
			Image dc2i = new Image(dc2file);

			Card1PlayerIV.setImage(i1);
			Card2PlayerIV.setImage(i2);
			Card2DealerIV.setImage(dc2i);
			game1.currentBet = betAmount;
			game1.totalWinnings -= game1.currentBet;
			setStartBalance.setText("Balance: " + game1.totalWinnings);
			roundStarted = true;
			betField.setDisable(true);
			betButton.setDisable(true);

		}
		);

		hitButton.setOnAction(actionEvent -> {
			if(roundStarted) {
				Card c = game1.theDealer.drawOne();
				game1.playerHand.add(c);
				addCard(c,"player");
				if(game1.theDealer.deckSize() <= 0) {
					game1.theDealer.shuffleDeck();
				}
				String winner;
				if(isOver21(game1.playerHand)) {
					//game over, bust
					winner = "dealer";
					endRound(winner,true);
					if(game1.totalWinnings > 0) {

					} else {


						winnerLabel.setText("BUST; Winner: " + winner + "; You win " + game1.evaluateWinnings() + " ,GAME OVER BALANCE <= 0.0");

						endGame();
					}
					return;
				}

			} else {
				return;
			}

		}
		);
		stayButton.setOnAction(actionEvent -> {
					if(roundStarted) {
						//show the dealer's first card
						Card dc1 = game1.bankerHand.get(0);//hidden one
						String dc1file = mapOfValues.get(dc1.value) + "_of_" + dc1.suit + ".png";
						Image dc1i = new Image(dc1file);
						Card1DealerIV.setImage(dc1i);
						boolean needsToDraw = game1.gameLogic.evaluateBankerDraw(game1.bankerHand);
						while(needsToDraw) {
							Card c = game1.theDealer.drawOne();
							game1.bankerHand.add(c);
							addCard(c,"dealer");
							if(game1.theDealer.deckSize() <= 0) {
								game1.theDealer.shuffleDeck();
							}
							needsToDraw = game1.gameLogic.evaluateBankerDraw(game1.bankerHand);
						}

						String winner;
						if(isOver21(game1.bankerHand)) {
							//game over, bust
							winner = "player";
							endRound(winner,true);

							if(game1.totalWinnings > 0) {

							} else {
								endGame();
							}
							return;
						} else {
							winner = game1.gameLogic.whoWon(game1.playerHand,game1.bankerHand);
							endRound(winner,false);
							if(game1.totalWinnings > 0) {

							} else {
								winnerLabel.setText("WIN BY VALUE; Winner: " + winner + "; You win " + game1.evaluateWinnings() + " ,GAME OVER BALANCE <= 0.0");
								endGame();
							}
						}
					} else {
						return;
					}

				}
		);
		playAnotherRoundButton.setOnAction(actionEvent -> {
					startRound();
					playAnotherRoundButton.setDisable(true);

				}
		);


//		b2.setOnAction(actionEvent -> {t1.clear();t2.clear();t2.setText("final string goes here");b1.setDisable(false);b1.setText("button one");});//uses lambda expression
//
//		//Make the next level structures
//

		dealerHBox.setAlignment(Pos.CENTER);
		playerHBox.setAlignment(Pos.CENTER);
		wholeBox = new VBox(30,startButton,dealerHBox,winnerLabel,setStartBalance,playerHBox,bottomBox);
		wholeBox.setAlignment(Pos.CENTER);

//		borderPane.setLeft(v1);
		borderPane.setCenter(wholeBox);
//		borderPane.setRight(t2);

		borderPane.setPadding(new Insets(10,6,10,6));
//		BorderPane.setAlignment(t2,Pos.CENTER);
		BorderPane.setAlignment(wholeBox,Pos.CENTER);
//		BorderPane.setAlignment(t1,Pos.CENTER);

		//Final Touches
		
		
		

		Scene scene = new Scene(borderPane, 800,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		//while loop to start the game.

//		while(isStarted) {
//
//		}

	}

}
