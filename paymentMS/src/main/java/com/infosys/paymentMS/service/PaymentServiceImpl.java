package com.infosys.paymentMS.service;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.paymentMS.domain.CardInfo;
import com.infosys.paymentMS.dto.CardDto;
import com.infosys.paymentMS.exception.ServiceException;
import com.infosys.paymentMS.repository.CardInfoRepository;




@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	CardInfoRepository cardInfoRepository;

	public CardDto[] getCards(Integer userId) throws ServiceException{
		CardDto[] cards=CardDto.createDtoArray(cardInfoRepository.findByUserId(userId));
		return cards;
	}
//method to add card
	public Boolean addCard(CardDto card,Integer userId) throws ServiceException {
		CardInfo finale=CardDto.createDomain(card,userId);
		if(card.getCardNumber().matches("[0-9]{16}")) {
			if(luhnAlgorithm(card.getCardNumber())) {
				if(validateCard(card)) {
					if(cardInfoRepository.findByCardNumberAndUserId(finale.getCardNumber(),userId) == null) {
						cardInfoRepository.save(finale);
						return true;}
					else {
						throw new ServiceException("card already present");
					}
				}
				else {
					throw new ServiceException("Card Already expired");
				}
			}
			else {
				throw new ServiceException("please check the number and enter again");
			}
		}
		else {
			throw new ServiceException("not a valid number");
		}
		
		
		
	}
//method to validate whether the expiry month and date 
	public Boolean validateCard(CardDto card) {
		Calendar c=Calendar.getInstance();
		Calendar cc=(Calendar) c.clone();
		cc.set(Calendar.MONTH, card.getExpiryMonth());
		cc.set(Calendar.YEAR, card.getExpiryYear());
		if(c.before(cc)) {
			return true;
		}
		else {
			return false;
		}
		
	}
//method to validate cardnumber using luhn's algorithm
	public Boolean luhnAlgorithm(String cardnumber) {
		int sum = 0;
        boolean alternate = false;
        for (int i = cardnumber.length() - 1; i >= 0; i--)
        {
                int n = Integer.parseInt(cardnumber.substring(i, i + 1));
                if (alternate)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                alternate = !alternate;
        }
        return (sum % 10 == 0);
	}
	
//method to delete the card
	public Boolean deleteCard(CardDto card, Integer userId) throws ServiceException {
		CardInfo finale=CardDto.createDomain(card,userId);
		if(cardInfoRepository.findByCardNumberAndUserId(finale.getCardNumber(),userId) != null) {
			cardInfoRepository.delete(finale);
			return true;
		}
		else {
			throw new ServiceException("No card with following details is present");
		}
	}

}
