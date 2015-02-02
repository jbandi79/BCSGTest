package com.bcsg.bank.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankCardManager {

	public static void main(String[] args) throws Exception {

		ArrayList<BankCard> bankCardList = new ArrayList<BankCard>();
		
		BankCard bankcard1 = new BankCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		BankCard bankcard2 = new BankCard("Royal Bank of  Canada", "4519-4532-4524-2456", "Oct-2017");
		BankCard bankcard3 = new BankCard("American Express", "3786-7334-8965-345", "Dec-2018");
		
		bankCardList.add(bankcard1);
		bankCardList.add(bankcard2);
		bankCardList.add(bankcard3);
		
		Collections.sort(bankCardList, BankCard.Comparators.EXPIRYDATE);
		Collections.reverse(bankCardList);
		displayBankCards(bankCardList);
	}
	
	private static void displayBankCards(List<BankCard> p_bankCardList) {
		System.out.println("--------------------------------------------------------");
		for(BankCard bankCard: p_bankCardList) {
			System.out.printf("%-23s %-23s %-10s\n",
					bankCard.getIssuingBank(),
					bankCard.getMaskedCardNumber(),
					bankCard.getExpiryDateInMonthnameYearFormat() );
		}
		System.out.println("--------------------------------------------------------");
	}

}
