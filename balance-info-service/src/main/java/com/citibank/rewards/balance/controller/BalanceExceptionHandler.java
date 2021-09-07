package com.citibank.rewards.balance.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citibank.rewards.balance.exception.BalanceRequestInvalidDataException;
import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.ErrorResponse;
import com.citibank.rewards.balance.model.StatusBlock;

@RestControllerAdvice
public class BalanceExceptionHandler {

	//org.springframework.web.bind.ServletRequestBindingException
	//BalanceRequestInvalidDataException
	
	@ExceptionHandler(value = BalanceRequestInvalidDataException.class)
	public ErrorResponse handleRequestInvalidException(BalanceRequestInvalidDataException exception) {

		ErrorResponse response = buildErrorResp(exception.getRespCode(), exception.getRespMsg());

		return response;
	}

	@ExceptionHandler(value = BusinessException.class)
	public ErrorResponse handleDataErrors(BusinessException exception) {

		ErrorResponse response = buildErrorResp(exception.getRespCode(), exception.getRespMsg());

		return response;
	}

	@ExceptionHandler(value = SystemException.class)
	public ErrorResponse handleSystemErrors(SystemException exception) {

		ErrorResponse response = buildErrorResp(exception.getRespCode(), exception.getRespMsg());

		return response;
	}

	@ExceptionHandler(value = Exception.class)
	public ErrorResponse handleGenericErrors(Exception exception) {

		exception.printStackTrace();
		
		ErrorResponse response = buildErrorResp("22222", "unknown error from database:" + exception.getMessage());
		
	    return response;
	}

	private ErrorResponse buildErrorResp(String respCode, String respMsg) {
		ErrorResponse response = new ErrorResponse();
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);
		response.setStatusBlock(statusBlock);
		return response;
	}

}
