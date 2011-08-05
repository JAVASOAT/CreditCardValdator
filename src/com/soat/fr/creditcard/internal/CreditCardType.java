package com.soat.fr.creditcard.internal;

import com.soat.fr.creditcard.CreditCard;

public enum CreditCardType {

	VISA(VisaCreditCard.INSTANCE), MASTERCARD(MasterCardCreditCard.INSTANCE), AMEX(AmexCreditCard.INSTANCE), DINERS_CLUB(
			DinersClubCreditCard.INSTANCE), EN_ROUTE(EnRouteCreditCard.INSTANCE);

	private CreditCard creditCard;

	private CreditCardType(CreditCard creditCard) {
		this.setCreditCard(creditCard);
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}
