package com.citibank.rewards.balance.exception;

public class BalanceRequestInvalidDataException extends Exception {

	private String respCode;
	private String respMsg;

	public BalanceRequestInvalidDataException(String respCode, String respMsg) {

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
