package com.yanyuk.tasks;

import junit.framework.TestCase;

public class Test108 extends TestCase {

	public void testToString() {
		Task108 test = new Task108();
		if (test.toString().equals(""))
			fail("Bad string");
	}

	public void testHasNoExitWord() {
		Task108 test = new Task108();
		assertFalse(test.hasNoExitWord("exit"));
		assertFalse(test.hasNoExitWord("e"));
		assertFalse(test.hasNoExitWord("q"));
		assertTrue(test.hasNoExitWord("5"));
	}

	public void testIsNaturalNumber() {
		Task108 test = new Task108();
		assertTrue(test.isNaturalNumber(3.0));
	}

}
