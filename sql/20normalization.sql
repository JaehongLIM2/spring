USE mydatabase;

# NORMALIZATION : 정규화(형)

# FIRST  NORMAL FORM(1NF, 1정규화) :
# SECOND NORMAL FORM(2NF, 2정규화) :
# THIRD  NORMAL FORM(3NF, 3정규화) :

# 1NF
# 모든 레코드가 유일해야하고,
    # -> NOTNULL, UNIQUE 컬럼이 적어도 하나 있어야함
# 모든 데이터는 atomic(원자적) 해야한다.
# ** 원자적이란? 한개의 컬럼에 하나의 값만 들어가야함 **

CREATE TABLE table25
(
    name  VARCHAR(10),
    phone VARCHAR(255)
);

INSERT INTO table25
    (name, phone)
VALUES ('임재홍', '10020303030');

SELECT *
FROM table25;

INSERT INTO table25
    (name, phone)
VALUES ('김두', '10023130, 01033302030');

CREATE TABLE table26
(
    name   VARCHAR(10),
    phone1 VARCHAR(255),
    phone2 VARCHAR(255)
);

INSERT INTO table26
    (name, phone1)
VALUES ('손', '01030302020');

INSERT INTO table26
    (name, phone1, phone2)
VALUES ('김', '01030202030', '01022923939');

SELECT *
FROM table26;

ALTER TABLE table26
    ADD COLUMN address VARCHAR(255) AFTER name;

UPDATE table26
SET address = '서울'
WHERE name = '손';

UPDATE table26
SET address = '부산'
WHERE name = '김';

CREATE TABLE table27
(
    name  VARCHAR(10),
    phone VARCHAR(255)
);

INSERT INTO table27
    (name, phone)
VALUES ('손', '01030302020'),
       ('김', '01030202030'),
       ('김', '01022923939');

ALTER TABLE table26
    DROP COLUMN phone1;

ALTER TABLE table26
    DROP COLUMN phone2;

SELECT *
FROM table27;

CREATE TABLE table28
(
    name    VARCHAR(10),
    address VARCHAR(10),
    work    VARCHAR(10)
);

INSERT INTO table28
    (name, address, work)
VALUES ('kim', 'seoul', 'intel');

INSERT INTO table28
(name, address, work)
VALUES ('lee', 'busan', 'intel');

INSERT INTO table28
(name, address, work)
VALUES ('choi', 'seoul', 'tesla');

INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'google');

INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'google');

SELECT *
FROM table28;

# ALTER TABLE table28
# ADD COLUMN id INT UNIQUE NOT NULL ;

CREATE TABLE table29
(
    id      INT NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(20),
    work    VARCHAR(20)
);

DESC table29;





