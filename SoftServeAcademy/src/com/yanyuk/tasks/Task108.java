package com.yanyuk.tasks;

public class Task108 extends Task {

	private static final String TASK_DATE = "[20.05.2014]";
	private static final String TASK_DESCRIPTION = "So, if you have a natural number\n"
			+ "I can find smalleest one to your by calculating '2^r' expression.\n"
			+ "Enter your number:";

	Task108() {
		super(TASK_DESCRIPTION);
	}

	@Override
	public void run() {
		super.run();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + TASK_DATE;
	}

	@Override
	protected void exec(String inputString) {
		Double inputNumber = null;

		try {
			inputNumber = Double.parseDouble(inputString);

			if (isNaturalNumber(inputNumber)) {

				System.out.println("->"
						+ (Math.sqrt(inputNumber) + Math.ulp(inputNumber)));
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Sorry. Error: " + e.getClass().getSimpleName()
					+ "! Try again.");
		}

	}

}
