USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country
FROM customer;

CREATE TABLE my_table20
(
    name  VARCHAR(30) PRIMARY KEY,
    money INT
);

INSERT INTO my_table20
    (name, money)
VALUES ('a', 10000),
       ('b', 10000);

SELECT *
FROM my_table20;

CREATE TABLE my_table21
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20),
    address     VARCHAR(20),
    inserted_at DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO my_table21
    (name, address)
VALUES ('lee', 'seoul');

INSERT INTO my_table21
    (name, address)
VALUES ('kim', 'pusan');

SELECT *
FROM my_table21;

CREATE TABLE my_table22
(
    name    VARCHAR(20),
    address VARCHAR(20),
    country VARCHAR(20),
    PRIMARY KEY (name)
);

INSERT INTO my_table22
    (name, address, country)
VALUES ('kim', 'seoul', 'korea');

# INSERT INTO my_table22
#     (address, country)
# VALUES ('jeju', 'usa');

CREATE TABLE my_table23
(
    name    VARCHAR(30),
    address VARCHAR(30),
    country VARCHAR(30),
    info    VARCHAR(30),
    PRIMARY KEY (name, address)
);

CREATE TABLE my_table24
(
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    score    INT          NULL,
    name     VARCHAR(20)  NOT NULL,
    address  VARCHAR(200) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);

# 복합키가 있는 my_table25 테이블 만들고 Entity 만들어보기
CREATE TABLE my_table25
(
    name    VARCHAR(255),
    address VARCHAR(255),
    city    VARCHAR(255),
    gender  VARCHAR(20),
    height  DEC(10, 2),
    weight  DEC(10, 2),
    notes   VARCHAR(255),
    info    VARCHAR(255),
    PRIMARY KEY (name, address, gender, height, weight)
);


# 복합키가 있는 my_table26 Entity 부터 만들고 테이블 만들기
CREATE TABLE my_table26
(
    title   VARCHAR(255) NULL,
    content VARCHAR(255) NULL,
    author  VARCHAR(255) NULL,
    id      INT          NOT NULL,
    id2     INT          NOT NULL,
    CONSTRAINT pk_my_table26 PRIMARY KEY (id, id2)
);

# foreign key
CREATE TABLE my_table27
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(25),
    info          VARCHAR(25)
);

DROP TABLE my_table28;
CREATE TABLE my_table28
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(25),
    price        INT,
    unit         VARCHAR(25),
    category_id  INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);





