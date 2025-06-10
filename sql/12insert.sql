SELECT COUNT(*)
FROM Customers;

SELECT *
FROM Categories;

SELECT *
FROM Products;

# INSERT INTO : 새 데이터(record, row) 입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUE ('92', 'JaeHong', 'LIM', 'seoul', 'shinchon', '29934', 'KOREA');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUE ('93', 'DooHwan', 'KIM', 'Jeju', 'Jeju-si', '63646', 'KOREA');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUE ('94', 'Jisung', 'PARK', 'Suwon', 'Suwon', '12354', 'KOREA');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUE ('Jiwon', 'CHOI', 'Seoul', 'Shinrim', '9934', 'KOREA');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
    VALUE ('Giryang', 'KIM', 'Jeju', 'Jeju-si', '63364', 'KOREA');

# 연습 :
#       Categories 테이블에 새 레코드 2개 입력해보기
INSERT INTO Categories
    (CategoryName, Description)
    VALUE ('Computer', 'Graphic card, cpu, ram, hdd, sdd');

INSERT INTO Categories
(CategoryName, Description)
    VALUE ('Ramen', '돈코츠, 토리파이탄, 시오, 쇼유, 이에케, 지로');

#       Products 테이블에 새 레코드 2개 입력해보기
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE ('RTX5090', '5', '2', '2kg', 599.99);

INSERT INTO Products
(ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE ('RTX5060', '5', '2', '500g', 59);

# null : 값이 없다
INSERT INTO Customers
(CustomerName)
VALUE ('손흥민');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# NULL과 ''은 다름 // MySQL 에서는 다르지만 Oracle 에서는 같음
INSERT INTO Customers
    (CustomerName, ContactName)
    VALUE ('이재명', NULL);

INSERT INTO Customers
(CustomerName, ContactName, Address)
    VALUE ('김문수', NULL, '');

# 연습 :
# Categories 테이블에 새 데이터를 넣기(Description은 null 로 남기기)
INSERT INTO Categories
(CategoryName, Description)
    VALUE ('책상들', null);

# Categories 테이블에 새 데이터를 넣기(Description은 '' 로 남기기)
INSERT INTO Categories
(CategoryName, Description)
    VALUE ('의자들', '');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;


