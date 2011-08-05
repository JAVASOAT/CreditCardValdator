package com.soat.fr.creditcard.internal;
import com.soat.fr.creditcard.CreditCard;

public enum EnRouteCreditCard implements CreditCard {

	INSTANCE;
	
	@Override
	public boolean isCreditCardValid(CreditCardSplitting ccs) {
		if (ccs.getDigit4().equals("2014") || ccs.getDigit4().equals("2149") && ccs.getSize() == 15) {
			return true;
		}
		return false;
	}

}
