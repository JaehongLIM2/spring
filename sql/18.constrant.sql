USE mydatabase;
# 제약 사항(Constraint) : 컬럼에 입력 가능한 값을 제한

# NOT NULL : null 허용 안함
# UNIQUE : 중복 허용 안함
# DEFAULT : 값 안주면 기본 값

# NOT NULL
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL # NULL 허용 안됨
);

INSERT INTO table14
    (col1, col2)
VALUES (5, 1);

INSERT INTO table14
    (col1, col2)
VALUES (null, 1);

INSERT INTO table14
    (col2)
VALUES (1);

SELECT *
FROM table14;

INSERT INTO table14
    (col1, col2)
VALUES (11, null);

INSERT INTO table14
    (col1)
VALUES (11);

# 연습
# (name varchar not null), (address varchar) table 15 만들기

CREATE TABLE table15
(
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255)
);

INSERT INTO table15
    (name, address)
VALUES ('임재홍', '신촌');

INSERT INTO table15
    (name, address)
VALUES ('김두환', '신촌');

INSERT INTO table15
    (name)
VALUES ('최지원');

INSERT INTO table15
    (address)
VALUES ('신촌');

SELECT *
FROM table15;

# DEFAULT : 값 안주면 기본 값
CREATE TABLE table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'anonymous'
);

INSERT INTO table16
(col1, col2)
VALUES ('abd', 'wdw');

INSERT INTO table16
(col2)
VALUES ('wdw');

INSERT INTO table16
(col1)
VALUES ('wrtw');

SELECT *
FROM table16;

CREATE TABLE table17
(
    col1 VARCHAR(10)          DEFAULT 'val1',
    col2 VARCHAR(10) NOT NULL DEFAULT 'val2'
);

INSERT INTO table17
    (col1, col2)
VALUES ('abc', 'sdw');

INSERT INTO table17
(col1, col2)
VALUES (null , 'sdw');

INSERT INTO table17
(col1, col2)
VALUES ('abc', null);

INSERT INTO table17
(col2)
VALUES ('sdw');

INSERT INTO table17
(col1)
VALUES ('abc');

SELECT *
FROM table17;

# 연습
# name varchar not null
# score int not null default 0
# table18 만들기
CREATE TABLE table18
(
    name  VARCHAR(10) NOT NULL,
    score INT         NOT NULL DEFAULT 0
);

INSERT INTO table18
    (name, score)
VALUES ('임재홍', '100');

INSERT INTO table18
(name)
VALUES ('김두환');

INSERT INTO table18
(name, score)
VALUES ('김창범', null);

INSERT INTO table18
(score)
VALUES ('100');

SELECT *
FROM table18;

CREATE TABLE table19
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);

INSERT INTO table19
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table19
(col1, col2)
VALUES ('abc', 'qwe');

INSERT INTO table19
(col1, col2)
VALUES ('owo', 'def');

INSERT INTO table19
(col1)
VALUES ('owo');

# NULL 은 중복되지 않음

SELECT *
FROM table19;

CREATE TABLE table20
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) NOT NULL UNIQUE
);

INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'swd');

INSERT INTO table20
(col1, col2)
VALUES ('abc', '123');

INSERT INTO table20
(col2)
VALUES ('abc');

INSERT INTO table20
(col1)
VALUES ('abc');

INSERT INTO table20
(col2)
VALUES ('abc');

# 연습
CREATE TABLE table21
(
    name  VARCHAR(20) NOT NULL UNIQUE,
    score INT         NOT NULL DEFAULT 0
);

INSERT INTO table21
    (name, score)
VALUES ('임재홍', 20);

INSERT INTO table21
(name)
VALUES ('김두환');

INSERT INTO table21
(name, score)
VALUES ('김두환', 20);

INSERT INTO table21
(score)
VALUES (41);

SELECT *
FROM table21;

# 테이블의 구조 보기
DESCRIBE table21;

# 연습
# w3schools.Products 테이블 구조보기
DESC w3schools.Products;

SHOW CREATE TABLE w3schools.Products;

CREATE TABLE `Products` (
                            `ProductID` int NOT NULL AUTO_INCREMENT,
                            `ProductName` varchar(255) DEFAULT NULL,
                            `SupplierID` int DEFAULT NULL,
                            `CategoryID` int DEFAULT NULL,
                            `Unit` varchar(255) DEFAULT NULL,
                            `Price` decimal(10,2) DEFAULT NULL,
                            PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci








# Primary key : 기본 키(주 키, PK)
# Foreign key : 외래 키(참조 키, FK)