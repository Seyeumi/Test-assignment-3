package com.oliverloenning.testapp2.interfaces;

import java.util.List;

public interface Account {

    Bank getBank();

    Customer getCustomer();

    String getNumber();

    long getBalance();

    List<Movement> getWithdrawals();

    List<Movement> getDeposits();

    void setBalance(long amount);

    void transfer(long amount, Account target);

    void transfer(long amount, String targetNumber);
}
