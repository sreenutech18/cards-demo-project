package com.citibank.rewards.balance.dao;

import com.citibank.rewards.balance.exception.BusinessException;
import com.citibank.rewards.balance.exception.SystemException;
import com.citibank.rewards.balance.model.BalanceDAORequest;
import com.citibank.rewards.balance.model.BalanceDAOResponse;

public interface BalanceDAO {
	
	BalanceDAOResponse getBalance(BalanceDAORequest daoReq) throws BusinessException, SystemException;

}
