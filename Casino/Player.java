
public class Player {

	private String name;
	private double account;
	private double money;
	boolean check;

	/*
	 * constructor Player
	 * @param
	 */
	public Player() {

	}
	/*
	 * constructor Player
	 * @param name and the account of the player
	 */
	public Player(String name, double Paccount) {
		this.name = name;
		account = Paccount;
	}
	/*
	 * setName
	 * @param string name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * setAcount
	 * @param double account
	 */
	public void setAccount(double Paccount) {
		account = Paccount;
	}
	/*
	 * addAccount
	 * @param double money added to account
	 */
	public void addAccount(double money) {
		account+=money;
	}
	/*
	 * getName
	 * @returns string name
	 */
	public String getName() {
		return name;
	}
	/*
	 * getAccount
	 * @returns double account
	 */
	public double getAccount() {
		return account;
	}
	/*
	 * setDeposit
	 * sets the money deposited variable
	 * @param double money
	 */
	public void setDeposit(double Money) {
		money = Money;
	}
	/*
	 * getDeposit
	 * gets the money deposited variable
	 * @returns double money variable
	 */
	public double getDeposit() {
		return money;
	}
	/*
	 * depFromAccount
	 * subtracts the money from the users account
	 * @calculates double account Variable
	 */
	public void depFromAcc() {
		account -= money;
	}
	/*
	 * DepositCasinoMoney
	 * uses the checkEhough method to return the appropriate values
	 * @calculates double account Variable
	 */
	public double DepositCasinoMoney() {
		checkEnough(money);
		if(check==true) {
			return money;
		}
		else 
			return 0;
	}
	/*
	 * setWithdrawMoney
	 * if the user wishes to withdraw money from the casino account and the money is appropriate it will calculate values
	 * @param casino object and player object
	 */
	public void setWithdrawMoney(Casino cas,Player play) {
		cas.setWithdrawFromCasinoAccount(play);
		double Wmoney = cas.getWithdrawFromCasinoAccount();
		this.account+=Wmoney;
	}
	/*
	 * showDepositCasinoMoney
	 * when the user wishes to deposit money into their casino account
	 * and values are true this method will display
	 * @param double deposited money,casino object and player object
	 */
	public void showDepositCasinoMoney(double depmoney,Player player,Casino cas) {
		cas.setCasinoMoney(depmoney);
		boolean CHECK = player.checkEnough(cas.getCasinoMoney());
		if (CHECK == true) {
			setDeposit(depmoney);
			this.money = getDeposit();
			depFromAcc();
		} else {
			System.out.println("Your money is not good here, you need to have more money in your account");
			depmoney = 0;
			this.money = depmoney;
		}
	}
	/*
	 * checkEnough
	 * check to see if the player has enough money in thier account to deposit into the casino account
	 * @param double money(amount of money to be depsoited)
	 */
	public boolean checkEnough(double money) {

		if (account < money) {
			check = false;
		} else {
			check = true;
		}
		return check;
	}
}
