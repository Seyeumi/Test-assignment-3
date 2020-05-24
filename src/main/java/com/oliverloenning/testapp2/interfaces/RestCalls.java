package com.oliverloenning.testapp2.interfaces;

import com.oliverloenning.testapp2.enums.Actions;
import com.oliverloenning.testapp2.enums.Status;
import com.oliverloenning.testapp2.models.AccountDummy;
import com.oliverloenning.testapp2.models.CustomerDummy;
import com.oliverloenning.testapp2.models.MovementDTO;

import java.util.List;

public interface RestCalls {

    List<Movement> getMovementsOnAccount(String id);

    Status createAccount(AccountDummy account);

    Status createCustomer(CustomerDummy customer);

    Account getAccountFromBank(String id);

    Customer getCustomerFromBank(String cpr);

    long getAccountBalance(Account account);

    Status addOrWithdraw(MovementDTO movementDTO);

}
