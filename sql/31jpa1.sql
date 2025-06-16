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



