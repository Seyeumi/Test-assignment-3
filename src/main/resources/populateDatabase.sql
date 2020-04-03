/* Dummy data */

INSERT INTO Bank
VALUES ('123', 'Glorious Bank');

INSERT INTO Customer VALUES ('12345678', 'Glorious Customer1', '123');
INSERT INTO Customer VALUES ('12345679', 'Glorious Customer2', '123');
INSERT INTO Customer VALUES ('12345680', 'Glorious Customer3', '123');

INSERT INTO Account VALUES ('1', '123', '12345678', 100.00);
INSERT INTO Account VALUES ('2', '123', '12345678', 150.00);
INSERT INTO Account VALUES ('3', '123', '12345679', 1000.00);
INSERT INTO Account VALUES ('4', '123', '12345679', 3000.00);
INSERT INTO Account VALUES ('5', '123', '12345680', 5000.00);

INSERT INTO Movement VALUES (null, current_date, 20.00, '1');
INSERT INTO Movement VALUES (null, current_date, 40.00, '1');
INSERT INTO Movement VALUES (null, current_date, -50.00, '1');
INSERT INTO Movement VALUES (null, current_date, -30.00, '1');
INSERT INTO Movement VALUES (null, current_date, -100.00, '2');
INSERT INTO Movement VALUES (null, current_date, 1000.00, '2');
INSERT INTO Movement VALUES (null, current_date, 70.00, '3');
INSERT INTO Movement VALUES (null, current_date, -150.00, '4');
INSERT INTO Movement VALUES (null, current_date, 200.00, '4');
INSERT INTO Movement VALUES (null, current_date, -230.00, '5');
INSERT INTO Movement VALUES (null, current_date, -300.00, '5');
INSERT INTO Movement VALUES (null, current_date, -500.00, '5');