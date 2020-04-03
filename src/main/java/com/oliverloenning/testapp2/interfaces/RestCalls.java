package com.oliverloenning.testapp2.interfaces;

import com.oliverloenning.testapp2.enums.Actions;
import com.oliverloenning.testapp2.enums.Status;
import com.oliverloenning.testapp2.models.MovementDTO;

import java.util.List;

public interface RestCalls {

    List<Movement> getMovementsOnAccount(String id);

    Status createAccount(Account account);

    Status createCustomer(Customer customer);

    Account getAccountFromBank(String id);

    Customer getCustomerFromBank(String cpr);

    long getAccountBalance(Account account);

    Status addOrWithdraw(MovementDTO movementDTO);

}
