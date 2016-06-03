//NOTE! Magik3dot2 is a copy of 3dot1, only cleaned up

public class Magik3dot2 {

	int printCounter = 0;
	long howManyCalc = 0;
	long shouldBe = 1;
	double inBetweenCal;
	WriteFile writeFile;
	long startTime;
	long inBetweenTime;
	long endTime;

	public Magik3dot2(int runNumber) {
		
		//shouldBe = runNumber;
		for(int i = 0; i < 9; i++){
			shouldBe = shouldBe * runNumber;
		}
		System.out.println("The number of calculations going to run: " + shouldBe);
		
		//The runNumber works the same like an arrays position. 10 is 9, 2 is 1 etc.
		System.out.println("The run number is " + runNumber);
		System.out.println("Starting calculations...");
		
		startTime = System.currentTimeMillis();

		// The nested for-loop works like a odometer. Right to left
		for (int i = 0; i < runNumber; i++) {
			for (int h = 0; h < runNumber; h++) {
				for (int g = 0; g < runNumber; g++) {
					for (int f = 0; f < runNumber; f++) {
						for (int e = 0; e < runNumber; e++) {
							for (int d = 0; d < runNumber; d++) {
								for (int c = 0; c < runNumber; c++) {
									for (int b = 0; b < runNumber; b++) {
										for (int a = 0; a < runNumber; a++) {
											
											howManyCalc++;
											
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
													
													System.out.printf("%4d %4d %4d\n", a, b, c);
													System.out.printf("%4d %4d %4d\n", d, e, f);
													System.out.printf("%4d %4d %4d\n", g, h, i);
													
													System.out.println("The sum of the table is " + sumABC);
													System.out.println();

													//writeFile = new WriteFile(temp, sumABC, runNumber);

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
			System.out.println("   OH SHIT " + i); //shows program is running
			
			if (i == 0){
				eta();
			}else {
				inBetweenCalculations();
			}
			
		}

		System.out.println();
		System.out.println("All Done!");
		System.out.println("The number of tables counted was " + printCounter);
		System.out.println("The number of total calculations done was " + howManyCalc);
		System.out.println("Time taken " + (String.format("%.2f", (double)(System.currentTimeMillis() - startTime)/1000)));
		
		//writeFile = new WriteFile(printCounter);
	}

	// Check to see if any number repeats.
	// Technically checking twice. Once for the number itself, and second for
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
	
	private void eta(){
		//TODO get the eta working at all changes, and add a time stamp
		System.out.println("How many vs should be  " + howManyCalc + "/" + shouldBe);
		System.out.println();
		
		inBetweenCalculations();
		
		inBetweenCal = 1 / (inBetweenCal/100); //turns the percent into a decimal
		System.out.println("Times needed to be multiplied " + inBetweenCal);
		
		inBetweenTime = System.currentTimeMillis() - startTime;
		System.out.println("ETA " + (String.format("%.2f", (inBetweenTime * inBetweenCal) / 1000)));
	}
	
	private void inBetweenCalculations(){
		inBetweenCal = (double)howManyCalc/shouldBe * 100; //turns the difference into a percent
		System.out.println("Percent completed: %" + (String.format("%.1f", inBetweenCal)));
	}

}
