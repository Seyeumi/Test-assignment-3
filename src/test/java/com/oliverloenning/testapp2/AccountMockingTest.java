package com.oliverloenning.testapp2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Customer;
import com.oliverloenning.testapp2.models.AccountDummy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountMockingTest {

    @Mock
    Customer customer;

    @Mock
    Bank mockedBank;

    @Test
    public void testAccountTransferWithAccount() {
        final String targetNumber = "TGT54321";
        Account source = new AccountDummy(mockedBank, customer, "SRC54321");
        Account target = new AccountDummy(mockedBank, customer, targetNumber);

        source.transfer(10000, target);
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());

    }

    @Test
    public void testAccountTransferWithNumber() {
        final String targetNumber = "TGT54321";
        Account source = new AccountDummy(mockedBank, customer, "SRC54321");
        Account target = new AccountDummy(mockedBank, customer, targetNumber);
        when(mockedBank.getAccount(targetNumber)).thenReturn(target);

        source.transfer(10000, "TGT54321");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
    }



}