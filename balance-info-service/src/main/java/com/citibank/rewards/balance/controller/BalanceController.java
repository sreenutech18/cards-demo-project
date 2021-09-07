package com.citibank.rewards.balance.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.BalanceRequest;
import com.citibank.rewards.balance.model.BalanceResponse;
import com.citibank.rewards.balance.service.BalanceService;
import com.citibank.rewards.balance.service.impl.BalanceServiceImpl;
import com.citibank.rewards.balance.validator.BalanceValidator;

@RestController
public class BalanceController {

	// @GetMapping(value="/balance/{cardNum}")
	@RequestMapping(method = RequestMethod.GET , value = "/balance/{cardNum}", produces = {"application/json","application/xml"})
	public BalanceResponse getBalance( @PathVariable("cardNum" ) String cardNum,
			                           @RequestHeader(value="client-Id", required=true) String clientId, 
			                           @RequestHeader(value="request-id", required=true) String requestId,
			                           @RequestHeader(value="msg-ts", required=true) String msgts) throws BalanceRequestInvalidDataException, BusinessException, SystemException {

		System.out.println("Entered into controller :"+cardNum);
		// prepare the balance request
		BalanceRequest request = new BalanceRequest();
		request.setCardNum(cardNum);
		request.setClientId(clientId);
		request.setRequestId(requestId);
		request.setMsgTs(msgts);

		// validate the request

		BalanceValidator validator = new BalanceValidator();
		validator.validateRequest(request);
		
		// Call service layer 
		
		BalanceService service = new BalanceServiceImpl();
		
		BalanceResponse response  = service.getBalance(request);
		
		System.out.println("Exit from controller :"+response);
		return response;

	}

}
