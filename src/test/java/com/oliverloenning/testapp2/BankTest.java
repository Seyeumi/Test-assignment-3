package com.oliverloenning.testapp2;

import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.models.BankDummy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class BankTest {

    @Test
    public void testCreateBank() throws Exception {
        Bank bank = new BankDummy("17288888", "Glorious bank");
        assertNotNull(bank);
    }


}
