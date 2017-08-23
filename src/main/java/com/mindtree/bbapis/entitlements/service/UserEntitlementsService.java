package com.mindtree.bbapis.entitlements.service;

import com.mindtree.bbapis.dao.UserEntitlementsDAO;

public interface UserEntitlementsService {
	UserEntitlementsDAO findEntitlementsFor(String userId);

	UserEntitlementsDAO addEntitlementsFor(String userId, UserEntitlementsDAO entitlements);
}
