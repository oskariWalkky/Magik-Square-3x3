import java.util.Scanner;

public class Magik3 {
	public static void main(String[] args) {

		boolean trigger = false;
		Scanner sc;

		do {
			// Ask the user to input a valid integer, if not then repeat
			System.out.println("Enter a runNumber:");
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				System.out.println();

				// Read database and display the usable tables
				System.out.println("Which table would you like to save to?");
				ReadDriver rd = new ReadDriver();

				// Choose which table
				int arrayIndex = 0;
				String stringGetTable = "";
				// TODO you have many scanners in the choose tables, and that's ugly
				Scanner scannerGetTable = new Scanner(System.in);
				while ( arrayIndex < 1 || arrayIndex > rd.tableList.size()) {
					// User did not enter an integer
					if (!scannerGetTable.hasNextInt()) {
						System.out.println("Enter a valid integer on the list.");
						scannerGetTable = new Scanner(System.in);
						continue;
					} 
					
					arrayIndex = scannerGetTable.nextInt();
					
					// User did not enter an integer on displayed list
					if (arrayIndex > rd.tableList.size() || arrayIndex < 1) {
						System.out.println("Choose a corresponding number on the list.");
						scannerGetTable = new Scanner(System.in);
						continue;
					}
				}
				stringGetTable = rd.tableList.get(arrayIndex - 1);
				WriteDriver.setWhichTable(stringGetTable);

				// Ask the user if they would like to use this table
				System.out.println();
				System.out.println("You are going to use '" + stringGetTable + "'. Would you like to continue? (y/n)");
				Scanner scCont;
				boolean triggerM = false;
				do {
					scCont = new Scanner(System.in);
					if (scCont.hasNext()) {
						String scContToString = scCont.nextLine();

						// User entered yes, continue...
						if (scContToString.equals("y") || scContToString.equals("Y") || scContToString.equals("yes")) {
							// Execute order 66... I mean the main program
							@SuppressWarnings("unused")
							Magik3dot2 m3d2 = new Magik3dot2(sc.nextInt());
							triggerM = true;

							// User entered no, terminate...
						} else if (scContToString.equals("n") || scContToString.equals("N")
								|| scContToString.equals("no")) {
							System.out.println("Terminating program");
							triggerM = true;

						} else {
							// User entered something other than yes or no
							System.out.println("Try again, but this time follow the previous instructions");
						}
					}
				} while (triggerM == false);
				scannerGetTable.close();
				scCont.close();
				System.out.println();

				trigger = true;
			} else {
				// The user did not enter a valid integer, start again
				System.out.println("That's no Moon!");
			}
		} while (trigger == false);
		sc.close();
		System.out.println("Der End!");
	}
}
