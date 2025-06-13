USE w3schools;

create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null
);

ALTER TABLE Products
    ADD FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID);

create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID)
);

create index CategoryID
    on w3schools.Products (CategoryID);

ALTER TABLE Products
    ADD FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID);

ALTER TABLE Orders
    ADD FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID),
    ADD FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID),
    ADD FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID);

ALTER TABLE OrderDetails
    ADD FOREIGN KEY (OrderID) REFERENCES Orders (OrderID),
    ADD FOREIGN KEY (ProductID) REFERENCES Products (ProductID);






















