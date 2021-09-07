package com.citibank.rewards.balance.model;

import lombok.Data;

@Data
public class BalanceResponse {
	
	private StatusBlock statusBlock;
	private BalanceInfo balanceInfo;

}
