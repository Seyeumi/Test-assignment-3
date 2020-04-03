package com.oliverloenning.testapp2.interfaces;

import java.util.Map;

public interface Bank {
  String getCvr();
  String getName();
  Customer getCustomer(String cpr);
  Account getAccount(String number);
  Map<String, Account> getAccounts(Customer customer);

  void addAccount(Account account);

  void addCustomer(Customer customer);
}
