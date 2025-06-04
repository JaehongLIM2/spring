# DISTINCT : 조회 결과에서 중복 제거
SELECT Country
FROM Customers;

SELECT DISTINCT Country
FROM Customers;

SELECT DISTINCT Country
FROM Customers
ORDER BY Country;

SELECT Country, City
FROM Customers;

SELECT DISTINCT Country, City
FROM Customers
ORDER BY Country, City;

# 연습 : 공급자가 있는 국가들 중복없이 abc 순으로 조회
SELECT DISTINCT Country
FROM Suppliers
ORDER BY Country;

# 연습 : 고객이 있는 도시들을 중복 없이 abc 순으로 조회
SELECT DISTINCT City
FROM Customers
ORDER BY City;







