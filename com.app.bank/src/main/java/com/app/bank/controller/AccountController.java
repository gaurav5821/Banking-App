package com.app.bank.controller;

import com.app.bank.dto.AccountDto;
import com.app.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //ADD ACOUNT REST-API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //GET ACCOUNT REST-API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    //DEPOSIT REST-API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositMoney(@PathVariable Long id, @RequestBody Map<String, Double> money){
        return new ResponseEntity<>(accountService.deposit(id, money.get("amount")), HttpStatus.OK);
    }

    //WITHDRAW REST-API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawMoney(@PathVariable Long id, @RequestBody Map<String, Double> money){
        return new ResponseEntity<>(accountService.withdraw(id, money.get("amount")), HttpStatus.OK);
    }
    //GET ALL ACCOUNT REST-API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    //DELETE ACCOUNT REST-API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
         accountService.deleteAccount(id);
         return new ResponseEntity<>("Account deleted", HttpStatus.OK);
    }
}
