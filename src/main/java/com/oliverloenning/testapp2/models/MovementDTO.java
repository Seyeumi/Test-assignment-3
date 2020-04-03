package com.oliverloenning.testapp2.models;

import com.oliverloenning.testapp2.enums.Actions;
import com.oliverloenning.testapp2.interfaces.Account;

public class MovementDTO {
    private Account account;
    private long balance;
    private Actions action;

    public MovementDTO(Account account, long balance, Actions action) {
        this.account = account;
        this.balance = balance;
        this.action = action;
    }

    public Account getAccount() {
        return account;
    }

    public long getBalance() {
        return balance;
    }

    public Actions getAction() {
        return action;
    }
}
