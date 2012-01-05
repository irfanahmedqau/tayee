DELETE FROM tx;
DELETE FROM customer_account_xref;
DELETE FROM account;
DELETE FROM customer;
DELETE FROM next_id;

INSERT INTO account VALUES
('5005', 'Money Market', 'Hi Balance', 4000.00, 0.00, 3500.00, '2000-02-28 23:03:20');
 
INSERT INTO account VALUES
('5006', 'Checking', 'Checking', 85.00, 0.00, 66.54, '2000-04-16 03:12:00');

INSERT INTO account VALUES
('5007', 'Credit', 'Visa', 599.18, 5000.00, 166.08, '2000-03-23 10:13:54');

INSERT INTO account VALUES
('5008', 'Savings', 'Super Interest Account', 55601.35, 0.00, 5433.89, '2000-01-15 12:55:33');

INSERT INTO customer VALUES
('200', 'Jones', 'Richard', 'K',
 '88 Poplar Ave.', 'Cupertino', 'CA', '95014',
 '408-123-4567', 'rhill@j2ee.com');

INSERT INTO customer VALUES
('201', 'Jones', 'Mary', 'R',
 '88 Poplar Ave.', 'Cupertino', 'CA', '95014',
 '408-123-4567', 'mhill@j2ee.com');

INSERT INTO customer_account_xref VALUES
('200', '5005');

INSERT INTO customer_account_xref VALUES
('201', '5005');

INSERT INTO customer_account_xref VALUES
('200', '5006');

INSERT INTO customer_account_xref VALUES
('200', '5007');

INSERT INTO customer_account_xref VALUES
('201', '5006');

INSERT INTO customer_account_xref VALUES
('201', '5007');

INSERT INTO customer_account_xref VALUES
('200', '5008');

INSERT INTO customer_account_xref VALUES
('201', '5008');

