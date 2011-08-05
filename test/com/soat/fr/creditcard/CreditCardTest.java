package com.soat.fr.creditcard;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

	Map<String, String> testNumbers = new HashMap<String, String>();

	@Before
	public void setUp() throws Exception {
		testNumbers.put("American Express", "378282246310005");
		testNumbers.put("American Express", "371449635398431");
		testNumbers.put("American Express Corporate", "378734493671000");
		testNumbers.put("Diners Club", "30569309025904");
		testNumbers.put("Diners Club", "30569309025905");
		testNumbers.put("Diners Club", "38520000023237");
		testNumbers.put("MasterCard", "5555555555554440");
		testNumbers.put("MasterCard", "5105105105105100");
		testNumbers.put("Visa", "4111111111111110");
		testNumbers.put("Visa", "4012888888881880");
		testNumbers.put("Visa", "4222222222222");
	}

	@Test
	public void testInvalidCC() {
		boolean validCC = CreditCardTool.INSTANCE.isCreditCardValid("12345");
		assertFalse(validCC);
		validCC = CreditCardTool.INSTANCE.isCreditCardValid("999999999999999");
		assertFalse(validCC);
	}

	@Test
	public void testValidCC() {
		Collection<String> testCardNumberValues = testNumbers.values();
		for (String testCardNumberValue : testCardNumberValues) {
			boolean validCC = CreditCardTool.INSTANCE.isCreditCardValid(testCardNumberValue);
			assertTrue(validCC);
		}
	}
}
