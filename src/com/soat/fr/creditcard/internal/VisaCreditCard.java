package com.soat.fr.creditcard.internal;
import com.soat.fr.creditcard.CreditCard;

public enum VisaCreditCard implements CreditCard {

	INSTANCE; 
	
	@Override
	public boolean isCreditCardValid(CreditCardSplitting ccs) {
		if ("4".equals(ccs.getDigit1()) && (ccs.getSize() == 13 || ccs.getSize() == 16)) {
			return true;
		}
		return false;
	}

}
