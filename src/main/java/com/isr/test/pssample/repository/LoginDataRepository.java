package com.isr.test.pssample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.repository.custom.LoginDataRepositoryCustom;


@Repository("login")
public interface LoginDataRepository extends JpaRepository<Login, Long>, LoginDataRepositoryCustom{

}
