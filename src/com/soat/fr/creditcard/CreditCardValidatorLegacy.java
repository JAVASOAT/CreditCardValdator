package com.soat.fr.creditcard;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreditCardValidatorLegacy {

	// Credit Card Types
	public static final int INVALID = -1;
	public static final int MASTERCARD = 1;
	public static final int AMERICAN_EXPRESS = 2;
	public static final int VISA = 0;
	public static final int EN_ROUTE = 3;
	public static final int DINERS_CLUB = 4;

	private static final String[] cardNames = { "Visa", "Mastercard",
			"American Express", "En Route", "Diner's CLub/Carte Blanche", };

	/* Validate Credit Card number */
	public static boolean validCC(String number) {
		if ((getCardID(number)) != -1)
			return validCCNumber(number);
		return false;
	}

	private static int getCardID(String number) {
		int valid = INVALID;

		String digit1 = number.substring(0, 1);
		String digit2 = number.substring(0, 2);
		String digit3 = number.substring(0, 3);
		String digit4 = number.substring(0, 4);

		if (isNumber(number)) {
			/*
			 * ----* VISA prefix=4* if so then length=13 or 16
			 */
			if (digit1.equals("4")) {
				if (number.length() == 13 || number.length() == 16)
					valid = VISA;
			}
			/*
			 * ----------* MASTERCARD prefix= 51 ... 55* and the String length=
			 * 16
			 */
			else if (digit2.compareTo("51") >= 0 && digit2.compareTo("55") <= 0) {
				if (number.length() == 16)
					valid = MASTERCARD;
			}
			/*
			 * ----* AMEX prefix=34 or 37* and String length=15
			 */
			else if (digit2.equals("34") || digit2.equals("37")) {
				if (number.length() == 15)
					valid = AMERICAN_EXPRESS;
			}
			/*
			 * -----* ENROU prefix=2014 or 2149* String length=15
			 */
			else if (digit4.equals("2014") || digit4.equals("2149")) {
				if (number.length() == 15)
					valid = EN_ROUTE;
			}
			/*
			 * -----* DCLUB prefix=300 ... 305 or 36 or 38* and String length=14
			 */
			else if (digit2.equals("36")
					|| digit2.equals("38")
					|| (digit3.compareTo("300") >= 0 && digit3.compareTo("305") <= 0)) {
				if (number.length() == 14)
					valid = DINERS_CLUB;
			}
		}
		return valid;

		/*
		 * ----* DISCOVER card prefix = 60* string Length = 16* left as an
		 * exercise ...
		 */

	}

	private static boolean isNumber(String n) {
		try {
			Double.valueOf(n).doubleValue();
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String getCardName(int id) {
		return (id > -1 && id < cardNames.length ? cardNames[id] : "");
	}

	private static boolean validCCNumber(String n) {
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
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) throws Exception {
		String aCard = "";

		if (args.length > 0)
			aCard = args[0];
		else {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Enter the Card number : ");
			aCard = input.readLine();
		}
		if (getCardID(aCard) > -1) {
			System.out.println("This is a Valid Credit Card");
			System.out.println("and the Card Type is "
					+ getCardName(getCardID(aCard)));
			System.out.println("The card number " + aCard + " is "
					+ (validCC(aCard) ? " good." : " bad."));
		} else
			System.out.println("Sorry this is an invalid Credit Card Number");
	}
}