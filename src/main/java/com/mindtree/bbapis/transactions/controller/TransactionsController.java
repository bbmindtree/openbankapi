package com.mindtree.bbapis.transactions.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bbapis.dao.TransactionDAO;
import com.mindtree.bbapis.response.GenericResponse;
import com.mindtree.bbapis.transactions.service.TransactionsInfoService;
import com.mindtree.bbapis.vo.TransactionData;

@RestController
public class TransactionsController {

	@Autowired
	TransactionsInfoService transactioInfoService;

	@RequestMapping(value = "/accounts/transactions/details", method = RequestMethod.GET)
	public ResponseEntity getTransactionByID(@RequestParam Map<String, String> requestParams) {
		String accountNumber = requestParams.get("accountNumber");
		String transactionId = requestParams.get("transactionId");
		TransactionData transactionData = transactioInfoService.findTransactionByID(transactionId, accountNumber);
		return new ResponseEntity(transactionData, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/transactions", method = RequestMethod.GET)
	public ResponseEntity getTransactions(@RequestParam(value = "accountNumber") String accountNumber) {
		List<TransactionData> transactionDataList = transactioInfoService.findTransactionsOf(accountNumber);
		return new ResponseEntity(transactionDataList, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/transaction/create", method = RequestMethod.POST)
	public GenericResponse addTransaction(@RequestBody TransactionDAO transaction) {

		return transactioInfoService.createTransaction(transaction);
	}
}
