package com.oliverloenning.testapp2;

import com.oliverloenning.testapp2.database.BankRepository;
import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.interfaces.Connector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.Assert.*;

@SpringBootTest
class DatabaseTest {
    private static java.sql.Connection conn;

    /* Setup connection */
    @BeforeAll()
    public static void openConnection() {
        conn = Connector.getDatabaseConnection();
    }

    /* Close down operation */
    @AfterAll
    public static void closeConnection() throws SQLException {
        conn.close();
    }

    @Test
    public void testIfBankExistsInDatabase() {
        BankRepository bankRepository = new BankRepository(conn);
        Bank bank = bankRepository.getBank();

        assertEquals(bank.getName(), "Glorious Bank");
    }


}