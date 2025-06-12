USE mydatabase;

CREATE TABLE table39
(
    col1 INT
);

CREATE TABLE table40
(
    col_a INT
);

INSERT INTO table39
    (col1)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

INSERT INTO table40
    (col_a)
VALUES (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9);

# cartesian product
SELECT *
FROM table39
         JOIN table40;

# inner join
SELECT *
FROM table39
         JOIN table40
              ON table39.col1 = table40.col_a;

# left (outer) join
SELECT *
FROM table39
         LEFT JOIN table40
                   ON table39.col1 = table40.col_a;

# right (outer) join
SELECT *
FROM table39
         RIGHT JOIN table40
                    ON table39.col1 = table40.col_a;

ALTER TABLE table39
    ADD COLUMN name VARCHAR(10);

SELECT *
FROM table39;

ALTER TABLE table40
    ADD COLUMN toy VARCHAR(10);

SELECT *
FROM table40;

# 장난감이 있는 사람들
# inner join
SELECT *
FROM table39
         JOIN table40
              ON table39.col1 = table40.col_a;

# 장난감 있는 사람들 + 장난감 없는 사람들
SELECT *
FROM table39
         LEFT JOIN table40
                   ON table39.col1 = table40.col_a;

#장난감 없는 사람들 (+ WHERE)
SELECT *
FROM table39
         LEFT JOIN table40
                   ON table39.col1 = table40.col_a
WHERE col_a IS NULL;

# 주인이 있는 장난감 + 주인이 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40
                    ON table39.col1 = table40.col_a;

# 주인이 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40
                    ON table39.col1 = table40.col_a
WHERE col1 IS NULL;

USE w3schools;


# 주문한 적 없는 고객들
SELECT *
FROM Customers c
         LEFT JOIN Orders o
                   ON c.CustomerID = o.CustomerID
WHERE OrderID IS NULL;

# 연습
DELETE
FROM Orders
WHERE EmployeeID IN (2, 3);

# 주문을 처리한 적 없는 직원들 조회
SELECT e.EmployeeID, e.LastName, e.FirstName
FROM Orders o
         RIGHT JOIN  Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE OrderID IS NULL;

# UNION










