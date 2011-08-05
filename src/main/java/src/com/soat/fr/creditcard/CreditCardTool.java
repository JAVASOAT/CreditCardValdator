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

import com.soat.fr.creditcard.internal.CreditCardSplitting;
import com.soat.fr.creditcard.internal.CreditCardType;

public enum CreditCardTool {

	INSTANCE;
	
	public boolean isCreditCardValid(String creditCardNumber) {
		
		CreditCardSplitting ccs;
		
		try {
			ccs = splitCreditCardNumber(creditCardNumber);
		} catch (CreditCardException e) {
			return false;
		}
		
		CreditCardType[] values = CreditCardType.values();
		for (CreditCardType creditCard : values) {
			if ( creditCard.getCreditCard().isCreditCardValid(ccs) ) {
				if ( validAlgoCreditCardNumber(creditCardNumber)){
					return true;					
				}
			}
		}
		return false;
	}
	
	private CreditCardSplitting splitCreditCardNumber(String creditCardNumber) throws CreditCardException{
		try {
			Double.valueOf(creditCardNumber).doubleValue();			
		} catch ( NumberFormatException nfe){
			throw new CreditCardException("Bad card number format");
		}
		String digit1 = creditCardNumber.substring(0, 1);
		String digit2 = creditCardNumber.substring(0, 2);
		String digit3 = creditCardNumber.substring(0, 3);
		String digit4 = creditCardNumber.substring(0, 4);
		
		CreditCardSplitting ccs = new CreditCardSplitting();
		ccs.setSize(creditCardNumber.length());		
		ccs.setDigit1(digit1);
		ccs.setDigit2(digit2);
		ccs.setDigit3(digit3);
		ccs.setDigit4(digit4);
		
		return ccs;
	}
	
	private static boolean validAlgoCreditCardNumber(String n) {
		try {
			int j = n.length();
			String[] s1 = new String[j];
			for (int i = 0; i < n.length(); i++)
				s1[i] = "" + n.charAt(i);
			int checksum = 0;
			for (int i = s1.length - 1; i >= 0; i -= 2) {
				int k = 0;
				if (i > 0) {
					k = Integer.valueOf(s1[i - 1]).intValue() * 2;
					if (k > 9) {
						String s = "" + k;
						k = Integer.valueOf(s.substring(0, 1)).intValue()
								+ Integer.valueOf(s.substring(1)).intValue();
					}
					checksum += Integer.valueOf(s1[i]).intValue() + k;
				} else
					checksum += Integer.valueOf(s1[0]).intValue();
			}
			return ((checksum % 10) == 0);
		} catch (Exception e) {
			return false;
		}
	}
}
