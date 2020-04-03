CREATE TABLE Movement
(
    movementId int NOT NULL AUTO_INCREMENT,
    time       DateTime,
    amount     DECIMAL(20, 3),
    accountId varchar(225) NOT NULL,
    PRIMARY KEY (movementId)
);

CREATE TABLE Account
(
    accountNumber varchar(255) NOT NULL,
    bankId        varchar(255),
    customerId    varchar(255),
    balance       DECIMAL(20, 3),
    PRIMARY KEY (accountNumber)
);

CREATE TABLE Bank
(
    cvr       varchar(255) NOT NULL,
    bankName  varchar(255),
    PRIMARY KEY (cvr)
);

CREATE TABLE Customer
(
    cpr           varchar(255) NOT NULL,
    name          varchar(255),
    bankCvr       varchar(255),
    PRIMARY KEY (cpr)
);

ALTER TABLE Account
    ADD FOREIGN KEY (customerId) REFERENCES Customer (cpr),
    ADD FOREIGN KEY (bankId) REFERENCES Bank (cvr);

ALTER TABLE Customer
    ADD FOREIGN KEY (bankCvr) REFERENCES Bank (cvr);

ALTER TABLE Movement
    ADD FOREIGN KEY (accountId) REFERENCES Account(accountNumber)