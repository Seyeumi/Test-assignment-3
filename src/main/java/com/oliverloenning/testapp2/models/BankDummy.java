package com.oliverloenning.testapp2.models;

import java.util.HashMap;
import java.util.Map;

import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Customer;

public class BankDummy implements Bank {
  private String cvr;
  private String name;

  Map<String, Customer> customers = new HashMap<>();
  Map<String, Account> accounts = new HashMap<>();

  public BankDummy(String cvr, String name) {
    this.cvr = cvr;
    this.name = name;
  }

  public String getCvr() {
    return cvr;
  }

  public String getName() {
    return name;
  }

  @Override
  public Customer getCustomer(String cpr) {
    return customers.get(cpr);
  }

  @Override
  public Account getAccount(String number) { return accounts.get(number); }

  @Override
  public Map<String, Account> getAccounts(Customer customer) {
    return accounts;
  }

  @Override
  public void addAccount(Account account) {
    accounts.put(account.getNumber(), account);
  }

  @Override
  public void addCustomer(Customer customer) {
    customers.put(customer.getCpr(), customer);
  }

}

