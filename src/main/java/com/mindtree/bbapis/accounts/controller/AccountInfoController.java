package com.mindtree.bbapis.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bbapis.accounts.services.AccountInfoService;
import com.mindtree.bbapis.dao.AccountDAO;
import com.mindtree.bbapis.vo.Account;

@RestController
public class AccountInfoController {

	@Autowired
	AccountInfoService accountInfoService;

	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public ResponseEntity getAccounts(@RequestParam(value = "userId") String userId) {
		System.out.println("@@@@@@@@@@@@@" + userId);
		List<Account> accounts = accountInfoService.findByUserId(userId);
		return new ResponseEntity(accounts, HttpStatus.OK);
	}

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public ResponseEntity getOneAccount(@RequestParam(value = "accountNumber") String accountNumber) {
		Account account = accountInfoService.findByAccountNumber(accountNumber);
		return new ResponseEntity(account, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/create", method = RequestMethod.POST)
	public ResponseEntity createAccount(@RequestBody AccountDAO newAccount) {
		Account account = accountInfoService.createAccount(newAccount);
		return new ResponseEntity(account, HttpStatus.OK);
	}
}
