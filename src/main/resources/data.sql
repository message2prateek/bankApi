INSERT INTO customer values
(100,'Prateek', 'Business'),
(101, 'Justin', 'Individual'),
(102, 'Anna', 'Individual');

INSERT INTO account(id, name, type, status, balance, customer_id) values -- for ManyToOne relationships use customer_id instead of customerId or customer
(111111, 'YouMoney', 'Savings', 'Open', 200.01, 100),
(222222, 'NiceToKnowYouMoney', 'Current', 'Open', 80.00, 100),
(333333, 'ThankYouMoney', 'Current', 'Closed', 80.00, 100),
(223345, 'GoMoney','Current', 'Open', 1001.00, 101),
(223344,'DontLetGoMoney', 'Savings', 'Open', 1033.00, 101),
(123456, 'MyMoney', 'Current', 'Open', 122.43, 102),
(123457, 'OnlyMyMoney', 'Savings', 'Closed', 2323.79, 102);
