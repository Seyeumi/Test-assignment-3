package com.oliverloenning.testapp2.models;



import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Customer;
import com.oliverloenning.testapp2.interfaces.Movement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountDummy implements Account {

    private Bank bank;
    private Customer customer;
    private String number;
    private long balance = 0;
    private List<Movement> withdrawals = new ArrayList<>();
    private List<Movement> deposits = new ArrayList<>();

    public AccountDummy(Bank bank, Customer customer, String number) {
        this.bank = bank;
        this.customer = customer;
        this.number = number;
    }

    @Override
    public Bank getBank() {
        return bank;
    }
    @Override
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String getNumber() {
        return number;
    }
    @Override
    public List<Movement> getWithdrawals() {
        return withdrawals;
    }
    @Override
    public List<Movement> getDeposits() {
        return deposits;
    }

    @Override
    public void setBalance(long amount) {
        this.balance = amount;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    public void transfer(long amount, Account target) {
            balance = balance - amount;
            target.setBalance(target.getBalance() + amount);
            Movement movement = new MovementDummy(LocalDateTime.now(), amount);
            withdrawals.add(movement);
            target.getDeposits().add(movement);
    }

    public void transfer(long amount, String targetNumber) {
            Account target = bank.getAccount(targetNumber);
            transfer(amount, target);
    }
}
