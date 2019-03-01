package com.infosys.paymentMS.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.infosys.paymentMS.dto.CardDto;

@Entity
public class CardInfo {
	@Id
	private String cardNumber;
	private String name;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Integer userId;
	
	
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public CardInfo(String cardNumber, String name, Integer expiryMonth, Integer expiryYear, Integer userId) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.userId = userId;
	}
	public CardInfo() {
	}
	public static CardInfo createDomain(CardDto card,Integer userId) {
		return new CardInfo(card.getCardNumber(),card.getName(),card.getExpiryMonth(),card.getExpiryYear(),userId);
	}
	
	
	
	

}
