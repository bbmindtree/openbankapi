package com.mindtree.bbapis.transactions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bbapis.accounts.repository.AccountDAORepository;
import com.mindtree.bbapis.accounts.services.AccountInfoService;
import com.mindtree.bbapis.dao.AccountDAO;
import com.mindtree.bbapis.dao.TransactionDAO;
import com.mindtree.bbapis.entity.Balance;
import com.mindtree.bbapis.entity.TransactionDetails;
import com.mindtree.bbapis.response.GenericFailResponse;
import com.mindtree.bbapis.response.GenericResponse;
import com.mindtree.bbapis.transactions.repository.TransactionDAORepository;
import com.mindtree.bbapis.vo.Account;
import com.mindtree.bbapis.vo.TransactionData;

@Service
public class TransactionsInfoServiceImpl implements TransactionsInfoService {

	@Autowired
	private TransactionDAORepository transactionRepo;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AccountDAORepository accountrepo;

	TransactionData transactionData = new TransactionData();
	TransactionDAO transactionDao;
	TransactionDetails transactionDetails = new TransactionDetails();
	AccountDAO accountDao;
	AccountDAO payerAccount;
	AccountDAO payeeAccount;
	Account thisAccount = new Account();
	Account otherAccount = new Account();
	Balance value = new Balance();
	Balance newBalance = new Balance();
	private List<TransactionData> transactionDataList;

	@Override
	public TransactionData findTransactionByID(String transactionId, String accountNumber) {
		transactionDao = transactionRepo.findByIdAndThisAccount(transactionId, accountNumber);
		thisAccount = accountInfoService.findByAccountNumber(transactionDao.getThisAccount());
		/* setting value and new Balance */
		value.setAmount(transactionDao.getAmount());
		value.setCurrency("USD");
		thisAccount.setViews_available(null);
		/* setting transaction details */
		transactionDetails.setValue(value);
		transactionDetails.setNew_balance(thisAccount.getBalance());
		transactionDetails.setCompletedDate(transactionDao.getCompleteDate());
		transactionDetails.setDescription(transactionDao.getDescription());
		transactionDetails.setPostedDate(transactionDao.getPostedDate());
		transactionDetails.setType(transactionDao.getType());

		/* setting this account and other Account */

		otherAccount = accountInfoService.findByAccountNumber(transactionDao.getOtherAccount());
		otherAccount.setViews_available(null);
		/* setting transaction object */
		transactionData.setId(transactionDao.getId());
		transactionData.setDetails(transactionDetails);
		transactionData.setThis_account(thisAccount);
		transactionData.setOther_account(otherAccount);

		return transactionData;
	}

	@Override
	public List<TransactionData> findTransactionsOf(String accountNumber) {
		List<TransactionDAO> transactionList = transactionRepo.findByThisAccount(accountNumber);
		transactionDataList = new ArrayList<TransactionData>();
		for (TransactionDAO transactionDao : transactionList) {
			thisAccount = accountInfoService.findByAccountNumber(transactionDao.getThisAccount());
			/* setting value and new Balance */
			value.setAmount(transactionDao.getAmount());
			value.setCurrency("USD");
			thisAccount.setViews_available(null);
			/* setting transaction details */
			transactionDetails.setValue(value);
			transactionDetails.setNew_balance(thisAccount.getBalance());
			transactionDetails.setCompletedDate(transactionDao.getCompleteDate());
			transactionDetails.setDescription(transactionDao.getDescription());
			transactionDetails.setPostedDate(transactionDao.getPostedDate());
			transactionDetails.setType(transactionDao.getType());

			/* setting this account and other Account */

			otherAccount = accountInfoService.findByAccountNumber(transactionDao.getOtherAccount());
			otherAccount.setViews_available(null);
			/* setting transaction object */
			transactionData.setId(transactionDao.getId());
			transactionData.setDetails(transactionDetails);
			transactionData.setThis_account(thisAccount);
			transactionData.setOther_account(otherAccount);
			transactionDataList.add(transactionData);
		}
		return transactionDataList;
	}

	@Override
	public GenericResponse createTransaction(TransactionDAO transaction) {

		payerAccount = accountrepo.findOneByAccountNumber(transaction.getThisAccount());
		payeeAccount = accountrepo.findOneByAccountNumber(transaction.getOtherAccount());
		if (payerAccount.getAmount() < transaction.getAmount()) {
			return new GenericFailResponse("You dont have enough Balance to make this transaction");
		}
		payerAccount.setAmount(payerAccount.getAmount() - transaction.getAmount());
		payeeAccount.setAmount(payeeAccount.getAmount() + transaction.getAmount());
		accountrepo.save(payerAccount);
		accountrepo.save(payeeAccount);
		transaction.setId(String.valueOf(UUID.randomUUID()));
		try {
			transactionRepo.save(transaction);
			return new GenericResponse(Boolean.TRUE);
		} catch (Exception e) {
			return new GenericFailResponse("Some error occured during completing this transaction");
		}
	}
}
