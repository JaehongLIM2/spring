USE mydatabase;

CREATE TABLE table38
(
    id INT
);

INSERT INTO table38
    (id)
VALUES (9),
       (8),
       (7);

SELECT *
FROM table34;

SELECT *
FROM table35;

SELECT *
FROM table38;

SELECT *
FROM table34 t34
         JOIN
     table35 t35
         JOIN
     table38 t38;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND s.SupplierID = p.SupplierID;


# 공급자별 공급하는 상품 카테고리
SELECT DISTINCT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName;

# 카테고리별 공급자 정보
SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;

# 연습
# 1996-07-05 에 주문된 상품명 목록
# Orders, OrderDetails, Products
SELECT o.OrderDate, p.ProductName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-05';

SELECT o.OrderDate, c.CustomerName, od.Quantity
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
# WHERE p.ProductName = 'Tofu'
WHERE p.ProductID = 14 # 조건의 사용되는 컬럼들은 기본키를 사용할 수록 성능이 좋음
ORDER BY c.CustomerName, o.OrderDate;

# 연습
# 우수 고객 선정 조회
# 고객별 주문 금액
# Orders, OrderDetails, Products, Customers
USE w3schools;
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON p.ProductID = od.ProductID
         JOIN Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

# 연습
# 1997-09 에 가장 많은 주문(가격 기준)을 처리한 직원
SELECT e.FirstName, e.LastName, SUM(od.Quantity * p.Price) `가장 많은 주문`
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Employees e
              ON o.EmployeeID = e.EmployeeID
         JOIN Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY `가장 많은 주문` DESC;


















