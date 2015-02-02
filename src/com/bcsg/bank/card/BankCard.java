package com.bcsg.bank.card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BankCard {
	private String issuingBank;
	private String cardNumber;
	private Date expiryDate;
	
	public BankCard(String p_issuingBank, String p_cardNumber, Date p_expiryDate) {
		this.issuingBank = p_issuingBank;
		this.cardNumber = p_cardNumber;
		this.expiryDate = p_expiryDate;
	}

	public BankCard(String p_issuingBank, String p_cardNumber, String p_expiryDate) throws ParseException {
		this.issuingBank = p_issuingBank;
		this.cardNumber = p_cardNumber;
		this.expiryDate = parseDateString(p_expiryDate);
	}
	
	private Date parseDateString(String p_inputDateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		Date date = sdf.parse(p_inputDateString);
		return date;
	}
	
	public String getIssuingBank() {
		return this.issuingBank;
	}
	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}

	public String getMaskedCardNumber() {
		String justNumbers = cardNumber.replace("-", "");
		String idNumbers = justNumbers.substring(0, 2);
		
		if(idNumbers.equals("45")) { // VISA
			return "45" + justNumbers.substring(2, 4) + "-xxxx-xxxx-xxxx";
		}
		else if(idNumbers.equals("37")) { // AMEX
			return "xxxx-xxxx-xxxx-" + justNumbers.substring(12, 15);
		}
		else if(idNumbers.equals("56")) { // maybe MASTERCARD
			return "56xx-xxxx-xxxx-xxxx";
		}
		else {
			return justNumbers.substring(0, 4) + "-xxxx-xxxx-xxxx";
		}
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}
	
	public String getExpiryDateInMonthnameYearFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		String date = sdf.format(this.expiryDate); 
		return date;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.issuingBank).append(",").append(this.cardNumber).append(",").append(this.expiryDate);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {
		if((obj instanceof BankCard) && 
				((BankCard)obj).getIssuingBank().equals( this.getIssuingBank() ) &&
				((BankCard)obj).getCardNumber().equals( this.getCardNumber() ) &&
				((BankCard)obj).getExpiryDate().equals( this.getExpiryDate() )
			) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.getIssuingBank().length() + this.getCardNumber().length() + this.getExpiryDate().toString().length(); 
	}
	
    public static class Comparators {

        public static Comparator<BankCard> EXPIRYDATE = new Comparator<BankCard>() {
            @Override
            public int compare(BankCard o1, BankCard o2) {
                return o1.expiryDate.compareTo(o2.expiryDate); // compareTo method of Date Class exists 
            }
        };
        public static Comparator<BankCard> CARDNUMBER = new Comparator<BankCard>() {
            @Override
            public int compare(BankCard o1, BankCard o2) {
                String str1 = o1.cardNumber.replace("-", "");
                String str2 = o2.cardNumber.replace("-", "");
                return str1.compareTo(str2); // compareTo method of String Class exists 
            }
        };
    }	
	
}

