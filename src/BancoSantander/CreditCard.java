package BancoSantander;

import java.util.Calendar;
import java.util.Random;

import BancoSantander.Contas.Account;

public class CreditCard {

	private Random random = new Random();

	private String numberCard;
	private String cvv;
	private double limitCard;
	private boolean activeCreditCard;
	private Calendar expirationDate;
	
	public CreditCard() {
		this.activeCreditCard = false;
	}

	public CreditCard(String numberCard, String cvv) {
		super();
		this.activeCreditCard = true;
		this.numberCard = numberCard;
		this.cvv = cvv;
		this.limitCard = 600.0;
		this.expirationDate = Calendar.getInstance();
		this.expirationDate.add(Calendar.YEAR, 5);
	}

	public boolean isActiveCreditCard() {
		return activeCreditCard;
	}

	public void setActiveCreditCard(boolean activeCreditCard) {
		this.activeCreditCard = activeCreditCard;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public String getCvv() {
		return cvv;
	}

	public double getLimitCard() {
		return limitCard;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}
	
	public void activateCreditCard(Account account) {
		String numberCard = this.randomNumberCreditCard();
		String numberCVV = this.randomCvv();

		CreditCard creditCard = new CreditCard(numberCard, numberCVV);
		account.setCreditCard(creditCard);
	}

	private String randomNumberCreditCard() {
		String numberCreditCard = "";

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				numberCreditCard += Integer.toString(random.nextInt(10));
			}
			numberCreditCard += " ";
		}
		return numberCreditCard;
	}
	
	private String randomCvv() {
		String cvv ="";
		for (int i = 0; i < 3; i++) {
			cvv += Integer.toString(random.nextInt(10));
		}
		return cvv;
	}

	@Override
	public String toString() {
		int month = this.expirationDate.get(Calendar.MONTH) + 1;
		int year = this.expirationDate.get(Calendar.YEAR);

		String expirationDate = "" + month + "/" + year;
		return "[" + "numberCard=" + numberCard + ", cvv=" + cvv + ", limitCard="
				+ limitCard + ", activeCreditCard=" + activeCreditCard + ", expirationDate=" + expirationDate + "]";
	}

}