INSERT INTO tx VALUES
('00000001', '5005', '2001-10-01 12:55:33', '200.00', '4200.00', 'Refund');
UPDATE account SET balance = 4200.00 WHERE account_id = 5005;
INSERT INTO tx VALUES
('00000003', '5008', '2001-10-03 12:55:33', '-1000.00', '54601.35', 'Transfer Out');
UPDATE account SET balance = 54604.35 WHERE account_id = 5008; 
INSERT INTO tx VALUES
('00000004', '5006', '2001-10-03 12:55:33', '1000.00', '1085.00', 'Transfer In');
UPDATE account SET balance = 1085.00 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000005', '5007', '2001-10-05 12:55:33', '33.00', '199.08', 'Clothing');
UPDATE account SET balance = 199.08 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000006', '5006', '2001-10-06 12:55:33', '2000.00', '3085.00', 'Paycheck Deposit');
UPDATE account SET balance = 3085.00 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000007', '5005', '2001-10-07 12:55:33', '-200.00', '4000.00', 'ATM Withdrawal');
UPDATE account SET balance = 3085.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000008', '5006', '2001-10-08 12:55:33', '-200.00', '2885.00', 'Car Insurance');
UPDATE account SET balance = 2885.00 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000009', '5007', '2001-10-09 12:55:33', '186.00', '385.08', 'Car Repair');
UPDATE account SET balance = 385.08 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000010', '5008', '2001-10-10 12:55:33', '1000.00', '55601.35', 'Deposit');
UPDATE account SET balance = 55601.35 WHERE account_id = 5008; 
INSERT INTO tx VALUES
('00000011', '5007', '2001-10-11 12:55:33', '585.00', '970.08', 'Airplane Tickets');
UPDATE account SET balance = 970.08 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000012', '5006', '2001-10-12 12:55:33', '-675.00', '2210.00', 'Mortgage Payment');
UPDATE account SET balance = 2210.00 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000013', '5005', '2001-10-13 12:55:33', '-100.00', '3900.00', 'ATM Withdrawal');
UPDATE account SET balance = 3900.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000014', '5006', '2001-10-14 12:55:33', '-385.08', '1824.92', 'Visa Payment');
UPDATE account SET balance = 1824.92 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000015', '5007', '2001-10-15 12:55:33', '-385.08', '585.00', 'Payment');
UPDATE account SET balance = 585.00 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000017', '5007', '2001-10-17 12:55:33', '26.95', '611.95', 'Movies');
UPDATE account SET balance = 611.95 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000018', '5006', '2001-10-18 12:55:33', '-31.00', '1793.92', 'Groceries');
UPDATE account SET balance = 1793.92 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000019', '5005', '2001-10-19 12:55:33', '-150.00', '3750.00', 'ATM Withdrawal');
UPDATE account SET balance = 3750.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000020', '5006', '2001-10-20 12:55:33', '2000.00', '3173.92', 'Paycheck Deposit');
UPDATE account SET balance = 3173.92 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000021', '5007', '2001-10-21 12:55:33', '124.00', '735.95', 'Furnishings');
UPDATE account SET balance = 735.95 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000023', '5007', '2001-10-23 12:55:33', '33.12', '769.07', 'Hardware');
UPDATE account SET balance = 769.07 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000024', '5006', '2001-10-24 12:55:33', '-175.33', '2998.59', 'Utility Bill');
UPDATE account SET balance = 2998.59 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000025', '5006', '2001-10-25 12:55:33', '-123.00', '2875.59', 'Groceries');
UPDATE account SET balance = 2875.59 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000026', '5006', '2001-10-26 12:55:33', '-675.00', '2200.59', 'Mortgage Payment');
UPDATE account SET balance = 2200.59 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000027', '5007', '2001-10-27 12:55:33', '24.72', '793.79', 'Cafe');
UPDATE account SET balance = 793.79 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000028', '5008', '2001-10-28 12:55:33', '1000.00', '56601.35', 'Deposit');
UPDATE account SET balance = 56601.35 WHERE account_id = 5008; 
INSERT INTO tx VALUES
('00000029', '5007', '2001-10-29 12:55:33', '35.00', '828.79', 'Hair Salon');
UPDATE account SET balance = 828.79 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000030', '5006', '2001-10-30 12:55:33', '-20.00', '2180.59', 'Gasoline');
UPDATE account SET balance = 2180.59 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000031', '5005', '2001-11-01 12:55:33', '-100.00', '3650.00', 'ATM Withdrawal');
UPDATE account SET balance = 3650.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000032', '5006', '2001-11-02 12:55:33', '-56.87', '2123.72', 'Phone Bill');
UPDATE account SET balance = 2123.72 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000033', '5007', '2001-11-03 12:55:33', '67.99', '896.78', 'Acme Shoes');
UPDATE account SET balance = 896.78 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000035', '5007', '2001-11-05 12:55:33', '24.00', '920.78', 'Movies');
UPDATE account SET balance = 920.78 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000036', '5006', '2001-11-06 12:55:33', '2000.00', '4123.72', 'Paycheck Deposit');
UPDATE account SET balance = 4123.72 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000038', '5006', '2001-11-08 12:55:33', '-100.00', '4023.72', 'Groceries');
UPDATE account SET balance = 4023.72 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000039', '5007', '2001-11-09 12:55:33', '26.95', '947.73', 'Pizza');
UPDATE account SET balance = 947.73 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000041', '5007', '2001-11-11 12:55:33', '125.00', '1072.73', 'Dentist');
UPDATE account SET balance = 1072.73 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000042', '5006', '2001-11-12 12:55:33', '-675.00', '3348.72', 'Mortgage Payment');
UPDATE account SET balance = 3348.72 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000043', '5005', '2001-11-13 12:55:33', '-150.00', '3500.00', 'ATM Withdrawal');
UPDATE account SET balance = 3500.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000044', '5006', '2001-11-14 12:55:33', '-947.73', '2400.99', 'Visa Payment');
UPDATE account SET balance = 2400.99 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000045', '5007', '2001-11-15 12:55:33', '-947.73', '125.00', 'Payment');
UPDATE account SET balance = 125.00 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000047', '5007', '2001-11-17 12:55:33', '49.90', '100.85', 'Bookstore');
UPDATE account SET balance = 100.85 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000048', '5006', '2001-11-18 12:55:33', '-100.00', '2300.99', 'Groceries');
UPDATE account SET balance = 2300.99 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000050', '5006', '2001-11-20 12:55:33', '2000.00', '4300.99', 'Paycheck Deposit');
UPDATE account SET balance = 4300.99 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000051', '5007', '2001-11-21 12:55:33', '80.32', '181.17', 'Restaurant');
UPDATE account SET balance = 181.17 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000053', '5007', '2001-11-23 12:55:33', '11.78', '192.95', 'Electronics');
UPDATE account SET balance = 192.95 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000054', '5006', '2001-11-24 12:55:33', '-150.45', '4150.54', 'Utility Bill');
UPDATE account SET balance = 4150.54 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000055', '5005', '2001-11-25 12:55:33', '-100.00', '3400.00', 'ATM Withdrawal');
UPDATE account SET balance = 3400.00 WHERE account_id = 5005; 
INSERT INTO tx VALUES
('00000056', '5006', '2001-11-26 12:55:33', '-675.00', '3475.54', 'Mortgage Payment');
UPDATE account SET balance = 3475.54 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000057', '5007', '2001-11-27 12:55:33', '24.00', '216.95', 'Ice Skating');
UPDATE account SET balance = 216.95 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000058', '5006', '2001-11-28 12:55:33', '-1000.00', '2475.54', 'Transfer Out');
UPDATE account SET balance = 2475.54 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000059', '5008', '2001-11-28 12:55:33', '1000.00', '57601.35', 'Transfer In');
UPDATE account SET balance = 57601.35 WHERE account_id = 5008; 
INSERT INTO tx VALUES
('00000060', '5006', '2001-12-02 12:55:33', '-99.22', '3376.32', 'Phone Bill');
UPDATE account SET balance = 3376.32 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000061', '5007', '2001-12-03 12:55:33', '29.97', '246.92', 'Toy Store');
UPDATE account SET balance = 246.92 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000062', '5006', '2001-12-04 12:55:33', '-2000.00', '376.32', 'Transfer Out');
UPDATE account SET balance = 376.32 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000063', '5008', '2001-12-05 12:55:33', '2000.00', '59601.35', 'Transfer In');
UPDATE account SET balance = 59601.35 WHERE account_id = 5008; 
INSERT INTO tx VALUES
('00000064', '5006', '2001-12-06 12:55:33', '2000.00', '2376.32', 'Paycheck Deposit');
UPDATE account SET balance = 59601.35 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000065', '5007', '2001-12-07 12:55:33', '14.69', '261.61', 'Cafe');
UPDATE account SET balance = 261.61 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000066', '5006', '2001-12-08 12:55:33', '-108.99', '2267.33', 'Groceries');
UPDATE account SET balance = 2267.33 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000067', '5006', '2001-12-09 12:55:33', '-30.12', '2237.21', 'Gasoline');
UPDATE account SET balance = 2237.21 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000069', '5007', '2001-12-11 12:55:33', '125.00', '386.61', 'Dentist');
UPDATE account SET balance = 2237.21 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000070', '5006', '2001-12-12 12:55:33', '-675.00', '1562.21', 'Mortgage Payment');
UPDATE account SET balance = 1562.21 WHERE account_id = 5006;  
INSERT INTO tx VALUES
('00000072', '5006', '2001-12-14 12:55:33', '-261.61', '1300.60', 'Visa Payment');
UPDATE account SET balance = 1300.60 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000073', '5007', '2001-12-15 12:55:33', '-261.61', '125.00', 'Payment');
UPDATE account SET balance = 125.00 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000075', '5007', '2001-12-17 12:55:33', '24.00', '149.00', 'Drug Store');
UPDATE account SET balance = 149.00 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000076', '5006', '2001-12-18 12:55:33', '-67.98', '1232.62', 'Groceries');
UPDATE account SET balance = 1232.62 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000078', '5006', '2001-12-20 12:55:33', '2000.00', '3232.62', 'Paycheck Deposit');
UPDATE account SET balance = 3232.62 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000079', '5007', '2001-12-21 12:55:33', '32.95', '181.95', 'CDs');
UPDATE account SET balance = 181.95 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000081', '5007', '2001-12-23 12:55:33', '14.10', '196.05', 'Sports Store');
UPDATE account SET balance = 196.05 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000082', '5006', '2001-12-24 12:55:33', '-99.30', '3133.32', 'Utility Bill');
UPDATE account SET balance = 3133.32 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000084', '5006', '2001-12-26 12:55:33', '-675.00', '2458.32', 'Mortgage Payment');
UPDATE account SET balance = 2458.32 WHERE account_id = 5006; 
INSERT INTO tx VALUES
('00000085', '5007', '2001-12-27 12:55:33', '23.98', '220.03', 'Garden Supply');
UPDATE account SET balance = 220.03 WHERE account_id = 5007; 
INSERT INTO tx VALUES
('00000086', '5005', '2001-12-28 12:55:33', '-100.00', '3300.00', 'ATM Withdrawal');
UPDATE account SET balance = 3300.00 WHERE account_id = 5005; 

INSERT INTO next_id VALUES ('customer', 202);
INSERT INTO next_id VALUES ('account', 5050);
INSERT INTO next_id VALUES ('tx',      100);
