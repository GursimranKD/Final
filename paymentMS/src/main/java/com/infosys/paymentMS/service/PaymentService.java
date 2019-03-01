package com.infosys.paymentMS.service;

import com.infosys.paymentMS.dto.CardDto;
import com.infosys.paymentMS.exception.ServiceException;


public interface PaymentService {
	public CardDto[] getCards(Integer userId) throws ServiceException;
	

}
