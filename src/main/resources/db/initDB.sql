DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_list;
DROP TABLE IF EXISTS goods;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE goods
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR         NOT NULL,
    price_goods decimal(10, 2)   NOT NULL,
    CONSTRAINT goods_unique_idx UNIQUE (name, price_goods)
);

CREATE TABLE order_list
(
id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
goods_id    INTEGER         NOT NULL,
price_order decimal(10, 2)   NOT NULL,
number      INTEGER         NOT NULL,
cost        decimal(10, 2)   NOT NULL,
CONSTRAINT order_list_idx UNIQUE (goods_id, number),
FOREIGN KEY (goods_id) REFERENCES goods (id)
);

CREATE TABLE orders
(
id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
number_order    INTEGER         NOT NULL,
email           VARCHAR(100)    NOT NULL,
time            TIMESTAMP       NOT NULL,
order_list_id   INTEGER,
CONSTRAINT orders_idx UNIQUE (email , order_list_id),
FOREIGN KEY (order_list_id) REFERENCES order_list (id)
);

