# ALIAS (AS) : 컬럼이나 테이블에 별칭 주기
SELECT CustomerName, ContactName
FROM Customers;

SELECT CustomerName AS NAME, ContactName AS CONTACT
FROM Customers;

# AS : 생략 가능
SELECT CustomerName NAME, ContactName CONTACT
FROM Customers;

SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균가격
FROM Products;

# 띄어쓰기 사용할 때는 '' 또는 `` 사용
SELECT AVG(Price) '평균 가격'
FROM Products;

# 테이블에 별칠 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

SELECT p.ProductName, c.CategoryName
FROM Products p,
     Categories c;






