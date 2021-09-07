package com.citibank.rewards.balance.exception;

public class BusinessException extends Exception{
	
	private String respCode;
	private String respMsg;

	public BusinessException(String respCode, String respMsg) {

		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

}
