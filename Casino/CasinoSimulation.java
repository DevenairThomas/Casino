import java.util.Scanner;

public class CasinoSimulation {

	public static void main(String[] args) {
		
		//creating objects for the simulation
		Scanner keyboard = new Scanner(System.in);
		OutCome outcome = new OutCome();
		Casino casino = new Casino();
		Player player = new Player();
		BlackJack jack = new BlackJack();
		Slots slots = new Slots();
		//delimiter for next int and double skipping inputs
		keyboard.useDelimiter(System.lineSeparator());
		Die die = new Die();
		//class identifiers
		boolean decideSlot;
		boolean decideJack;
		boolean checkminmax;
		boolean decideSlotX;
		boolean decideJackX;
		boolean CHECK = true;

		//display and inputs
		System.out.println("Welcome to our Casino");
		System.out.println("What is your Name?");
		String name = keyboard.next();
		player.setName(name);
		System.out.println("How much money do you have in you account " + player.getName() + "?");
		double account = keyboard.nextDouble();
		player.setAccount(account);
		System.out.println("How much money would you like to deposit in your Casino Account " + player.getName() + "?");
		double CasinoMoney = keyboard.nextDouble();
		player.showDepositCasinoMoney(CasinoMoney, player, casino);
		//check to see if the user has entered a sufficient amount
		checkminmax = casino.showMinMax();

		//if the user hasnt it will prompt withdraw or deposit
		while (checkminmax == false) {
			System.out.println("To deposit press 1, To withdraw press 2");
			String depositwithdraw = keyboard.next();
			//if the user would wish to withdraw
			if (depositwithdraw.equals("2")) {
				System.out.println("Please withdraw some money");
				player.setWithdrawMoney(casino, player);
				boolean checkminmaxredux = casino.showMinMax();
				if (checkminmaxredux == true) {
					checkminmax = true;
				} else {
					checkminmax = false;
				}
			}
			//if the user would wish to deposit
			if (depositwithdraw.equals("1")) {
				System.out.println("Please deposit more money");
				System.out.println(
						"How much money would you like to deposit in your Casino Account " + player.getName() + "?");
				double CasinoMoneyRedux = keyboard.nextDouble();
				player.showDepositCasinoMoney(CasinoMoneyRedux, player, casino);
				boolean checkminmaxredux = casino.showMinMax();
				if (checkminmaxredux == true) {
					checkminmax = true;
				} else {
					checkminmax = false;
				}
			}

		}
		//if the amount is sufficient the player can start to play
		while (checkminmax == true) {
			if (casino.getCheck(player) == false) {
				CHECK = false;
			}
			System.out.println("Your Casino Account has " + casino.getCasinoMoney());
			CHECK = true;

			//display and input for game modes
			while (CHECK == true) {
				
				System.out.println("Which Game Would you like to play? 1 for Slots and 2 for BlackJack");
				//if player chooses games
				String decide = keyboard.next();
				if (decide.equals("1")) {
					decideSlot = true;
				} else {
					decideSlot = false;
				}
				if (decide.equals("2")) {
					decideJack = true;
				} else {
					decideJack = false;
				}
				//if user decides to play the slots
				while (decideSlot == true) {
					System.out.println("How much would you like to bet");
					double bet = keyboard.nextDouble();
					casino.showBet(bet);
					casino.setCheckGame(slots);
					slots.playGame(true, slots, casino);
					outcome.setValue(casino, slots);
					outcome.calculateWin(casino, slots);
					casino.addWinnings(outcome);
					System.out.println("Your Casino Account has: " + casino.getCasinoMoney());
					decideSlotX = casino.showMinMax();
					//if user has too much funds or too little to continue
					if (decideSlotX == false) {
						System.out.println("You need to add or remove money to play again");
						decideSlot = false;
						CHECK = false;
					} 
					//display if the user would like to play some more if funds are sufficient
					else {
						System.out.println("Would you like to play again? y/n");
						String decideStringSlot = keyboard.next();
						if (decideStringSlot.equals("y") && decideSlot == true) {
							decideSlot = true;
							checkminmax = casino.showMinMax();
						} else {
							decideSlot = false;
						}
					}
				}
				//if user decides to play the blackjack
				while (decideJack == true) {
					System.out.println("How much would you like to bet");
					double bet = keyboard.nextDouble();
					casino.showBet(bet);
					casino.setCheckGame(jack);
					jack.playGame(true, die, die, casino);
					outcome.setValue(casino, jack);
					outcome.calculateWin(casino, jack);
					casino.addWinnings(outcome);
					System.out.println("Your Casino Account has: " + casino.getCasinoMoney());
					decideJackX = casino.showMinMax();
					//if user has too much funds or too little to continue
					if (decideJackX == false) {
						System.out.println("You need to add or remove money to play again");
						decideJack = false;
					} 
					//display if the user would like to play some more if funds are sufficient
					else {
						System.out.println("Would you like to play again? y/n");
						String decideStringJack = keyboard.next();
						if (decideStringJack.equals("y") && decideJack == true) {
							decideJack = true;
						} else {
							decideJack = false;
						}
					}
				}
				//after games display and to continue?
				System.out.println("Your Casino Account has: " + casino.getCasinoMoney());
				System.out.println("Would you like to continue " + player.getName() + " ? y/n");
				String check = keyboard.next();
				//checks inputs to continue
				if (check.equals("y") && casino.showMinMax() == true) {
					CHECK = true;
				} else {
					CHECK = false;
					checkminmax = false;
				}
			}
		}
		//if the user doesnt want to play asks user to withdraw from casino account into regular account
		while (CHECK == false) {
			System.out.println("Would you like to withdraw from your Account " + player.getName() + "?y/n");
			String check = keyboard.next();
			if (check.equals("y")) {
				player.setWithdrawMoney(casino, player);
				System.out.println("Your Casino Account has: " + casino.getCasinoMoney() + " and your account has "
						+ player.getAccount());
				CHECK = true;
			} 
			//if the user doesnt want to withdraw displays final numbers
			else {
				System.out.println("Your Casino Account has: " + casino.getCasinoMoney() + " and your account has "
						+ player.getAccount());
				CHECK = true;
			}
		}
	}

}
