import java.util.Random;

public class Dealer {

	/*
	 * constructor Dealer
	 * @param
	 */
	public Dealer() {

	}
	/*
	 *Method checkHit, when the dealer gets a score it runs through a series of if statements with
	 *with appropriate percentage rates
	 * @returns true or false on whether the dealer should roll again
	 */
	public static boolean checkHit(int score) {
		Random rand = new Random(100);
		boolean check = false;
		int a;
		if (score < 10) {
			check = true;
		}
		if (score == 10) {
			a = rand.nextInt();
			if (a < 97) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 11) {
			a = rand.nextInt();
			if (a < 91) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 12) {
			a = rand.nextInt();
			if (a < 83) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 13) {
			a = rand.nextInt();
			if (a < 72) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 14) {
			a = rand.nextInt();
			if (a < 58) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 15) {
			a = rand.nextInt();
			if (a < 42) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 16) {
			a = rand.nextInt();
			if (a < 28) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 17) {
			a = rand.nextInt();
			if (a < 17) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 18) {
			a = rand.nextInt();
			if (a < 8) {
				check = true;
			} else {
				check = false;
			}
		}
		if (score == 19) {
			a = rand.nextInt();
			if (a < 3) {
				check = true;
			} else {
				check = false;
			}

		}
		return check;
	}

}
