USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
(customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country
FROM customer;

CREATE TABLE my_table20
(
    name  VARCHAR(30) PRIMARY KEY,
    money INT
);

INSERT INTO my_table20
    (name, money)
VALUES ('a', 10000),
       ('b', 10000);

SELECT *
FROM my_table20;







