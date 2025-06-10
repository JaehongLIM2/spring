# DELETE : 특정 행(row, record)를 삭제
SELECT *
FROM Customers
ORDER BY CustomerID DESC;

DELETE
FROM Customers
WHERE CustomerID = 103;

DELETE
FROM Customers
WHERE CustomerID = 101;

SELECT *
FROM Customers
WHERE Country IS NULL;

# ** 지우기 전에 꼭 같은 WHERE 절로 SELECT 해보기 **

DELETE
FROM Customers
WHERE Country IS NULL;

SELECT *
FROM Customers
WHERE CustomerID = 100;

DELETE
FROM Customers
WHERE CustomerID = 100;

# ** WHERE 없이 삭제하면 모든 레코드가 삭제됨 **

DELETE
FROM Customers;

# 연습
# 공급자 테이블에서
# 30번 공급자 삭제하기
SELECT *
FROM Suppliers;

SELECT *
FROM Suppliers
WHERE SupplierID = 30;

DELETE
FROM Suppliers
WHERE SupplierID = 30;

# 공급자 테이블의 모든 레코드 삭제하기
DELETE
FROM Suppliers;




