package com.isr.test.pssample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isr.test.pssample.model.Account;

@Repository("account")
public interface AccountRepository extends JpaRepository<Account, String> {

	public Account findByUsername(String username);

}
