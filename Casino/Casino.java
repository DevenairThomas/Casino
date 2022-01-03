import java.util.Scanner;

public class Casino {

	private double casinoMoney;
	private double bet;
	private int checkGame;
	private double withdraw;
	
	/*
	 * constructor Casino
	 * @param
	 */
	public Casino() {

	}
	/*
	 * constructor Casino
	 * @param double( money deposited into casino account)
	 */
	public Casino(double casinoMoney) {
		this.casinoMoney = casinoMoney;
	}
	/*
	 * constructor Casino
	 * @param player object double (Casino money account)
	 */
	public Casino(Player person, double casinoMoney) {
		this.casinoMoney = casinoMoney;
	}
	/*
	 * method setCasinoMoney
	 * @param double( the money in the casino account)
	 */
	public void setCasinoMoney(double casinoMoney) {
		this.casinoMoney = casinoMoney;
	}
	/*
	 * method getCasinoMoney
	 * @returns double( the money in the casino account)
	 */
	public double getCasinoMoney() {
		return casinoMoney;
	}
	/*
	 * method showBet
	 * @params double(bet)
	 * @retruns displays if account is sufficient for bets and to retry if false
	 */
	public void showBet(double bet) {
		Scanner keyboard = new Scanner(System.in);
		boolean check = checkBet(bet);
		if (check==true){
		setBet(bet);
		}else {
			System.out.println("Insufficient funds in Casino Acccount retry"+"/n"+ "Enter new amount");
			double a = keyboard.nextDouble();
			showBet(a);
		}
	}
	/*
	 * method checkBet check to see if the account is sufficient
	 * @param double(the amount of bet
	 * @returns boolean
	 */
	public boolean checkBet(double bet) {
		boolean check = true;
		if (this.casinoMoney<bet) {
			check = false;
		}
		return check;
	}
	/*
	 * method setBet
	 * calculates casino account after the bet hass been made
	 * @param double (bet)
	 */
	public void setBet(double bet) {
		this.bet = bet;
		casinoMoney -= this.bet;
	}
	/*
	 * method getBet
	 * @returns double(bet)
	 */
	public double getBet() {
		return bet;
	}
	/*
	 * method addWinnings
	 * calculates the casino account after the outcome calculates winnings
	 * @param object outcome
	 */
	public void addWinnings(OutCome outcome) {
		casinoMoney += outcome.win;
	}
	/*
	 * method setCheckGame
	 * if game is blackjack tell outcome objec
	 * @param object blackjack
	 */
	public void setCheckGame(BlackJack jack) {
		checkGame = 2;
	}
	/*
	 * method setCheckGame
	 * if game is slots tell outcome object
	 * @param object slots
	 */
	public void setCheckGame(Slots slot) {
		checkGame = 1;
	}
	/*
	 * method getCheckGame
	 * if game is blackjack/slots tell outcome
	 * @returns int checkgame
	 */
	public int getCheckGame() {
		return checkGame;
	}
	/*
	 * method getCheck
	 * if the player has insufficient funds will true or false
	 * @returns boolean check
	 */
	public boolean getCheck(Player play) {
		return play.check;
	}
	/*
	 * method showMinMax
	 * if the player has insufficient funds in casino account will true or false less thaan 1000 or more than 20
	 * @returns boolean (true for sufficient and false for insufficient)
	 */
	public boolean showMinMax() {
		boolean check =true;
		if (casinoMoney > 1000||casinoMoney<20) {
			System.out.println("The maximum you can have is 1000$ and minimum you can have is 20");
			check = false;
		}
		return check;
	}
	/*
	 * method setWithdraw
	 * asks the player to deposit into casino account
	 * @returns display and calculates if the user can
	 */
	public void setWithdrawFromCasinoAccount(Player player) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("How much would you like to deposit into your acount?");

		double a = keyboard.nextDouble();
		if (casinoMoney >= a) {
			player.addAccount(a);
			casinoMoney -= a;
		} else {
			System.out.println("Funds are insufficient try again");
			setWithdrawFromCasinoAccount(player);
		}
	}
	/*
	 * method getWithdrawFromCasino
	 * @returns double withdraw
	 */
	public double getWithdrawFromCasinoAccount() {
		return withdraw;
	}

}
