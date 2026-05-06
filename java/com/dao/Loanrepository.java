package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Loan;
import com.entity.User;
@Repository
public interface Loanrepository extends JpaRepository<Loan,Integer> {
	List<Loan>findByUser(User user);
	List<Loan>findByStatus(String status);
	List<Loan> findAll();

}
