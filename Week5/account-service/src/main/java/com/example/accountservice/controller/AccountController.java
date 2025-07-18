package com.example.accountservice.controller;

import com.example.accountservice.model.Account;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository repo;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        account.setOpenedDate(java.time.LocalDate.now());
        return repo.save(account);
    }

    @GetMapping("/{userId}")
    public List<Account> getAccountsByUserId(@PathVariable String userId) {
        return repo.findByUserId(userId);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return repo.findAll();
    }
}
