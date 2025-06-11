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


# Primary key : 기본 키(주 키, PK)
# Foreign key : 외래 키(참조 키, FK)