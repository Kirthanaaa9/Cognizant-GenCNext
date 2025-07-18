package com.example.loanservice.controller;

import com.example.loanservice.model.Loan;
import com.example.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanRepository repo;

    @PostMapping("/apply")
    public Loan applyLoan(@RequestBody Loan loan) {
        loan.setStatus("pending");
        return repo.save(loan);
    }

    @GetMapping("/{userId}")
    public List<Loan> getLoans(@PathVariable String userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return repo.findAll();
    }
}
