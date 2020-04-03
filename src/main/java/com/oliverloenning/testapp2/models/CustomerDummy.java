package com.oliverloenning.testapp2.models;

import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Customer;
import com.oliverloenning.testapp2.interfaces.Movement;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDummy implements Customer {
  private String cpr;
  private String name;
  private Bank bank;
  Map<String, Account> accounts = new HashMap<>();

  public CustomerDummy(String cpr, String name, Bank bank) {
    this.cpr = cpr;
    this.name = name;
    this.bank = bank;
  }

  @Override
  public String getCpr() {
    return cpr;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Bank getBank() {
    return bank;
  }

  @Override
  public Map<String, Account> getAccounts() {
    return accounts;
  }

  @Override
  public List<Movement> getListOfWithdrawal(int number) {
    return accounts.get(number).getWithdrawals();
  }

  @Override
  public List<Movement> getListOfDeposits(int number) {
    return accounts.get(number).getDeposits();
  }

  @Override
  public void transfer(int amount, Account account, Account targetAccount) {
    Account fromAccount = accounts.get(account.getNumber());
    Account toAccount = bank.getAccount(targetAccount.getNumber());
    fromAccount.setBalance(fromAccount.getBalance() - amount);
    toAccount.setBalance(toAccount.getBalance() + amount);
    Movement movement = new MovementDummy(LocalDateTime.now(), amount);
    fromAccount.getWithdrawals().add(movement);
    toAccount.getDeposits().add(movement);
  }
}
