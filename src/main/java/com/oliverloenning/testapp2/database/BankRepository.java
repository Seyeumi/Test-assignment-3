package com.oliverloenning.testapp2.database;

import com.oliverloenning.testapp2.interfaces.Bank;
import com.oliverloenning.testapp2.models.BankDummy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankRepository {
    private Connection conn;

    public BankRepository(Connection conn) {
        this.conn = conn;
    }

    public Bank getBank() {
        String query = "SELECT * from Bank";
        Bank bank = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);


            while (rs.next()) {
                String cvr = rs.getString("cvr");
                String bankName = rs.getString("bankName");
                bank = new BankDummy(cvr, bankName);
            }
        } catch (SQLException e) {

        }
        return bank;
    };
}
