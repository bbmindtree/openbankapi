package com.mindtree.bbapis.transactions.service;

import java.util.List;

import com.mindtree.bbapis.dao.TransactionDAO;
import com.mindtree.bbapis.response.GenericResponse;
import com.mindtree.bbapis.vo.TransactionData;

public interface TransactionsInfoService {
	public TransactionData findTransactionByID(String transactionId, String accountNumber);

	public List<TransactionData> findTransactionsOf(String accountNumber);

	public GenericResponse createTransaction(TransactionDAO transaction);
}
