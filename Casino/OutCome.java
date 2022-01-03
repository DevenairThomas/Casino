
public class OutCome {

	private int value;
	double win;
	public Slots slot;
	public BlackJack jack;

	/*
	 * constructor OutCome
	 * @param
	 */
	public OutCome() {

	}
	/*
	 * method setOutCome
	 * @param int outcome value
	 */
	public void setOutCome(int OutComeValue) {
		value = OutComeValue;
	}
	/*
	 * method getOutCome
	 * @returns the int value of outcome
	 */
	public int getOutCome() {
		return value;
	}
	/*
	 * method setValue
	 *  @param casino object, slots object
	 * @returns the int value if slots was game
	 */
	public void setValue(Casino cas, Slots slot) {
		if (cas.getCheckGame() == 1) {
			value = slot.showWin();
		}
	}
	/*
	 * method getValue
	 * @param casino object, blackjack object
	 * @returns the int value if blackjack was game
	 */
	public void setValue(Casino cas, BlackJack jack) {
		if (cas.getCheckGame() == 2) {
			value = jack.showWinType();
		}
	}
	/*
	 * method calculateWin
	 * @param casino object, blackjack object
	 * @returns double win( value of the bet *outcome value)
	 */
	public double calculateWin(Casino cas,BlackJack jack) {
		setValue(cas,jack);
		this.win = (cas.getBet() * value);
		return win;
	}
	/*
	 * method calculateWin
	 * @param casino object, slots object
	 * @returns double win( value of the bet *outcome value)
	 */
	public double calculateWin(Casino cas,Slots slot) {
		setValue(cas,slot);
		this.win = (cas.getBet() * value);
		return win;
	}


}
