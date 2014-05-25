package com.yanyuk.tasks;

public class Task331a extends Task {
	
	private static final String TASK_DATE = "[20.05.2014]";
	private static final String TASK_DESCRIPTION = "Enter a natural number and I will try\n"
			+ "to find variables 'x', 'y' and 'z' which follow the expression:\n"
			+ "[your number] = x^2 + y^2 + z^2.\n"
			+ "Enter your number:";
	private int [] result = new int [3];

	Task331a() {
		super(TASK_DESCRIPTION );
	}

	@Override
	protected void exec(String inputString) {
		double inputNumber;

		try {
			inputNumber = Integer.parseInt(inputString);

			if (isNaturalNumber(inputNumber)) {
								
				result = findX((int)inputNumber);
				System.out.println(result);

			}

		} catch (IllegalArgumentException e) {
			System.out.println("Sorry. Error: " + e.getClass().getSimpleName()
					+ "! Try again.");
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + TASK_DATE;
	}
	
	private int [] findX(int number) {
		
		result[0] = (int)Math.sqrt(number);
		try {
		if(Math.pow(result[0], 2) == result[0])
			return result;
		else
			result[1] = findY(number - result[0]);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Sorry. Could not resolve the expression.");
		}
		return result;
		
	}
	
	private int findY(int numY) {
		int result;
		
		result = (int)Math.sqrt(numY);
		if(Math.pow(result, 2) == numY)
			return result;
		else
			this.result[2] = findZ(numY - result);
		return 0;
	}
	
	private int findZ(int numZ) throws ArithmeticException{
		int result;
		
		result = (int)Math.sqrt(numZ);
		if(Math.pow(result, 2) == numZ)
			return result;
		else
			throw new ArithmeticException();
	}

}
