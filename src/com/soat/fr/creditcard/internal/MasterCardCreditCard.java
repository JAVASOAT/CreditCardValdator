package com.soat.fr.creditcard.internal;
import com.soat.fr.creditcard.CreditCard;

public enum MasterCardCreditCard implements CreditCard {

	INSTANCE;
	
	@Override
	public boolean isCreditCardValid(CreditCardSplitting ccs) {
		if (ccs.getDigit2().compareTo("51") >= 0 && ccs.getDigit2().compareTo("55") <= 0 && ccs.getSize() == 16) {
			return true;
		}
		return false;
	}

}
