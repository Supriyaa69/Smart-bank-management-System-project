package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Account;
import com.entity.Transction;
@Repository
public interface TranscationRepository extends JpaRepository<Transction,Integer>{
	List<Transction>findBySenderAccount(Account account);
	List<Transction>findByReceiverAccount(Account account);

}
