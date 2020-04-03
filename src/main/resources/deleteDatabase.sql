ALTER TABLE Account
    DROP FOREIGN KEY Account_ibfk_1,
    DROP FOREIGN KEY Account_ibfk_2;

ALTER TABLE Customer
    DROP FOREIGN KEY Customer_ibfk_1;

ALTER TABLE Movement
    DROP FOREIGN KEY Movement_ibfk_1;

DROP TABLE if EXISTS Movement;
DROP TABLE if EXISTS Account;
DROP TABLE if EXISTS Bank;
DROP TABLE if EXISTS Customer;