package com.infosys.paymentMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.paymentMS.domain.CardInfo;



@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, String>{
	public CardInfo[] findByUserId(Integer userId);
	public CardInfo findByCardNumberAndUserId(String cardNumber, Integer userId);


}
