# NULL : 값이 없다

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# SUM, COUNT, MIN, MAX, AVG
# 집계 함수는 NULL을 집계에 포함하지 않음
SELECT COUNT(CustomerName)
FROM Customers;

SELECT COUNT(ContactName)
FROM Customers;

SELECT COUNT(Address)
FROM Customers;

# 2881.70
SELECT SUM(Price)
FROM Products;

# 36.477215
SELECT AVG(Price)
FROM Products;

INSERT INTO Products
    (ProductName)
    VALUE ('커피');

INSERT INTO Products
(ProductName)
    VALUE ('죽');

# NULL인 컬럼 조회
SELECT *
FROM Customers
WHERE ContactName = 'KIM'
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
# WHERE ContactName = NULL
WHERE ContactName IS NULL
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
# WHERE ContactName != NULL
WHERE ContactName IS NOT NULL
ORDER BY CustomerID DESC;

# 연습 :
# Categories 에서 Description 이 null 인 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NULL;

# Categories 에서 Description 이 null 이 아닌 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NOT NULL;

SELECT *
FROM Products
ORDER BY ProductID DESC;

# 2881.70
SELECT SUM(Price)
FROM Products;

# 36.477215
SELECT AVG(Price)
FROM Products;

# 35.576543
SELECT AVG(IFNULL(Price, 0))
FROM Products;

# IFNULL : NULL 인 경우 다른 값으로 조회
SELECT ProductID,
       ProductName,
       SupplierID,
       IFNULL(CategoryID, '미정') CategoryID,
       IFNULL(Unit, '없다') Unit,
       IFNULL(Price, 0)
FROM Products
ORDER BY ProductID DESC;

# 연습 :
# Categories 테이블 조회 Description 이 NULL 이면 '정해지지 않음' 으로 조회
SELECT IFNULL(Description, '정해지지 않음') Description
FROM Categories;


# Description 컬럼 으로 COUNT() 함수 결과를 조회, NULL도 COUNT 에 포함 되도록
SELECT COUNT(IFNULL(Description, '미정'))
FROM Categories;







