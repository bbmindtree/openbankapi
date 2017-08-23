package com.mindtree.bbapis.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.bbapis.dao.AccountDAO;

public interface AccountDAORepository extends JpaRepository<AccountDAO, Long> {

	List<AccountDAO> findAllByUserId(String userId);

	AccountDAO findOneByAccountNumber(String accountNumber);

}
