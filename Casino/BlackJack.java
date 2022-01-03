import java.util.Scanner;

public class BlackJack {

	private int PlayerScore;
	private int DealerScore;
	private boolean check;
	private boolean dealerCheck;
	private int checkWin;

	/*
	 * constructor BlackJack
	 * @param
	 */
	public BlackJack() {

	}

	/*
	 *Method getHit
	 *Creates 2 die to roll
	 * @returns the value of the dice
	 */
	public int getHit(Die die) {
		die.roll();
		return die.getValue();
	}
	/*
	 *Method setPlayerScore adds the dice to the score of the player
	 * @param object Die
	 */
	public void setPlayerScore(Die die) {
		PlayerScore += getHit(die);
	}
	/*
	 *Method getPlayerScore 
	 * @returns playerScore
	 */
	public int getPlayerScore() {
		return PlayerScore;
	}
	/*
	 *Method setDealerScore adds the dice to the score of the dealer
	 * @param object Die
	 */
	public void setDealerScore(Die die) {
		DealerScore += getHit(die);

	}
	/*
	 *Method getDealerScore 
	 * @returns DealerScore
	 */
	public int getDealerScore() {
		return DealerScore;
	}
	/*
	 *Method checkOver checks to see if the score is over 21
	 * @param int score
	 */
	public boolean checkOver(int score) {
		boolean check = false;
		if (score >= 21) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	/*
	 *Method checkWin returns check win variable to see if player won lost or draw
	 * @returns int 1,2,0
	 */
	public int checkWin() {
		if(PlayerScore>21&&DealerScore>21) {
			checkWin =1;
		}
		if (PlayerScore > 21 && DealerScore < 21) {
			checkWin = 2;
		}
		if (PlayerScore < 21 && DealerScore > 21) {
			checkWin = 0;
		}
		if (PlayerScore == 21) {
			checkWin = 2;
		}
		if (DealerScore == 21) {
			checkWin = 0;
		}
		if (PlayerScore <21) {
			if(DealerScore>21) {
			checkWin = 2;
			}
		}
		if (DealerScore <21) {
			if(PlayerScore >21) {
			checkWin = 0;
			}
		}
		if (DealerScore == PlayerScore) {
			checkWin = 1;
		}
		return checkWin;
	}
	/*
	 *Method show win displays to the user how and what you won
	 * @param object Casino
	 */
	public void showWin(Casino cas) {
		if(checkWin==1) {
			System.out.println("You recieved "+PlayerScore+" and the dealer got "+DealerScore+"/n it was a draw");
			System.out.println("Youve bet "+cas.getBet() +" and didnt win or lose anything");
		}
		if(checkWin==2) {
			System.out.println("You recieved "+PlayerScore+" and the dealer got "+DealerScore+"/n You Won!");
			System.out.println("Youve bet "+cas.getBet() +" and won "+(cas.getBet()*2));
		}
		if(checkWin==0) {
			System.out.println("You recieved "+PlayerScore+" and the dealer got "+DealerScore+"/n You Lost");
			System.out.println("Youve bet "+cas.getBet() +" and lost "+cas.getBet());
		}
	}
	/*
	 *Method playerRoll initiates the first instance of player rolling the die
	 * @param boolean checkPlayer(to play) and Die object to get values
	 */
	public void playerRoll(boolean checkPlayer, Die die) {
		if (checkPlayer == true) {
			System.out.println("Dealer rolls your dice");
			setPlayerScore(die);
			System.out.println("The Dealer rolls thier dice");
			System.out.println("Your Score is " + getPlayerScore());
		}
	}
	/*
	 *Method dealerRoll initiates the first instance of dealer rolling the die
	 * @param boolean checkPlayer(to play) and Die object to get values
	 */
	public int dealerRoll(boolean checkDealer, Die die) {
		int a = 0;
		if (checkDealer == true) {
			setDealerScore(die);
			a = getDealerScore();
		}
		return a;
	}
	
	/*
	 *Method rollAgainCheck asks the user if they want to roll the die again
	 * @returns a check value true or false
	 */
	public void rollAgainCheck() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Would you like to roll again? y/n");
		String a = keyboard.next();
		if (a.equalsIgnoreCase("y")) {
			check = true;
		} else {
			check = false;
		}
	}
	/*
	 *Method playerPlayGame initiates the entire instance of playing BlackJack
	 * @param boolean checkPlayer(to play) and Die object to get values
	 */
	public void playerPlayGame(boolean play, Die die) {
		playerRoll(play, die);
		rollAgainCheck();
		while (this.check == true) {
			playerRoll(check, die);
			rollAgainCheck();
			if(checkOver(PlayerScore)==true){
				this.check=false;
			}
		}
	}
	/*
	 *Method dealerPlayGame initiates the first instance of playing BlackJack
	 * @param boolean checkPlayer(to play) and Die object to get values
	 * @returns boolean true or false
	 */
	public boolean playDealerGame(boolean play, Die die) {
		dealerRoll(play, die);
		dealerCheck = Dealer.checkHit(DealerScore);
		return dealerCheck;
	}
	/*
	 *Method dealerPlayGame initiates the entire instance of playing BlackJack
	 * @param boolean checkPlayer(to play) and Die object to get values
	 * @returns boolean true or false
	 */
	public boolean playDealerFullGame(boolean play, Die die) {
		playDealerGame(play, die);
		while (dealerCheck == true) {
			playDealerGame(play, die);
		}
		return false;
	}
	/*
	 *Method playGame initiates the entire instance of playing BlackJack
	 * @param boolean checkPlayer(to play) and 2 Die object to get values and a Casino object to  calculate winnings
	 */
	public void playGame(boolean play, Die die,Die die1,Casino cas) {
		playerPlayGame(play,die);
		playDealerFullGame(play,die1);
		checkWin();
		showWin(cas);
	}
	/*
	 *Method showWintype
	 * @returns the win value 1,2,0
	 */
	public int showWinType() {
		return checkWin;
	}

}
