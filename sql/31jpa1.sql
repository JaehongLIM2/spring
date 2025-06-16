USE jpa;
# db의 table 명과 컬럼명은 lower_snake_case
CREATE TABLE my_table1
(
    id INT AUTO_INCREMENT PRIMARY KEY,
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







