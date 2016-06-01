//NOTE! Magik3dot2 is a copy of 3dot1, only cleaned up

public class Magik3dot2 {

	int[] derArray = new int[9];
	int printCounter = 0;

	public Magik3dot2(int runNumber) {

		System.out.println("The run number is " + runNumber);
		System.out.println("Starting calculations...");

		// The nested for-loop works like a speedOmeter. Right to left, or in
		// this case inner to outer.
		for (int i = 0; i < runNumber; i++) {
			for (int h = 0; h < runNumber; h++) {
				for (int g = 0; g < runNumber; g++) {
					for (int f = 0; f < runNumber; f++) {
						for (int e = 0; e < runNumber; e++) {
							for (int d = 0; d < runNumber; d++) {
								for (int c = 0; c < runNumber; c++) {
									for (int b = 0; c < runNumber; c++) {
										for (int a = 0; a < runNumber; a++) {
											derArray[0] = a;
											derArray[1] = b;
											derArray[2] = c;
											derArray[3] = d;
											derArray[4] = e;
											derArray[5] = f;
											derArray[6] = g;
											derArray[7] = h;
											derArray[8] = i;

											int[] temp = { a, b, c, d, e, f, g, h, i };

											int sumABC = a + b + c;
											int sumDEF = d + e + f;
											int sumGHI = g + h + i;
											int sumADG = a + d + g;
											int sumBEH = b + e + h;
											int sumCFI = c + f + i;
											int sumAEI = a + e + i;
											int sumGEC = g + e + c;

											if (sumABC == sumDEF && sumABC == sumGHI && sumABC == sumADG
													&& sumABC == sumBEH && sumABC == sumCFI && sumABC == sumAEI
													&& sumABC == sumGEC) {

												if (noRepeats(temp, a) && noRepeats(temp, b) && noRepeats(temp, c)
														&& noRepeats(temp, d) && noRepeats(temp, e)
														&& noRepeats(temp, f) && noRepeats(temp, g)
														&& noRepeats(temp, h) && noRepeats(temp, i)) {

													// TODO Format how the
													// numbers print out so they
													// align.
													System.out.println();
													System.out.println(a + "   " + b + "   " + c);
													System.out.println(d + "   " + e + "   " + f);
													System.out.println(g + "   " + h + "   " + i);
													System.out.println("The sum of the table is " + sumABC);
													System.out.println();

													printCounter++;

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("   OH SHIT " + i);
		}

		System.out.println();
		System.out.println("All Done!");
		System.out.println("The number of tables counted was " + printCounter);
	}

	// This method checks to see if any number repeats.
	// Technically it checks twice. Once for the number itself, and second for
	// an actual repeat.
	public boolean noRepeats(int[] argsArray, int value) {

		boolean contains = true;
		int trigger = 0;

		for (int i = 0; i < argsArray.length; i++) {
			if (argsArray[i] == value) {
				trigger++;
				if (trigger == 2) {

					contains = false;
					break;
				}
			}
		}

		return contains;
	}

}
