package com.app.bank.mapper;

import com.app.bank.dto.AccountDto;
import com.app.bank.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getName(), accountDto.getBalance());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(account.getId(), account.getName(), account.getBalance());
        return accountDto;
    }
}
