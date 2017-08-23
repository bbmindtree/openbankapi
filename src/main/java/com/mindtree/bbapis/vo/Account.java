package com.mindtree.bbapis.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mindtree.bbapis.dao.UserEntitlementsDAO;
import com.mindtree.bbapis.entity.AccountRouting;
import com.mindtree.bbapis.entity.Balance;
import com.mindtree.bbapis.entity.Bank;
import com.mindtree.bbapis.entity.Owners;

@JsonInclude(Include.NON_NULL)

public class Account {

	private String accountNumber;
	private String Id;
	private String label;
	private String type;
	private String IBAN;
	private String swift_bic;
	private String banking_id;

	private Owners owner = new Owners();
	private Balance balance;
	private UserEntitlementsDAO views_available;
	private AccountRouting account_routing;
	private Bank bank;

	public Account() {
		this.bank = new Bank();
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Account(String type) {
		this.type = type;
		this.account_routing = new AccountRouting();
		/* this.views_available = new UserEntitlementsDAO(); */
	}

	@Override
	public String toString() {
		return "Account [Id=" + Id + ", label=" + label + ", accountNumber=" + accountNumber + ", type=" + type
				+ ", IBAN=" + IBAN + ", swift_bic=" + swift_bic + ", banking_id=" + banking_id + ", owner=" + owner
				+ ", balance=" + balance + ", views_available=" + views_available + ", account_routing="
				+ account_routing + "]";
	}

	public Owners getOwner() {
		return owner;
	}

	public void setOwner(Owners owner) {
		this.owner = owner;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public UserEntitlementsDAO getViews_available() {
		return views_available;
	}

	public void setViews_available(UserEntitlementsDAO views_available) {
		this.views_available = views_available;
	}

	public AccountRouting getAccount_routing() {
		return account_routing;
	}

	public void setAccount_routing(AccountRouting account_routing) {
		this.account_routing = account_routing;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSwift_bic() {
		return swift_bic;
	}

	public void setSwift_bic(String swift_bic) {
		this.swift_bic = swift_bic;
	}

	public String getBanking_id() {
		return banking_id;
	}

	public void setBanking_id(String banking_id) {
		this.banking_id = banking_id;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getIBAN() {
		return IBAN;
	}

}
