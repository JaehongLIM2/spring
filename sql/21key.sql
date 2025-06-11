USE mydatabase;
# Key : 각 레코드를 구분하는 컬럼(들)
# Primary key : 기본키, 대표키, 주요키, 주키, PK
#   ** UNIQUE
#   ** NOT NULL
#   ** 변경되지 말아야 함
#   ** Insert 할 때 결정되어야함

CREATE TABLE table30
(
    name    VARCHAR(20),
    address VARCHAR(20),
#     phone   VARCHAR(20) UNIQUE NOT NULL,
    phone VARCHAR(20) PRIMARY KEY
);
DROP TABLE table30;

DESC table30;

CREATE TABLE table31
(
    name    VARCHAR(20),
    address VARCHAR(20),
    phone   VARCHAR(20),
    PRIMARY KEY (phone)
);
DESC table31;

CREATE TABLE table32
(
    name    VARCHAR(20),
    address VARCHAR(20),
    notes   VARCHAR(20),
    PRIMARY KEY (name, address)
);
DESC table32;

CREATE TABLE table33
(
    number  VARCHAR(13) PRIMARY KEY,
    name    VARCHAR(20),
    address VARCHAR(30)
);


















