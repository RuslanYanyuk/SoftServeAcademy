package com.yanyuk.tasks;

import java.util.ArrayList;

public class TaskManager {

	private static final int DECORATION_LINE_LENGTH = 80;
	private static final String HELLO_MESSAGE = "Hello. This is collection of tasks by Ruslan Yanyuk";
	private static final String SELECT_MESSAGE = "Enter a task number from the list to run it.";
	private static ArrayList<Task> taskList = new ArrayList<Task>();

	public static void main(String[] args) {
		int inputNumber;
		String inputString;

		printHeader();
		fillAndPrintList();
		
		inputString = Task.getLineFromPrompt();
		while (Task.hasNoExitWord(inputString)) {
			try {
				inputNumber = Integer.parseInt(inputString);
				printDecorationLine();
				taskList.get(inputNumber - 1).run();
				printDecorationLine();
				System.out.println(SELECT_MESSAGE);
			} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
				System.out.println("Sorry. Error: "
						+ e.getClass().getSimpleName() + "! Try again.");
			}
			inputString = Task.getLineFromPrompt();
		}
		System.out.println("Exit.");

	}

	private static void printHeader() {
		printDecorationLine();
		System.out.println(HELLO_MESSAGE);
		System.out.println(SELECT_MESSAGE);
		Task.printExitOptionsMessage();
		printDecorationLine();
		// printDecorationLine();
	}

	private static void printTaskList() {
		int i = 1;
		for (Task t : taskList) {
			System.out.println(i + ". " + t.toString());
			i++;
		}
	}

	private static void printDecorationLine() {
		for (int i = 0; i < DECORATION_LINE_LENGTH; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	private static void fillAndPrintList() {
		taskList.add(new Task108());
		taskList.add(new Task331a());
		printTaskList();
	}

}
