USE mydatabase;

CREATE TABLE table34
(
    name VARCHAR(1)
);

CREATE TABLE table35
(
    score INT
);

INSERT INTO table34
    (name)
VALUES ('임'),
       ('김'),
       ('박'),
       ('최'),
       ('박');

INSERT INTO table35
    (score)
VALUES (5),
       (4),
       (3),
       (3),
       (5);

SELECT *
FROM table34;

SELECT *
FROM table35;

# 행은 25개, 열은 2개
SELECT *
FROM table34,
     table35;

USE w3schools;

SELECT *
FROM w3schools.Products
         JOIN
     w3schools.Categories;

# Cartesian Product (카테시안 곱)
CREATE TABLE table36
(
    `대회`  VARCHAR(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);

CREATE TABLE table37
(
    `우승자`  VARCHAR(30),
    `생년월일` VARCHAR(100),
    PRIMARY KEY (`우승자`)
);

INSERT INTO table36
    (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');

INSERT INTO table37
    (우승자, 생년월일)
VALUES ('chip', '97-03-14'),
       ('al', '75-07-21'),
       ('bob', '68-09-28');

SELECT *
FROM table36;

SELECT *
FROM table37;

# 카테시안 곱
SELECT *
FROM table36
         JOIN
     table37;

SELECT *
FROM table36
         JOIN
     table37
WHERE table36.우승자 = table37.우승자;

SELECT *
FROM table36
         JOIN
     table37
     ON table36.우승자 = table37.우승자;

SELECT `대회`, `연도`, table36.`우승자`, `생년월일`
FROM table36
         JOIN
     table37
     ON table36.우승자 = table37.우승자;

# ALIAS
SELECT `대회` AS Congress, `연도` Year, t6.`우승자`, `생년월일`
FROM table36 AS t6
         JOIN
     table37 t7
     ON t6.우승자 = t7.우승자;

#
SELECT *
FROM w3schools.Products;

SELECT *
FROM w3schools.Categories;

SELECT t.CategoryName, p.ProductName
FROM w3schools.Products p
         JOIN
     w3schools.Categories t
     ON p.CategoryID = t.CategoryID
ORDER BY t.CategoryName, p.ProductName;

SELECT *
FROM w3schools.Suppliers;

SELECT *
FROM w3schools.Products;

SELECT s.SupplierName, p.ProductName
FROM w3schools.Suppliers s
         JOIN
     w3schools.Products p
     On s.SupplierID = p.SupplierID
ORDER BY SupplierName, ProductName;

# 주문별 처리 직원
SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN
     w3schools.Employees e
     ON e.EmployeeID = o.EmployeeID
WHERE e.EmployeeID = 3;

# 1 번 고객이 주문한 날짜들 조회

SELECT o.OrderDate, o.CustomerID, c.CustomerName
FROM w3schools.Orders o
         JOIN
     w3schools.Customers c
     ON o.CustomerID = c.CustomerID
WHERE c.CustomerID = 1;

# 고객별 주문 건수
SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
JOIN
    w3schools.Customers c
ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY c.CustomerID;

SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
         JOIN
     w3schools.Customers c
     ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) >= 20
ORDER BY c.CustomerID;

# 연습
# 직원 별 주문 처리 건수
SELECT e.EmployeeID, e.LastName, e.FirstName, COUNT(*)
FROM w3schools.Orders o
JOIN
    w3schools.Employees e
ON o.EmployeeID = e.EmployeeID
GROUP BY e.EmployeeID
ORDER BY e.EmployeeID;

# 카테고리별 상품의 평균 가격
SELECT c.CategoryID, c.CategoryName, AVG(p.Price) Price
FROM w3schools.Categories c
JOIN
    w3schools.Products p
ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID;







