package com.oliverloenning.testapp2.rest;

import com.oliverloenning.testapp2.enums.Actions;
import com.oliverloenning.testapp2.enums.Status;
import com.oliverloenning.testapp2.interfaces.*;
import com.oliverloenning.testapp2.models.AccountDummy;
import com.oliverloenning.testapp2.models.BankDummy;
import com.oliverloenning.testapp2.models.CustomerDummy;
import com.oliverloenning.testapp2.models.MovementDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController("/rest")
public class Contract implements RestCalls {

    public static Bank bank = new BankDummy("abcdef", "Glorious Bank");

    @GetMapping("/movement/{id}")
    @Override
    public List<Movement> getMovementsOnAccount(@PathVariable("id") String id) {
        List<Movement> result = null;
        try {
            Account acc = bank.getAccount(id);
            List<Movement> withdrawals = acc.getWithdrawals();
            List<Movement> deposits = acc.getDeposits();
            result = Stream.concat(withdrawals.stream(), deposits.stream())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("No account with that id exists.");
        }
        return result;
    }

    @PostMapping("/account")
    @Override
    public Status createAccount(@RequestBody AccountDummy account) {
        if (account == null) {
            return Status.FAILED;
        }
        if (bank.getAccount(account.getNumber()) != null) {
            return Status.FAILED;
        }
        bank.addAccount(account);
        return Status.SUCCESS;
    }

    @PostMapping("/customer")
    @Override
    public Status createCustomer(@RequestBody CustomerDummy customer) {
        if (customer == null) {
            return Status.FAILED;
        }
        if (bank.getCustomer(customer.getCpr()) != null) {
            return Status.FAILED;
        }
        bank.addCustomer(customer);
        return Status.SUCCESS;
    }

    @GetMapping("/account/{id}")
    @Override
    public Account getAccountFromBank(@PathVariable("id") String id) {
        return bank.getAccount(id);
    }

    @GetMapping("/customer/{cpr}")
    @Override
    public Customer getCustomerFromBank(@PathVariable("cpr") String cpr) {
        return bank.getCustomer(cpr);
    }

    @GetMapping("/balance")
    @Override
    public long getAccountBalance(@RequestBody Account account) {
        return account.getBalance();
    }

    @PostMapping("/movement")
    @Override
    public Status addOrWithdraw(@RequestBody MovementDTO movementDTO) {
        Account accountInBank = bank.getAccount(movementDTO.getAccount().getNumber());
        switch (movementDTO.getAction()) {
            case DEPOSIT:
                accountInBank.setBalance(accountInBank.getBalance() + movementDTO.getBalance());
                return Status.SUCCESS;
            case WITHDRAW:
                if (accountInBank.getBalance() < movementDTO.getBalance()) {
                    return Status.FAILED;
                } else {
                    accountInBank.setBalance(accountInBank.getBalance() - movementDTO.getBalance());
                    return Status.SUCCESS;
                }
            default:
                return null;
        }
    }
}
