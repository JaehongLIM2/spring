# LIKE (~같은)
# % _ : wildcard

# % : 0개 이상 아무거나
# _ : 1개 아무거나

# u 로 시작하는 국가에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country LIKE 'u%';

# a 로 시작하는 고객명 조회
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%';

# a 로 시작하고 a 로 끝나는 고객명
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%a';

# 중간에 to 가 있는 고객명
# **가장 자주 사용**
SELECT *
FROM Customers
WHERE CustomerName LIKE '%to%';

# 10 번대 고객들
SELECT *
FROM Customers
WHERE CustomerID LIKE '1_';

# 1997 년 12 월에 주문한 주문들
SELECT *
FROM Orders
WHERE OrderDate LIKE '1997-12-__';

# 연습 문제
# 직원 설명에 college 가 포함된 직원들 조회
SELECT *
FROM Employees
WHERE Notes LIKE '%college%';

# C로 시작하는 상품명인 상품 조회
SELECT *
FROM Products
WHERE ProductName LIKE 'c%';

SELECT *
FROM Customers;





