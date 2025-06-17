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

CREATE TABLE supplier
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255),
    phone         VARCHAR(255)
);

DROP TABLE supplier;

INSERT INTO supplier
    (supplier_name, contact_name, address, city, postal_code, country, phone)
SELECT SupplierName, ContactName, Address, City, PostalCode, Country, Phone
FROM w3schools.Suppliers;

SELECT *
FROM supplier;

CREATE TABLE product
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255),
    supplier_id  INT,
    category_id  INT,
    unit         VARCHAR(255),
    price        DEC(10, 2)
);

INSERT INTO product
    (product_name, supplier_id, category_id, unit, price)
SELECT ProductName, SupplierID, CategoryID, Unit, Price
FROM w3schools.Products;

SELECT *
FROM product;




