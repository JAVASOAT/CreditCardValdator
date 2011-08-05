/*
 * Copyright (c) 2011 So@t 
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.soat.fr.creditcard;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

	Map<String, String> testValidNumbers = new HashMap<String, String>();
        Map<String, String> testInvalidNumbers = new HashMap<String, String>();

	@Before
	public void setUp() throws Exception {
		testValidNumbers.put("American Express", "371449635398431");
		testValidNumbers.put("American Express Corporate", "378734493671000");
		testValidNumbers.put("Diners Club", "38520000023237");
		testValidNumbers.put("MasterCard", "5105105105105100");
		testValidNumbers.put("Visa", "4222222222222");

                testInvalidNumbers.put("American Express", "371449635398432");
                testInvalidNumbers.put("American Express Corporate", "378734493671001");
                testInvalidNumbers.put("Diners Club", "38520000023238");
                testInvalidNumbers.put("MasterCard", "5105105105105101");
                testInvalidNumbers.put("Visa", "4222222222223");
	}

	@Test
	public void testInvalidCC() {
		Collection<String> testCardNumberValues = testInvalidNumbers.values();
                for (String testCardNumberValue : testCardNumberValues) {
                      boolean validCC = CreditCardTool.INSTANCE.isCreditCardValid(testCardNumberValue);
			System.out.println(">>> "+validCC);
                      assertFalse(validCC);
                }
	}

	@Test
	public void testValidCC() {
		Collection<String> testCardNumberValues = testValidNumbers.values();
		for (String testCardNumberValue : testCardNumberValues) {
			boolean validCC = CreditCardTool.INSTANCE.isCreditCardValid(testCardNumberValue);
			System.out.println(">>> "+validCC);
			assertTrue(validCC);
		}
	}
}
