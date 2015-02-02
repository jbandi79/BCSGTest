package com.bcsg.bank.card.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.bcsg.bank.card.BankCard;

public class BankCardManagerTest {

	@Test
	public void test() throws ParseException {
		ArrayList<BankCard> bankCardList1 = new ArrayList<BankCard>();

		BankCard bankcard1 = new BankCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		BankCard bankcard2 = new BankCard("Royal Bank of  Canada", "4519-4532-4524-2456", "Oct-2017");
		BankCard bankcard3 = new BankCard("American Express", "3786-7334-8965-345", "Dec-2018");

		bankCardList1.add(bankcard1);
		bankCardList1.add(bankcard2);
		bankCardList1.add(bankcard3);

		Collections.sort(bankCardList1, BankCard.Comparators.EXPIRYDATE);
		Collections.reverse(bankCardList1);
		
		ArrayList<BankCard> bankCardList2 = new ArrayList<BankCard>();

		BankCard bankcard4 = new BankCard("American Express", "3786-7334-8965-345", "Dec-2018");
		BankCard bankcard5 = new BankCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		BankCard bankcard6 = new BankCard("Royal Bank of  Canada", "4519-4532-4524-2456", "Oct-2017");
		
		bankCardList2.add(bankcard4);
		bankCardList2.add(bankcard5);
		bankCardList2.add(bankcard6);
		
		assertEquals(bankCardList1, bankCardList2);		
		
	}

}
