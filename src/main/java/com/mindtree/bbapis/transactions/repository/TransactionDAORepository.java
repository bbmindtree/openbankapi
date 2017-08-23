package com.mindtree.bbapis.transactions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.bbapis.dao.TransactionDAO;

public interface TransactionDAORepository extends JpaRepository<TransactionDAO, Long> {

	TransactionDAO findByIdAndThisAccount(String Id, String thisAccount);

	List<TransactionDAO> findByThisAccount(String thisAccountNumber);

}
