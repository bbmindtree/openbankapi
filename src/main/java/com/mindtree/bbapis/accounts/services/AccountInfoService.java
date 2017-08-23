package com.mindtree.bbapis.accounts.services;

import java.util.List;

import com.mindtree.bbapis.dao.AccountDAO;
import com.mindtree.bbapis.vo.Account;

public interface AccountInfoService {
	public List<Account> findByUserId(String userId);

	public Account findByAccountNumber(String accountNumber);

	public Account createAccount(AccountDAO newAccount);
}
