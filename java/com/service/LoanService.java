package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Loanrepository;
import com.dao.UserRepository;
import com.entity.Loan;
import com.entity.User;

@Service
public class LoanService {
	@Autowired
	private Loanrepository loanRepository;
	@Autowired
	private UserRepository userRepository; 
	
	public  String applyLoan(int userId, double amount) {
		if (amount <= 0) {
	        return "Invalid loan amount";
	    }

	    Optional<User> userOpt = userRepository.findById(userId);

	    if (userOpt.isEmpty()) {
	        return "User not found";
	    }

	    User user = userOpt.get();
	    Loan loan = new Loan();
	    loan.setAmount(amount);
	    loan.setStatus("PENDING");
	    loan.setUser(user);

	    loanRepository.save(loan);

	    return "Loan application submitted successfully";
		
	}
	public String updateLoanStatus(int loanId, String status) {

	    Optional<Loan> loanOpt = loanRepository.findById(loanId);

	    if (loanOpt.isEmpty()) {
	        return "Loan not found";
	    }

	    if (!status.equalsIgnoreCase("APPROVED") &&
	        !status.equalsIgnoreCase("REJECTED")) {
	        return "Invalid status";
	    }

	    Loan loan = loanOpt.get();
	    loan.setStatus(status.toUpperCase());

	    loanRepository.save(loan);

	    return "Loan status updated successfully";
	}
	public List<Loan> getAllLoans() {
	    return loanRepository.findAll();
	}

}
