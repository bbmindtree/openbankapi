package com.mindtree.bbapis.accounts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bbapis.accounts.repository.AccountDAORepository;
import com.mindtree.bbapis.dao.AccountDAO;
import com.mindtree.bbapis.dao.UserEntitlementsDAO;
import com.mindtree.bbapis.entitlements.repository.UserEntitlementsDaoRepository;
import com.mindtree.bbapis.entity.Balance;
import com.mindtree.bbapis.vo.Account;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	private AccountDAORepository accountInfoRepository;

	@Autowired
	private UserEntitlementsDaoRepository userEntitlementsDaoRepository;

	private static int count = 0;
	Account account = new Account();
	Balance balance = new Balance();
	UserEntitlementsDAO userEntitlementsDAO = new UserEntitlementsDAO();
	private List<Account> accounts = null;

	@Override
	public List<Account> findByUserId(String userId) {
		accounts = new ArrayList<Account>();
		System.out.println("@@@@@@@@@@@@@INSIDE ACC" + userId);
		List<AccountDAO> accountdao1 = accountInfoRepository.findAllByUserId(userId);
		for (AccountDAO accountdao : accountdao1) {
			account = new Account(accountdao.getType());
			account.setAccountNumber(accountdao.getAccountNumber());
			account.setBanking_id(accountdao.getBanking_id());
			account.setIBAN(accountdao.getIBAN());
			account.setId(accountdao.getId());
			account.setLabel(accountdao.getLabel());
			account.setSwift_bic(accountdao.getSwift_bic());
			balance.setAmount(accountdao.getAmount());
			balance.setCurrency(accountdao.getCurrency());
			account.setBalance(balance);
			accounts.add(account);
		}
		return accounts;
	}

	@Override
	public Account findByAccountNumber(String accountNumber) {
		AccountDAO accountdao;
		accountdao = accountInfoRepository.findOneByAccountNumber(accountNumber);
		userEntitlementsDAO = userEntitlementsDaoRepository.findById("owner");
		account.setAccountNumber(accountdao.getAccountNumber());
		account.setIBAN(accountdao.getIBAN());
		account.setId(accountdao.getId());
		account.setType(accountdao.getType());
		account.setSwift_bic(accountdao.getSwift_bic());
		balance.setAmount(accountdao.getAmount());
		balance.setCurrency(accountdao.getCurrency());
		account.setBalance(balance);
		account.setViews_available(userEntitlementsDAO);

		return account;
	}

	@Override
	public Account createAccount(AccountDAO newAccount) {
		account = new Account();
		/*
		 * int year = Calendar.getInstance().get(Calendar.YEAR); int month =
		 * Calendar.getInstance().get(Calendar.MONTH); String accountNumber;
		 * accountNumber = String.valueOf(year) + String.valueOf(month);
		 */
		// newAccount.setAccountNumber("201703070001");
		newAccount.setBanking_id("BANK00001234");
		AccountDAO accountdao = accountInfoRepository.save(newAccount);
		account = new Account(accountdao.getType());
		account.setAccountNumber(accountdao.getAccountNumber());
		account.setBanking_id(accountdao.getBanking_id());
		account.setIBAN(accountdao.getIBAN());
		account.setId(accountdao.getId());
		account.setLabel(accountdao.getLabel());
		account.setSwift_bic(accountdao.getSwift_bic());
		balance.setAmount(accountdao.getAmount());
		balance.setCurrency(accountdao.getCurrency());
		account.setBalance(balance);
		return account;
	}
}
