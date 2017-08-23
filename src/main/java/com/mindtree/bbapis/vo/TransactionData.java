/**
 * 
 */
package com.mindtree.bbapis.vo;

import com.mindtree.bbapis.entity.TransactionDetails;
import com.mindtree.bbapis.entity.TransactionMetadata;

/**
 * @author M1037565
 *
 */
public class TransactionData {
	private String id;
	private Account this_account;
	private Account other_account;
	private TransactionDetails details;
	private TransactionMetadata transactionMetadata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getThis_account() {
		return this_account;
	}

	public void setThis_account(Account this_account) {
		this.this_account = this_account;
	}

	public Account getOther_account() {
		return other_account;
	}

	public void setOther_account(Account other_account) {
		this.other_account = other_account;
	}

	public TransactionDetails getDetails() {
		return details;
	}

	public void setDetails(TransactionDetails details) {
		this.details = details;
	}

	public TransactionMetadata getMetadata() {
		return transactionMetadata;
	}

	public void setMetadata(TransactionMetadata transactionMetadata) {
		this.transactionMetadata = transactionMetadata;
	}

	public TransactionData() {
		this.transactionMetadata = new TransactionMetadata();
	}
}
