package com.yanyuk.tasks;

import java.util.Scanner;

public abstract class Task implements Runnable {

	private static final String EXIT_WORD1 = "exit";
	private static final String EXIT_WORD2 = "e";
	private static final String EXIT_WORD3 = "q";
	private static final String HELLO_MESSAGE = "This is";
	private static final String EXIT_OPTIONS_MESSAGE = "Type 'exit' or 'e' or 'q' to quit.";
	private String taskDescrition;
	
	Task(String taskDescrition) {
		this.taskDescrition = taskDescrition;
	}
	
	public static boolean hasNoExitWord(String inputString) {

		switch (inputString) {
		case EXIT_WORD1:
			return false;
		case EXIT_WORD2:
			return false;
		case EXIT_WORD3:
			return false;
		default:
			return true;
		}

	}

	public static String getLineFromPrompt() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public static boolean isNaturalNumber(Double inputNumber)
			throws NotNaturalNumberException {

		if ((inputNumber == Math.floor(inputNumber))
				&& !Double.isInfinite(inputNumber) && inputNumber >= 0)
			return true;
		else
			throw new NotNaturalNumberException();

	}
		
	public static void printExitOptionsMessage(String exitOptionsMessage) {
		System.out.println(EXIT_OPTIONS_MESSAGE);
	}
	
	public static void printExitOptionsMessage() {
		System.out.println(EXIT_OPTIONS_MESSAGE);
	}

	@Override
	public void run() {
		String inputString = "";
		
		printTaskInformation(HELLO_MESSAGE, EXIT_OPTIONS_MESSAGE);
		printExitOptionsMessage(EXIT_OPTIONS_MESSAGE);
		System.out.println(taskDescrition);
		
		while (hasNoExitWord(inputString = getLineFromPrompt())) {
			exec(inputString);
		}
	}
	
	private void printTaskInformation(String helloMessage,
			String exitOptionMessage) {

		System.out.println(helloMessage + " " + this.getClass().getSimpleName());
	}

	abstract protected void exec(String inputString);

}
