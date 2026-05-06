package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.dto.LoanRequest;
import com.service.LoanService;
import com.entity.Loan;
@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public String applyLoan(@RequestBody LoanRequest request) {

        return loanService.applyLoan(
                request.getUserId(),
                request.getAmount()
        );
    }
    @PutMapping("/update")
    public String updateLoan(@RequestParam int loanId,
                             @RequestParam String status) {

        return loanService.updateLoanStatus(loanId, status);
    }
    @GetMapping("/all")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}