package com.infosys.paymentMS.dto;

import com.infosys.paymentMS.domain.CardInfo;

public class CardDto {
	
	private String cardNumber;
	private String name;
	private Integer expiryMonth;
	private Integer expiryYear;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public Integer getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	public CardDto(String cardNumber, String name, Integer expiryMonth, Integer expiryYear) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		
	}
	public CardDto() {
		
	}
	public static CardDto[] createDtoArray(CardInfo[] cardInfo) {
		CardDto[] x=new CardDto[cardInfo.length];
		for(int i=0;i<cardInfo.length;i++) {
			x[i]=new CardDto(cardInfo[i].getCardNumber(),cardInfo[i].getName(),cardInfo[i].getExpiryMonth(),cardInfo[i].getExpiryYear());
		}
		return x;
	}
	public static CardInfo createDomain(CardDto card,Integer userId) {
		return CardInfo.createDomain(card,userId);
	}
	

}
