package com.mindtree.bbapis.entitlements.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.bbapis.dao.UserEntitlementsDAO;

public interface UserEntitlementsDaoRepository extends JpaRepository<UserEntitlementsDAO, Long> {
	UserEntitlementsDAO findById(String Id);
}
