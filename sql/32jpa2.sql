USE jpa;

CREATE TABLE customer
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name  varchar(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255)
);

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT CustomerName, ContactName, Address, City, PostalCode, Country
FROM w3schools.Customers;

SELECT *
FROM customer;

CREATE TABLE employee
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    last_name  VARCHAR(255),
    first_name VARCHAR(255),
    birth_date DATE,
    photo      VARCHAR(255),
    notes      VARCHAR(5000)
);

INSERT INTO employee
    (last_name, first_name, birth_date, photo, notes)
SELECT LastName, FirstName, BirthDate, Photo, Notes
FROM w3schools.Employees;

SELECT *
FROM employee;

SELECT *
FROM w3schools.Employees;







