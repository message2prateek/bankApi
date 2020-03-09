INSERT INTO customer values
(100,'John', 'Business'),
(101, 'Stephen', 'Individual'),
(102, 'Mark', 'Individual');

INSERT INTO account(id, name, type, status, balance, customer_id) values -- for ManyToOne relationships use customer_id instead of customerId or customer
(111111, 'Go', 'Current', 'Open', 200.01, 100),
(222222, 'SeriousSaver', 'Savings', 'Open', 80.00, 100),
(333333, 'Freedom', 'Current', 'Closed', 80.00, 100),
(223345, 'Jumpstart','Current', 'Open', 1001.00, 101),
(223344,'Online', 'Savings', 'Open', 1033.00, 101),
(123456, 'Go', 'Current', 'Open', 122.43, 102),
(123457, 'TermDeposit', 'Savings', 'Closed', 2323.79, 102);
