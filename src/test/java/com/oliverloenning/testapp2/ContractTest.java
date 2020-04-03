package com.oliverloenning.testapp2;

import com.oliverloenning.testapp2.interfaces.Account;
import com.oliverloenning.testapp2.interfaces.Customer;
import com.oliverloenning.testapp2.interfaces.Movement;
import com.oliverloenning.testapp2.models.AccountDummy;
import com.oliverloenning.testapp2.models.CustomerDummy;
import com.oliverloenning.testapp2.rest.Contract;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class ContractTest {

	@Autowired
	Contract contract;

	@BeforeAll
	public static void setup() {
		Customer customer1 = new CustomerDummy("12345", "Glorious Customer1", Contract.bank);
		Customer customer2 = new CustomerDummy("12346", "Glorious Customer2", Contract.bank);
		Customer customer3 = new CustomerDummy("12347", "Glorious Customer3", Contract.bank);
		Account account1 = new AccountDummy(Contract.bank, customer1, "123");
		Account account2 = new AccountDummy(Contract.bank, customer2, "124");
		Account account3 = new AccountDummy(Contract.bank, customer3, "125");
		Contract.bank.addCustomer(customer1);
		Contract.bank.addCustomer(customer2);
		Contract.bank.addCustomer(customer3);
		Contract.bank.addAccount(account1);
		Contract.bank.addAccount(account2);
		Contract.bank.addAccount(account3);
	}

	@Test
	public void createNewAccount() {
		Account account = new AccountDummy(Contract.bank, Contract.bank.getCustomer("12345"), "126");
		contract.createAccount(account);

		assertEquals(account, Contract.bank.getAccount(account.getNumber()));
	}

	@Test
	public void getMovementsOnAnAccount() {
		List<Movement> movements = contract.getMovementsOnAccount("123");
		assertEquals(movements.size(), 0);
	}

	@Test
	public void getCustomer() {
		Customer customer4 = new CustomerDummy("12348", "Glorious Customer4", Contract.bank);
		contract.createCustomer(customer4);

		assertEquals(contract.getCustomerFromBank("12348"), customer4);
	}


}
