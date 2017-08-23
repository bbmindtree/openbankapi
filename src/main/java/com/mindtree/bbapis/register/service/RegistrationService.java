/**
 * 
 */
package com.mindtree.bbapis.register.service;

import com.mindtree.bbapis.entity.Customer;

/**
 * @author M1037565
 *
 */
public interface RegistrationService {
	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Boolean updatePassword(Customer customer);

	public Customer findByLoginId(String loginId);

	public Boolean sendPasswordChangeLink(String userId);
}
