package com.mindtree.bbapis.security.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bbapis.accounts.services.AccountInfoService;
import com.mindtree.bbapis.vo.Account;

@RestController
public class LoginController {

	@Autowired
	AccountInfoService accountInfoService;

	@RequestMapping(value = "customer/login", method = RequestMethod.GET)
	public ResponseEntity Login(@RequestParam Map<String, String> requestParams) {
		String loginId = requestParams.get("loginId");
		List<Account> accounts = accountInfoService.findByUserId(loginId);
		return new ResponseEntity(accounts, HttpStatus.OK);
	}

}
