import java.util.Random;

/**
 * The Die class simulates a six-sided die.
 */

public class Die {
	private int sides = 6; // Number of sides
	private int value1; // The die's value
	private int value2;// die 2 value

	/**
	 * The constructor performs an initial roll of the die.
	 * 
	 * @param numSides The number of sides for this die.
	 */

	public Die() {
		roll();
	}

	/**
	 * The roll method simulates the rolling of 2 die
	 */

	public void roll() {
		// Create a Random object.
		Random rand = new Random();

		// Get a random value for the die.
		value1 = rand.nextInt(sides) + 1;
		value2 = rand.nextInt(sides) + 1;
	}

	/**
	 * getSides method
	 * 
	 * @return The number of sides for this die.
	 */

	public int getSides() {
		return sides;
	}

	/**
	 * getValue method
	 * 
	 * @return The value of the die.
	 */
	public int getValue() {
		return value1 + value2;
	}
}