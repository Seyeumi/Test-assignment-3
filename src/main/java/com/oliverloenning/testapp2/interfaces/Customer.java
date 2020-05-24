package com.oliverloenning.testapp2.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Customer {
    public void transfer(int amount, Account account, Account targetAccount);
    public String getCpr();
    public String getName();
    public Bank getBank();
    public Map<String, Account> getAccounts();

    public List<Movement> getListOfWithdrawal(int number);
    public List<Movement> getListOfDeposits(int number);
}

