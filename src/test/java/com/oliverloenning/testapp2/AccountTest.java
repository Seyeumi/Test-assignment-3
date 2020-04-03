package com.oliverloenning.testapp2;

import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Customer;
import com.oliverloenning.testapp2.models.AccountDummy;
import com.oliverloenning.testapp2.models.BankDummy;
import com.oliverloenning.testapp2.models.CustomerDummy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class AccountTest {

    @Test
    public void testCreateAccount() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account account = new AccountDummy(bank, customer, "12345");
        assertNotNull(account);
    }

    @Test
    public void testCreateAccountWithBank() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account account = new AccountDummy(bank, customer, "12345");
        assertEquals(bank, account.getBank());
        assertNotNull(account.getBank());
    }

    @Test
    public void testCreateAccountWithNumber() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        String number = "12345";
        Account account = new AccountDummy(bank, customer, "12345");
        assertEquals(number, account.getNumber());
    }

    @Test
    public void testCreateAccountWithZeroBalance() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account account = new AccountDummy(bank, customer, "12345");
        assertEquals(0L, account.getBalance());
    }

    @Test
    public void testTransferPositiveAmount() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account source = new AccountDummy(bank, customer, "12345");
        Account target = new AccountDummy(bank, customer, "12346");
        source.transfer(10000, target);
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
    }

    @Test
    public void testTransferPositiveAmountUsingNumber() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account source = new AccountDummy(bank, customer, "12345");
        Account target = new AccountDummy(bank, customer, "12346");
        bank.addAccount(source);
        bank.addAccount(target);
        source.transfer(10000, "12346");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
    }

    @Test
    public void testAccountSetBalance() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account acc = new AccountDummy(bank, customer, "12345");
        acc.setBalance(1337);

        assertEquals(1337, acc.getBalance());
    }

    @Test
    public void testAccountMovements() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account source = new AccountDummy(bank, customer, "12345");
        Account target = new AccountDummy(bank, customer, "1337");

        source.transfer(10, target);
        assertEquals(1, source.getWithdrawals().size());

    }

    @Test
    public void testAccountTwoMovements() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account source = new AccountDummy(bank, customer, "12345");
        Account target = new AccountDummy(bank, customer, "1337");

        source.transfer(10, target);
        source.transfer(10, target);
        assertEquals(2, source.getWithdrawals().size());
    }

    @Test
    public void testAccountDeposits() {
        Bank bank = new BankDummy("17299999", "Glorious bank");
        Customer customer = new CustomerDummy("0102030405", "Glorious Customer", bank);
        Account source = new AccountDummy(bank, customer, "12345");
        Account target = new AccountDummy(bank, customer, "1337");

        source.transfer(10, target);
        source.transfer(10, target);
        assertEquals(2, target.getDeposits().size());
    }
}
