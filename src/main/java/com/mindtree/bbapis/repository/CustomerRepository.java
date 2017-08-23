/**
 * 
 */
package com.mindtree.bbapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.bbapis.entity.Customer;

/**
 * @author M1037565
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByMobile(String string);
}
