package com.soat.fr.creditcard.internal;
import com.soat.fr.creditcard.CreditCard;

public enum DinersClubCreditCard implements CreditCard {

	INSTANCE;
	
	@Override
	public boolean isCreditCardValid(CreditCardSplitting ccs) {
		if (ccs.getSize() == 14 && "36".equals(ccs.getDigit2()) || "38".equals(ccs.getDigit2())
				|| (ccs.getDigit3().compareTo("300") >= 0 && ccs.getDigit3().compareTo("305") <= 0)) {
			return true;
		}
		return false;
	}

}
