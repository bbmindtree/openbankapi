package com.mindtree.bbapis.entitlements.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.bbapis.dao.UserEntitlementsDAO;
import com.mindtree.bbapis.entitlements.repository.UserEntitlementsDaoRepository;

public class UserEntitlementsServiceImpl implements UserEntitlementsService {

	@Autowired
	UserEntitlementsDaoRepository userEntitlementsDaoRepo;
	@Autowired
	UserEntitlementsDAO entitlements;

	@Override
	public UserEntitlementsDAO findEntitlementsFor(String userId) {
		entitlements = userEntitlementsDaoRepo.findById(userId);
		return entitlements;
	}

	@Override
	public UserEntitlementsDAO addEntitlementsFor(String userId, UserEntitlementsDAO entitlements) {
		// TODO Auto-generated method stub
		return null;
	}

}
