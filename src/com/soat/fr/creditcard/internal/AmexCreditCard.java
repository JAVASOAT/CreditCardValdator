package com.soat.fr.creditcard.internal;

import com.soat.fr.creditcard.CreditCard;

public enum AmexCreditCard implements CreditCard {

	INSTANCE;
	
	@Override
	public boolean isCreditCardValid(CreditCardSplitting ccs) {
		if (ccs.getDigit2().equals("34") || ccs.getDigit2().equals("37") && ccs.getSize() == 15) {
			return true;
		}
		return false;
	}

}
