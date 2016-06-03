
public class Magik3 {
	public static void main(String[] args) {

		// TODO This section will interact with the read and write methods, so
		// you can save and continue your progress

		boolean trigger = false;
		Scanner sc;

		do {

			System.out.println("Enter a runNumber");
			sc = new Scanner(System.in);
			if (sc.hasNextInt()) {

				trigger = true;
				@SuppressWarnings("unused")
				Magik3dot2 m3d2 = new Magik3dot2(sc.nextInt());

			} else {
				System.out.println("That's no Moon!");
			}

		} while (trigger == false);

		sc.close();
		System.out.println("Der End!");

	}

}
