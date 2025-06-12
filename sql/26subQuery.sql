# sub query : 쿼리 안의 쿼리
USE mydatabase;

# 한 번도 주문된 적 없는 상품 목록
USE w3schools;
DELETE
FROM OrderDetails
WHERE ProductID IN (10, 20, 30, 40);

# 한 번도 주문된 적 없는 상품들 이름 조회
SELECT *
FROM OrderDetails od
         RIGHT JOIN Products p
                    ON p.ProductID = od.ProductID
WHERE od.OrderDetailID IS NULL
ORDER BY p.ProductID;

# 1. 주문된 적 있는 상품 ID
SELECT ProductID
FROM OrderDetails;

# 2. 위 쿼리 결과에 없는 상품 ID 들
SELECT *
FROM Products
WHERE ProductID NOT IN (SELECT ProductID
                        FROM OrderDetails);

# 상품과 카테고리 정보 조회
SELECT *
FROM Products p
         JOIN
     Categories c
     ON p.CategoryID = c.CategoryID;

SELECT ProductID,
       ProductName,
       (SELECT c.CategoryName
        FROM Categories c
        WHERE c.CategoryID = p.CategoryID) CategoryName
FROM Products p;


# 연습
# 1996-08-01 에 주문 처리한 직원명 조회
# 1. JOIN 방식
SELECT e.FirstName, e.LastName
FROM Orders o
         JOIN Employees e
              ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate = '1996-08-01';

# 2. Sub Query 방식
# ** Sub Query 는 한 개의 값만 반환할 수 있음 **
SELECT o.OrderDate,
       (SELECT e.LastName
        FROM Employees e
        WHERE o.EmployeeID = e.EmployeeID)
FROM Orders o
WHERE OrderDate = '1996-08-01';

# 연습
# 상품의 평균 가격보다 높은 상품들 조회
# sub query
SELECT *
FROM (SELECT CategoryID, AVG(Price) avg
      FROM Products
      GROUP BY CategoryID) p
WHERE avg >= 50;

# 연습
# 1996-09 월 평균 처리 금액보다 높은 금액을 처리한 직원 목록

SELECT e.EmployeeID, SUM(Price * Quantity) sum
FROM Employees e
         JOIN Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN OrderDetails od
              ON od.OrderID = o.OrderID
         JOIN Products p
              ON p.ProductID = od.ProductID
WHERE OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY e.EmployeeID;

# 1996-09 월 평균 처리 금액 : 총 처리 금액 / 직원 수

SELECT SUM(p.Price * od.Quantity) / COUNT(DISTINCT e.EmployeeID)
FROM Employees e
         JOIN Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN OrderDetails od
              ON od.OrderID = o.OrderID
         JOIN Products p
              ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';

# -------------

SELECT e.EmployeeID, e.LastName, e.FirstName,  SUM(Price * Quantity) sum
FROM Employees e
         JOIN Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN OrderDetails od
              ON od.OrderID = o.OrderID
         JOIN Products p
              ON p.ProductID = od.ProductID
WHERE OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY e.EmployeeID
HAVING sum > (SELECT SUM(p.Price * od.Quantity) / COUNT(DISTINCT e.EmployeeID)
              FROM Employees e
                       JOIN Orders o
                            ON e.EmployeeID = o.EmployeeID
                       JOIN OrderDetails od
                            ON od.OrderID = o.OrderID
                       JOIN Products p
                            ON p.ProductID = od.ProductID
              WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30')
ORDER BY EmployeeID;









