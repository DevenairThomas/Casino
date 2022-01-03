import java.util.Random;

public class Slots {
	private int value;
	private int value1;
	private int value2;
	public int[] wheel = new int[3];
	int win;

	/*
	 * constructor Slots
	 * @param
	 */
	public Slots() {

	}

	/*
	 *Method getValue 
	 * @returns value
	 */
	public int getValue() {
		return value;
	}
	/*
	 *Method genWheel
	 * @generates 3 random values to simulate 3 slot wheels
	 */
	public void genWheel() {
		Random rand = new Random();
		this.value = rand.nextInt(5);
		this.value1 = rand.nextInt(5);
		this.value2 = rand.nextInt(5);
	}
	/*
	 *Method makeFruit
	 * @creates an array with eachString equivalent to the random values
	 */
	public static String makeFruit(int value) {
		String fruit;
		String[] fruitSlots = { "Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars" };
		fruit = fruitSlots[value];
		return fruit;
	}

	/*
	 *Method calculateWin
	 * @assigns the win calculations of the Slots class
	 */
	public void calculateWin() {
		if (value == value1 && value == value2) {
			win = 3;
		}
		if (value == value1 && value != value2) {
			win = 2;
		}
		if (value1 == value2 && value1 != value) {
			win = 2;
		}
		if (value2 == value && value2 != value1) {
			win = 2;
		}
		if (value != value1 && value1 != value2) {
			win = 0;
		}
	}

	/*
	 *Method setWin
	 * @param int win variable for testing
	 */
	public void setCheckWin(int win) {
		this.win =  win;
	}
	
	public int checkWin() {
		return win;
	}
	/*
	 *Method results prints out the results that will show up after the player has decided to play the game
	 * @param Casino object
	 */
	public void results(Casino cas) {
		if (win == 3) {
			System.out.println("Youve inserted "+cas.getBet());
			System.out.println("After pulling the handle a " + makeFruit(value) +" "+ makeFruit(value1) + " and a "
					+ makeFruit(value2) + " appear!" +"Congratulations, You've won the MAX!");
			System.out.println("Youve won "+(cas.getBet()*2));
		}
		if (win == 2) {
			System.out.println("Youve inserted "+cas.getBet());
			System.out.println("After pulling the handle a " + makeFruit(value)+ " "+ makeFruit(value1) + " and a "
					+ makeFruit(value2) + " appear!" + "You've won!");
			System.out.println("Youve won "+(cas.getBet()*2));
		}
		if (win==0)  {
			System.out.println("Youve inserted "+cas.getBet());
			System.out.println("After pulling the handle a " + makeFruit(value)+ " "+ makeFruit(value1) + " and a "
					+ makeFruit(value2) + " appear!" + "Try again");
			System.out.println("Youve lost "+cas.getBet());
		}
	}
	/*
	 *Method playGame runs through all the needed methods to play the game and return results
	 * @param boolean, Slots object and Casin object
	 */
	public void playGame(boolean play,Slots slot,Casino cas) {
		if(play==true) {
		slot.genWheel();
		slot.calculateWin();
		slot.results(cas);		
		}
	}
	/*
	 *Method showWin
	 * @returns the win variable
	 */
	public int showWin() {
		return win;
	}

}
