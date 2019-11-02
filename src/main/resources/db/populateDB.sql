DELETE FROM orders;
DELETE FROM order_list;
DELETE FROM goods;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO goods (name, price_goods) VALUES
('макароны', 100.99),
('Samsung S9', 80000.94),
('кружка', 122.02),
('велосипед', 50200.23),
('Биг-мак', 64.21),
('тетрадь', 2.01);

INSERT INTO order_list (goods_id, price_order, number, cost) VALUES
(1, 100.99, 2, 2 * 100.99),
(2, 80000.94, 3, 3 * 80000.94),
(3, 122.02, 1, 1 * 122.02),
(4, 50200.23, 4, 4 * 50200.23),
(5, 64.21, 12, 12 * 64.21),
(6, 2.01, 112, 112 * 2.01);

INSERT INTO orders (number_order, email, time, order_list_id) VALUES
(111, 'user1@yandex.ru', '2019-09-29 00:01:01', 7),
(111, 'user1@yandex.ru', '2019-09-29 00:01:01', 10),
(111, 'user1@yandex.ru', '2019-09-29 00:01:01', 11),
(112, 'user2@yandex.ru', '2019-09-28 10:11:11', 8),
(112, 'user2@yandex.ru', '2019-09-28 10:11:11', 12),
(113, 'user3@yandex.ru', '2019-09-27 23:01:01', 9);
