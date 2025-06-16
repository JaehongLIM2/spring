USE jpa;
# db의 table 명과 컬럼명은 lower_snake_case
CREATE TABLE my_table1
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    city    VARCHAR(30),
    address VARCHAR(30)
);

INSERT INTO my_table1
    (name, city, address)
VALUES ('KIM', 'Seoul', '신촌'),
       ('LEE', 'Busan', '서면'),
       ('PARK', 'Jeju', '구좌'),
       ('LIM', 'Suwon', '수원'),
       ('GWAK', 'Daegu', '대구');

SELECT *
FROM my_table1;

CREATE TABLE my_table2
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(30),
    address VARCHAR(30),
    city    VARCHAR(30)
);

INSERT INTO my_table2
    (name, address, city)
SELECT name, address, city
FROM my_table1;

SELECT *
FROM my_table2;

CREATE TABLE my_table3
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30),
    info  VARCHAR(30),
    nick  VARCHAR(30)
);

INSERT INTO my_table3
    (email, info, nick)
VALUES ('naver', '졸림', '도람뿌');

SELECT *
FROM my_table3;

ALTER TABLE my_table3
    ADD COLUMN country VARCHAR(30);

ALTER TABLE my_table3
    ADD COLUMN home_address VARCHAR(30);

ALTER TABLE my_table3
    ADD COLUMN work_address VARCHAR(30);

CREATE TABLE my_table4
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(30),
    score      DEC(10, 2),
    birth_date DATE,
    start_at   TIME,
    created_at DATETIME
);

INSERT INTO my_table4
    (name, score, birth_date, start_at, created_at)
VALUES ('Jaehong', '33.12', '1995-02-28', '14:23:22', '1994-07-04 12:32:43');

SELECT *
FROM my_table4;

CREATE TABLE my_table5
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    address     VARCHAR(30),
    hired_data  DATE,
    inserted_at DATETIME,
    height      DEC(10, 2),
    score       INT
);

INSERT INTO my_table5
    (address, hired_data, inserted_at, height, score)
VALUES ('new', '1920-02-18', '2025-06-16 11:38:23', 200.32, 4942);

SELECT *
FROM my_table5;

CREATE TABLE my_table6
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    city        VARCHAR(30),
    score       DEC(10, 2),
    weight      BIGINT,
    birth_date  DATE,
    start_at    TIME,
    inserted_at DATETIME
);

# 연습
# my_table7 과
# 매핑되는 Entity7을 만들어 보세요.

CREATE TABLE my_table7
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(30),
    team        VARCHAR(30),
    city        VARCHAR(30),
    country     VARCHAR(30),
    height      DEC(10, 2),
    birth_date  DATE,
    inserted_at DATETIME
);














